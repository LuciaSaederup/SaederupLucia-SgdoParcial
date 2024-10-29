package Modelos;

public class Urgentes {
    private int numeroKit;
    private String barrio;

    public Urgentes() {
    }

    public Urgentes(int numeroKit, String barrio) {
        this.numeroKit = numeroKit;
        this.barrio = barrio;
    }

    public int getNumeroKit() {
        return numeroKit;
    }

    public void setNumeroKit(int numeroKit) {
        this.numeroKit = numeroKit;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
}
