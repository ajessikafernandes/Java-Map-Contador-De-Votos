package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.LinkedHashMap;
import java.util.Map;

public class programa {

	public static void main(String[] args) throws IOException {

		String arquivo = "C:\\temp\\in.txt";

		Map<String, Integer> votos = new LinkedHashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

			String linhas = br.readLine();
			while (linhas != null) {

				String[] dados = linhas.split(",");
				String nome = dados[0];
				int cont = Integer.parseInt(dados[1]);

				if (votos.containsKey(nome)) {
					int votosNoMomento = votos.get(nome);
					votos.put(nome, cont + votosNoMomento);
				}

				else {
					votos.put(nome, cont);
				}

				linhas = br.readLine();
			}

			for (String chave : votos.keySet()) {
				System.out.println(chave + ": " + votos.get(chave));
			}

		}

		catch (IOException msg) {
			System.out.println("Falha na Execução: " + msg.getMessage());
		}

	}

}
