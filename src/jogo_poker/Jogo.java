package jogo_poker;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/**
 *
 * @author Biancardi e Mendes
 */
public class Jogo extends javax.swing.JFrame {

    Random r = new Random();
    //Classe que gera ordens aleatórias

    JFrame janela = this;
    //Criando uma novo JFrame usando os atributos desta janela, para mais informações vá até o método gerarBarra.

    ArrayList<String> rank = new ArrayList<>();
    //ArrayList do rank de jogadas

    static int cont_bot;
    static int cont_jogador;
    //variáveis que contam os pontos obtidos pelo Bot ou Jogador
    @SuppressWarnings("FieldMayBeFinal")
    private int[] carta_J = new int[2];
    private int[] carta_B = new int[2];
    //Arrays que guardam as cartas do Bot e do Jogad
    //contador de cartas geradas
    private int[] naipe_J = new int[2];
    private int[] naipe_B = new int[2];
    private int[] limite_c = new int[13];
    private int[][] limite_n = new int[13][4];
    private int giro;
    private int valor_final_jogador;
    private int valor_final_bot;
    private Jogador J;
    public Jogo() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        carta_J[0] = r.nextInt(13);
        naipe_J[0] = r.nextInt(4);
        limite_c[carta_J[0]]++;
        limite_n[carta_J[0]][naipe_J[0]]++;
        //gerando a primeira carta do Jogo, sendo ela a carta 1 do Jogador
        
        barra_jogada.setVisible(false);
        jogada_atualJ.setVisible(false);
        
        gerarJogador();
        gerarBot();
        //métodos que geram as demais cartas, tanto do Jogador quanto do Bot      

        J = new Jogador(carta_J);
        jogada_atualJ.setText(J.getResultado());
        if(J.getResultado().equals("carta mais alta")){
            barra_jogada.setForeground(Color.RED);
            barra_jogada.setValue(1);
        }else{
             barra_jogada.setForeground(Color.RED);
            barra_jogada.setValue(2);
        }
        
        rank.add("carta mais alta");
        rank.add("par");
        rank.add("dois pares");
        rank.add("trinca");
        rank.add("sequência");
        rank.add("flush");
        rank.add("full house");
        rank.add("quadra");
        rank.add("Straight Flush");
        rank.add("Royal Flush");
        //adiciona ao rank as jogadas em sua respectiva ordem de valor

        barra.setVisible(false);
        score_jogador.setText("Player: " + cont_jogador);
        score_bot.setText("Bot: " + cont_bot);
    }

    int gerador = 0;
    int cont = 0;

    ArrayList<Integer> cartas_mesa = new ArrayList<>();
    //ArrayList das cartas gerados na mesa durante do Jogo
    ArrayList<Integer> naipes = new ArrayList<>();
    //ArrayList dos naipes gerados na mesa durante do Jogo

    
    private String resultado_jogador;
    private String resultado_bot;
    private boolean barra_foda;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carta1 = new javax.swing.JLabel();
        carta2 = new javax.swing.JLabel();
        carta2_bot = new javax.swing.JLabel();
        carta1_bot = new javax.swing.JLabel();
        passar = new javax.swing.JButton();
        correr = new javax.swing.JButton();
        barra = new javax.swing.JProgressBar();
        score_bot = new javax.swing.JLabel();
        score_jogador = new javax.swing.JLabel();
        jogada_atualJ = new javax.swing.JLabel();
        barra_jogada = new javax.swing.JProgressBar();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(638, 400));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(638, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        carta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/carta_virada.png"))); // NOI18N
        getContentPane().add(carta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 60, 60));

        carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/carta_virada.png"))); // NOI18N
        getContentPane().add(carta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 60, 60));

        carta2_bot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/carta_virada.png"))); // NOI18N
        getContentPane().add(carta2_bot, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 60, 60));

        carta1_bot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/carta_virada.png"))); // NOI18N
        getContentPane().add(carta1_bot, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, 60));

        passar.setBackground(new java.awt.Color(204, 204, 204));
        passar.setForeground(new java.awt.Color(102, 102, 102));
        passar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/botao_passar.png"))); // NOI18N
        passar.setToolTipText("");
        passar.setBorder(null);
        passar.setBorderPainted(false);
        passar.setContentAreaFilled(false);
        passar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        passar.setFocusPainted(false);
        passar.setFocusable(false);
        passar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passarMouseClicked(evt);
            }
        });
        getContentPane().add(passar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 90, 40));

        correr.setBackground(new java.awt.Color(204, 204, 204));
        correr.setForeground(new java.awt.Color(102, 102, 102));
        correr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/botao_correr.png"))); // NOI18N
        correr.setBorder(null);
        correr.setBorderPainted(false);
        correr.setContentAreaFilled(false);
        correr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        correr.setFocusPainted(false);
        correr.setFocusable(false);
        correr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correrMouseClicked(evt);
            }
        });
        correr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correrActionPerformed(evt);
            }
        });
        getContentPane().add(correr, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 90, 40));

        barra.setBackground(java.awt.Color.darkGray);
        barra.setForeground(new java.awt.Color(255, 51, 51));
        barra.setBorderPainted(false);
        barra.setFocusable(false);
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        score_bot.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        score_bot.setForeground(new java.awt.Color(255, 255, 255));
        score_bot.setText("Bot:  0");
        getContentPane().add(score_bot, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 60, -1));

        score_jogador.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        score_jogador.setForeground(new java.awt.Color(255, 255, 255));
        score_jogador.setText("Player: 0");
        getContentPane().add(score_jogador, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 70, -1));

        jogada_atualJ.setForeground(new java.awt.Color(255, 255, 255));
        jogada_atualJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jogada_atualJ.setText("carta mais alta");
        jogada_atualJ.setToolTipText("");
        getContentPane().add(jogada_atualJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 120, 20));

        barra_jogada.setBackground(java.awt.Color.gray);
        barra_jogada.setMaximum(10);
        barra_jogada.setBorderPainted(false);
        barra_jogada.setFocusable(false);
        getContentPane().add(barra_jogada, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 80, -1));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/fundo_alternativo.png"))); // NOI18N
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 410));

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //evento para caso o Jogador corra, determina o Bot como ganhador e mostra suas cartas
    private void correrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correrMouseClicked
        if (correr.isEnabled()) {
            barra_foda = true;
            cont_bot++;
            setAterta("Mas Já?", "bot ganhou devido a sua desistência", 1);
            passar.setEnabled(false);
            correr.setEnabled(false);
            this.girar(carta_B, carta1_bot, carta2_bot, naipe_B);
        }
    }//GEN-LAST:event_correrMouseClicked

    //Evento que pega a ação de passar, gerando as cartas na mesa e apresentando o resultado após todas as cinco estiverem sido geradas
    private void passarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passarMouseClicked
        if (passar.isEnabled()) {
            cont++;

            if (cont == 1) {
                for (int i = 0; i < 3; i++) {

                    gerarCartasMesa();

                }
                J = new Jogador(cartas_mesa, naipes, carta_J, naipe_J);
                resultado_jogador = J.getResultado();
                jogada_atualJ.setText(J.getResultado());
                for (int i = 0; i < 10; i++) {
                    if (resultado_jogador.contains(rank.get(i))) {
                        valor_final_jogador = i;
                    }
                }
                if (valor_final_jogador < 3) {
                    barra_jogada.setForeground(Color.RED);
                    barra_jogada.setValue(valor_final_jogador + 1);
                } else if (valor_final_jogador >= 3 && valor_final_jogador <= 5) {
                    barra_jogada.setForeground(Color.YELLOW);
                    barra_jogada.setValue(valor_final_jogador + 1);
                } else {
                    barra_jogada.setForeground(Color.GREEN);
                    barra_jogada.setValue(valor_final_jogador + 1);
                }
                //gera as 3 primeiras cartas na mesa
            }
            if (cont == 2) {
                gerarCartasMesa();
                 
                J = new Jogador(cartas_mesa, naipes, carta_J, naipe_J);
                resultado_jogador = J.getResultado();
                jogada_atualJ.setText(J.getResultado());
                valor_final_jogador = 0;
                for (int i = 0; i < 10; i++) {
                    if (resultado_jogador.contains(rank.get(i))) {
                        valor_final_jogador = i;
                    }
                }
                if (valor_final_jogador < 3) {
                    barra_jogada.setForeground(Color.RED);
                    barra_jogada.setValue(valor_final_jogador + 1);
                } else if (valor_final_jogador >= 3 && valor_final_jogador <= 5) {
                    barra_jogada.setForeground(Color.YELLOW);
                    barra_jogada.setValue(valor_final_jogador + 1);
                } else {
                    barra_jogada.setForeground(Color.GREEN);
                    barra_jogada.setValue(valor_final_jogador + 1);
                }
            } else if (cont == 3) {
                gerarCartasMesa();

                J = new Jogador(cartas_mesa, naipes, carta_J, naipe_J);
                resultado_jogador = J.getResultado();
                jogada_atualJ.setText(J.getResultado());
                valor_final_jogador = 0;
                
                Bot B = new Bot(cartas_mesa, naipes, carta_B, naipe_B);
                resultado_bot = B.getResultado();

                //instanciando as classes Bot e Jogador, e recolhendo o resultado calculado por elas
                for (int i = 0; i < 10; i++) {
                    if (resultado_bot.contains(rank.get(i))) {
                        valor_final_bot = i;
                    }
                }

                for (int i = 0; i < 10; i++) {
                    if (resultado_jogador.contains(rank.get(i))) {
                        valor_final_jogador = i;
                    }
                }
                if (valor_final_jogador < 3) {
                    barra_jogada.setForeground(Color.RED);
                    barra_jogada.setValue(valor_final_jogador + 1);
                } else if (valor_final_jogador >= 3 && valor_final_jogador <= 5) {
                    barra_jogada.setForeground(Color.YELLOW);
                    barra_jogada.setValue(valor_final_jogador + 1);
                } else {
                    barra_jogada.setForeground(Color.GREEN);
                    barra_jogada.setValue(valor_final_jogador + 1);
                }
                //ordena o resultado de acordo com o rank de jogadas

                if (valor_final_bot > valor_final_jogador) {
                    cont_bot++;
                    setAterta("Bot Ganhou!", "ele tinha: " + resultado_bot + ", você tinha: " + resultado_jogador, 1);

                }
                if (valor_final_jogador > valor_final_bot) {
                    cont_jogador++;
                    setAterta("Player Ganhou!", "você tinha: " + resultado_jogador + ", ele tinha: " + resultado_bot, 1);
                }
                if (valor_final_bot == valor_final_jogador) {

                    valor_final_bot = 0;
                    valor_final_jogador = 0;

                    if (B.getCarta_alta() != J.getCarta_alta()) {
                        valor_final_bot = B.getCarta_alta();
                        valor_final_jogador = J.getCarta_alta();
                    } else {
                        valor_final_bot = B.getCarta_baixa();
                        valor_final_jogador = J.getCarta_baixa();
                    }

                    if (valor_final_bot > valor_final_jogador) {
                        cont_bot++;
                        setAterta("Bot Ganhou!", "ele tinha: " + resultado_bot + ", você tinha: " + resultado_jogador, 1);

                    }
                    if (valor_final_jogador > valor_final_bot) {
                        cont_jogador++;
                       setAterta("Player Ganhou!", "você tinha: " + resultado_jogador + ", ele tinha: " + resultado_bot, 1);
                    }
                    if (valor_final_jogador == valor_final_bot) {
                        setAterta("Empate!", "Parece que ambos tinham as mesmas cartas", 1);
                    }
                }
                //verifica o maior resulado e pontua o vencedor

                passar.setEnabled(false);
                correr.setEnabled(false);
                this.girar(carta_B, carta1_bot, carta2_bot, naipe_B);
                //deixa as cartas do Bot visíveis
            }
        }

    }//GEN-LAST:event_passarMouseClicked

    private void correrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correrActionPerformed

    /*
    o metódo gerarBarra gera a barra de carregamento para a nova rodada,
    usando a classe Thread para que ela possa carregar em tempo real,
    em seguida, usa o JFrame criado anteriormente para poder fechar a janela atual e criar 
    uma nova para que a rodada possa ser inicializada.
     */
    public void gerarBarra() {
        score_bot.setText("Bot: " + cont_bot);
        score_jogador.setText("Player: " + cont_jogador);
        barra.setVisible(true);
        new Thread() {
            @Override
            public void run() {
                while (barra.getValue() < 100) {
                    if (barra_foda == true) {
                        try {
                            sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    barra.setValue(barra.getValue() + 1);
                    if (barra.getValue() == 100) {
                        if (cont_bot == 3 || cont_jogador == 3) {
                            if (cont_bot > cont_jogador) {
                                setAterta("Deseja Continuar?", "bot venceu com o placar de " + cont_bot + " a " + cont_jogador, 2);
                            }
                            if (cont_jogador > cont_bot) {
                                setAterta("Deseja Continuar?", "você venceu com o placar de " + cont_jogador + " a " + cont_bot, 2);
                            }
                            cont_bot = 0;
                            cont_jogador = 0;
                            score_bot.setText("Bot: " + cont_bot);
                            score_jogador.setText("Player: " + cont_jogador);
                            //verifica o ganhador da partida após o mesmo alcançar os 3 pontos, retornando a tela de Menu em seguida
                        }else{
                            new Jogo().setVisible(true);
                            dispose();
                        }
                    }
                }
            }
        }.start();
    }

    /*
    o métdo gerarCartasMesa gera as cartas da mesa, 
    ele cria um novo objeto da Classe JLabel,
    a localização desse JLabel aumenta de acordo com um contador denominado de gerador,
    que aumenta a cada chamada do metódo.
    
    esse método também verifica e gera as imagens das cartas.
     */
    private void gerarCartasMesa() {
        gerador++;
        JLabel label = new JLabel();
        fundo.add(label);
        label.setBounds(150 + (gerador * 50), 160, 70, 70);
        int naipe_mesa = r.nextInt(4);
        int num = r.nextInt(13);
        limite_n[num][naipe_mesa]++;
        limite_c[num]++;
        if (limite_c[num] >= 5) {
            while (limite_c[num] >= 5) {
                num = r.nextInt(13);
                 limite_c[num]++;
            }
        } else {
            if (limite_n[num][naipe_mesa] >= 2) {
                while (limite_n[num][naipe_mesa] >= 2) {
                    naipe_mesa = r.nextInt(4);
                    limite_n[num][naipe_mesa]++;
                }
            }
        }
        
        naipes.add(naipe_mesa);
        cartas_mesa.add(num);

        switch (naipe_mesa) {
            case 0:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/copas/carta_" + num + ".png")));
                break;
            case 1:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/espada/carta_" + num + ".png")));
                break;
            case 2:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/ouro/carta_" + num + ".png")));
                break;
            case 3:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/zap/carta_" + num + ".png")));
                break;
        }
    }

    /*
    o metódo gerarCartas_BJ gera as cartas do Jogador e do Bot,
    tendo como parâmetros um valor (no cado a carta) e um JLabel(onde você deseja que a imagem seja setada).
     */
    private void gerarCartas_BJ(int[] carta, JLabel c1, JLabel c2, int[] naipe) {
        JLabel label = new JLabel();
        for (int i = 0; i < 2; i++) {
            switch (naipe[i]) {
                case 0:
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/copas/carta_" + carta[i] + ".png")));
                    break;
                case 1:
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/espada/carta_" + carta[i] + ".png")));
                    break;
                case 2:
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/ouro/carta_" + carta[i] + ".png")));
                    break;
                case 3:
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/zap/carta_" + carta[i] + ".png")));
                    break;
            }
            switch (i) {
                case 0:
                    c1.setIcon(label.getIcon());
                    break;
                case 1:
                    c2.setIcon(label.getIcon());
                    break;
            }
        }
    }

    /*
    os métodos gerarBot e gerarJogador permitem a verificação e geração das cartas 
    do Jogador e do Bot, caso a carta gerada ou naipe seja igual a um gerado anteriormente
    o método se encarrega de gerar uma nova carta ou naipe para que não haja repetições.
     */
    private void gerarJogador() {
        carta_J[1] = r.nextInt(13);
        naipe_J[1] = r.nextInt(4);
        limite_c[carta_J[1]]++;
        limite_n[carta_J[1]][naipe_J[1]]++;
        if (limite_c[carta_J[1]] >= 5) {
            while (limite_c[carta_J[1]] >= 5) {
                carta_J[1] = r.nextInt(13);
                limite_c[carta_J[1]]++;
            }
        } else {
            if (limite_n[carta_J[1]][naipe_J[1]] >= 2) {
                while (limite_n[carta_J[1]][naipe_J[1]] >= 2) {
                    naipe_J[1] = r.nextInt(4);
                    limite_n[carta_J[1]][naipe_J[1]]++;
                }
            }
        }
        this.girar(carta_J, carta1, carta2, naipe_J);
    }

    private void gerarBot() {
        for (int i = 0; i < 2; i++) {
            carta_B[i] = r.nextInt(13);
            naipe_B[i] = r.nextInt(4);
            limite_n[carta_B[i]][naipe_B[i]]++;
            limite_c[carta_B[i]]++;
            if (limite_c[carta_B[i]] >= 5) {
                while (limite_c[carta_B[i]] >= 5) {
                    carta_B[i] = r.nextInt(13);
                    limite_c[carta_B[i]]++;
                }
            } else {
                if (limite_n[carta_B[i]][naipe_B[i]] >= 2) {
                    while (limite_n[carta_B[i]][naipe_B[i]] >= 2) {
                        naipe_B[i] = r.nextInt(4);
                        limite_n[carta_B[i]][naipe_B[i]]++;
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Darcula".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Jogo j = new Jogo();
            j.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JProgressBar barra_jogada;
    private javax.swing.JLabel carta1;
    private javax.swing.JLabel carta1_bot;
    private javax.swing.JLabel carta2;
    private javax.swing.JLabel carta2_bot;
    private javax.swing.JButton correr;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel jogada_atualJ;
    private javax.swing.JButton passar;
    private javax.swing.JLabel score_bot;
    private javax.swing.JLabel score_jogador;
    // End of variables declaration//GEN-END:variables

    private void girar(int[] carta, JLabel c1, JLabel c2, int[] naipe) {
        new Thread() {
            int i = 0;

            public void run() {
                if (giro == 0) {
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                while (i < 6) {
                    try {
                        sleep(30);
                        i++;
                        try {
                            c1.setIcon(new ImageIcon(getClass().getResource("/jogo_poker/sprites/a" + i + ".png")));
                            c2.setIcon(new ImageIcon(getClass().getResource("/jogo_poker/sprites/a" + i + ".png")));
                        } catch (NullPointerException a) {
                            gerarCartas_BJ(carta, c1, c2, naipe);
                            if(giro == 0){
                                barra_jogada.setVisible(true);
                                jogada_atualJ.setVisible(true);
                            }
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                giro++;
            }
        }.start();
    }

    
    
    private void setAterta(String titulo, String texto, int botoes){
       
       if(botoes == 1){
        JButton botao_ok = new JButton(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/botao_ok.png")));
        botao_ok.setBorder(null);
        botao_ok.setBorderPainted(false);
        botao_ok.setContentAreaFilled(false);
        botao_ok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botao_ok.setFocusPainted(false);
        botao_ok.setFocusable(false);
        botao_ok.setBounds(120, 90, 85, 40);
        alerta alert = new alerta(titulo, texto, botao_ok, this);
        alert.setVisible(true);
        
       }else{
        JButton botao_sim = new JButton(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/botao_sim.png")));
        JButton botao_nao = new JButton(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/botao_nao.png")));
        botao_sim.setBorder(null);
        botao_sim.setBorderPainted(false);
        botao_sim.setContentAreaFilled(false);
        botao_sim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botao_sim.setFocusPainted(false);
        botao_sim.setFocusable(false);
        botao_sim.setBounds(83, 90, 85, 40);
        botao_nao.setBorder(null);
        botao_nao.setBorderPainted(false);
        botao_nao.setContentAreaFilled(false);
        botao_nao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botao_nao.setFocusPainted(false);
        botao_nao.setFocusable(false);
        botao_nao.setBounds(173, 90, 85, 40);
        alerta alert = new alerta(titulo, texto, botao_sim, botao_nao, this);
        alert.setVisible(true); 
       }
    }
}