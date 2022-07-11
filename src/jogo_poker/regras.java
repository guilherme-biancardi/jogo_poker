/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_poker;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodnei Rovanelli
 */
public class regras extends javax.swing.JFrame {
    /**
     * Creates new form regras
     */
    
     ArrayList<String> regras_texto = new ArrayList<>();
     ArrayList<String> regras_titulo = new ArrayList<>();
     int cont = 0;
     
    public regras() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(regras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        titulo.setBounds(-860, titulo.getY(), titulo.getWidth(), titulo.getHeight());
        scroll.setBounds(-860, scroll.getY(), scroll.getWidth(), scroll.getHeight());
        avancar.setBounds(-390, avancar.getY(), avancar.getWidth(), avancar.getHeight());
        voltar.setBounds(-630, voltar.getY(), voltar.getWidth(), voltar.getHeight());
        scroll.getViewport().setOpaque(false);
        new Thread(){
            int t = 0;
            @Override
            public void run(){
            while(t < 4){
                try {
                    sleep(750);
                    t++;
                } catch (InterruptedException ex) {
                    Logger.getLogger(regras.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(t == 3){
                    
                    for(int i = 0; i < 10; i++){
                        try {
                            sleep(30);
                            titulo.setBounds(-860 + (i*100), titulo.getY(), titulo.getWidth(), titulo.getHeight());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(regras.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    for(int i = 0; i < 10; i++){
                        try {
                            sleep(30);
                            scroll.setBounds(-860 + (i*100), scroll.getY(), scroll.getWidth(), scroll.getHeight());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(regras.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    try {
                        sleep(300);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(regras.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for(int i = 0; i < 10; i++){
                        try {
                            sleep(20);
                            voltar.setBounds(-630 + (i*100), voltar.getY(), voltar.getWidth(), voltar.getHeight());
                            avancar.setBounds(-390 + (i*100), avancar.getY(), avancar.getWidth(), avancar.getHeight());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(regras.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            }
        }.start();
        regras_titulo.add("Bem Vindo as Regras!");
        regras_titulo.add("Como Jogar");
        regras_titulo.add("Ordem das Mãos");
        regras_texto.add("<html>Este tutorial dará a você uma boa ideia de como jogar <br/> caso você nunca tenha jogado poker antes,"
    + " aqui você <br/> verá todas regras para que possa "
    + "desfrutar do jogo <br/> da melhor maneira possível.<br/>"
    + "\n<br/>"
    + "\n<br/>"
    + "\n<br/>"
    + "\n<br/>"
    + "vamos lá!</html>"
);
        regras_texto.add("<html>Aqui estão as ações possíveis a cada rodada do jogo: <br/><br/>\n" +
"        • Passar: você só podera passar caso não haja aposta na rodada atual, <br/>\n" +
"        caso todos os jogadores passem a rodada é concluída.<br/><br/>\n" +
"        \n" +
"        • Correr: caso o jogador corra ele perderá a chance de continuar na rodada, <br/>\n" +
"        caso todos os jogadores corram, o último a ficar na mesa ganhará a rodada. <br/><br/>\n" +
"        \n" +
"        • Apostar: para apostar basta informar o número de fichas que deseja colocar em jogo, <br/>\n" +
"        lembre-se de que caso a aposta seja aumentada, o jogador deverá pagar para que <br/>possa continuar na rodada.</html>");
        regras_texto.add("<html>Aqui estão as ordem das mãos possíveis do jogo: <br/><br/>\n" +
"        • Carta Mais Alta: forma de desempate caso os jogadores possuam o mesmo jogo, <br/>\n" +
"        sendo a mais alta o ás e a mais baixa o 2.<br/><br/>\n" +
"        \n" +
"        • Par: são duas cartas de mesmo número ou valor.<br/><br/>\n" +
"        \n" +
"        • Dois Pares: Dois diferentes pares em uma mesma mão. <br/><br/>\n" +
"        \n" +
"        • Trinca: três cartas de mesmo número ou valor.<br/><br/>\n" +
"        \n" +
"        • Sequência: cinco cartas de qualquer naipe, em ordem.<br/><br/>\n" +
"        \n" +
"        • Flush: cinco cartas do mesmo naipe, em qualquer ordem. <br/><br/>\n" +
"        \n" +
"        • Full House: uma trinca e um par em uma mesma mão. <br/><br/>\n" +
"        \n" +
"        • Quadra: quatro cartas de mesmo número ou valor. <br/><br/>\n" +
"        \n" +
"        • Straight Flush: cinco cartas do mesmo naipe e em sequência. <br/><br/>\n" +
"        \n" +
"        • Royal Flush: A melhor mão possível, sendo Dez, Valete, Dama, Rei e Ás, <br/>todos do mesmo naipe.</html>");
    }

   
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        avancar = new javax.swing.JLabel();
        voltar = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        texto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 500));
        setUndecorated(true);
        getContentPane().setLayout(null);

        avancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/botao_avancar.png"))); // NOI18N
        avancar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        avancar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avancarMouseClicked(evt);
            }
        });
        getContentPane().add(avancar);
        avancar.setBounds(510, 440, 30, 30);

        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/botao_voltar.png"))); // NOI18N
        voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarMouseClicked(evt);
            }
        });
        getContentPane().add(voltar);
        voltar.setBounds(270, 440, 30, 30);

        titulo.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 150, 61));
        titulo.setText("Bem Vindo as Regras!");
        getContentPane().add(titulo);
        titulo.setBounds(30, 10, 380, 60);

        scroll.setBorder(null);
        scroll.setOpaque(false);

        texto.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        texto.setForeground(new java.awt.Color(255, 150, 61));
        texto.setText("<html>Este tutorial dará a você uma boa ideia de como jogar <br/> caso você nunca tenha jogado poker antes,"
            + " aqui você <br/> verá todas regras para que possa "
            + "desfrutar do jogo <br/> da melhor maneira possível.<br/>"
            + "\n<br/>"
            + "\n<br/>"
            + "\n<br/>"
            + "\n<br/>"
            + "vamos lá!</html>");
        texto.setToolTipText("");
        texto.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        scroll.setViewportView(texto);

        getContentPane().add(scroll);
        scroll.setBounds(30, 80, 850, 260);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogo_poker/componentes/fundo_regras.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -20, 900, 520);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseClicked
        cont--;
        if(cont < regras_texto.size()){
            avancar.setVisible(true);
        }
        try{
        texto.setText(regras_texto.get(cont));
        titulo.setText(regras_titulo.get(cont));
        }catch(ArrayIndexOutOfBoundsException e){
            new Menu().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_voltarMouseClicked

    private void avancarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avancarMouseClicked
        cont++;
        if(cont == regras_texto.size()-1){
            avancar.setVisible(false);
        }
        texto.setText(regras_texto.get(cont));
        titulo.setText(regras_titulo.get(cont));
    }//GEN-LAST:event_avancarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avancar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel texto;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel voltar;
    // End of variables declaration//GEN-END:variables
}
