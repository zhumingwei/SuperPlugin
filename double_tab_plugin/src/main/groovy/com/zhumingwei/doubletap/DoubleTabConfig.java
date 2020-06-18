package com.zhumingwei.doubletap;

import org.apache.http.util.TextUtils;

/**
 * @author zhumingwei
 * @date 2020/6/18 09:50
 * @email zhumingwei@bilibili.com
 */
public class DoubleTabConfig {
    public String injectClassName = "";
    public String injectFunctionName = "";

    public static String ByteCodeInjectClassName = "";
    public static String ByteCodeInjectFunctionName = "";

    public void transform() {
        if (TextUtils.isEmpty(injectClassName)) {
            ByteCodeInjectClassName = "com/wallstreetcn/sample/DoubleTapCheck";
        } else {
            ByteCodeInjectClassName = injectClassName.replace(".", "/");
        }
        if (TextUtils.isEmpty(injectFunctionName)) {
            ByteCodeInjectFunctionName = "isNotDoubleTap";
        } else {
            ByteCodeInjectFunctionName = injectFunctionName;
        }
    }
}
