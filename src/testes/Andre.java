package testes;
import java.util.Scanner;

import rb.RedBlackNode;
import rb.RedBlackTree;
public class Andre {
	

	/*
	 * Instrucoes:
	 * Retorna a cor de um n� especifico => arvore.search().color
	 * and open the template in the editor.
	 */

	   public static void main(String []args){
	        System.out.println(" 0 = Black & 1 = RED");
	        System.out.println(" -  Todo n� � red ou black");
	        System.out.println(" -  A raiz � black");
	        System.out.println(" -  Todo folha NIL black");
	        System.out.println(" -  Se um n� � vermelho, ambos seus filhos s�o pretos");
	        System.out.println(" -  Para cada n�, todos os caminhos de um n� at� as folhas descendentes, contem o mesmo numero");
	        System.out.println("    de n�s(altura preta)");
	        
	// -> Referencias de Objetos e v�riaveis

	Scanner ler = new Scanner(System.in);

	int num, num1, num2, num3, num4, num5, num6, num7, num8, num9;



	//criando arvRB  ...............................................................
	        RedBlackTree arv = new RedBlackTree();
	        //System.out.println("ARVORE REDBLACK CRIADA :)! ");  
	        RedBlackNode no = new RedBlackNode();
	        
	//inserindo valor digitado
	System.out.println("INSIRA UM NOVO ELEMENTO ...");
	        num = ler.nextInt();
	System.out.println("INSIRA UM NOVO ELEMENTO ...");
	        num1 = ler.nextInt();
	System.out.println("INSIRA UM NOVO ELEMENTO ...");
	        num2 = ler.nextInt();
	System.out.println("INSIRA UM NOVO ELEMENTO ...");
	        num3 = ler.nextInt();

	//Inserindo na arvore

	    arv.insert(no.key = num);
	    arv.insert(no.key = num1);
	    arv.insert(no.key = num2);
	    arv.insert(no.key = num3);
	    
	    arv.size();
	    System.out.println("tamanho da arvore:  " + arv.size());
	        System.out.println("Digite o valor do n� a ser pesquisado: ");
	        int nop = ler.nextInt();
	    System.out.println("cor do n� pesquisado: " + arv.search(nop).color);
	    
	    TODO: //IMPRIMIR TODOS OS ELEMENTOS DA ARVORE
	    for(int i= 1; i< arv.size(); i++){
	        
	    }

	    
	    
	        
	    }
	}
