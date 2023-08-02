package com.example.assignment2gc200521445.Utilities;

import com.example.assignment2gc200521445.Models.ApiResponse;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiUtility {

    public static ApiResponse getDataFromApi (String searchName) {

        searchName = searchName.trim().replace(" ", "%20");
        String url = "https://jsearch.p.rapidapi.com/search?query=" + searchName;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Key", "4d0bafadbemsh83c38c18785f401p182919jsn8b4d8d3e607d")
                .header("X-RapidAPI-Host", "jsearch.p.rapidapi.com")
                .build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), ApiResponse.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
