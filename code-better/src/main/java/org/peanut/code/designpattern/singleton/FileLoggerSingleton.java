package org.peanut.code.designpattern.singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 单例实现
 *
 * @author lch
 */
public class FileLoggerSingleton {

    private FileWriter fileWriter;

    private static final FileLoggerSingleton instance = new FileLoggerSingleton();

    private FileLoggerSingleton() {
        File file = new File("log.txt");
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileLoggerSingleton getInstance() {
        return instance;
    }

    public void log(String message) {
        try {
            fileWriter.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
