package br.com.uniceplac.designpatterns.strategy;

import org.springframework.stereotype.Component;

@Component("descontoEstudante")
public class DescontoEstudante implements DescontoStrategy {
    @Override
    public double calcularDesconto(double valor) {
        return valor * 0.50; // 50% de desconto
    }
}