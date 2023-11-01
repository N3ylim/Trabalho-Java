import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        String[] times = {
            "América Mineiro",  "Athletico-PR", "Atlético Mineiro", "Bahia", "Botafogo",
            "Corinthians", "Coritiba", "Cruzeiro", "Cuiabá", "Flamengo",
            "Fluminense", "Fortaleza", "Goiás", " Grêmio", "Internacional",
            "Palmeiras", "Red Bull Bragantino", "Santos", "São Paulo", "Vasco"
        };

        int[] pontuacoes = new int[times.length];

        int[] cartão = new int[times.length];

        int[] vitoria = new int[times.length];

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 - Visualizar Tabela");
            System.out.println("2 - Editar Pontuação");
            System.out.println("3 - Adicionar Cartão Amarelo");
            System.out.println("4 - Editar número de Vitória");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch(opcao){
                case 0:
                    scanner.close();
                    return;
                case 1:
                    exibirTabela(times, pontuacoes, cartão, vitoria, scanner);
                    break;
                case 2:
                    editarPontuacao(times, pontuacoes, cartão, vitoria, scanner);
                    break;
                case 3:
                    editarCartão(times, pontuacoes, cartão, vitoria, scanner);
                    break;
                case 4:
                    editarVitoria(times, pontuacoes, cartão, vitoria, scanner);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }
    }

    public static void exibirTabela(String[] times, int[] pontuacoes, int[] cartão, int[] vitoria, Scanner scanner) {
        System.out.println("\nPosição  | Time                 | Pontuação | Cartão Amarelo | Vitórias |");
        System.out.println("---------|----------------------|-----------|----------------|----------|");
        for(int i = 0; i < times.length; i++){
            System.out.printf("%-8d | %-20s | %-9d | %-14d | %-8d |\n", (i + 1), times[i], pontuacoes[i], cartão[i], vitoria[i]);
        
        }

        System.out.printf("-------------------------------------------------------------------------");
    }

    public static void editarPontuacao(String[] times, int[] pontuacoes, int[] cartão, int[] vitoria, Scanner scanner){
        while(true){
            System.out.println("\nTimes disponíveis para edição:");
            exibirTabela(times, pontuacoes, cartão, vitoria, scanner);
            System.out.println("\nEscolha o número do time para editar a pontuação (ou 0 para voltar):");
            
            int posicao = scanner.nextInt();    

            if(posicao == 0){
                break;
            }

            if(posicao >= 1 && posicao <= times.length) {
                System.out.println("Digite a nova pontuação para " + times[posicao - 1] + ":");
                int novaPontuacao = scanner.nextInt();

                if(novaPontuacao >= 0){
                    pontuacoes[posicao - 1] = novaPontuacao;
                } else {
                    System.out.println("A pontuação não pode ser negativa.");
                }
            } else {
                System.out.println("Posição inválida. Tente novamente.");
            }

            scanner.nextLine();
        }
        ordenarPorPontuacao(times, pontuacoes, cartão, vitoria);
    }

    public static void editarCartão(String[] times, int[] pontuacoes, int[] cartão, int[] vitoria, Scanner scanner){
        while(true) {
            System.out.println("\n Times disponiveis para edição: ");
            exibirTabela(times, pontuacoes, cartão, vitoria, scanner);
            System.out.println("\nEscolha o número do time que desejar editar os cartões amarelos(ou 0 para voltar):");

            int posicao = scanner.nextInt();
            
            if (posicao==0){
                break;
            }
            if (posicao >= 1 && posicao <= times.length){
                System.out.println("Digite o novo número de cartões amarelos do "
                + times[posicao - 1] + ":");
                int novo_cartão = scanner.nextInt();
                if (novo_cartão >= 0) {
                    cartão[posicao - 1] = novo_cartão;
                } else {
                    System.out.println("O número de cartões amarelos não pode ser negativo");
                }
            } else {
                System.out.println("Posição inválida, tente novamento.");
            }

            scanner.nextLine();
            
            }
        }

    public static void editarVitoria(String[] times, int[] pontuacoes, int[] cartão, int[] vitoria, Scanner scanner){
        while(true){
            System.out.println("\nTimes disponíveis para edição:");
            exibirTabela(times, pontuacoes, cartão, vitoria, scanner);
            System.out.println("\nEscolha o número do time para editar as vitórias (ou 0 para voltar):");
            
            int posicao = scanner.nextInt();    

            if(posicao == 0){
                break;
            }

            if(posicao >= 1 && posicao <= times.length) {
                System.out.println("Digite a nova vitória para " + times[posicao - 1] + ":");
                int novaVitoria = scanner.nextInt();

                if(novaVitoria >= 0){
                    vitoria[posicao - 1] = novaVitoria;
                } else {
                    System.out.println("A vitória não pode ser negativa.");
                }
            } else {
                System.out.println("Posição inválida. Tente novamente.");
            }

            scanner.nextLine();
        }
        ordenarPorPontuacao(times, pontuacoes, cartão, vitoria);
    }
    
    public static void ordenarPorPontuacao(String[] times, int[] pontuacoes, int[] cartão, int[] vitoria){
        for (int i = 0; i < pontuacoes.length - 1; i++){
            for (int j = i + 1; j < pontuacoes.length; j++){
                if (pontuacoes[i] < pontuacoes[j] || // Se a pontuação do time i for menor que a do time j
                    (vitoria[i] < vitoria[j] && pontuacoes[i] == pontuacoes[j]) ||
                    (pontuacoes[i] == pontuacoes[j] && cartão[i] > cartão[j] && vitoria[i] < vitoria[j]) ||
                    (pontuacoes[i] == pontuacoes[j] && vitoria[i] == vitoria[j] && cartão[i] > cartão[j])){
                    
                        int tempPontuacao = pontuacoes[i];
                        pontuacoes[i] = pontuacoes[j];
                        pontuacoes[j] = tempPontuacao;

                        int tempcartão = cartão[i];
                        cartão[i] = cartão[j];
                        cartão[j] = tempcartão;

                        String tempTime = times[i];
                        times[i] = times[j];
                        times[j] = tempTime;

                        int tempVitoria = vitoria[i];
                        vitoria[i] = vitoria[j];
                        vitoria[j] = tempVitoria;
                }
            }
        }
    }
}