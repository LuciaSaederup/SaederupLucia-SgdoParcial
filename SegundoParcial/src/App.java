import Excepciones.KitsInsuficientes;
import Excepciones.PersonaYaExiste;
import Modelos.Persona;
import Servicios.JsonUtils;
import Servicios.ServicioPersona;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws KitsInsuficientes, IOException, PersonaYaExiste {
        ServicioPersona servicioPersona = new ServicioPersona();
        JsonUtils utilidades = new JsonUtils();
        Persona persona1 = new Persona("Maria", "Gomez",50,"Chacarita","PRofesora", Long.valueOf(20159874));
        Persona persona2 = new Persona("Juan","Perez", 25,"San jose", "carpintero", Long.valueOf(38291454));
        servicioPersona.registrarPersona(persona1);
        servicioPersona.registrarPersona(persona2);
        utilidades.persistirEnArchivoSanosYAislados("sanosYAislados.json");
    }
}
