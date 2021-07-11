package com.ivaneye.jjvm.finder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivaneye
 * @since 2021-07-11 12:22:36
 */
public class DirFinder implements Finder {

    private List<Finder> finders = new ArrayList<>();

    public DirFinder(String cpStr) {
        // todo
//        val dir = File(cpStr)
//        val files = dir.walk().filter { file -> file.name.endsWith(".jar") || file.name.endsWith(".class") }
//        files.forEach { f ->
//            if (f.name.endsWith(".jar")) {
//                finders.add(JarFinder(f.absolutePath))
//            } else if (f.name.endsWith(".class")) {
//                finders.add(FileFinder(f.absolutePath))
//            }
//        }
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        for (Finder f : finders) {
            byte[] result = f.readClass(className);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
