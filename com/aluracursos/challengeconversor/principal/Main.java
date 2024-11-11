package com.aluracursos.challengeconversor.principal;

import com.aluracursos.challengeconversor.api.Requests;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String base = null;
        String target = null;
        BigDecimal cantidadAConvertir = BigDecimal.ZERO;
        Scanner lectura = new Scanner(System.in);
        String menu =
                """
                    Elija el tipo de conversión a realizar:
                                        1. ARS a USD
                                        2. BOB a ARS
                                        3. BRL a CLP
                                        4. CLP a BOB
                                        5. COP a BRL
                                        6. USD a CLP
                                        7. Salir""";


        while (true){
            System.out.println(menu);
            String opcion = lectura.nextLine();

                switch(opcion) {
                    case "1":
                        base = "ARS";
                        target = "USD";
                        break;
                    case "2":
                        base = "BOB";
                        target = "ARS";

                        break;
                    case "3":
                        base = "BRL";
                        target = "CLP";
                        break;
                    case "4":
                        base = "CLP";
                        target = "BOB";
                        break;
                    case "5":
                        base = "COP";
                        target = "BRL";
                        break;
                    case "6":
                        base = "USD";
                        target = "CLP";
                        break;
                    case "7":
                        System.out.println("Gracias por utilizar nuestros servicios. Programa terminado");
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        continue;
                }

            System.out.println("Ingrese el monto a convertir: ");
            cantidadAConvertir = new BigDecimal(lectura.nextLine());
            try {
                Requests conversor = new Requests(base, target, cantidadAConvertir);
                conversor.realizarSolicitud();
                System.out.println("---------------------------------------------------");
                System.out.println(conversor);
                System.out.println("---------------------------------------------------");

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Error al procesar la colicitud" + e.getMessage());
            }

        }

    }
}