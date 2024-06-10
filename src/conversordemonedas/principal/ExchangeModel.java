package conversordemonedas.principal;




public class ExchangeModel {
    private String codigoMonedaOrigen;
    private String codigoMonedaDestino;
    private double montoOrigen;
    private double montoDestino;

    public ExchangeModel(ExchangeModelRecord record, BuscarApi buscarApi) {
        this.codigoMonedaOrigen= record.base_code();
        this.codigoMonedaDestino= record.target_code();
        this.montoOrigen = buscarApi.getMonto();
        this.montoDestino = record.conversion_result();
    }

    public String getCodigoMonedaOrigen() {
        return codigoMonedaOrigen;
    }

    public String getCodigoMonedaDestino() {
        return codigoMonedaDestino;
    }

    public double getMontoOrigen() {
        return montoOrigen;
    }

    public double getMontoDestino() {
        return montoDestino;
    }



    @Override
    public String toString() {
        return "Cambio de moneda: " + "\n"+
                " Codigo de moneda origen: " + codigoMonedaOrigen + ", \n" +
                " Codigo de moneda destino: " + codigoMonedaDestino + ", \n" +
                " Monto de origen: " + montoOrigen + ", \n" +
                " Monto de destino: " + montoDestino;
    }

}


