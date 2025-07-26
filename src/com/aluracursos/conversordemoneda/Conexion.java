package com.aluracursos.conversordemoneda;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class Conexion {

    private String apiKey;
    private String monedaPrincipal;
    //private HttpRequest request;
    //private HttpResponse<String> response;

    public Conexion(String apiKey, String monedaPrincipal){

        this.apiKey = apiKey;
        this.monedaPrincipal = monedaPrincipal;
    }



    public HttpClient getClient(){
        HttpClient client = HttpClient.newHttpClient();
        return client;
    }

     public HttpResponse<String> getRequest(){
         String direccion = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+monedaPrincipal;
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create(direccion))
                 .build();
         HttpResponse<String> response = null;
         try {
             response = getClient()
                     .send(request, HttpResponse
                             .BodyHandlers
                             .ofString());
         }catch (IOException e){
             System.out.println(e);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }

         return response;
     }

}
