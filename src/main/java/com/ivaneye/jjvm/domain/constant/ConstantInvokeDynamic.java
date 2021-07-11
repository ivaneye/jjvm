package com.ivaneye.jjvm.domain.constant;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;

/**
 * @author ivaneye
 * @since 2021-07-11 10:56:15
 */
public class ConstantInvokeDynamic implements Constant {

    private U1 tag;
    private U2 bootstrapMethodAttrIndex;
    private U2 nameAndTypeIndex;
    private ClassInfo classInfo;

    public ConstantInvokeDynamic(U1 tag, U2 bootstrapMethodAttrIndex, U2 nameAndTypeIndex, ClassInfo classInfo) {
        this.tag = tag;
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
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
