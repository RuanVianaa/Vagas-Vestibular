public class Candidato implements Comparable<Candidato> {
    private String nome;
    private double nota;

    public Candidato(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public int compareTo(Candidato outro) {
        // 1º critério: nota em ordem decrescente
        if (Double.compare(outro.nota, this.nota) != 0) {
            return Double.compare(outro.nota, this.nota);
        }
        // 2º critério (empate): nome em ordem alfabética crescente
        return this.nome.compareToIgnoreCase(outro.nome);
    }

    @Override
    public String toString() {
        return String.format("%s - %.1f", nome, nota);
    }
}