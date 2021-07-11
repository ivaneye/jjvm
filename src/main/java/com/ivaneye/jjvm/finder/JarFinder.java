package com.ivaneye.jjvm.finder;

import sun.misc.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author ivaneye
 * @since 2021-07-11 12:20:33
 */
public class JarFinder implements Finder {

    private String jarPath;

    public JarFinder(String jarPath) {
        this.jarPath = jarPath;
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        ZipFile zipFile = new ZipFile(jarPath);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        byte[] result = new byte[zipFile.size()];
        int rNum = 0;
        while (entries.hasMoreElements()) {
            ZipEntry e = entries.nextElement();
            if (e.getName().contains(className)) {
                InputStream is = zipFile.getInputStream(e);
                BufferedInputStream bis = new BufferedInputStream(is);
                byte[] tmp = new byte[1024];
                int num = -1;
                while ((num = bis.read(tmp)) != -1) {
                    int i = 0;
                    for (; i < num; i++) {
                        result[rNum + i] = tmp[i];
                    }
                    rNum += i;
                }
                return Arrays.copyOfRange(result, 0, rNum);
            }
        }
        return null;
    }
}
