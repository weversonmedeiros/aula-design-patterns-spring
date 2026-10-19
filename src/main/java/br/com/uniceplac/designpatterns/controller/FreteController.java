package br.com.uniceplac.designpatterns.controller;

import br.com.uniceplac.designpatterns.dto.FreteRequest;
import br.com.uniceplac.designpatterns.service.CalculadoraFreteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fretes")
public class FreteController {

    private final CalculadoraFreteService calculadoraFreteService;

    public FreteController(CalculadoraFreteService calculadoraFreteService) {
        this.calculadoraFreteService = calculadoraFreteService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<Double> calcularFrete(@RequestBody FreteRequest request) {
        double valorFrete = calculadoraFreteService.calcular(request);
        return ResponseEntity.ok(valorFrete);
    }
}