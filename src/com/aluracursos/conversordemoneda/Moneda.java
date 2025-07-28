package com.aluracursos.conversordemoneda;

import java.util.Map;

public record Moneda(String basecode, double conversion_rates) {

    @Override
    public String toString() {
        return "Moneda{" +
                "basecode='" + basecode + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }
}
