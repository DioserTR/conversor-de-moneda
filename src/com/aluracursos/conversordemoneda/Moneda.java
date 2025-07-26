package com.aluracursos.conversordemoneda;

import java.util.Map;

public record Moneda(String result, double conversion_rates) {

    @Override
    public String toString() {
        return "Moneda: " + result +
                ", Conversión=" + conversion_rates;
    }
}
