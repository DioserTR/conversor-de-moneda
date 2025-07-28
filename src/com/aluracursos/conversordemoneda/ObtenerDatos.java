package com.aluracursos.conversordemoneda;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.http.HttpResponse;

public class ObtenerDatos extends Conexion{

    private String basecode;
    private double tasaconversion;

    public String getBasecode() {
        return basecode;
    }

    public Double getTasaconversion() {
        return tasaconversion;
    }
    public ObtenerDatos(String apiKey, String monedaPrincipal) {
        super(apiKey, monedaPrincipal);
    }

    @Override
    public HttpResponse<String> getRequest() {
        return super.getRequest();
    }

    public JsonObject ParseJsonObject(){
        JsonElement jsonElement = JsonParser.parseString(getRequest().body());
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return jsonObject;
    }

    public void Resultado(){

        JsonObject object = ParseJsonObject();
        //Tenemos el basecode
        this.basecode = object.get("base_code").getAsString();
        JsonObject conversionRates = object.getAsJsonObject("conversion_rates");
        this.tasaconversion = conversionRates.get("PEN").getAsDouble();

        Moneda moneda = new Moneda(getBasecode(), getTasaconversion());
        System.out.println(moneda);

    }


}
