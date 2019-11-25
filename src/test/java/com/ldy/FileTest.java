package com.ldy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileTest {

    @Test
    public void test01() throws IOException {
        File file = new File("/Users/lidanyang/Desktop/demo.json");
        FileInputStream inputStream = new FileInputStream(file);
        int length = (int) file.length();
        byte[] data = new byte[length];
        inputStream.read(data);

        File outFile = new File("/Users/lidanyang/Desktop/DemoOut.json");
        outFile.createNewFile();
        FileOutputStream out = new FileOutputStream(outFile);
        out.write(data);

    }
}
