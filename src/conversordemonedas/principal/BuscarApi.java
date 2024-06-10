package conversordemonedas.principal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscarApi {
    private String uriBase;
    private int monto;
    private String json;

    public BuscarApi(String uriBase){
        this.uriBase = uriBase;
        busquedaExchangeApi();
    }

    private int montoValidacion(){
        Scanner lector = new Scanner(System.in);
        Exception exep = null;
        do {

            System.out.println("Digite el monto que desea convertir: ");
            try {
                this.monto = lector.nextInt();
                return this.monto;
            }catch (Exception e){
                exep = e;
                System.out.println("Por favor, digite un monto numerico valido");
            }

        }while(exep != null);

        return 0;

    }

    private void busquedaExchangeApi(){
        try{
            String direccion = "https://v6.exchangerate-api.com/v6/f3130bd34216e0735f3483b2/pair/"+uriBase+"/"+montoValidacion();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.json = response.body();
            new JsonToRecord(this.getJson());

        }catch (Exception e){
            System.out.println("Error en busqueda en api! " + e);
        }


    }

    public int getMonto() {
        return monto;
    }

    public String getJson() {
        return json;
    }
}
