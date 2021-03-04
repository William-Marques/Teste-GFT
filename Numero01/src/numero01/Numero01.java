package numero01;

import java.util.Scanner;

public class Numero01 {

    /*
     * 1. Crie um programa que leia cinco números e imprima na tela:
     * Qual o maior número
     * Qual o menor número
     * Se os cinco números forem iguais, informe ao usuário que os 5 são iguais.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner (System.in);
        double numeros[] = new double[5];
        double maiornum =0, menornum =0;
        
        for(int i = 0; i < numeros.length; i++){
            System.out.print("Digite o " +(i+1)+"º numero: ");
		numeros[i] = teclado.nextDouble();
                    if(numeros[i] > maiornum){ 
			maiornum = numeros[i];
		}
	}
        
        menornum = numeros[0];
        for (int j = 0; j < numeros.length; j++) {
            if(numeros[j] < menornum){
		menornum = numeros[j];
		}
                   
        }
        if((numeros[1]==numeros[2])&&(numeros[2]==numeros[3])&&(numeros[3]==numeros[4])&&(numeros[4]==numeros[0])){
            System.out.println("Todos números são iguais");
        }else{
            System.out.println("Maior número é "+ maiornum);
            System.out.println("Menor número é "+ menornum);
        }            
        
    }
    
}
