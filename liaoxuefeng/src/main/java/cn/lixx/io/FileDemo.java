package cn.lixx.io;

import java.io.File;
import java.io.IOException;

import cn.lixx.utils.Tools;

public class FileDemo {

    public static void main(String[] args) throws IOException {
        f1();
        Tools.printLine();
    }

    public static void f1() throws IOException {
        File f = new File("..");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println(File.separator);
    }
}
