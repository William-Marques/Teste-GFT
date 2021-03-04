package numero03;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Numero03 {
    
    /*
    3. Considerando o paradigma de Orientação a Objetos:
    • Crie uma classe chamada “Carga” que contenha os atributos: valor e peso,
    seus seletores(getters) e modificadores(setters).
    • Crie uma classe pai abstrata chamada “Transporte” que receba uma “Carga”
    no construtor, e um método chamado: “calculaFrete(int distancia)” que irá
    retornar o valor do frete baseado na carga. O parâmetro distancia, informa um
    inteiro com a distância em Km.
    • Crie duas classes que herdam “Transporte”: “Vagao” e “Caminhao”
    o “Vagao” deverá implementar o método “calculaFrete(int distancia)”,
    considerando que o frete é definido por: 7% do peso da carga + 1% do
    valor da carga + R$0,50 por Km.
    o “Caminhao” deverá implementar o método “calculaFrete(int
    distancia)”, considerando que o frete é definido por: 2% do peso da
    carga + 3% do valor da carga + R$2 por Km.
    o Se um vagão receber uma carga com menos de 15.000kg, $5.000
    deverão ser adicionados ao frete.
    o Se um caminhão receber uma carga com valor acima de $40.000, um
    desconto de 25% deve ser concedido no frete.
    */

    private static DecimalFormat df = new DecimalFormat("#,####.##");

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o peso da carga: ");
        final String peso = sc.next();
        System.out.print("Informe o valor da carga: ");
        final String valor = sc.next();
        System.out.print("Informe a distancia de entrega: ");
        final String distancia = sc.next();

        final Carga carga = new Carga(new BigDecimal(valor), Double.parseDouble(peso));
        System.out.println(
            new Vagao(carga).calculaFrete(Integer.parseInt(distancia)));
        System.out.println(
            new Caminhao(carga).calculaFrete(Integer.parseInt(distancia)));
    }

    public static class Carga  {

        private BigDecimal valor;
        private Double peso;

        public Carga(BigDecimal valor, Double peso) {
            this.valor = valor;
            this.peso = peso;
        }

        public BigDecimal getValor() {
            return valor;
        }

        public void setValor(BigDecimal valor) {
            this.valor = valor;
        }

        public Double getPeso() {
            return peso;
        }

        public void setPeso(Double peso) {
            this.peso = peso;
        }
    }

    public abstract static class Transporte {

        private Carga carga;

        public Transporte(Carga carga) {
            this.carga = carga;
        }

        public abstract String calculaFrete(int distancia);
    }

    public static class Vagao extends Transporte {

        public Vagao(Carga carga) {
            super(carga);
        }

        @Override
        public String calculaFrete(int distancia) {
            double custoFrete = (super.carga.peso * 0.07D);
            custoFrete += super.carga.valor.multiply(new BigDecimal(0.01)).doubleValue();
            custoFrete += Double.valueOf(distancia) * 0.5d;

            if (super.carga.peso < 15000d) {
                custoFrete += 5000d;
            }

            return df.format(custoFrete );
        }
    }

    public static class Caminhao extends Transporte {

        public Caminhao(Carga carga) {
            super(carga);
        }

        @Override
        public String calculaFrete(int distancia) {
            double custoFrete = (super.carga.peso * 0.02D);
            custoFrete += super.carga.valor.multiply(new BigDecimal(0.03)).doubleValue();
            custoFrete += Double.valueOf(distancia) * 2d;

            if (super.carga.valor.compareTo(new BigDecimal(40000)) > 0) {
                double desconto = custoFrete * 0.25d;
                custoFrete -= desconto;
            }

            return df.format(custoFrete);
        }
    }
}
