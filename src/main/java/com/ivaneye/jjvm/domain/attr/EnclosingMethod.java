package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-10 23:17:49
 */
@Data
public class EnclosingMethod extends Attribute {

    private U2 classIndex;
    private U2 methodIndex;
}
