package Servicios;

import Excepciones.TemperaturaMaxima;
import Modelos.Persona;
import Modelos.Urgentes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ServicioSistemaDeSalud {
    private Integer cantidadKits = 100;
    private Map<Integer, String> temperaturas;
    private List<Urgentes> urgentes;


    public ServicioSistemaDeSalud() {
    }

    public Integer getCantidadKits() {
        return cantidadKits;
    }

    public void setCantidadKits(Integer cantidadKits) {
        this.cantidadKits = cantidadKits;
    }

    public List<Urgentes> getUrgentes() {
        return urgentes;
    }

    public void setUrgentes(List<Urgentes> urgentes) {
        this.urgentes = urgentes;
    }

    public Map<Integer, String> getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(Map<Integer, String> temperaturas) {
        this.temperaturas = temperaturas;
    }

    public void reducirKit(){
        Integer cantidad = getCantidadKits();
        setCantidadKits(cantidad - 1);
    }
    public int getTemperatura() {
        return (int)  Math.max(Long.valueOf(36),Long.valueOf(39));
    }

    public void testear(Persona persona) throws IOException, TemperaturaMaxima {
        persona.setTemperatura(getTemperatura());
        String personaTemperatura = persona.getDni().toString() +"-"+ persona.getTemperatura();
        this.temperaturas.put(persona.getKit(), personaTemperatura);
        this.aislar(persona);
    }

    public void aislar(Persona persona) throws TemperaturaMaxima, IOException {
        if(persona.getTemperatura() >= 38){
            throw new TemperaturaMaxima(persona.getKit(), persona.getBarrio(), persona.getTemperatura());
        }
    }
}
