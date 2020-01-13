package com.gs.util;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopy {
    public static String copyFile(MultipartFile photo, String mkdirName) throws FileNotFoundException {
        //获取上传的文件名
        String oldFileName = photo.getOriginalFilename();
        //创建一个时间戳
        long timestamp = System.currentTimeMillis();
        //给老的文件名重命名并和时间戳进行拼接
        String newFile = timestamp + oldFileName.substring(oldFileName.lastIndexOf("."));
        //获取项目的根目录
        File path=new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path.getAbsolutePath(),"static/upload/");
        //判断文件夹是否存在 if !.exists():如果文件夹不存在  .mkdir()自动创建一个文件夹
        if(!upload.exists()){
            upload.mkdirs();
        }
        try {
            photo.transferTo(new File(upload + "\\" + newFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mkdirName + "/" + newFile;
    }
}
