package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ReadFromFile {
	public static void main(String args[]) throws IOException, ParseException{
		String teste = "Porto Alegre  Casa De Carnes Moacir Ltda           11/02/17     210479";
		String linha = "";
		try {
			FileReader fw = new FileReader("H:\\git\\didactic-tribble\\src\\persistencia\\04744325807-nf.csv");
			BufferedReader bf = new BufferedReader(fw);
			linha = bf.readLine();
			linha = bf.readLine();
			while(linha!=null){
				
				String municipio = linha.substring(0,14);
				String razao = linha.substring(14, 48);
				razao.replaceAll("\\s+","");
				String emissao = linha.substring(48, 59);
				emissao = emissao.replaceAll("\\s+","");				
				int numero = Integer.parseInt(new String(linha.substring(59, 70).replaceAll("\\s+","")));
				String origem = linha.substring(70, 102);
				String numeroEquip = linha.substring(102, 124);
				if(numeroEquip.isEmpty()){
					numeroEquip = "null";
				}else{
					numeroEquip = numeroEquip.replaceAll("\\s+","");
				}
				NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
				Number number = format.parse(linha.substring(124, 134).replaceAll("\\s+",""));
				double valor = number.doubleValue();
				linha = bf.readLine();
				String dt_registro = linha.substring(135,147);
				//dt_registro = linha.replaceAll("\\s+","");

				System.out.println("Teste: "+dt_registro);
			}
			bf.close();
			System.out.println(linha);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Tamanho: "+teste.length());
		
	}
	
	
}
