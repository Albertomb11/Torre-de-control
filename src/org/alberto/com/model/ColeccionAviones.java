package org.alberto.com.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Alberto on 08/05/2017.
 */
public class ColeccionAviones {
    private ArrayList<Avion> aviones;

    public ColeccionAviones(){
        aviones = new ArrayList<>();
    }

    public void sumarAvion(Avion avion){
        if (avion != null){
            aviones.add(avion);
        }
    }

    public void mostrarAviones() {
        Collections.sort(aviones, Avion.comparadorDistancia);

        for (Avion avion : aviones) {
            System.out.println(avion);
        }
    }

    public int longitud() {
        return aviones.size();
    }
}

