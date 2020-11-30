package com.nbd.kickstarterdb;

import com.nbd.kickstarterdb.controller.ProjectController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class KickstarterDbApplicationTests {

//    @Autowired
//    private ProjectController projectController;
//
//    private HttpResponse<String> response;
//    private HttpRequest request;
//    private HttpClient client;
//    private String output = "";
//    private long start;
//    private long elapsedTime;

    @Test
    void contextLoads() throws IOException, InterruptedException {
//        assertThat(projectController).isNotNull();
//        client = HttpClient.newHttpClient();
//
//        //GET
//        output += "Single record GET querry took: ";
//        request = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8080/api/projects/1002139381"))
//                .build();
//        start = System.currentTimeMillis();
//        response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        elapsedTime = System.currentTimeMillis() - start;
//        output += elapsedTime + " ms Status: " + response.statusCode() + "\n";
//
//        //POST
//        output += "Single record POST querry took: ";
////        request = HttpRequest.newBuilder()
////                .uri(URI.create("http://localhost:8080/api/projects/99999"))
////                .POST(HttpRequest.BodyPublishers.ofFile()
////                .build();
//        start = System.currentTimeMillis();
//        response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        elapsedTime = System.currentTimeMillis() - start;
//        output += elapsedTime + " ms Status: " + response.statusCode() + "\n";
//
//        System.out.println(output);
    }

}
