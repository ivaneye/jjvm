package com.ivaneye.jjvm;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.constant.Constant;
import com.ivaneye.jjvm.finder.ClassPath;
import com.ivaneye.jjvm.finder.FileFinder;
import com.ivaneye.jjvm.finder.JarFinder;
import com.ivaneye.jjvm.reader.ClassReader;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ivaneye
 * @since 2021-07-12 16:06:23
 */
public class MainTest {

    @Test
    public void show() {
        ClassPath cp = new ClassPath("/home/ivaneye/my/mygit/jjvm/target/test-classes");
        String className = "com.ivaneye.jjvm.Hello".replaceAll("\\.", "/");
        byte[] classData = cp.readClass(className);
        ClassReader classReader = new ClassReader(classData);
        ClassInfo classInfo = classReader.readClass();
        classInfo.show();
    }

    @Test
    public void test() throws IOException {
        Path dir = Paths.get("/home/ivaneye/my/mygit/jjvm/target/test-classes");
        List<Path> files = Files.walk(dir).filter(file -> {
            System.out.println(file.getFileName());
            System.out.println(file.getFileName().toString().endsWith(".class"));
            return !file.getFileName().endsWith(".jar")
                    && !file.getFileName().endsWith(".class");
        }).collect(Collectors.toList());
        System.out.println("=====================");
        System.out.println(files.size());
        System.out.println("=====================");
        files.forEach(f -> {
                    System.out.println("=====================");
                    System.out.println(f.getFileName());
                }
        );
    }

}
