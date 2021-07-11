package com.ivaneye.jjvm.finder;

import java.io.IOException;

/**
 * @author ivaneye
 * @since 2021-07-11 12:19:45
 */
public interface Finder {

    /**
     * 从指定路径读取类内容，返回字节数组
     */
    byte[] readClass(String className) throws IOException;

}
