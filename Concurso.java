import java.util.Scanner;

public class Concurso {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Leitura do número de candidatos
        System.out.print("Digite a quantidade de candidatos: ");
        int quantidadeCandidatos = entrada.nextInt();
        entrada.nextLine();  // Limpar o buffer

        // Arrays para armazenar os dados
        String[] listaNomes = new String[quantidadeCandidatos];
        double[] notasProva1 = new double[quantidadeCandidatos];
        double[] notasProva2 = new double[quantidadeCandidatos];
        double[] mediasFinais = new double[quantidadeCandidatos];

        // Leitura dos dados de cada candidato
        for (int i = 0; i < quantidadeCandidatos; i++) {
            System.out.print("Digite o nome do candidato " + (i + 1) + ": ");
            listaNomes[i] = entrada.nextLine();
            System.out.print("Digite a nota da prova 1: ");
            notasProva1[i] = entrada.nextDouble();
            System.out.print("Digite a nota da prova 2: ");
            notasProva2[i] = entrada.nextDouble();
            entrada.nextLine();  // Limpar o buffer
            
            // Calcula a média final
            mediasFinais[i] = (notasProva1[i] + notasProva2[i]) / 2.0;
        }

        // Exibe a tabela de candidatos com suas médias
        System.out.println("\nTabela de Candidatos:");
        System.out.println("Nome\t\tProva 1\tProva 2\tMédia");
        for (int i = 0; i < quantidadeCandidatos; i++) {
            System.out.printf("%s\t\t%.2f\t%.2f\t%.2f\n", listaNomes[i], notasProva1[i], notasProva2[i], mediasFinais[i]);
        }

        // Lista candidatos aprovados e calcula a porcentagem de aprovação
        int totalAprovados = 0;
        double somaMediasAprovados = 0;
        System.out.println("\nCandidatos Aprovados:");
        for (int i = 0; i < quantidadeCandidatos; i++) {
            if (mediasFinais[i] >= 70) {
                System.out.println(listaNomes[i]);
                totalAprovados++;
                somaMediasAprovados += mediasFinais[i];
            }
        }

        // Calcula e exibe a porcentagem de aprovação
        double porcentagemAprovacao = (double) totalAprovados / quantidadeCandidatos * 100;
        System.out.printf("\nPorcentagem de aprovação: %.2f%%\n", porcentagemAprovacao);

        // Encontra o candidato com a maior média
        double maiorMedia = mediasFinais[0];
        String nomeMaiorMedia = listaNomes[0];
        for (int i = 1; i < quantidadeCandidatos; i++) {
            if (mediasFinais[i] > maiorMedia) {
                maiorMedia = mediasFinais[i];
                nomeMaiorMedia = listaNomes[i];
            }
        }
        System.out.println("Candidato com maior média: " + nomeMaiorMedia);

        // Calcula e exibe a média das notas dos aprovados
        if (totalAprovados > 0) {
            double mediaAprovados = somaMediasAprovados / totalAprovados;
            System.out.printf("Média das notas dos aprovados: %.2f\n", mediaAprovados);
        } else {
            System.out.println("Não há candidatos aprovados.");
        }

        entrada.close();
    }
}