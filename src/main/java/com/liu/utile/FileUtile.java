package com.liu.utile;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: blog
 * @author: smile liu
 * @description:
 * @create: 2019-02-23 14:54
 **/

public class FileUtile {
    public String hostname = "111.230.74.190";
    public Integer port = 21;
    static final String USERNAME = "liu";
    static final String PASSWORD = "liuliuliu";
    public FTPClient ftpClient = null;
    public boolean updataImg(MultipartFile file,String filename){
        ftpClient = new FTPClient();
        ftpClient.setDefaultTimeout(5 * 1000);
        ftpClient.setConnectTimeout(5 * 1000);
        ftpClient.setDataTimeout(5 * 1000);


        try {
            FileInputStream input = (FileInputStream) file.getInputStream();
            ftpClient.connect(hostname,port);
            ftpClient.enterLocalPassiveMode();
            ftpClient.login(USERNAME,PASSWORD);
            ftpClient.setSoTimeout(5*1000);
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                System.out.println("连接FTP服务器失败！");
                return false;
            }else{
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                ftpClient.storeFile(filename,input);
            }
            ftpClient.logout();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return true;
    }
}
