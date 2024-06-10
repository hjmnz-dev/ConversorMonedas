package conversordemonedas.principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GuardarArchivo {

    private List<ExchangeModel> lista;
    private ExchangeModel archivo;

    public GuardarArchivo(List<ExchangeModel> lista) throws IOException {
        this.lista = lista;
        guardarLista(this.lista);
    }

    private void guardarLista(List<ExchangeModel> lista) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter escritura = new FileWriter("ListaExchange.json");
        escritura.write(gson.toJson(lista));
        escritura.close();

        System.out.println("Archivo json guardado exitosamente!");
    }

}
