package testes;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dados.GerarNumerosAleatorios;
import dados.ManipuladorDeDados;
import rb.RedBlackTree;
import rb.RedBlackNode;


public class Teste {

	
	public static void main (String [] args) throws IOException {	
		
		int TOTALREPETICOES = 3; // QUANTIDADE DE VEZES QUE O ALGORITMO IRÁ REPETIR AS ORDENAÇÕES
		int TOTALAMOSTRAS = 10; // QUANTIDADE DE AMOSTRAS POR ORDENAÇÃO
		int quantidadeElementos = 10000;
		
		long [][] armazenarDadosInsertion = new long [TOTALREPETICOES][TOTALAMOSTRAS];	
		
		String resultado = "AmostrasInsertion.txt";
		File pasta = new File (resultado); 
		pasta.createNewFile();
		PrintWriter pw = new PrintWriter (resultado);
		RedBlackTree arvore = new RedBlackTree ();
		RedBlackNode no = new RedBlackNode();
		Integer[] conjuntoElementos;
		for (int repeticoes=0; repeticoes<TOTALREPETICOES; repeticoes++) { //inicio for
			for (int amostras=0; amostras<TOTALAMOSTRAS; amostras++) {// inicio segundo for
				
				List<Integer> conteudo = new ArrayList<>();
				
				String nomeDados = "Dados Arvore RB" + (amostras+1) +".txt";
				
				GerarNumerosAleatorios.gerarNumerosAleatorios(quantidadeElementos, nomeDados);//Gerando Numeros
				
				conteudo = ManipuladorDeDados.leitorDeDados(nomeDados);
				
				conjuntoElementos = conteudo.toArray(new Integer[conteudo.size()]); //Transforma a Lista em Array
	
				long tempoInicial =  System.currentTimeMillis();// PEGA O TEMPO INICIAL
				for (int ele : conjuntoElementos) {
					no.key = ele;
					arvore.insert(no.key);
				} //insere os elementos na árvore
				long tempoFinal =  (System.currentTimeMillis() - tempoInicial); //CALCULA O TEMPO FINAL
				
				armazenarDadosInsertion[repeticoes][amostras] = tempoFinal;
				pw.println ((quantidadeElementos*(amostras+1))+";" + armazenarDadosInsertion[repeticoes][amostras]);
				
				/*String resultInsertionRB = "Resultado Insertion RB Tree" + (amostras+1) + ".txt"; // CRIAÇÃO DO ARQUIVO ORDENADO
				
				ManipuladorDeDados.escreverTempoEmArquivo((tempoFinal), 
						resultInsertionRB, conjuntoElementos); // ESCREVENDO O RESULTADO DO TEMPO DE INSERÇÃO NO ARQUIVO
				*/
			} //fim segundo for
		} //fim primeiro for
		
		ManipuladorDeDados.calcularMedias(armazenarDadosInsertion, TOTALREPETICOES, TOTALAMOSTRAS, quantidadeElementos, 1);
		
		// Chamada do método para Calcular as Médias
		pw.close();	
	}	
}
