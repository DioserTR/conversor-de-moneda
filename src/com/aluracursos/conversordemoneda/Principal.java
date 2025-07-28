package com.aluracursos.conversordemoneda;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        //Declaramos variables principales
        String apiKey = "ffc0cc3b4086110623160275";
        String monedaIngreso = null;
        String monedaSalida = null;

        //Mostramos Menu
        Conversor conversor = new Conversor();


        Scanner scanner = new Scanner(System.in);
        while(true){
            conversor.exibirMenu();
            int numeroDeMenu = scanner.nextInt();

            if (numeroDeMenu == 9){
                break;
            } else if (numeroDeMenu < 1 || numeroDeMenu > 9) {
                System.out.println("Opción no valida");
                break;
            }else{
                //Seleccionamos las monedas que vamos a trabajar
                switch (numeroDeMenu){
                    case 1:
                        monedaIngreso = "USD";
                        monedaSalida = "ARS";
                        break;
                    case 2:
                        monedaIngreso = "ARS";
                        monedaSalida = "USD";
                        break;
                    case 3:
                        monedaIngreso = "USD";
                        monedaSalida = "BRL";
                        break;
                    case 4:
                        monedaIngreso = "BRL";
                        monedaSalida = "USD";
                        break;
                    case 5:
                        monedaIngreso = "USD";
                        monedaSalida = "COP";
                        break;
                    case 6:
                        monedaIngreso = "COP";
                        monedaSalida = "USD";
                        break;
                    case 7:
                        monedaIngreso = "USD";
                        monedaSalida = "PEN";
                        break;
                    case 8:
                        monedaIngreso = "PEN";
                        monedaSalida = "USD";
                        break;
                }

                System.out.println("Ingrese el valor que desea convertir:");
                double montoIngreso = scanner.nextDouble();

                //Enviamos parametro y (Recuperamos los datos)
                ObtenerDatos oDatos = new ObtenerDatos(apiKey, monedaIngreso, monedaSalida, montoIngreso);
                oDatos.Resultado();
            }
        }



        //Interactuamos con el usuario
        //System.out.println("Ingrese la moneda que desea convertir: ");
        //String tipoMoneda = scanner.nextLine();



        //Enviamos parametro y (Recuperamos los datos)
        //ObtenerDatos oDatos = new ObtenerDatos(apiKey,tipoMoneda);

        //Mostramos resultados de Record
        //oDatos.Resultado();


    }
}
