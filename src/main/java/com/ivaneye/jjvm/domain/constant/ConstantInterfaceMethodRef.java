package com.ivaneye.jjvm.domain.constant;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;

/**
 * @author ivaneye
 * @since 2021-07-10 22:45:09
 */
public class ConstantInterfaceMethodRef implements Constant {

    private U1 tag;
    private U2 classIndex;
    private U2 nameAndTypeIndex;
    private ClassInfo classInfo;

    public ConstantInterfaceMethodRef(U1 tag, U2 classIndex, U2 nameAndTypeIndex, ClassInfo classInfo) {
        this.tag = tag;
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
        this.classInfo = classInfo;
    }

    @Override
    public String type() {
        return "InterfaceMethod";
    }

    @Override
    public String value() {
        return classInfo.getConstantPool().get(classIndex.toInt()).value()
                + "."
                + classInfo.getConstantPool().get(nameAndTypeIndex.toInt()).value();
    }

    @Override
    public String toString() {
        return type()
                + "    #" + classIndex.toInt() + ".#" + nameAndTypeIndex.toInt()
                + "    // " + value();
    }
}
