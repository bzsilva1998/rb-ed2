package dados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GerarNumerosAleatorios {
	
	public static void gerarNumerosAleatorios (int qtdElementos, String nomeArquivo) throws IOException {
		// M�todo que ir� criar um arquivo com a quantidade de elementos 
		// passada como par�metro
		
		BufferedWriter buff = new BufferedWriter (new FileWriter(nomeArquivo));
		//wri = new FileWriter (nomeArquivo);
		Random gerador = new Random();
		for (int i=0; i<qtdElementos; i++) {
			buff.append(gerador.nextInt()+"\n");
		}
		buff.close();
	} // Fim do M�todo GerarNumerosAleatorios
}
