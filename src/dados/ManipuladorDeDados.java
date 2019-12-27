package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManipuladorDeDados {
	
	
	public static List <Integer> leitorDeDados(String nomeArquivo) { // ESTE MÉTODO FAZ A LEITURA
		//DE UM ARQUIVO E COLOCA OS ELEMENTOS EM UMA LISTA
		
	List <Integer> conjuntoElementos = new ArrayList <>();
		
		try {
			BufferedReader lerArq = new BufferedReader (new FileReader(nomeArquivo));
			String linha = lerArq.readLine();
							
			while (linha != null) {	
				conjuntoElementos.add(Integer.parseInt(linha));
				linha = lerArq.readLine();	
			} //fim While
			
			lerArq.close();
		} catch (IOException e) {
			System.err.printf ("Não foi possível abrir o arquivo: %s\n", e.getMessage());
		} //fim Catch
	
		return conjuntoElementos;
	} //FIM LEITOR DE DADOS
	
	public static void escreverResultadoEmArquivo (int qtdElementos, String nomeArquivo, Integer[] conjunto ) throws IOException {
		// Método que irá escrever elementos em um arquivo TXT já criado
		
		BufferedWriter buff = new BufferedWriter (new FileWriter(nomeArquivo)); 

			for (int i=0; i<qtdElementos; i++) {
				buff.append(conjunto[i] + "\n");
			}
		buff.close();
	}
	public static void escreverTempoEmArquivo (long x, String nomeArquivo, Integer[] conjunto ) throws IOException {
		// Método que irá escrever elementos em um arquivo TXT já criado
		
		BufferedWriter buff = new BufferedWriter (new FileWriter(nomeArquivo)); 

			
		buff.append(conjunto.length + ": "+ x + ";\n");
			
		buff.close();
	}
	
	public static void calcularMedias (long [][] matriz, int linha, int coluna, int qtdElementos, int id) throws IOException {
		int vet[] = new int [coluna];
		
		BufferedWriter buff = new BufferedWriter (new FileWriter (nomeArquivoMedia(id)));
		
		for (int k=0; k<coluna; k++)
		{		
			for (int i=0; i<linha; i++) {
				for (int j=0; j<coluna; j++) {
					if (k==j) {
						vet[k] += matriz[i][j]; // Soma o numero de tempo em cada quantidade
					}
				}
			} 
		} 

		for (int x=0; x<coluna; x++) {
			vet[x] = vet[x]/linha;
			buff.append(qtdElementos +": " + (vet[x]) +"\n");
			qtdElementos += 10000;
		} // Calcula a média
		
		buff.close();
	} // Fim CalcularMedias


	private static String nomeArquivoMedia (int id) {
		String nomeArq=null;		
		if (id != 0) {
			if (id==1) {
				nomeArq="mediasInsert.txt";
			}
			
			else if (id==2) {
				nomeArq="mediasRemove.txt";
			}
			
		}
		
		return nomeArq;
	} // Fim NomeArquivoMedia
	
} //Fim Class ManipuladorDeDados

