package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;

/**
 * @author ivaneye
 * @since 2021-07-11 10:13:25
 */
public class RuntimeInvisibleParameterAnnotations implements Attribute {

    private U2 attributeNameIndex;
    private U4 attributeLength;
    private U1 numParameters;
    private ParameterAnnotationInfo[] parameterAnnotations;
}