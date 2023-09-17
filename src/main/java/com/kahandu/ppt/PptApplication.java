package com.kahandu.ppt;

import com.kahandu.ppt.config.OpenAiConfiguration;
import com.kahandu.ppt.controller.*;
import com.kahandu.ppt.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PptApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(PptApplication.class, args);
	}

	@Autowired
	public PptController pptController;

	@Override
	public void run(String... args) throws Exception {
		Content content = new Content();

		pptController.getPowerPoint(content);
	}
}
