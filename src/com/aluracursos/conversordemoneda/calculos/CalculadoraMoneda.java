package com.aluracursos.conversordemoneda.calculos;

import com.aluracursos.conversordemoneda.ObtenerDatos;

public class CalculadoraMoneda {

    private double montoSalida;


    public double calcularCambio(ObtenerDatos oDatos){


        //Obtenemos los valores y el tipo de cambio
        montoSalida = oDatos.getMontoIngreso() / oDatos.getTasaconversion();

        //Regresamos el monto la convertido
        oDatos.setMontoSalida(montoSalida);
        //System.out.println(montoSalida);
        return montoSalida;
    }
}
