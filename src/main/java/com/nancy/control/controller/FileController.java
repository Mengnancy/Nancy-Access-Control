package com.nancy.control.controller;

import com.nancy.control.bean.Production;
import com.nancy.control.bean.ResponseVO;
import com.nancy.control.dao.ProductionMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/19 下午2:33
 */
@RestController
public class FileController {
    @Autowired
    private ProductionMapper productionMapper;

    @GetMapping("/download")
    public void download(HttpServletResponse response) {
        File file = new File("D:\\mytest");
        OutputStream os = null;

        BufferedInputStream bis = null;
        byte[] buffer = new byte[1024];

        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            os = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buffer)) != 0) {
                os.write(buffer, 0, i);
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

    @PostMapping("/upload")
    public ResponseVO upload(MultipartFile file, @RequestParam String currentId) {
        if (file.getSize() == 0) {
            return new ResponseVO(-1, "上传文件为空");
        }
        String diretory = "D:\\mytest\\" + currentId + File.separator;
        try {
            File newFile = new File(diretory + file.getOriginalFilename());
            file.transferTo(newFile);
        } catch (IOException e) {
            System.err.println("创建文件失败");
        }

        System.err.println("文件是否为空 ： " + file.isEmpty());
        System.err.println("文件的大小为 ：" + file.getSize());
        System.err.println("文件的媒体类型为 ： " + file.getContentType());
        System.err.println("文件的名字： " + file.getName());
        System.err.println("文件的originName为： " + file.getOriginalFilename());

        Production production = new Production();
        production.setIdProduction(currentId);
        production.setDirectory(diretory);
        //修改目录文件夹
        productionMapper.updateDirectory(production);

        return new ResponseVO("上传成功");
    }

    @PostMapping("/multiUpload")
    public ResponseVO multiUpload(@RequestParam("file") MultipartFile[] files, @RequestParam String currentId) {
        if (files.length == 0) {
            return new ResponseVO(-1, "没有选中上传文件");
        }

        String diretory = "D:\\mytest\\" + currentId + File.separator;

        for (MultipartFile file : files) {
            System.err.println("文件是否为空 ： " + file.isEmpty());
            System.err.println("文件的大小为 ：" + file.getSize());
            System.err.println("文件的媒体类型为 ： " + file.getContentType());
            System.err.println("文件的名字： " + file.getName());
            System.err.println("文件的originName为： " + file.getOriginalFilename());
            File newFile = new File(diretory + file.getOriginalFilename());
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                System.err.println(file.getOriginalFilename() + "传输失败");
            }
        }
        Production production = new Production();
        production.setIdProduction(currentId);
        production.setDirectory(diretory);
        //修改目录文件夹
        productionMapper.updateDirectory(production);
        return new ResponseVO("上传成功");
    }
}
