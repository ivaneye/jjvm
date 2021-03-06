package com.ivaneye.jjvm.domain.type;

/**
 * 无符号2字节
 *
 * @author ivaneye
 * @since 2021-07-02 11:14:20
 */
public class U2 {

    private byte[] datas;

    public U2(byte[] datas) {
        this.datas = datas;
    }

    public Integer toInt() {
        return (Byte.toUnsignedInt(datas[0]) << 8)
                + Byte.toUnsignedInt(datas[1]);
    }

    public String toHexString() {
        String str = "";
        for (Byte data : datas) {
            str += Integer.toHexString(Byte.toUnsignedInt(data)).toUpperCase();
        }
        return str;
    }
}
