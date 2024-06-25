package SegundoBi.Organizador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Organizador {
    private List<Conta> contas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void adicionarContaDeLuz() {
        System.out.println("Digite a descrição da conta de luz:");
        String descricao = scanner.nextLine();
        System.out.println("Digite o valor da conta de luz:");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        contas.add(new ContaDeLuz(descricao, valor));
        System.out.println("Conta de luz adicionada com sucesso!");
    }

    public void adicionarContaDeAgua() {
        System.out.println("Digite a descrição da conta de água:");
        String descricao = scanner.nextLine();
        System.out.println("Digite o valor da conta de água:");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        contas.add(new ContaDeAgua(descricao, valor));
        System.out.println("Conta de água adicionada com sucesso!");
    }

    public void adicionarContaDeGas() {
        System.out.println("Digite a descrição da conta de gás:");
        String descricao = scanner.nextLine();
        System.out.println("Digite o valor da conta de gás:");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        contas.add(new ContaDeGas(descricao, valor));
        System.out.println("Conta de gás adicionada com sucesso!");
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta registrada.");
        } else {
            System.out.println("Listando contas:");
            for (Conta conta : contas) {
                System.out.println("Descrição: " + conta.getDescricao() + " - Valor: R$" + conta.getValor());
            }
        }
    }

    public void calcularTotalContas() {
        double total = contas.stream().mapToDouble(Conta::getValor).sum();
        System.out.println("Total a pagar: R$" + total);
    }

    public void inserirSalario() {
        System.out.println("Digite o valor do salário:");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        double totalContas = contas.stream().mapToDouble(Conta::getValor).sum();
        double saldo = salario - totalContas;
        System.out.println("Saldo após pagar as contas: R$" + saldo);
    }

    public void executar() {
        int opcao;
        do {
            System.out.println("\nMain");
            System.out.println("1 - Adicionar Conta de Luz");
            System.out.println("2 - Adicionar Conta de Água");
            System.out.println("3 - Adicionar Conta de Gás");
            System.out.println("4 - Listar Contas");
            System.out.println("5 - Calcular Total de Contas");
            System.out.println("6 - Inserir Salário e Calcular Saldo");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção:");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarContaDeLuz();
                    break;
                case 2:
                    adicionarContaDeAgua();
                    break;
                case 3:
                    adicionarContaDeGas();
                    break;
                case 4:
                    listarContas();
                    break;
                case 5:
                    calcularTotalContas();
                    break;
                case 6:
                    inserirSalario();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        Organizador organizador = new Organizador();
        organizador.executar();
    }
}