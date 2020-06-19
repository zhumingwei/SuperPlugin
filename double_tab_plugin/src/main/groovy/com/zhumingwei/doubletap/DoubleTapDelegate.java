package com.zhumingwei.doubletap;


import com.zhumingwei.doubletap.base.AbstractAsmDelegate;
import com.zhumingwei.doubletap.base.AsmHelper;

public class DoubleTapDelegate extends AbstractAsmDelegate {
    @Override
    public AsmHelper createHelper() {
        return new DoubleTapAsmHelper();
    }
}
