package com.ivaneye.jjvm.domain.attr.sub;

import com.ivaneye.jjvm.domain.attr.sub.AnnotationInfo;
import com.ivaneye.jjvm.domain.attr.sub.ArrayValueInfo;
import com.ivaneye.jjvm.domain.attr.sub.EnumConstValueInfo;
import com.ivaneye.jjvm.domain.type.U2;

/**
 * @author ivaneye
 * @since 2021-07-10 23:00:29
 */
public class ValueInfo {

    private U2 constValueIndex;
    private EnumConstValueInfo enumConstValue;
    private U2 classInfoIndex;
    private AnnotationInfo annotationValue;
    private ArrayValueInfo arrayValue;
}
