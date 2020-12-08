package com.linfd.scri.disinfectrobot;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileControl {
    // 文件复制
    public static boolean copyFile(String source, String copy) throws Exception {
        source = source.replace("\\", "/");
        copy = copy.replace("\\", "/");

        File source_file = new File(source);
        File copy_file = new File(copy);

        // BufferedStream缓冲字节流

        if (!source_file.exists()) {
            throw new IOException("文件复制失败：源文件（" + source_file + "） 不存在");
        }
        if (copy_file.isDirectory()) {
            throw new IOException("文件复制失败：复制路径（" + copy_file + "） 错误");
        }
        File parent = copy_file.getParentFile();
        // 创建复制路径
        if (!parent.exists()) {
            parent.mkdirs();
        }
        // 创建复制文件
        if (!copy_file.exists()) {
            copy_file.createNewFile();
        }

        FileInputStream fis = new FileInputStream(source_file);
        FileOutputStream fos = new FileOutputStream(copy_file);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] KB = new byte[1024];
        int index;
        while ((index = bis.read(KB)) != -1) {
            bos.write(KB, 0, index);
        }

        bos.close();
        bis.close();
        fos.close();
        fis.close();

        if (!copy_file.exists()) {
            return false;
        } else if (source_file.length() != copy_file.length()) {
            return false;
        } else {
            return true;
        }

    }

}
