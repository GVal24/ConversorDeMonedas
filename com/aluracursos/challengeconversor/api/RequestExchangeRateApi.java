package com.aluracursos.challengeconversor.api;

public record RequestExchangeRateApi(String base_code, String target_code, double conversion_rate, double conversion_result) {
}
