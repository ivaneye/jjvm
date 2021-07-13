package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.attr.sub.ParameterAnnotationInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-11 10:13:25
 */
@Data
public class RuntimeInvisibleParameterAnnotations extends Attribute {

    private U1 numParameters;
    private ParameterAnnotationInfo[] parameterAnnotations;
}
