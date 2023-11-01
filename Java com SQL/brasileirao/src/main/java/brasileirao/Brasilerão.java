import java.util.Scanner;

public class Brasileirão {
    public static void main(String[] args) {
        String[] times = {
            "América Mineiro",  "Athletico-PR", "Atlético Mineiro", "Bahia", "Botafogo",
            "Corinthians", "Coritiba", "Cruzeiro", "Cuiabá", "Flamengo",
            "Fluminense", "Fortaleza", "Goiás", "Grêmio", "Internacional",
            "Palmeiras", "Red Bull Bragantino", "Santos", "São Paulo", "Vasco"
        };

        int[] pontuacoes = new int[times.length];

        int[] cartão = new int[times.length];

        int[] vitoria = new int[times.length];

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 - Visualizar Tabela");
            System.out.println("2 - Adicionar Cartão Amarelo");
            System.out.println("3 - Editar número de Vitória");
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
                    editarCartão(times, pontuacoes, cartão, vitoria, scanner);
                    break;
                case 3:
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
        for (int i = 0; i < times.length; i++) {
            String cor = "";
    
            // Mantenha a cor verde para os 4 primeiros times
            if (i < 4) {
                cor = "\u001B[32m";
            }
            // Adicione a cor azul para os times da 5ª à 8ª posição
            else if (i >= 4 && i < 8) {
                cor = "\u001B[34m";
            }
            // Mantenha a cor vermelha para os 4 últimos times
            else if (i >= times.length - 4) {
                cor = "\u001B[31m";
            }
            // Adicione a cor laranja escura para os times da 14ª à 17ª posição
            else if (i >= 12 && i < 16) {
                cor = "\u001B[38;5;208m";
            }
            // Use a cor padrão (branco) para os demais times
            else {
                cor = "\u001B[13m";
            }
    
            // Restaure a cor padrão no final da linha
            String corPadrao = "\u001B[0m";
    
            System.out.printf("%-8d | %s%-20s%s | %-9d | %-14d | %-8d |\n", (i + 1), cor, times[i], corPadrao, pontuacoes[i], cartão[i], vitoria[i]);
        }
    
        System.out.printf("-------------------------------------------------------------------------");
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
                    pontuacoes[posicao - 1] = novaVitoria * 3;
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
                if (pontuacoes[i] < pontuacoes[j] || 
                (pontuacoes[i] == pontuacoes[j] && cartão[j] < cartão[i] || vitoria[i] < vitoria[j])) {

                    int tempPontuacao = pontuacoes[i];
                    pontuacoes[i] = pontuacoes[j];
                    pontuacoes[j] = tempPontuacao;

                    int tempCartão = cartão[i];
                    cartão[j] = cartão[i];
                    cartão[i] = tempCartão;

                    int tempVitoria = vitoria[i];
                    vitoria[i] = vitoria[j];
                    vitoria[j] = tempVitoria;
                    
                    String tempTime = times[i];
                    times[i] = times[j];
                    times[j] = tempTime;
                    
                }
            }
        }
    }
}