package numero02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Numero02 {
    /*
    2. Elabore um programa para calcular diferentes impostos:
    • Crie uma interface chamada “Imposto” com o método:
    “calculaImposto(double valor)”
    • Crie três classes que implementam a interface Imposto e implemente o
    método “calculaImposto”, seguindo suas regras.
    o ICMS
    ▪ Incide 27% sobre o valor
    o IPI
    ▪ Incide 7% sobre o valor, desde que seja abaixo de 20000
    ▪ Incide 19% sobre o valor, se for igual ou maior que 20000
    o COFINS
    ▪ Incide 4% sobre o valor, somente se for maior que 12000
    ▪ Igual ou abaixo a 12000, não tem incidência

    • Crie uma classe com método Main, que receba um valor e retorne ao usuário:
    o Quanto cada imposto vai custar
    o Qual o valor final com o somatório dos impostos

    Nota: Os percentuais de impostos são fictícios.
    */

    private static DecimalFormat df = new DecimalFormat("#,####.##");

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um valor: ");
        Double valor = Double.parseDouble(sc.next());

        final String icms = new ICMS().calculaImposto(valor);
        final String ipi = new IPI().calculaImposto(valor);
        final String confins = new CONFINS().calculaImposto(valor);

        System.out.println("Valor ICMS: " + icms);
        System.out.println("Valor IPI: " + ipi);
        System.out.println("Valor CONFINS: " + confins);
        System.out.println("Valor Somatória Impostos: " + (Double.parseDouble(icms) + Double.parseDouble(ipi) + Double.parseDouble(confins)));
    }


    public interface Imposto {
        String calculaImposto(double valor);
    }

    public static class ICMS implements Imposto {

        @Override
        public String calculaImposto(double valor) {
            final double indice = valor * 0.27D;
            return df.format(indice);
        }
    }

    public static class IPI implements Imposto{

        @Override
        public String calculaImposto(double valor) {
            if (valor >= 20000d) {
                return df.format(valor*0.19d);
            }
            return df.format(valor*0.07d);
        }
    }

    public static class CONFINS implements Imposto{

        @Override
        public String calculaImposto(double valor) {
            if (valor > 12000d) {
                return df.format(valor*0.04d);
            }
            return df.format(valor);
        }
    }
}
