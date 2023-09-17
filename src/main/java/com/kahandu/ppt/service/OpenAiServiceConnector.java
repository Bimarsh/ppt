package com.kahandu.ppt.service;

import com.kahandu.ppt.config.OpenAiConfiguration;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.ImageResult;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class OpenAiServiceConnector {




    @Autowired
    OpenAiConfiguration openAiConfiguration;

    public void createAuthorizationHeader( HttpHeaders httpHeaders){
        httpHeaders.put("Authorization", Arrays.asList("Bearer "+openAiConfiguration.getClientSecret()));
        httpHeaders.put(HttpHeaders.CONTENT_TYPE,Arrays.asList("application/json"));
    }

    public void callOpenAi(String url, Object requestBody, String responseBody)
    {

        RestTemplate restTemplate = new RestTemplate();
        requestBody="{\n" +
                "     \"model\": \"gpt-3.5-turbo\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \"Say this is a test!\"}],\n" +
                "     \"temperature\": 0.7\n" +
                "   }";
        HttpHeaders httpHeaders = new HttpHeaders();
        createAuthorizationHeader(httpHeaders);
        HttpEntity<Object> stringHttpEntity = new HttpEntity<>(requestBody,httpHeaders);

        responseBody = restTemplate.exchange(url, HttpMethod.POST,stringHttpEntity,String.class).getBody();
    }

    public ImageResult generateImage(String prompt)
    {
        OpenAiService service = new OpenAiService(openAiConfiguration.getClientSecret());
        CreateImageRequest createImageRequest = CreateImageRequest.builder()
                .prompt(prompt)
                .n(1)
                .size("1024x1024")
                .build();
       return service.createImage(createImageRequest);
    }



//    public ImageResult generateImage(String prompt)
//    {
//        OpenAiService service = new OpenAiService(openAiConfiguration.getClientSecret());
//        CreateImageRequest createImageRequest = CreateImageRequest.builder()
//                .prompt(prompt)
//                .n(1)
//                .size("1024x1024")
//                .build();
//        return service.createImage(createImageRequest);
//    }




}
