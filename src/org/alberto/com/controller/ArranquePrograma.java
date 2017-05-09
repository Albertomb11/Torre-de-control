package org.alberto.com.controller;

import org.alberto.com.model.Avion;
import org.alberto.com.model.ColeccionAviones;
import java.util.Date;
import java.util.Scanner;
/**
 * Created by Alberto on 09/05/2017.
 */
public class ArranquePrograma {
    ColeccionAviones coleccionAviones;

    public ArranquePrograma(){
        coleccionAviones = new ColeccionAviones();
    }

    public void arranque() {
        int opt;

        while ((opt = showMenu()) != 0) {
            switch (opt) {
                case 1:
                    coleccionAviones.sumarAvion(leerAvion());
                    break;
                case 2:
                    if (coleccionAviones.longitud() > 0) {
                        coleccionAviones.mostrarAviones();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public Avion leerAvion() {
        Scanner s = new Scanner(System.in);
        String codigoVuelo;
        String aerolinea;
        int velocidadAeronave;
        Date fechaHora;
        double distanciaAeropuerto;
        Avion avion;

        do {
            System.out.println("Inserte código de vuelo: ");
            codigoVuelo = s.next();
        } while (codigoVuelo.equals(""));

        do {
            System.out.println("Inserte aerolinea: ");
            aerolinea = s.next();
        } while (aerolinea.equals(""));

        do {
            System.out.println("Inserte la velocidad de la aeronave: ");
            velocidadAeronave = s.nextInt();
        } while (velocidadAeronave <= 0);

        fechaHora = new Date();

        do {
            System.out.println("Distancia a pista");
            distanciaAeropuerto = s.nextDouble();
        } while (distanciaAeropuerto <= 0.0);

        avion = new Avion(codigoVuelo, aerolinea, velocidadAeronave, fechaHora, distanciaAeropuerto);

        return avion;
    }

    public int showMenu() {
        Scanner s = new Scanner(System.in);
        int opt;

        System.out.println("****************************");
        System.out.println("* 1. Registrar aeronave    *");
        if (coleccionAviones.longitud() > 0) {
            System.out.println("* 2. Aeronaves registradas *");
        }
        System.out.println("* 0. Salir                 *");
        System.out.println("****************************");

        System.out.println("Opción: ");
        opt = s.nextInt();

        return opt;
    }
}

