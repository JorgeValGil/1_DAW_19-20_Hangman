/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import model.HangMan;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class MainWindow extends javax.swing.JFrame {

    HangMan hangMan;
    private JLabel[] hangManLabels;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        hangManLabels = new JLabel[]{jLabelImg0, jLabelImg1, jLabelImg2, jLabelImg3, jLabelImg4, jLabelImg5, jLabelImg6};
    }

    private void startNewGame() {
        try {
            String gamemode = (String) JOptionPane.showInputDialog(this, "Selecciona un modo de xogo", "Modo de xogo",
                    JOptionPane.QUESTION_MESSAGE, null, new String[]{"Un xogador, xerando a palabra ao azar",
                        "Dous xogadores", "Un xogador, xerando a palabra dunha BD",
                        "Un xogador, collendo a palabra dun ficheiro de texto",
                        "Un xogador, obtendo a palabra dun ficheiro XML"}, "Un xogador, xerando a palabra ao azar");
            if (gamemode != null && !gamemode.trim().isEmpty()) {
                if (gamemode.equals("Un xogador, xerando a palabra ao azar")) {
                    WordGenerator word1 = new ArrayWordGenerator();
                    String hiddenWord = word1.generateWord();
                    hangMan = new HangMan(hiddenWord);
                    this.showGameStatus();

                }
                if (gamemode.equals("Dous xogadores")) {
                    WordGenerator word2 = new GUIKeyboardWordGenerator();
                    String hiddenWord2 = word2.generateWord();
                    hangMan = new HangMan(hiddenWord2);
                    this.showGameStatus();
                }
                if (gamemode.equals("Un xogador, xerando a palabra dunha BD")) {
                    WordGenerator word3 = new DBWordGenerator();
                    String hiddenWord = word3.generateWord();
                    hangMan = new HangMan(hiddenWord);
                    this.showGameStatus();

                }
                if (gamemode.equals("Un xogador, collendo a palabra dun ficheiro de texto")) {
                    WordGenerator word4 = new FileWordGenerator();
                    String hiddenWord = word4.generateWord();
                    hangMan = new HangMan(hiddenWord);
                    this.showGameStatus();
                }
                if (gamemode.equals("Un xogador, obtendo a palabra dun ficheiro XML")) {
                    WordGenerator word5 = new XMLWordGenerator();
                    String hiddenWord = word5.generateWord();
                    hangMan = new HangMan((hiddenWord));
                    this.showGameStatus();
                }

                jTextFieldInsert.setEnabled(true);
                jButtonTry.setEnabled(true);
            }

        } catch (GenerateWordException ex) {
            if (ex.isVisible()) {
                JOptionPane.showMessageDialog(this, "Erro:" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }

    private void showGameStatus() {
        jLabelWordL.setText(hangMan.showHiddenWord());
        jLabelFailsL.setText(hangMan.getStringFails());
        for (int i = 0; i < hangManLabels.length; i++) {
            if (i == hangMan.getFails().size()) {
                hangManLabels[i].setVisible(true);
            } else {
                hangManLabels[i].setVisible(false);
            }
        }
        if (hangMan.isGameOver()) {
            jTextFieldInsert.setEnabled(false);
            jButtonTry.setEnabled(false);
            if (hangMan.maxFailsExceeded()) {
                JOptionPane.showConfirmDialog(null, "Fin do xogo. Quedaches aforcado!!! A palabra oculta era " + hangMan.showFullWord(), "Game Over", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(null, "Ganache!!! A palabra oculta era " + hangMan.showFullWord(), "Victoria", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    private void tryChar() {
        String text = jTextFieldInsert.getText();
        jTextFieldInsert.setText("");
        if (!text.isEmpty() && Character.isLetter(text.charAt(0))) {
            char letra = text.charAt(0);
            hangMan.tryChar(letra);
            showGameStatus();
        } else {
            JOptionPane.showConfirmDialog(null, "Debes introducir unha letra minúscula!!!", "Entrada de datos", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabelWord = new javax.swing.JLabel();
        jLabelWordL = new javax.swing.JLabel();
        jLabelFails = new javax.swing.JLabel();
        jLabelFailsL = new javax.swing.JLabel();
        jLabelInsert = new javax.swing.JLabel();
        jTextFieldInsert = new javax.swing.JTextField();
        jButtonTry = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonNewGame = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabelImg6 = new javax.swing.JLabel();
        jLabelImg0 = new javax.swing.JLabel();
        jLabelImg1 = new javax.swing.JLabel();
        jLabelImg2 = new javax.swing.JLabel();
        jLabelImg3 = new javax.swing.JLabel();
        jLabelImg4 = new javax.swing.JLabel();
        jLabelImg5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("O aforcado");

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelWord.setText("Palabra a adiviñar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel1.add(jLabelWord, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel1.add(jLabelWordL, gridBagConstraints);

        jLabelFails.setText("Letras falladas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        jPanel1.add(jLabelFails, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, -10, 0, 0);
        jPanel1.add(jLabelFailsL, gridBagConstraints);

        jLabelInsert.setText("Introduce unha letra:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel1.add(jLabelInsert, gridBagConstraints);

        jTextFieldInsert.setEnabled(false);
        jTextFieldInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInsertActionPerformed(evt);
            }
        });
        jTextFieldInsert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldInsertKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 0);
        jPanel1.add(jTextFieldInsert, gridBagConstraints);

        jButtonTry.setText("Probar");
        jButtonTry.setEnabled(false);
        jButtonTry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
        jPanel1.add(jButtonTry, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jLabelTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelTitle.setText("O xogo do aforcado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jButtonNewGame.setText("Nova partida");
        jButtonNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewGameActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonNewGame);

        jButtonExit.setText("Saír");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonExit);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel4.setLayout(new java.awt.CardLayout());

        jLabelImg6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hangman-6.png"))); // NOI18N
        jPanel4.add(jLabelImg6, "card8");

        jLabelImg0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hangman-0.png"))); // NOI18N
        jPanel4.add(jLabelImg0, "card3");

        jLabelImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hangman-1.png"))); // NOI18N
        jPanel4.add(jLabelImg1, "card3");

        jLabelImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hangman-2.png"))); // NOI18N
        jPanel4.add(jLabelImg2, "card4");

        jLabelImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hangman-3.png"))); // NOI18N
        jPanel4.add(jLabelImg3, "card5");

        jLabelImg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hangman-4.png"))); // NOI18N
        jPanel4.add(jLabelImg4, "card6");

        jLabelImg5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hangman-5.png"))); // NOI18N
        jPanel4.add(jLabelImg5, "card7");

        getContentPane().add(jPanel4, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldInsertActionPerformed

    private void jButtonTryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTryActionPerformed
        tryChar();
    }//GEN-LAST:event_jButtonTryActionPerformed

    private void jButtonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewGameActionPerformed
        startNewGame();
    }//GEN-LAST:event_jButtonNewGameActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jTextFieldInsertKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldInsertKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tryChar();
        }
    }//GEN-LAST:event_jTextFieldInsertKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonNewGame;
    private javax.swing.JButton jButtonTry;
    private javax.swing.JLabel jLabelFails;
    private javax.swing.JLabel jLabelFailsL;
    private javax.swing.JLabel jLabelImg0;
    private javax.swing.JLabel jLabelImg1;
    private javax.swing.JLabel jLabelImg2;
    private javax.swing.JLabel jLabelImg3;
    private javax.swing.JLabel jLabelImg4;
    private javax.swing.JLabel jLabelImg5;
    private javax.swing.JLabel jLabelImg6;
    private javax.swing.JLabel jLabelInsert;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelWord;
    private javax.swing.JLabel jLabelWordL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldInsert;
    // End of variables declaration//GEN-END:variables
}
