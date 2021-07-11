package com.ivaneye.jjvm.domain.constant;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;

/**
 * @author ivaneye
 * @since 2021-07-10 22:45:09
 */
public class ConstantClass implements Constant {

    private U1 tag;
    private U2 nameIndex;
    private ClassInfo classInfo;

    public ConstantClass(U1 tag, U2 nameIndex, ClassInfo classInfo) {
        this.tag = tag;
        this.nameIndex = nameIndex;
        this.classInfo = classInfo;
    }

    @Override
    public String type() {
        return "Class";
    }

    @Override
    public String value() {
        return classInfo.getConstantPool().get(nameIndex.toInt()).value();
    }

    @Override
    public String toString() {
        return type() + "    " + nameIndex.toInt() + "    // " + value();
    }
}
