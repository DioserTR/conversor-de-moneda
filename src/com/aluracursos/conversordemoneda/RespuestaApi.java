package com.aluracursos.conversordemoneda;

import java.util.Map;

public class RespuestaApi {
    String base_code;
    Map<String, Double> conversion_rates;

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }
}
