package com.semillero.ecosistemas.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
//    @Value("${CLOUDINARY_CLOUD_NAME}")
//    private String cloudName;
//
//    @Value("${CLOUDINARY_API_KEY}")
//    private String apiKey;
//
//    @Value("${CLOUDINARY_API_SECRET}")
//    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dd8pefa3c");
        config.put("api_key", "486925555864549");
        config.put("api_secret", "jwGfoG76Mg44R_X8TELZ9-kdGpY");
        return new Cloudinary(config);
    }
}