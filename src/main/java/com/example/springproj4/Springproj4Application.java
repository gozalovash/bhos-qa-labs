package com.example.springproj4;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.FileReader;


@SpringBootApplication
public class Springproj4Application {

	public static void main(String[] args) {

		SpringApplication.run(Springproj4Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(new FileReader(""));
//		JSONObject api_key = (JSONObject) obj;
		String api_key = "qjQtmdf79oXF11SyHfM46bm4RpQ0OPzt";

		return args -> {
			Object object = restTemplate.getForObject("https://api.nytimes.com/svc/books/v3/lists/current/combined-print-and-e-book-fiction.json?api-key="+api_key, Object.class);
			assert object != null;
			System.out.println(object.toString());
		};
	}

}
