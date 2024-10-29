package Modelos;

public class Urgentes {
    private int numeroKit;
    private String barrio;
    private int temperatura;

    public Urgentes() {
    }

    public Urgentes(int numeroKit, String barrio, int temperatura) {
        this.numeroKit = numeroKit;
        this.barrio = barrio;
        this.temperatura = temperatura;
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

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Urgentes{" +
                "numeroKit=" + numeroKit +
                ", barrio='" + barrio + '\'' +
                ", temperatura=" + temperatura +
                '}';
    }
}
