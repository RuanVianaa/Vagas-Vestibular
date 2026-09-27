import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Candidato> candidatos = new ArrayList<>();
        String caminhoCSV = "candidatos_vestibular.csv"; // Caminho do arquivo CSV

        // Carregamento do arquivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoCSV))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) { // Pula o cabeçalho se houver
                    primeiraLinha = false;
                    continue;
                }
                String[] dados = linha.split(",");
                if (dados.length >= 2) {
                    String nome = dados[0].trim();
                    double nota = Double.parseDouble(dados[1].trim().replace(",", "."));
                    candidatos.add(new Candidato(nome, nota));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo, carregando dados de teste de exemplo...");
            // Dados de fallback para teste caso o arquivo local não esteja acessível
            candidatos.add(new Candidato("Carlos", 85.5));
            candidatos.add(new Candidato("Ana", 92.0));
            candidatos.add(new Candidato("Bruno", 85.5));
            candidatos.add(new Candidato("Daniel", 92.0));
        }

        System.out.println("--- Lista Antes da Ordenação ---");
        for (Candidato c : candidatos) {
            System.out.println(c);
        }

        // Ordenação utilizando a classe genérica Sorts<T>
        Sorts<Candidato> sorter = new Sorts<>();
        sorter.sort(candidatos);

        System.out.println("\n--- Lista de Candidatos Classificados ---");
        for (int i = 0; i < candidatos.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), candidatos.get(i));
        }
    }
}