package Servicios;

import Modelos.Persona;
import Modelos.SanosYAislados;
import Modelos.Urgentes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {
    private ObjectMapper mapper;

    public JsonUtils(){
        this.mapper = new ObjectMapper();
    }

    public List<Persona> leerArchivoPersonas(String nombreArch) throws IOException {
        Persona[] arreglo = new Persona[0];
        try {
            arreglo = mapper.readValue(new File(nombreArch), Persona[].class);

            String aerString = mapper.writeValueAsString(arreglo);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return Arrays.asList(arreglo);
    }

    public void escribirPersona(String nombreArch, Persona persona) throws IOException {
        try {
            List<Persona> lista = this.leerArchivoPersonas(nombreArch);
            lista.add(persona);
            this.mapper.writeValue(new File(nombreArch), lista);

            System.out.println("Agregado con exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Urgentes> leerArchivoUrgente(String nombreArch) throws IOException {
        Urgentes[] arreglo = new Urgentes[0];
        try {
            arreglo = mapper.readValue(new File(nombreArch), Urgentes[].class);

            String aerString = mapper.writeValueAsString(arreglo);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return Arrays.asList(arreglo);
    }

    public void escribirArchivoUrgente(String nombreArch, Urgentes Object) throws IOException {
        try {
            List<Urgentes> lista = this.leerArchivoUrgente(nombreArch);
            lista.add(Object);
            this.mapper.writeValue(new File(nombreArch), lista);

            System.out.println("Agregado con exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void persistirEnArchivoSanosYAislados(String nombreArch) throws IOException {
        List<Persona> personas = this.leerArchivoPersonas("personas.json");
        List<Urgentes> urgentes = this.leerArchivoUrgente("urgentes.json");

        SanosYAislados sanosYAislados = new SanosYAislados();
        sanosYAislados.setAislados(urgentes);
        sanosYAislados.setSanos(personas);
        this.mapper.writeValue(new File(nombreArch),sanosYAislados);

    }

}
