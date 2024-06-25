package SegundoBi.Organizador;

public class Conta {
    private String descricao;
    private double valor;

    public Conta(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}