package com.yh.utils;

import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传 工具类
 *
 * 接收图片，返回地址
 * 接收video，返回地址 + videoTime
 *
 * @author yuanzhe
 * @date 2019-10-05
 */

public class UploadUtil {

    public String ImgUpload(MultipartFile file) {

        String serverPath = "/usr/local/tomcat/webapps/show";

        File file1 = new File(serverPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }

        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String imgName = uuid + filename;

        File file2 = new File(serverPath, imgName);

        try {
            file.transferTo(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String imgUploadURL = "http://15637237221.wicp.vip/show/" + imgName;

        return imgUploadURL;
    }

    public String videoUpload(MultipartFile file) {
        String serverPath = "/usr/local/tomcat/webapps/show";
        File file1 = new File(serverPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }

        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String videoName = uuid + filename;

        File file2 = new File(serverPath, videoName);

        try {
            file.transferTo(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String videoUploadURL = "http://15637237221.wicp.vip/show/" + videoName;

        File source = new File(videoUploadURL);//file类读文件
        String length = "";

        try {
            MultimediaObject instance = new MultimediaObject(source);
            MultimediaInfo result = instance.getInfo();
            long ls = result.getDuration() / 1000;
            int hour = (int) (ls / 3600);
            int minute = (int) (ls % 3600) / 60;
            int second = (int) (ls - hour * 3600 - minute * 60);
            length = hour + ":" + minute + ":" + second;//时长
            System.out.println(length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String videoURL = videoUploadURL + "/" + length;
        return videoURL;
    }
}
