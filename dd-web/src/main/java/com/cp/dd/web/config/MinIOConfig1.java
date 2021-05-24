package com.cp.dd.web.config;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @desc:
 * @author: chengp
 * @since: 1.0
 */
@Configuration
@Slf4j
public class MinIOConfig1 {

    @Bean
    public MinioClient minioClient() {
        String host ="http://114.55.104.155:9000";
        String accesskey ="hmx";
        String secretkey = "hmx2020minio";
        MinioClient minioClient
                = null;
        try {
            minioClient = new MinioClient(host, accesskey, secretkey);
        } catch (InvalidEndpointException e) {
            log.error(e.getMessage());
        } catch (InvalidPortException e) {
            log.error(e.getMessage());
        }
        return minioClient;
    }


}
