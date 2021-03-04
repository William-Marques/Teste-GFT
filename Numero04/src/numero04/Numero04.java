package numero04;

import java.util.Scanner;

public class Numero04 {
    
    /*
    *4. Escreva um programa onde o usuário digite um valor inteiro e o programa escreva a
    * música do “Elefante incomoda” correspondente ao valor digitado:
    * Exemplo: Usuário digitou o nº 3
    *Saída:  Incomoda Incomoda Incomoda muito mais
    */

    public static void main (String... args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um valor inteiro: ");
        while(sc.hasNext()){
            System.out.print("Um elefante ");
            final Integer repeticoesInt = Integer.parseInt(sc.next());
            for (int i=repeticoesInt; i > 0; i--) {
                System.out.print("Incomoda, ");
            }
            System.out.print("muito mais. ");
        }
        sc.close();
        
    }
}
