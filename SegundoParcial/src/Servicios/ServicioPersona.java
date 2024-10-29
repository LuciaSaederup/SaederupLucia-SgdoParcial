package Servicios;

import Excepciones.KitsInsuficientes;
import Excepciones.PersonaYaExiste;
import Modelos.Persona;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class ServicioPersona {
    private String archivoPersona;
    JsonUtils utilidades;
    private ServicioSistemaDeSalud servicioSS;

    public ServicioPersona() {
        this.archivoPersona = "personas.json";
        this.utilidades = new JsonUtils();
        this.servicioSS = new ServicioSistemaDeSalud();
    }





    public void registrarPersona(Persona persona) throws IOException, PersonaYaExiste, KitsInsuficientes {
        try{
            ArrayList<Object> personas = (ArrayList<Object>) utilidades.leerArchivo(this.archivoPersona);
            if(servicioSS.getCantidadKits() <= 0){
                if(personas.equals(persona)){
                    throw new PersonaYaExiste();
                }else{
                    int temperatura = (int) Math.random();
                    servicioSS.reducirKit();
                    persona.setKit(servicioSS.getCantidadKits());
                    personas.add(persona);
                    utilidades.escribir(this.archivoPersona, personas);
                    servicioSS.testear(persona);
                }
            }else{
                throw new KitsInsuficientes();
            }


        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }




}
