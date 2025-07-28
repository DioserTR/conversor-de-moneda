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

        //Declaramos variables principales
        String apiKey = "ffc0cc3b4086110623160275";

        //Interactuamos con el usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la moneda que desea convertir: ");
        String tipoMoneda = scanner.nextLine();

        //Enviamos parametro y (Recuperamos los datos)
        ObtenerDatos oDatos = new ObtenerDatos(apiKey,tipoMoneda);

        //Mostramos resultados de Record
        oDatos.Resultado();


    }
}
