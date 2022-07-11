package jogo_poker;

import java.util.ArrayList;
import java.util.Arrays;


public class Bot implements jogadores {

    private final ArrayList<Integer> carta;
    //ArrayList que contém as cartas geradas na mesa

    private final ArrayList<Integer> naipes;
    //ArrayList que contém as cartas geradas na mesa

    private int[] carta_bot = new int[2];
    //Array que receberá as cartas do jogador

    private String resultado = "carta mais alta";
    //variável que guardará o resultado gerado

    private int[] naipes_bot = new int[2];
    //Array que receberá as cartas do Jogador

    int cartas_iguais;
    int[] cartas_D_bot = {1, 1};
    //variáveis que possibilitarão o cálculo do resultado

    private final int[] rank_cartas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};
    //Array contendo a ordem de cartas pelo seu valor no jogo

    private int carta_alta;
    private int carta_baixa;
    //variáveis que irão guardar a carta mais alta e mais baixa respectivamente

    private int flush_i = 0;
    private final int[] flush_d = {1, 1};
    String seq = "";

    /*
    No construtor teremos 2 parâmetros sendo eles, um Arraylist que receberá o
    Arraylist cartas_mesa na JFrame jogo e um Array que receberá as cartas do 
    Bot.
    
    Esses parâmetros inicializaram o ArrayList cartas e o Array cartas_bot,
    além de chamar os metódos cartaMaisAlta e recebe.
     */
    public Bot(ArrayList<Integer> carta, ArrayList<Integer> naipes, int[] cartas_B, int[] naipes_B) {
        this.carta = carta;
        this.carta_bot = cartas_B;
        this.naipes_bot = naipes_B;
        this.naipes = naipes;
        cartaMaisAlta();
        recebe();
        sequenciar();
    }

    public int getCarta_alta() {
        return carta_alta;
    }

    public int getCarta_baixa() {
        return carta_baixa;
    }

    public String getResultado() {
        return resultado;
    }

    /*
    o metódo cartaMaisAlta compara as cartas do jogador, a fim de
    gerar a carta mais alta e mais baixa.
    
    possibilitando assim um futuro desempate caso os resultados do
    Bot e do jogador sejam iguais.
     */
    @Override
    public final void cartaMaisAlta() {
        int[] desempate = new int[2];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 13; i++) {
                if (carta_bot[j] == rank_cartas[i]) {
                    desempate[j] = i;
                }
            }
        }
        if (desempate[0] >= desempate[1]) {
            carta_alta = desempate[0];
            carta_baixa = desempate[1];
        } else {
            carta_alta = desempate[1];
            carta_baixa = desempate[0];
        }
    }

    /*
    o método recebe será o método mais importante durante a execução do jogo,
    já que o mesmo calcula o resultado do Bot.
    
    ele compara as cartas e as calcula, indenpendente de serem iguais ou não.
    
    caso as cartas forem iguais ele efetuará o cálculo de uma forma se forem diferentes
    ele efetuará de outra, possibilitando assim a implementação de novas probabilidades como sequências.
     */
    @Override
    public final void recebe() {

        if (carta_bot[0] == carta_bot[1]) {
            cartas_iguais = 2;
            for (int i = 0; i < 5; i++) {
                if (carta_bot[0] == carta.get(i)) {
                    cartas_iguais++;
                }
            }
            switch (cartas_iguais) {
                case 2:
                    resultado = "par";

                    break;
                case 3:
                    resultado = "trinca";

                    break;
                case 4:
                    resultado = "quadra";
                    break;
            }

        } else {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 5; j++) {
                    if (carta_bot[i] == carta.get(j)) {
                        cartas_D_bot[i]++;
                    }
                }
            }
            switch (cartas_D_bot[0]) {
                case 2:
                    resultado = "par";

                    break;
                case 3:
                    resultado = "trinca";

                    break;
                case 4:
                    resultado = "quadra";

                    break;
            }
            switch (cartas_D_bot[1]) {
                case 1:
                    if (cartas_D_bot[0] == 1) {
                        resultado = "carta mais alta";
                    }
                    break;
                case 2:
                    if (cartas_D_bot[0] == 1) {
                        resultado = "par";

                    } else {
                        if (cartas_D_bot[0] == 2) {
                            resultado = "dois pares";
                        } else if (cartas_D_bot[0] == 3) {
                            resultado = "full house";
                        }
                    }
                    break;
                case 3:
                    if (cartas_D_bot[0] == 1) {
                        resultado = "trinca";

                    } else {
                        resultado = "full house";
                    }
                    break;
                case 4:
                    resultado = "quadra";

                    break;
            }

            if (naipes_bot[0] == naipes_bot[1]) {
                flush_i = 2;

                for (int i = 0; i < 5; i++) {
                    if (naipes_bot[0] == naipes.get(i)) {
                        flush_i++;
                    }
                }
                if (flush_i >= 5) {
                    resultado = "flush";
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (naipes_bot[i] == naipes.get(j)) {
                            flush_d[i]++;
                        }
                    }
                }
                if (flush_d[0] >= 5 || flush_d[1] >= 5) {
                    resultado = "flush";
                }
            }

        }
    }

    
    private void sequenciar() {
        int[] cartas_seq = new int[7];
        
        for(int i = 0; i < this.carta.size(); i++){
            cartas_seq[i] = this.carta.get(i);
        }
        
        cartas_seq[5] = carta_bot[0];
        cartas_seq[6] = carta_bot[1];
        
        Arrays.sort(cartas_seq);
        
        for (int i = 0; i < cartas_seq.length; i++) {
            if (!seq.contains(String.valueOf(cartas_seq[i]))) {
                seq += String.valueOf(cartas_seq[i]);
            }
        }
        if (seq.contains("01234") || seq.contains("12345") || seq.contains("23456") || seq.contains("34567") || seq.contains("45678") || seq.contains("56789") || seq.contains("678910") || seq.contains("7891011") || seq.contains("89101112")) {
            if (flush_d[0] >= 5 || flush_d[1] >= 5 || flush_i >= 5) {

                resultado = "Straight Flush";
            } else {
                resultado = "sequência";
            }
        } else if (seq.contains("9101112") && seq.contains("0")) {
            if (flush_d[0] >= 5 || flush_d[1] >= 5 || flush_i >= 5) {

                resultado = "Royal Flush";
            } else {
                resultado = "sequência";
            }
        } else if (flush_d[0] >= 5 || flush_d[1] >= 5 || flush_i >= 5) {
            resultado = "flush";
        }
    }
}
