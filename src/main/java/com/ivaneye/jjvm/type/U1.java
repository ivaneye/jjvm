package com.ivaneye.jjvm.type;

/**
 * 无符号1字节
 *
 * @author ivaneye
 * @since 2021-07-02 11:14:20
 */
public class U1 {

    private Byte data;

    public U1(Byte data) {
        this.data = data;
    }

    public Integer toInt() {
        return Byte.toUnsignedInt(data);
    }
}
