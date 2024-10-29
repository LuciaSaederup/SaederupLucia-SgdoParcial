package Servicios;

import Excepciones.KitsInsuficientes;
import Excepciones.PersonaYaExiste;
import Excepciones.TemperaturaMaxima;
import Modelos.Persona;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class ServicioPersona {
    private String archivoPersona = "personas.json";

    JsonUtils utilidades;

    private ServicioSistemaDeSalud servicioSS;

    public ServicioPersona() {
        this.utilidades = new JsonUtils();
        this.servicioSS = new ServicioSistemaDeSalud();
    }


    public void registrarPersona(Persona persona) throws IOException, PersonaYaExiste, KitsInsuficientes {
        try{
            List<Persona> personas = utilidades.leerArchivoPersonas(this.archivoPersona);
            if(!(servicioSS.getCantidadKits() <= 0)){
                if(personas.equals(persona)){
                    throw new PersonaYaExiste();
                }else{
                    int temperatura = 36 + (int)(Math.random() * 3);
                    servicioSS.reducirKit();
                    persona.setKit(servicioSS.getCantidadKits());
                    personas.add(persona);
                    utilidades.escribirPersona(archivoPersona, persona);
                    servicioSS.testear(persona);
                }
            }else{
                throw new KitsInsuficientes();
            }


        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (TemperaturaMaxima e) {
            throw new RuntimeException(e);
        }
    }




}
