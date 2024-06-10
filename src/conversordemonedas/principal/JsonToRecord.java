package conversordemonedas.principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonToRecord {
    private String json;
    private ExchangeModelRecord record;

    public JsonToRecord(String json) {
        this.json = json;
        setRecord(this.json);
    }

    private void setRecord(String json){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        record = gson.fromJson(json,ExchangeModelRecord.class);
    }

    public ExchangeModelRecord getRecord(){
        return record;
    }



}
