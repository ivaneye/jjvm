package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;

/**
 * @author ivaneye
 * @since 2021-07-10 23:10:43
 */
public class BootstrapMethods implements Attribute {

    private U2 attributeNameIndex;
    private U4 attributeLength;
    private U2 numBootStrapMethods;
    private BootStrapMethodInfo[] bootstrapMethods;
}
