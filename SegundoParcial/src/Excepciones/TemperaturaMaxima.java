package Excepciones;

import Modelos.Urgentes;
import Servicios.JsonUtils;
import Servicios.ServicioSistemaDeSalud;

import java.io.IOException;

public class TemperaturaMaxima extends Exception{

    public TemperaturaMaxima(int kit, String barrio) throws IOException {
        JsonUtils utilidades = new JsonUtils();
        String nombreArchivo = "urgentes.json";
        System.out.println("Temperatura demasiado alta, se agrega al archivo Urgencia");
        utilidades.escribirArchivoUrgente(nombreArchivo, new Urgentes(kit, barrio));

    }
}
