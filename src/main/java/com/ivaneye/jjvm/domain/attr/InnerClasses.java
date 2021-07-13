package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.attr.sub.InnerClassInfo;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-10 23:20:21
 */
@Data
public class InnerClasses extends Attribute {

    private U2 numberOfClasses;
    private InnerClassInfo[] classes;
}
