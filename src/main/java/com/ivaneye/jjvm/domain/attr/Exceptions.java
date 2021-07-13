package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-10 23:18:56
 */
@Data
public class Exceptions extends Attribute {

    private U2 numberOfExceptions;
    private U2[] exceptons;
}
