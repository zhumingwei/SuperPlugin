package com.zhumingwei.doubletap

import com.android.build.api.transform.QualifiedContent;
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformException
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.internal.pipeline.TransformManager
import com.zhumingwei.doubletap.base.BaseTransform
import com.zhumingwei.doubletap.base.TransformCallBack
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
        Log.info("transform")
        final DoubleTapDelegate injectHelper = new DoubleTapDelegate()
        BaseTransform baseTransform = new BaseTransform(transformInvocation, new TransformCallBack() {

            @Override
            byte[] process(String s, byte[] bytes, BaseTransform baseTransform) {
                if (ClassUtils.checkClassName(s)) {
                    Log.info("class name : " + s)
                    return injectHelper.transformByte(bytes)
                } else {
                    return null
                }
            }
        })
        Log.info("startTransform")
        baseTransform.startTransform()
    }
}

class Log {

    def static info(Object msg) {
        try {
            println "${msg}"
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}