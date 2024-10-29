package Excepciones;

public class PersonaYaExiste extends Exception{

    public PersonaYaExiste() {
        super("El dni de la persona ya se encuentra ingresado");
    }

}
