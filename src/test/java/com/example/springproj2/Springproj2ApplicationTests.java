package com.example.springproj2;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootTest
class Springproj2ApplicationTests {
	private static final String testURL = "https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos";
	private final RestTemplate restTemplate = new RestTemplate();

	@Test
	void jsonResponseListCheck() throws Exception{
		ArrayList jsonBody = restTemplate.getForObject(testURL, ArrayList.class);
		assert jsonBody != null;
	}
	@Test
	void jsonResponseIsUniqueCheck() throws Exception{
		ArrayList<LinkedHashMap> jsonBody = restTemplate.getForObject(testURL, ArrayList.class);
		HashSet uniqueIDs = new HashSet<>();
		HashSet uniqueNames = new HashSet<>();
		for (LinkedHashMap hm : jsonBody){
			if(!uniqueIDs.contains(hm.get("id")) && !uniqueNames.contains(hm.get("name"))){
				uniqueIDs.add(hm.get("id"));
				uniqueNames.add(hm.get("name"));
			}
			else {
				throw new Exception("Not unique ID or name");
			}
		}
	}
}
