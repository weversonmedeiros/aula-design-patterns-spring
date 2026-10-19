package br.com.uniceplac.designpatterns.service;

import br.com.uniceplac.designpatterns.dto.FreteRequest;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraFreteService {
    public double calcular(FreteRequest request) {
        double valorFinal = 0.0;

        if (request.tipoFrete().equalsIgnoreCase("PAC")) {
            valorFinal = (request.distanciaEmKm() * 0.5) + (request.pesoEmKg() * 1.2);
        } else if (request.tipoFrete().equalsIgnoreCase("SEDEX")) {
            valorFinal = (request.distanciaEmKm() * 1.5) + (request.pesoEmKg() * 2.5);
        } else if (request.tipoFrete().equalsIgnoreCase("MOTOBOY")) {
            valorFinal = 20.00; 
        } else if (request.tipoFrete().equalsIgnoreCase("TRANSPORTADORA")) {
            valorFinal = (request.distanciaEmKm() * 0.8) + (request.pesoEmKg() * 5.0) + 15.0; 
        } else {
            throw new IllegalArgumentException("Tipo de frete não suportado: " + request.tipoFrete());
        }

        return valorFinal;
    }
}