package com.ivaneye.jjvm.finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ivaneye
 * @since 2021-07-11 12:22:36
 */
public class DirFinder implements Finder {

    private List<Finder> finders = new ArrayList<>();

    public DirFinder(String cpStr) throws IOException {
        Path dir = Paths.get(cpStr);
        Stream<Path> files = Files.walk(dir).filter(file -> {
            return file.getFileName().toString().endsWith(".jar")
                    || file.getFileName().toString().endsWith(".class");
        });
        files.forEach(f -> {
                    if (f.getFileName().toString().endsWith(".jar")) {
                        finders.add(new JarFinder(f.toAbsolutePath().toString()));
                    } else if (f.getFileName().toString().endsWith(".class")) {
                        finders.add(new FileFinder(f.toAbsolutePath().toString()));
                    }
                }
        );
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
