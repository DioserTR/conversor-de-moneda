package com.aluracursos.conversordemoneda;

import com.aluracursos.conversordemoneda.calculos.CalculadoraMoneda;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.http.HttpResponse;

public class ObtenerDatos extends Conexion{

    private String basecode;
    private double tasaconversion;

    public double getTasaconversion() {
        return tasaconversion;
    }

    public void setTasaconversion(double tasaconversion) {
        this.tasaconversion = tasaconversion;
    }

    public String getBasecode() {
        return basecode;
    }



    public ObtenerDatos(String apiKey, String monedaIngreso, String monedaSalida, double montoIngreso) {

        super(apiKey, monedaIngreso, monedaSalida, montoIngreso);

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
        this.tasaconversion = conversionRates.get(ObtenerDatos.this.getMonedaIngreso()).getAsDouble();

        //Llamamos a la clase que va ha calcular los resulados
        CalculadoraMoneda calculadoraMoneda = new CalculadoraMoneda();
        calculadoraMoneda.calcularCambio(this);

        Moneda moneda = new Moneda(getMonedaIngreso(),
                getMonedaSalida(),
                getMontoIngreso(),
                getMontoSalida());
//      System.out.println(this.tasaconversion);
        //System.out.println(getMonedaIngreso()+ " " + getMonedaSalida() + " " + getMontoIngreso()+" " + getMontoSalida());
        System.out.println(moneda);

    }


}
