import java.io.*;

public class Principal {

	public static void main(String[] args) {
		BTree arvore = new BTree();
		// Inserindo os elementos da ABB a partir do arquivo
		try {
			FileReader file = new FileReader("src/arvore.txt");
			BufferedReader br = new BufferedReader(file);
			String linha = br.readLine();
			while (linha != null) {
				String[] separado = linha.split(" ");
				for (String a : separado) {
					arvore.inserir(arvore.raiz, Integer.parseInt(a));
				}

				linha = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.err.println("Erro de abertura no arquivo");
		}
		try {
			FileReader file = new FileReader("src/operacoes.txt");
			BufferedReader br = new BufferedReader(file);
			String linha = br.readLine();
			while (linha != null) {
				String[] separado = linha.split(" ");
				// Assumindo que o arquivo est� organizado corretamente
				int valor = 0;
				String metodo = separado[0];
				if (separado.length > 1) {
					valor = Integer.parseInt(separado[1]);
				}
				// Chamando os metodos
				if (metodo.equals("INSIRA")) {
					arvore.inserir(arvore.raiz, valor);
				}
				if (metodo.equals("REMOVA")) {
					arvore.remover(arvore.raiz, valor);
				}
				if (metodo.equals("BUSCAR")) {
					arvore.buscar(arvore.raiz, valor);
				}
				linha = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.err.println("Erro de abertura no arquivo");
		}
	}
}
