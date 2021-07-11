package com.ivaneye.jjvm.domain.constant;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;

/**
 * @author ivaneye
 * @since 2021-07-11 10:56:15
 */
public class ConstantMethodHandler implements Constant {

    private U1 tag;
    private U1 refKind;
    private U2 refIndex;
    private ClassInfo classInfo;

    public ConstantMethodHandler(U1 tag, U1 refKind, U2 refIndex, ClassInfo classInfo) {
        this.tag = tag;
        this.refKind = refKind;
        this.refIndex = refIndex;
        this.classInfo = classInfo;
    }

    @Override
    public String type() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String value() {
        throw new UnsupportedOperationException();
    }
}
