package Excepciones;

import Servicios.ServicioSistemaDeSalud;

public class KitsInsuficientes extends Exception{
    private ServicioSistemaDeSalud ss = new ServicioSistemaDeSalud();

    public KitsInsuficientes(){
        if(ss.getCantidadKits() == 0){
            ss.setCantidadKits(100);
        }
    }
}
