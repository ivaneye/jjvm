package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.attr.sub.AnnotationInfo;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-11 10:12:33
 */
@Data
public class RuntimeInvisibleAnnotations extends Attribute {

    private U2 numAnnotation;
    private AnnotationInfo[] annotations;
}
