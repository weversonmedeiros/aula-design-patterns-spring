package br.com.uniceplac.designpatterns.strategy;

import org.springframework.stereotype.Component;

@Component("descontoProfessor")
public class DescontoProfessor implements DescontoStrategy {
    @Override
    public double calcularDesconto(double valor) {
        return valor * 0.70; // 30% de desconto
    }
}