package com.ivaneye.jjvm.domain;

import com.ivaneye.jjvm.domain.attr.Attribute;
import com.ivaneye.jjvm.domain.type.U2;

import java.util.List;

/**
 * 方法信息
 *
 * @author ivaneye
 * @since 2021-07-05 18:31:43
 */
public class MethodInfo {

    private U2 accFlag;
    private U2 nameIdx;
    private U2 descIdx;
    private U2 attrCount;
    private List<Attribute> attrs;

    public MethodInfo(U2 accFlag, U2 nameIdx, U2 descIdx, U2 attrCount, List<Attribute> attrs) {
        this.accFlag = accFlag;
        this.nameIdx = nameIdx;
        this.descIdx = descIdx;
        this.attrCount = attrCount;
        this.attrs = attrs;
    }

    public String info(ClassInfo classInfo) {
        return accFlag.toHexString() +
                " #" + nameIdx.toInt() + " // " + classInfo.constantPool().get(nameIdx.toInt())
                + " #" + descIdx.toInt() + " // " + classInfo.constantPool().get(descIdx.toInt());
    }
}
