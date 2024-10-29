package Servicios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {
    private ObjectMapper mapper;

    public JsonUtils(){
        this.mapper = new ObjectMapper();
    }

    public List<Object> leerArchivo(String nombreArch) throws IOException {
        Object[] arreglo = new Object[0];
        try {
            arreglo = mapper.readValue(new File(nombreArch), Object[].class);

            String aerString = mapper.writeValueAsString(arreglo);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return Arrays.asList(arreglo);
    }

    public void escribir(String nombreArch, Object Object) throws IOException {
        try {
            List<Object> lista = this.leerArchivo(nombreArch);
            lista.add(Object);
            this.mapper.writeValue(new File(nombreArch), lista);

            System.out.println("Agregado con exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
