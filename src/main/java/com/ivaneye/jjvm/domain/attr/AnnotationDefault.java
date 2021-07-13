package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.attr.sub.ElementValue;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-10 22:58:30
 */
@Data
public class AnnotationDefault extends Attribute {

    private ElementValue defaultValue;

}
