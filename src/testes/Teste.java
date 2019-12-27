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
		
		int TOTALREPETICOES = 50; // QUANTIDADE DE VEZES QUE O ALGORITMO IRÁ REPETIR AS ORDENAÇÕES
		int TOTALAMOSTRAS = 10; // QUANTIDADE DE AMOSTRAS POR ORDENAÇÃO
		int quantidadeElementos = 10000;
		
		long [][] armazenarDadosInsertion = new long [TOTALREPETICOES][TOTALAMOSTRAS];	
		long [][] armazenarDadosRemove = new long [TOTALREPETICOES][TOTALAMOSTRAS];
		
		
		String resultadoInsertion = "AmostrasInsertion.txt";
		File pasta = new File (resultadoInsertion); 
		pasta.createNewFile();
		PrintWriter pw = new PrintWriter (resultadoInsertion);
		
		
		
		String resultadoRemove = "AmostrasRemove.txt";
		File pastaa= new File(resultadoRemove); 
		pastaa.createNewFile();
		PrintWriter pw1 = new PrintWriter(resultadoRemove);
		
		
		RedBlackTree arvore = new RedBlackTree ();
		RedBlackNode no = new RedBlackNode();
		Integer[] conjuntoElementos;
		List<Integer> conteudo = new ArrayList<>();
		
		for (int repeticoes=0; repeticoes<TOTALREPETICOES; repeticoes++) { //inicio for
			for (int amostras=0; amostras<TOTALAMOSTRAS; amostras++) {// inicio segundo for
							
				String nomeDados = "Dados Arvore RB" + (amostras+1) +".txt";
				
				GerarNumerosAleatorios.gerarNumerosAleatorios(quantidadeElementos*(amostras+1), nomeDados);//Gerando Numeros
				
				conteudo = ManipuladorDeDados.leitorDeDados(nomeDados);
				
				conjuntoElementos = conteudo.toArray(new Integer[conteudo.size()]); //Transforma a Lista em Array
	
				long tempoInicialInsertion =  System.currentTimeMillis();// PEGA O TEMPO INICIAL
				for (int ele : conjuntoElementos) {
					no.key = ele;
					arvore.insert(no.key);
				} //insere os elementos na árvore
				long tempoFinalInsertion =  (System.currentTimeMillis() - tempoInicialInsertion); //CALCULA O TEMPO FINAL
				
				armazenarDadosInsertion[repeticoes][amostras] = tempoFinalInsertion;
				pw.println ((quantidadeElementos*(amostras+1))+";" + armazenarDadosInsertion[repeticoes][amostras]);
				
				System.out.println("Arvore após inserção: " + arvore.size());
				
				long tempoInicialRemove = System.currentTimeMillis();
				for (int i=conjuntoElementos.length-1; i>=0; i--) {
					no.key = conjuntoElementos[i];
					arvore.remove(no);
				}
				long tempoFinalRemove = System.currentTimeMillis() - tempoInicialRemove;
				
				
				System.out.println("Árvore após remoção: " + arvore.size());
				armazenarDadosRemove[repeticoes][amostras] = tempoFinalRemove;
				pw1.println ((quantidadeElementos*(amostras+1))+";" + armazenarDadosRemove[repeticoes][amostras]);
				
				/*String resultInsertionRB = "Resultado Insertion RB Tree" + (amostras+1) + ".txt"; // CRIAÇÃO DO ARQUIVO ORDENADO
				
				ManipuladorDeDados.escreverTempoEmArquivo((tempoFinal), 
						resultInsertionRB, conjuntoElementos); // ESCREVENDO O RESULTADO DO TEMPO DE INSERÇÃO NO ARQUIVO
				*/
				
			} //fim segundo for
		} //fim primeiro for
		
		ManipuladorDeDados.calcularMedias(armazenarDadosInsertion, TOTALREPETICOES, TOTALAMOSTRAS, quantidadeElementos, 1);
		ManipuladorDeDados.calcularMedias(armazenarDadosRemove, TOTALREPETICOES, TOTALAMOSTRAS, quantidadeElementos, 2);
		
		
		
		//System.out.println(no.key);
		// Chamada do método para Calcular as Médias
		pw.close();	
	}	
}
