package com.example.springproj4;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@SpringBootTest
class Springproj4ApplicationTests {
	private static final String testURL = "https://api.nytimes.com/svc/books/v3/lists/current/combined-print-and-e-book-fiction.json?api-key=";
	private final RestTemplate restTemplate = new RestTemplate();

	@Test
	void jsonResponseListCheck() throws Exception{
		File file = new File(
				"./api-key.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String api_key =  br.readLine();
		System.out.println(api_key);
		LinkedHashMap jsonBody = restTemplate.getForObject(testURL+api_key, LinkedHashMap.class);
		//JSONObject jsonObject = (JSONObject) jsonBody;
		LinkedHashMap jsonResults= (LinkedHashMap) jsonBody.get("results");
		ArrayList<LinkedHashMap> booksList = (ArrayList) jsonResults.get("books");
		for (LinkedHashMap book : booksList){
			if (book.get("title").toString().isEmpty()){
				throw new Exception("Title is empty!");
			}
		}
	}

}
