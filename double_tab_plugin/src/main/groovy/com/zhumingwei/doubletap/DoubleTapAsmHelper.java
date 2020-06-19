package com.zhumingwei.doubletap;


import com.zhumingwei.doubletap.base.AsmHelper;
import com.zhumingwei.doubletap.helper.ModifyUtils;

import java.io.IOException;

public class DoubleTapAsmHelper implements AsmHelper {
    @Override
    public byte[] modifyClass(byte[] srcClass) throws IOException {
        return ModifyUtils.modifyClass(srcClass);
    }
}
