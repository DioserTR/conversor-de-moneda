package com.aluracursos.conversordemoneda;

import java.util.Map;

public record Moneda(String monedaIngreso, String monedaSalida, double montoIngreso, double montoSalida) {

    @Override
    public String toString() {

        return "El valor " + montoIngreso +" ("+monedaIngreso +") " +
                "corresponde al valor final de =>>> "
                + montoSalida + " ("+monedaSalida+")";

                //"El valor 25.0 (USD) corresponde al valor final de =>>> 20293.70 (PEN)" +

    }
}
