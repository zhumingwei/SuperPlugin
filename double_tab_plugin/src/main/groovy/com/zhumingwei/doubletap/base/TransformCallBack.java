package com.zhumingwei.doubletap.base;

public interface TransformCallBack {

    byte[] process(String className, byte[] classBytes, BaseTransform transform);

}
