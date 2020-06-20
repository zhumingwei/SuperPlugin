package com.zhumingwei.comic.superplugin;

import android.util.Log;

/**
 * @author zhumingwei
 * @date 2020/6/19 10:43
 * @email zhumingwei@bilibili.com
 */
class ClickHelper {
    public static long lastTime = 0;
    public boolean canClick(){
        long cur = System.currentTimeMillis();
        if(cur - lastTime > 500){
            lastTime = cur;
            return true;
        }
        Log.d("xxxxxxxxxxxxxxxxxxxxxx","doubleclick");
        return false;
    }
}
