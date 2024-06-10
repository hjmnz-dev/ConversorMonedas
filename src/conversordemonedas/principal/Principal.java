package conversordemonedas.principal;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        List<ExchangeModel> cambiosMoneda = new ArrayList<>();
        Scanner lector = new Scanner(System.in);
        int encendido = 1;
            while(encendido == 1){
                String uriBase = null;
                BuscarApi buscarApi = null;
                ExchangeModel cambioMoneda = null;
                String mensajeFinal = null;
                System.out.println("""
                    ***********************************************************
                    --> Sea bienvenido al conversor de moneda :D <--
                    
                    1) Dolar --> Peso argentino
                    2) Peso argentino --> Dolar
                    3) Dolar --> Real brasileño
                    4) Real brasileño --> Dolar
                    5) Dolar --> Peso colombiano
                    6) Peso colombiano --> Dolar
                    7) Salir
                    
                    - Elija una opcion valida: 
                    
                    ***********************************************************
                    """);

                try{
                    int opcion = lector.nextInt();

                    switch (opcion){
                        case 1:
                            uriBase = "USD/ARS";
                            buscarApi = new BuscarApi(uriBase);

                            try{
                                cambioMoneda = new ExchangeModel(new JsonToRecord(buscarApi.getJson()).getRecord(), buscarApi);
                                mensajeFinal = MessageFormat.format("El valor {0} [{1}] corresponde al valor final de =>>> {2} [{3}]", buscarApi.getMonto(), cambioMoneda.getCodigoMonedaOrigen(), cambioMoneda.getMontoDestino(), cambioMoneda.getCodigoMonedaDestino());
                                System.out.println(mensajeFinal);
                                cambiosMoneda.add(cambioMoneda);

                                new GuardarArchivo(cambiosMoneda);
                            }catch(Exception e){
                                System.out.println("Error al crear clase modelo "+e);
                            }

                            break;

                        case 2:
                            uriBase = "ARS/USD";
                            buscarApi = new BuscarApi(uriBase);

                            try{
                                cambioMoneda = new ExchangeModel(new JsonToRecord(buscarApi.getJson()).getRecord(), buscarApi);
                                mensajeFinal = MessageFormat.format("El valor {0} [{1}] corresponde al valor final de =>>> {2} [{3}]", buscarApi.getMonto(), cambioMoneda.getCodigoMonedaOrigen(), cambioMoneda.getMontoDestino(), cambioMoneda.getCodigoMonedaDestino());
                                System.out.println(mensajeFinal);
                                cambiosMoneda.add(cambioMoneda);
                                new GuardarArchivo(cambiosMoneda);
                            }catch(Exception e){
                                System.out.println("Error al crear clase modelo "+e);
                            }
                            break;

                        case 3:
                            uriBase = "USD/BRL";
                            buscarApi = new BuscarApi(uriBase);

                            try{
                                cambioMoneda = new ExchangeModel(new JsonToRecord(buscarApi.getJson()).getRecord(), buscarApi);
                                mensajeFinal = MessageFormat.format("El valor {0} [{1}] corresponde al valor final de =>>> {2} [{3}]", buscarApi.getMonto(), cambioMoneda.getCodigoMonedaOrigen(), cambioMoneda.getMontoDestino(), cambioMoneda.getCodigoMonedaDestino());
                                System.out.println(mensajeFinal);
                                cambiosMoneda.add(cambioMoneda);
                                new GuardarArchivo(cambiosMoneda);
                            }catch(Exception e){
                                System.out.println("Error al crear clase modelo "+e);
                            }
                            break;

                        case 4:
                            uriBase = "BRL/USD";
                            buscarApi = new BuscarApi(uriBase);

                            try{
                                cambioMoneda = new ExchangeModel(new JsonToRecord(buscarApi.getJson()).getRecord(), buscarApi);
                                mensajeFinal = MessageFormat.format("El valor {0} [{1}] corresponde al valor final de =>>> {2} [{3}]", buscarApi.getMonto(), cambioMoneda.getCodigoMonedaOrigen(), cambioMoneda.getMontoDestino(), cambioMoneda.getCodigoMonedaDestino());
                                System.out.println(mensajeFinal);
                                cambiosMoneda.add(cambioMoneda);
                                new GuardarArchivo(cambiosMoneda);
                            }catch(Exception e){
                                System.out.println("Error al crear clase modelo "+e);
                            }
                            break;

                        case 5:
                            uriBase = "USD/COP";
                            buscarApi = new BuscarApi(uriBase);

                            try{
                                cambioMoneda = new ExchangeModel(new JsonToRecord(buscarApi.getJson()).getRecord(), buscarApi);
                                mensajeFinal = MessageFormat.format("El valor {0} [{1}] corresponde al valor final de =>>> {2} [{3}]", buscarApi.getMonto(), cambioMoneda.getCodigoMonedaOrigen(), cambioMoneda.getMontoDestino(), cambioMoneda.getCodigoMonedaDestino());
                                System.out.println(mensajeFinal);
                                cambiosMoneda.add(cambioMoneda);
                                new GuardarArchivo(cambiosMoneda);
                            }catch(Exception e){
                                System.out.println("Error al crear clase modelo "+e);
                            }
                            break;

                        case 6:
                            uriBase = "COP/USD";
                            buscarApi = new BuscarApi(uriBase);

                            try{
                                cambioMoneda = new ExchangeModel(new JsonToRecord(buscarApi.getJson()).getRecord(), buscarApi);
                                mensajeFinal = MessageFormat.format("El valor {0} [{1}] corresponde al valor final de =>>> {2} [{3}]", buscarApi.getMonto(), cambioMoneda.getCodigoMonedaOrigen(), cambioMoneda.getMontoDestino(), cambioMoneda.getCodigoMonedaDestino());
                                System.out.println(mensajeFinal);
                                cambiosMoneda.add(cambioMoneda);
                                new GuardarArchivo(cambiosMoneda);
                            }catch(Exception e){
                                System.out.println("Error al crear clase modelo "+e);
                            }
                            break;

                        case 7:
                            encendido=0;
                            System.out.println("Gracias por utilizar el convertidor de moneda, cerrando programa...");

                            break;

                        default:
                            System.out.println("Numero digitado invalido, opciones vigentes(1-7).");
                            break;

                    }
                }catch(Exception e){
                    System.out.println("Respuesta invalida, cerrando programa...");
                    encendido = 0;

                }
            }
    }
}
