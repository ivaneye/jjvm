package com.ivaneye.jjvm.finder;

/**
 * @author ivaneye
 * @since 2021-07-11 12:27:59
 */
public class ClassPath {

    private static final String JAVA_HOME_KEY = "JAVA_HOME";

    private Finder bootClassPathFinder;
    private Finder userClassPathFinder;

    public ClassPath(String cpStr) {
        parseBootAndExtClasspath();
        parseUserClasspath(cpStr);
    }

    private void parseBootAndExtClasspath() {
        boolean hasJavaHome = System.getenv().containsKey(JAVA_HOME_KEY);
        if (!hasJavaHome) {
            throw new RuntimeException("Can not find JAVA_HOME");
        }
        String javaHome = System.getenv().get(JAVA_HOME_KEY);
        String jreLibPath = "$javaHome/jre/lib";
        String jreExtPath = "$javaHome/jre/lib/ext";
        bootClassPathFinder = new DirFinder(jreLibPath);
//        extClassPathFinder = DirFinder(jreExtPath)
    }

    private void parseUserClasspath(String cpStr) {
        userClassPathFinder = new DirFinder(cpStr);
    }

    public byte[] readClass(String className) {
        try {
            byte[] result = bootClassPathFinder.readClass(className);
            if (result == null) {
                result = userClassPathFinder.readClass(className);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
