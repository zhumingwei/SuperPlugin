package com.zhumingwei.doubletap.helper
import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle
import org.gradle.api.tasks.TaskState

import java.util.concurrent.TimeUnit

class TimingsListener implements BuildListener, TaskExecutionListener {
    private long startTime
    private HashMap<String,Long> startMap = new HashMap<>();
    private timings = []

    @Override
    void buildStarted(Gradle gradle) {

    }

    @Override
    void beforeSettings(Settings settings) {
        super.beforeSettings(settings)
    }

    @Override
    void settingsEvaluated(Settings settings) {

    }

    @Override
    void projectsLoaded(Gradle gradle) {

    }

    @Override
    void projectsEvaluated(Gradle gradle) {

    }

    @Override
    void buildFinished(BuildResult buildResult) {
        def ms = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS)
        println "buildFinished: print time ${ms}"
    }

    @Override
    void beforeExecute(Task task) {
        startTime = System.nanoTime()
        startMap.put(task.name,System.nanoTime())

    }

    @Override
    void afterExecute(Task task, TaskState taskState) {
        long startTime = startMap.get(task.name)
        def ms = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS)
        timings.add([ms,task.path])
        task.project.logger.warn "${task.path} took ${ms}ms"
    }
}