package br.com.uniceplac.designpatterns.controller;

import br.com.uniceplac.designpatterns.strategy.DescontoStrategy;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class CalculadoraBean {

    @Autowired
    private ApplicationContext context;

    private double valorOriginal;
    private String tipoDesconto;
    private double valorFinal;

    public void calcular() {
        if (tipoDesconto != null && !tipoDesconto.isEmpty()) {
            DescontoStrategy strategy = (DescontoStrategy) context.getBean(tipoDesconto);
            this.valorFinal = strategy.calcularDesconto(valorOriginal);
        }
    }

    public double getValorOriginal() { return valorOriginal; }
    public void setValorOriginal(double valorOriginal) { this.valorOriginal = valorOriginal; }

    public String getTipoDesconto() { return tipoDesconto; }
    public void setTipoDesconto(String tipoDesconto) { this.tipoDesconto = tipoDesconto; }

    public double getValorFinal() { return valorFinal; }
    public void setValorFinal(double valorFinal) { this.valorFinal = valorFinal; }
}