package com.aluracursos.challengeconversor.principal;

import com.aluracursos.challengeconversor.api.Requests;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String base = "USD";
        String target = "ARS";
        double cantidadAConvertir = 100.0;


        try {
            Requests conversor = new Requests(base, target, cantidadAConvertir);
            conversor.realizarSolicitud();
            System.out.println("---------------------------------------------------");
            System.out.println("Valor de cambio: ");
            System.out.println(conversor);
            System.out.println("---------------------------------------------------");

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }


    }

}
