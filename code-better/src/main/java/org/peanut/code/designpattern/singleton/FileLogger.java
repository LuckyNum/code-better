package org.peanut.code.designpattern.singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 往文件中打印日志
 *
 * @author lch
 */
public class FileLogger {

    private FileWriter fileWriter;

    public FileLogger() {
        File file = new File("log.txt");
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出日志
     *
     * @param message
     */
    public void log(String message) {
        synchronized (FileLogger.class) {
            try {
                fileWriter.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
