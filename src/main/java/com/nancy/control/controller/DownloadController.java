package com.nancy.control.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/19 下午2:33
 */
@RestController
public class DownloadController {
    @GetMapping("/download")
    public void download(HttpServletResponse response) {
        File file = new File("/Users/lingxin/Downloads/hello.txt");
        OutputStream os = null;

        BufferedInputStream bis = null;
        byte[] buffer = new byte[1024];

        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            os = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buffer)) != 0) {
                os.write(buffer,0,i);
                os.flush();
            }
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("content-disposition", "attachment; filename=hello.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
