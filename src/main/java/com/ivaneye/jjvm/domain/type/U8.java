package com.ivaneye.jjvm.domain.type;

/**
 * 无符号8字节
 *
 * @author ivaneye
 * @since 2021-07-02 11:14:20
 */
public class U8 {

    private byte[] highDatas;
    private byte[] lowDatas;

    public U8(byte[] highDatas, byte[] lowDatas) {
        this.highDatas = highDatas;
        this.lowDatas = lowDatas;
    }

    public Long toLong() {
        return (Byte.toUnsignedLong(highDatas[0]) << 56)
                + (Byte.toUnsignedLong(highDatas[1]) << 48)
                + (Byte.toUnsignedLong(highDatas[2]) << 40)
                + (Byte.toUnsignedLong(highDatas[3]) << 32)
                + (Byte.toUnsignedLong(lowDatas[0]) << 24)
                + (Byte.toUnsignedLong(lowDatas[1]) << 16)
                + (Byte.toUnsignedLong(lowDatas[2]) << 8)
                + Byte.toUnsignedLong(lowDatas[3]);
    }
}
