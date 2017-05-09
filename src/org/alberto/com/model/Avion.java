package org.alberto.com.model;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Alberto on 08/05/2017.
 */
public class Avion {
    //Atributos
    private String codigoVuelo;
    private String aerolinea;
    private int velocidadAeronave;
    private Date fechaHora;
    private double distanciaAeropuerto;

    //Constructores

    public Avion() {
        this.codigoVuelo = "Codigo no valido";
        this.aerolinea = "Aerolinea no valida";
        this.velocidadAeronave = 0;
        this.fechaHora = new Date();
        this.distanciaAeropuerto = 0;
    }

    public Avion(String codigoVuelo, String aerolinea, int velocidadAeronave, Date fechaHora, double distanciaAeropuerto) {
        this.setCodigoVuelo(codigoVuelo);
        this.setAerolinea(aerolinea);
        this.setVelocidadAeronave(velocidadAeronave);
        this.setFechaHora(fechaHora);
        this.setDistanciaAeropuerto(distanciaAeropuerto);
    }

    //Accesores
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        if (codigoVuelo.equals("")){
            this.codigoVuelo = "Codigo no valido";
        }else{
            this.codigoVuelo = codigoVuelo;
        }

    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        if (aerolinea.equals("")){
            this.aerolinea = "Aerolinea no valida";
        }else{
            this.aerolinea = aerolinea;
        }

    }

    public int getVelocidadAeronave() {
        return velocidadAeronave;
    }

    public void setVelocidadAeronave(int velocidadAeronave) {
        if (velocidadAeronave < 0){
            this.velocidadAeronave = 50;
        }else{
            this.velocidadAeronave = velocidadAeronave;
        }
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = new Date();
    }

    public double getDistanciaAeropuerto() {
        return distanciaAeropuerto;
    }

    public void setDistanciaAeropuerto(double distanciaAeropuerto) {
        if (distanciaAeropuerto <= 0){
            this.distanciaAeropuerto = 0;
        }else{
            this.distanciaAeropuerto = distanciaAeropuerto;
        }
    }

    //Metodo toString

    @Override
    public String toString() {
        return "Avion{" +
                "codigoVuelo='" + codigoVuelo + '\'' +
                ", aerolinea='" + aerolinea + '\'' +
                ", velocidadAeronave=" + velocidadAeronave + "Km/h" +
                ", fechaHora=" + fechaHora +
                ", distanciaAeropuerto=" + distanciaAeropuerto + "Km/h" +
                '}';
    }

    public static Comparator<Avion> comparadorDistancia = new Comparator<Avion>() {
        @Override
        public int compare(Avion avion1, Avion avion2) {
            return (int)avion1.getDistanciaAeropuerto() - (int)avion2.getDistanciaAeropuerto();
        }
    };

    public double distanciaActualizada(){
        double distanciaNueva;
        double velocidad = 0;
        Date actual = new Date();

        double antes = this.getFechaHora().getTime();
        double ahora = actual.getTime();

        double diferencia = (ahora - antes)/(1000*60);

        distanciaNueva = this.getDistanciaAeropuerto() - (diferencia * velocidad);

        if (distanciaNueva > 0){
            this.setDistanciaAeropuerto(distanciaNueva);
            return distanciaNueva;
        }else{
            this.setDistanciaAeropuerto(0);
        }
        return distanciaNueva;
    }
}
