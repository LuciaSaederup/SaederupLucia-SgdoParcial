package Modelos;

import java.util.ArrayList;
import java.util.List;

public class SanosYAislados {
    private List<Persona> sanos;
    private List<Urgentes> aislados;

    public SanosYAislados() {
    }

    public SanosYAislados(List<Persona> sanos, List<Urgentes> aislados) {
        this.sanos = sanos;
        this.aislados = aislados;
    }

    public List<Persona> getSanos() {
        return sanos;
    }

    public void setSanos(List<Persona> sanos) {
        this.sanos = sanos;
    }

    public List<Urgentes> getAislados() {
        return aislados;
    }

    public void setAislados(List<Urgentes> aislados) {
        this.aislados = aislados;
    }

    @Override
    public String toString() {
        return "SanosYAislados{" +
                "sanos=" + sanos +
                ", aislados=" + aislados +
                '}';
    }
}
