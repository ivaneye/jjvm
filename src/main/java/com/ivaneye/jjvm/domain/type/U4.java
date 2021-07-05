package com.ivaneye.jjvm.domain.type;

/**
 * 无符号4字节
 *
 * @author ivaneye
 * @since 2021-07-02 11:14:20
 */
public class U4 {

    private Byte[] datas;

    public U4(Byte[] datas) {
        this.datas = datas;
    }

    public Integer toInt() {
        return (Byte.toUnsignedInt(datas[0]) << 24)
                + (Byte.toUnsignedInt(datas[1]) << 16)
                + (Byte.toUnsignedInt(datas[2]) << 8)
                + Byte.toUnsignedInt(datas[3]);
    }

    public String toHexString() {
        String str = "";
        for (Byte data : datas) {
            str += Integer.toHexString(Byte.toUnsignedInt(data)).toUpperCase();
        }
        return str;
    }

    public Byte[] toByteArray() {
        return datas;
    }
}
