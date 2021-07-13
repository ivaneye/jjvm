package com.ivaneye.jjvm.domain.attr.sub;

import com.ivaneye.jjvm.domain.type.U2;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-10 23:14:34
 */
@Data
public class ExceptionTable {

    private U2 startPc;
    private U2 endPc;
    private U2 handlerPc;
    private U2 cacheType;

    public ExceptionTable(U2 startPc, U2 endPc, U2 handlerPc, U2 cacheType) {
        this.startPc = startPc;
        this.endPc = endPc;
        this.handlerPc = handlerPc;
        this.cacheType = cacheType;
    }
}
