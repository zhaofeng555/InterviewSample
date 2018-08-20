package com.haojg.lombok;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CleanUpExample {
    
    @SneakyThrows({FileNotFoundException.class, Exception.class})
    public static void main(String[] args) {
        File file = new File("C:/Users/wang2/Desktop/11.jpg");
        @Cleanup
        FileInputStream is = new FileInputStream(file);
        @Cleanup
        FileOutputStream os = new FileOutputStream(new File("C:/Users/wang2/Desktop/111.jpg"));
        
        byte[] buffer = new byte[1024];
        int length = 0;
        while((length = is.read(buffer)) != -1){
            os.write(buffer, 0, length);
        }
    }
}