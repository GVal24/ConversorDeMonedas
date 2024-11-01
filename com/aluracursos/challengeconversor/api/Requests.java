package com.aluracursos.challengeconversor.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Requests  {

    String base;
    String target;

    public Requests(String base, String target) throws IOException{
        this.base = base;
        this.target = target;
    }



    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }


    String direccion = "https://v6.exchangerate-api.com/v6/7a2431e0ce3e44dbb4001694/pair/" + base + '/' + target;


    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(direccion))
            .build();
    HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());


    String json = response.body();

    @Override
    public String toString() {
        return  json;
    }
}
