package com.ivaneye.jjvm.finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        // todo 完善逻辑
//        val zipFile = ZipFile(jarPath)
//        for(e in zipFile.entries()){
//            if(e.name.contains(className)){
//                return zipFile.getInputStream(e).use { it.readBytes() }
//            }
//        }
        return null;
    }
}
