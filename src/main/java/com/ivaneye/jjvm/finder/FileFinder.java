package com.ivaneye.jjvm.finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author ivaneye
 * @since 2021-07-11 12:20:33
 */
public class FileFinder implements Finder {

    private String libPath;

    public FileFinder(String libPath) {
        this.libPath = libPath;
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        if (libPath.replaceAll("\\\\", "/").contains(className)) {
            return Files.readAllBytes(Paths.get(libPath));
        }
        return null;
    }
}
