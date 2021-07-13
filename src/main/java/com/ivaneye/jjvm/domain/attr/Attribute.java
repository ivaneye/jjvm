package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * 属性信息
 *
 * @author ivaneye
 * @since 2021-07-10 22:57:50
 */
@Data
public abstract class Attribute {

    protected U2 attributeNameIndex;
    protected U4 attributeLength;

    public String info(ClassInfo classInfo) {
        return "Attr[" + classInfo.constantPool().get(attributeNameIndex.toInt()) + "]";
    }
}
