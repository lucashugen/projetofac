import java.util.Scanner;

public class Estudante {
    
    private String nomeCompleto;
    private String numeroMatricula;
    private String genero;
    private String dataDeNascimento;
    private String nomeCurso;
    private int anoDeInicio;
    private double notaExame1;
    private double notaExame2;
    private double mediaTrabalhos;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getAnoDeInicio() {
        return anoDeInicio;
    }

    public void setAnoDeInicio(int anoDeInicio) {
        this.anoDeInicio = anoDeInicio;
    }

    public double getNotaExame1() {
        return notaExame1;
    }

    public void setNotaExame1(double notaExame1) {
        this.notaExame1 = notaExame1;
    }

    public double getNotaExame2() {
        return notaExame2;
    }

    public void setNotaExame2(double notaExame2) {
        this.notaExame2 = notaExame2;
    }

    public double getMediaTrabalhos() {
        return mediaTrabalhos;
    }

    public void setMediaTrabalhos(double mediaTrabalhos) {
        this.mediaTrabalhos = mediaTrabalhos;
    }

    public boolean estaAprovado() {
        double mediaFinal = (notaExame1 + notaExame2 + mediaTrabalhos) / 3;
        return mediaFinal >= 6;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Estudante estudante = new Estudante();

        System.out.print("Nome Completo: ");
        estudante.setNomeCompleto(scanner.nextLine());

        System.out.print("Número de Matrícula: ");
        estudante.setNumeroMatricula(scanner.nextLine());

        System.out.print("Gênero: ");
        estudante.setGenero(scanner.nextLine());

        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        estudante.setDataDeNascimento(scanner.nextLine());

        System.out.print("Nome do Curso: ");
        estudante.setNomeCurso(scanner.nextLine());

        System.out.print("Ano de Início: ");
        estudante.setAnoDeInicio(scanner.nextInt());

        estudante.setNotaExame1(receberNota(scanner, "Nota do Exame 1 (0-10): "));
        estudante.setNotaExame2(receberNota(scanner, "Nota do Exame 2 (0-10): "));
        estudante.setMediaTrabalhos(receberNota(scanner, "Média dos Trabalhos (0-10): "));

        boolean aprovado = estudante.estaAprovado();

        System.out.println("\nResumo do Estudante:");
        System.out.println("Nome: " + estudante.getNomeCompleto());
        System.out.println("Matrícula: " + estudante.getNumeroMatricula());
        System.out.println("Curso: " + estudante.getNomeCurso());
        System.out.println("Aprovado: " + (aprovado ? "Sim" : "Não"));

        scanner.close();
    }

    private static double receberNota(Scanner scanner, String mensagem) {
        double nota;
        do {
            System.out.print(mensagem);
            nota = scanner.nextDouble();
            if (nota < 0 || nota > 10) {
                System.out.println("Valor inválido! Insira uma nota entre 0 e 10.");
            }
        } while (nota < 0 || nota > 10);
        return nota;
    }
}