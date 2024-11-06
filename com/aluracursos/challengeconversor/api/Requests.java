package com.aluracursos.challengeconversor.api;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requests  {

    String base;
    String target;
    double tasaConversion;
    double cantidadAConvertir;
    double totalConvertido;

    public Requests(String base, String target, double cantidadAConvertir) {
        this.base = base;
        this.target = target;
        this.cantidadAConvertir = cantidadAConvertir;
    }

    public Requests(RequestExchangeRateApi nuevaRequest) {
        this.base = nuevaRequest.base_code();
        this.target = nuevaRequest.target_code();
        this.tasaConversion = nuevaRequest.conversion_rate();
        this.totalConvertido = nuevaRequest.conversion_result();
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

    public double getCantidad() {
        return cantidadAConvertir;
    }

    public void setCantidad(double cantidad) {
        this.cantidadAConvertir = cantidad;
    }

    public double getTasaConversion() {
        return tasaConversion;
    }

    public void setTasaConversion(double tasaConversion) {
        this.tasaConversion = tasaConversion;
    }



    private String construirDireccion() {
        return "https://v6.exchangerate-api.com/v6/7a2431e0ce3e44dbb4001694/pair/" +
                base + "/" + target + "/" + cantidadAConvertir;
    }



    public void realizarSolicitud() throws IOException, InterruptedException {
        String direccion = construirDireccion();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setPrettyPrinting()
                .create();
        RequestExchangeRateApi nuevaRequest = gson.fromJson(response.body(),
                RequestExchangeRateApi.class);


        this.base = nuevaRequest.base_code();
        this.target = nuevaRequest.target_code();
        this.tasaConversion = nuevaRequest.conversion_rate();
        this.totalConvertido = nuevaRequest.conversion_result();
    }


    @Override
    public String toString() {
        return  "Divisa de base: " + getBase() +
                ".  Divisa de target: " + getTarget() +
                ". Cantidad a convertir: " + getCantidad() +
                ". Tasa de conversión: " + getTasaConversion() +
                ".  Monto total convertido: " + totalConvertido;
    }


}
