package com.zhumingwei.doubletap

import com.android.build.api.transform.Context
import com.android.build.api.transform.QualifiedContent;
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformException
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformInvocation
import com.android.build.api.transform.TransformOutputProvider
import com.android.build.gradle.internal.pipeline.TransformManager
import groovy.util.logging.Log
import org.gradle.api.Project

class DoubleTabTransform extends Transform {
    Project project
    DoubleTabTransform(Project project) {
        this.project = project
    }

    @Override
    String getName() {
        return "DoubleTabTransform"
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_JARS
    }

    @Override
    Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return false
    }

    @Override
    void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        println "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx transform"
        super.transform(transformInvocation)
    }
}