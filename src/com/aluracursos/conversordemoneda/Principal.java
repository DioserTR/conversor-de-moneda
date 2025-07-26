package com.aluracursos.conversordemoneda;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la moneda que desea convertir: ");
        String tipoMoneda = scanner.nextLine();
        String apiKey = "ffc0cc3b4086110623160275";


        //Realizamos la conexion
        Conexion conexion = new Conexion(apiKey,tipoMoneda);

        HttpClient client = conexion.getClient();
        HttpResponse<String> response = conexion.getRequest();

        //Clase
        //parseamos la respuesta con JSON

        JsonElement jsonElement = JsonParser.parseString(response.body());
        JsonObject jsonObject = jsonElement.getAsJsonObject();


        //Clase
        //Extraemos base_code
        String basecode = jsonObject.get("base_code").getAsString();

        //Extraemos el Objeto consersion_rates
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        //Obtenemos la moneda
        String monedaDestino = "PEN";
        double tasaConversion = conversionRates.get(monedaDestino).getAsDouble();

        //Respuesta
        System.out.println("Base: " + tipoMoneda
                + " Moneda conversion: "
                + monedaDestino
                + " Monto: "
                + tasaConversion);

        //Gson gson = new Gson();
        //RespuestaApi respuesta = gson.fromJson(response.body(), RespuestaApi.class);

        //Extraemos la tasa de conversion
        //String monedaDestino = "PEN";
        //double tasa = respuesta.conversion_rates.get(monedaDestino);

        //Moneda moneda = new Moneda(respuesta.base_code, tasa);

        //System.out.println(moneda);



    }
}
