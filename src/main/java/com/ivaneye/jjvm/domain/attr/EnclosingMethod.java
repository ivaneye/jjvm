package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;

/**
 * @author ivaneye
 * @since 2021-07-10 23:17:49
 */
public class EnclosingMethod implements Attribute {

    private U2 attributeNameIndex;
    private U4 attributeLength;
    private U2 classIndex;
    private U2 methodIndex;
}
