package com.ivaneye.jjvm.domain.constant;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;

/**
 * @author ivaneye
 * @since 2021-07-10 22:45:09
 */
public class ConstantNameAndType implements Constant {

    private U1 tag;
    private U2 nameIndex;
    private U2 descIndex;
    private ClassInfo classInfo;

    public ConstantNameAndType(U1 tag, U2 nameIndex, U2 descIndex, ClassInfo classInfo) {
        this.tag = tag;
        this.nameIndex = nameIndex;
        this.descIndex = descIndex;
        this.classInfo = classInfo;
    }

    @Override
    public String type() {
        return "NameAndType";
    }

    @Override
    public String value() {
        return classInfo.getConstantPool().get(nameIndex.toInt()).value() + ":"
                + classInfo.getConstantPool().get(descIndex.toInt()).value();
    }

    @Override
    public String toString() {
        return type()
                + "    #" + nameIndex.toInt() + ":#" + descIndex.toInt()
                + "    // " + value();
    }
}
