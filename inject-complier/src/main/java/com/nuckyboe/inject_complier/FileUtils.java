package com.nuckyboe.inject_complier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static void print(String s) {
//        File file = new File("/Users/DELL/Desktop/log.txt");
        File file = new File("C:\\Users\\DELL\\Desktop\\log.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            fileWriter.write(s + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
