package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class MockApiTest {
    @Test
    public void testRestTemplateRepos() throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        String ResourceUrl = "https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos";
        String response = restTemplate.getForObject(ResourceUrl,String.class);
        assertThat(response).isNotNull();
    }
    @Test
    public void testRestTemplateBranches() throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        String ResourceUrl = "https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos/1/branches";
        String response = restTemplate.getForObject(ResourceUrl,String.class);
        assertThat(response).isNotNull();
    }
    @Test
    public void testRestTemplateCommits() throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        String ResourceUrl = "https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos/1/branches/1/commits";
        String response = restTemplate.getForObject(ResourceUrl,String.class);
        assertThat(response).isNotNull();
    }
}



















