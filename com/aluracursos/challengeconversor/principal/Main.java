package com.aluracursos.challengeconversor.principal;

import com.aluracursos.challengeconversor.api.Requests;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String ARS = null;
        String GBP = null;


        Requests conversor = null;
        try {
            conversor = new Requests(ARS, GBP);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("---------------------------------------------------");
        System.out.println("Valor de cambio: ");
        System.out.println(conversor);
        System.out.println("---------------------------------------------------");



    }

}
