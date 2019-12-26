package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
public class ManipuladorArquivo {
	
    public static void escritor(String local_dados, int[] num) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(local_dados));
        for(int i=0; i<num.length; i++){
        	buffWrite.append(num[i]+"\n");
       }
        buffWrite.close();
    }
    
    
    public static int[] leitor(String local_dados, int[] num) throws IOException {
        FileReader ler = new FileReader(local_dados);
        BufferedReader reader = new BufferedReader(ler);  
        String linha; int i=0;
        while( (linha = reader.readLine()) != null ){	
        	num[i] = Integer.parseInt(linha);
        	i++;
        }
        reader.close();
        return num;
    }
    
    public static void gravaTempos(int totalDeDados, String local_tempos, long[][] num, String[] algoritmos) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(local_tempos));
        for(int i=0; i<num.length; i++){
        	for(int j=0; j<num[i].length; j++){
        		buffWrite.append(((i+1)*totalDeDados)+"-> "+algoritmos[j]+": "+num[i][j]+"; ");
        	}
        	buffWrite.append("\n");
        }
        buffWrite.close();
    }
    
    
    
    
}
