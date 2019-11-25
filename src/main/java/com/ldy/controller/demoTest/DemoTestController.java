package com.ldy.controller.demoTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 和 TestHelper 里的 demo 配套使用
 */
@RestController
@RequestMapping("/demo")
public class DemoTestController {

    @GetMapping("/testByteFile")
    public void downLoadByteFile(@RequestParam String filePath, HttpServletResponse response) throws IOException {
        File file = new File(filePath);
        FileInputStream in = new FileInputStream(file);
        int length = (int) file.length();
        byte[] data = new byte[length];
        in.read(data);
        response.getOutputStream().write(data);
    }
}
