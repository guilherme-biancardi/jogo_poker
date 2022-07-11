package jogo_poker;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Biancardi e Mendes
 */
public class Jogador implements jogadores {

    private final ArrayList<Integer> cartas;
    //ArrayList que contém as cartas geradas na mesa

    private final ArrayList<Integer> naipes;
    //ArrayList que contém as cartas geradas na mesa

    private int[] cartas_jogador = new int[2];
    //Array que receberá as cartas do Jogador

    private int[] naipes_jogador = new int[2];
    //Array que receberá as cartas do Jogador

    int cartas_iguais = 0;
    int[] cartas_D_jogador = {1, 1};
    //variáveis que possibilitarão o cálculo do resultado

    private String resultado = "carta mais alta";
    //variável que guardará o resultado gerado

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
    Jogador.
    
    Esses parâmetros inicializaram o ArrayList cartas e o Array cartas_jogador,
    além de chamar os metódos cartaMaisAlta e recebe.
     */
    public Jogador(ArrayList<Integer> cartas, ArrayList<Integer> naipes, int[] cartas_J, int[] naipes_J) {
        this.cartas = cartas;
        this.naipes = naipes;
        this.cartas_jogador = cartas_J;
        this.naipes_jogador = naipes_J;
        cartaMaisAlta();
        recebe();
        sequenciar();
    }

    public Jogador(int[] cartas_J) {
        this.cartas_jogador = cartas_J;
        this.cartas = new ArrayList<>();
        this.naipes = new ArrayList<>();

        cartas_iguais = 0;
        cartas_D_jogador = new int[2];
        for (int i = 0; i < 2; i++) {
            cartas_D_jogador[i] = 1;
        }
        if (cartas_jogador[0] == cartas_jogador[1]) {
            resultado = "par";
        }
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
    o metódo cartaMaisAlta compara as cartas do Jogador, a fim de
    gerar a carta mais alta e mais baixa.
    
    possibilitando assim um futuro desempate caso os resultados do
    bot e do Jogador sejam iguais.
     */
    @Override
    public final void cartaMaisAlta() {
        int[] desempate = new int[2];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 13; i++) {
                if (cartas_jogador[j] == rank_cartas[i]) {
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
    já que o mesmo calcula o resultado do Jogador.
    
    ele compara as cartas e as calcula, indenpendente de serem iguais ou não.
    
    caso as cartas forem iguais ele efetuará o cálculo de uma forma se forem diferentes
    ele efetuará de outra, possibilitando assim a implementação de novas probabilidades como sequências.
     */
    @Override
    public final void recebe() {
        if (cartas_jogador[0] == cartas_jogador[1]) {
            cartas_iguais = 2;
            for (int i = 0; i < cartas.size(); i++) {
                if (this.cartas.get(i) == cartas_jogador[0]) {
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
                for (int j = 0; j < cartas.size(); j++) {
                    if (cartas_jogador[i] == this.cartas.get(j)) {
                        cartas_D_jogador[i]++;
                    }
                }
            }
            switch (cartas_D_jogador[0]) {
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
            switch (cartas_D_jogador[1]) {
                case 1:
                    if (cartas_D_jogador[0] == 1) {
                        resultado = "carta mais alta";
                    }
                    break;
                case 2:
                    if (cartas_D_jogador[0] == 1) {
                        resultado = "par";
                    } else {
                        if (cartas_D_jogador[0] == 2) {
                            resultado = "dois pares";
                        } else if (cartas_D_jogador[0] == 3) {
                            resultado = "full house";
                        }
                    }
                    break;
                case 3:
                    if (cartas_D_jogador[0] == 1) {
                        resultado = "trinca";

                    } else {
                        resultado = "full house";
                    }
                    break;
                case 4:
                    resultado = "quadra";
                    break;
            }
            if (naipes_jogador[0] == naipes_jogador[1]) {
                flush_i = 2;

                for (int i = 0; i < naipes.size(); i++) {
                    if (naipes_jogador[0] == naipes.get(i)) {
                        flush_i++;
                    }
                }
                if (flush_i >= 5) {
                    resultado = "flush";
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < naipes.size(); j++) {
                        if (naipes_jogador[i] == naipes.get(j)) {
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
        
        for(int i = 0; i < this.cartas.size(); i++){
            cartas_seq[i] = this.cartas.get(i);
        }
        
        cartas_seq[5] = cartas_jogador[0];
        cartas_seq[6] = cartas_jogador[1];
        
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
