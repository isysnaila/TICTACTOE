package main;
import java.util.Scanner;

public class jogodavelha {

    static char[][] tabuleiro = {{' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '} };
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        
        char jogadorAtual = 'X';
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            exibirTabuleiro();
            System.out.println("Jogador "+ jogadorAtual +  ", escolha uma coluna (1-3): ");
            int coluna = leitura.nextInt();
            System.out.println("Jogador " + jogadorAtual + ", escolha uma linha (1-3): ");
            int linha = leitura.nextInt();
            if(tabuleiro[linha-1][coluna-1] == ' '){
                tabuleiro[linha-1][coluna-1] = jogadorAtual;
                if(checarVitoria(jogadorAtual)) {
                    exibirTabuleiro();
                    jogoAtivo = false;
                }else if(checarEmpate()) {
                    exibirTabuleiro();
                    System.out.println("EMPATE!");
                    jogoAtivo = false;
                }else{
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            }else {
                System.out.println("Posição já ocupada, tente novamente.");
                continue;
            }
        }
    }

    static void exibirTabuleiro(){
        for(char[] linha : tabuleiro){
            for(char coluna:linha){
                System.out.print("|" + coluna);
            }
            System.out.println("|");
        }
    }

    static boolean checarVitoria(char jogador){
        for(int i=0; i < 3; i++){
            if(tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador){
                System.out.println("Jogador "+ jogador + " venceu!");
                return true;
            }
        }

        for(int i = 0; i<3; i++){
            if(tabuleiro[0][i] == jogador && tabuleiro [1][i] == jogador && tabuleiro[2][i]==jogador){
                System.out.println("Jogador "+jogador+" venceu!");
                return true;
            }
        }

        if(tabuleiro[0][0]==jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador){
            System.out.println("Jogador "+jogador+" venceu!");
            return true;
        }
        return false;
    }

    static boolean checarEmpate() {
        for(char[] linha : tabuleiro){
            for(char coluna : linha){
                if(coluna == ' '){
                    return false;
                }
            }
        }
        return true;
    }
}