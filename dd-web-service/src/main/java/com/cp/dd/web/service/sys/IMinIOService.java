package com.cp.dd.web.service.sys;


import java.io.InputStream;

/**
 * @desc: 即时消息
 * @author: chengp
 * @since: 1.0
 */
public interface IMinIOService {

    String uploadFile(String fileName, InputStream is) throws Exception;

    byte[] loadFile(String fileName) throws Exception;

    String presignedPutUrl(String fileName)throws Exception;
    
    String presignGetUrl(String fileName)throws Exception;
    
}
