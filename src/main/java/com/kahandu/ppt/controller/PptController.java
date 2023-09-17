package com.kahandu.ppt.controller;


import com.kahandu.ppt.service.OpenAiServiceConnector;
import com.theokanning.openai.image.ImageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PptController {

    @Autowired
    OpenAiServiceConnector openAiServiceConnector;


    @PostMapping
    public ImageResult getImage(@RequestBody String prompt) {
        return openAiServiceConnector.generateImage("Small Boy from Nepal going uphill on a hill with load on his back");
    }

    @PostMapping
    public ImageResult getChatResponse(@RequestBody String prompt) {
        return openAiServiceConnector.generateImage("Small Boy from Nepal going uphill on a hill with load on his back");
    }
}

