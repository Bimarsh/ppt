package com.kahandu.ppt.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class OpenAiConfiguration {

    @Value("${open.ai.client.secret}")
    public String clientSecret;

    @Value("${open.ai.connect.endpoint}")
    public String connectEndpoint;

}
