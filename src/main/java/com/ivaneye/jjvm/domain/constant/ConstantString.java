package com.ivaneye.jjvm.domain.constant;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;

/**
 * @author ivaneye
 * @since 2021-07-10 22:45:09
 */
public class ConstantString implements Constant {

    private U1 tag;
    private U2 strIndex;
    private ClassInfo classInfo;

    public ConstantString(U1 tag, U2 strIndex, ClassInfo classInfo) {
        this.tag = tag;
        this.strIndex = strIndex;
        this.classInfo = classInfo;
    }

    @Override
    public String type() {
        return "String";
    }

    @Override
    public String value() {
        return classInfo.getConstantPool().get(strIndex.toInt()).value();
    }

    @Override
    public String toString() {
        return type() + "    " + strIndex.toInt() + "    // " + value();
    }
}
