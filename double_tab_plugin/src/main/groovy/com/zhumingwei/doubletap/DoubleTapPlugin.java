package com.zhumingwei.doubletap;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.AppPlugin;

import org.gradle.api.Action;
import org.gradle.api.GradleException;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import com.zhumingwei.doubletap.helper.TimingsListener;
public class DoubleTapPlugin implements Plugin<Project> {
    private static final String EXT_NAME = "doubleTab";

    @Override
    public void apply(Project project) {
        boolean isApp = project.getPlugins().hasPlugin(AppPlugin.class);
        project.getExtensions().create(EXT_NAME, DoubleTabConfig.class);
        if (!isApp) {
            throw new GradleException(" this plugin is not application");
        }
        AppExtension appExtension = project.getExtensions().getByType(AppExtension.class);
        project.getGradle().addListener(new TimingsListener());
        appExtension.registerTransform(new DoubleTabTransform(project));

        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(Project project) {
                 System.out.println("afterEvaluate transform");
                DoubleTabConfig config = (DoubleTabConfig) project.getExtensions().findByName(EXT_NAME);
                if (config == null) {
                    config = new DoubleTabConfig();
                }
                config.transform();
            }
        });
    }
}