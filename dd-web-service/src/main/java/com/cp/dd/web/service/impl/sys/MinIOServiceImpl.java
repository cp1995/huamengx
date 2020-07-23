package com.cp.dd.web.service.impl.sys;

import com.cp.dd.web.service.sys.IMinIOService;
import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidExpiresRangeException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.NoResponseException;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @desc:
 * @author: chegnp
 * @since: 1.0
 */
@AllArgsConstructor
@Service
public class MinIOServiceImpl implements IMinIOService {

    @Autowired
    private MinioClient minioClient;

    private static String bucketName = "hmx";

    private void makeBucket(String bucketName) throws Exception {
        if (!minioClient.bucketExists(bucketName)) {
            minioClient.makeBucket(bucketName);
        }
    }

    @Override
    public String uploadFile(String fileName, InputStream is) throws Exception {
        this.makeBucket(bucketName);
        minioClient.putObject(bucketName, fileName, is, null, null, null, null);
        return fileName;
    }

    @Override
    public byte[] loadFile(String fileName) throws Exception {
        this.makeBucket(bucketName);
        return this.toByteArray(minioClient.getObject(this.bucketName, fileName));
    }

    public byte[] toByteArray(InputStream in) throws IOException {
        if(in == null){
            return null;
        }
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        byte[] buffer=new byte[1024*4];
        int n=0;
        while ( (n=in.read(buffer)) !=-1) {
            out.write(buffer,0,n);
        }
        return out.toByteArray();
    }

    @Override
    public String presignedPutUrl(String fileName) throws Exception {
        String url = minioClient.presignedPutObject(bucketName, fileName);
        return url;
    }

    @Override
    public String presignGetUrl(String fileName) throws Exception {
        String url = minioClient.presignedGetObject(bucketName, fileName);
        return url;
    }
}
