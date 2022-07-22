//package ui;
//
//import model.HangMan;
//import java.util.Scanner;
//
///**
// * Xogo do aforcado. Clase MenuGenerator (Xeradora de menu). Esta clase
// * encárgase de mostrar os menús coas distintas opcións do xogo, e recoller o
// * que introduza o usuario
// *
// * @author Jorge Val Gil
// */
//public class MenuGenerator {
//
//    HangMan hangMan;
//
//    /**
//     * get de hangMan
//     *
//     * @return devolve hangMan
//     */
//    public HangMan getHangMan() {
//        return hangMan;
//    }
//
//    /**
//     * set de hangMan
//     *
//     * @param hangMan obxeto que xestiona a partida(obxeto de clase hangman)
//     */
//    public void setHangMan(HangMan hangMan) {
//        this.hangMan = hangMan;
//    }
//
//    /**
//     * Método que mostra o menú inicial que permite xerar a palabra a adiviñar.
//     *
//     * @return devole a palabra a adiviñar
//     */
//    private String showInitMenu() throws GenerateWordException {
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("---ESCOLLE O MODO DE XOGO---");
//        System.out.println("1. Aforcado estándar");
//        System.out.println("2. Aforcado para 2 xogadores");
//        int menu = sc.nextInt();
//        switch (menu) {
//            case 1:
//                WordGenerator word1 = new ArrayWordGenerator();
//                //xeramos a palabra a adiviñar mediante o método generateword da clase arraywordgenerator
//                return word1.generateWord();
//
//            case 2:
//                WordGenerator word2 = new KeyboardWordGenerator();
//                return word2.generateWord();
//        }
//        return null;
//    }
//
//    /**
//     * Método que mostra o menú do xogo, que vai pedindo as letras e mostrando o
//     * avance de fallos e acertos na palabra. O xogo remata cando se acertan
//     * todas as letras da palabra ou se chega ao límite de fallos
//     */
//    private void showGameMenu() {
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("---BENVIDO AO XOGO DO AFORCADO---");
//        do {
//            System.out.println("Palabra: " + hangMan.showHiddenWord());
//            System.out.println("Letras falladas: " + hangMan.getStringFails());
//            System.out.println("Introduce unha letra: ");
//            hangMan.tryChar(sc.next().charAt(0));
//        } while (!hangMan.isGameOver());
//        if (hangMan.maxFailsExceeded()) {
//            System.out.println("---FIN DO XOGO---");
//            System.out.println("A palabra era: " + hangMan.showFullWord());
//        } else {
//            System.out.println("Ganache! A palabra a adiviñar era: " + hangMan.showFullWord());
//        }
//    }
//
//    /**
//     * Método que se encarga de xogar outra partida ou sair da aplicación.
//     *
//     * @return devolve un boolean. true para xogar outra partida. false para
//     * sair da aplicacion.
//     */
//    private boolean showExitMenu() {
//        boolean endgame = false;
//        Scanner sc = new Scanner(System.in);
//        //pedimos nun scanner S para xogar outra partida e N para sair do xogo
//        System.out.println("FIN DO XOGO. Pulsa S pra xogar outra partida. Pulsa N pra sair do xogo");
//        char exitmenu = sc.next().charAt(0);
//        //comprobamos o canner nun switch
//        switch (exitmenu) {
//            case 'S':
//                endgame = false;
//                break;
//            case 'N':
//                endgame = true;
//                break;
//        }
//        return endgame;
//    }
//
//    /**
//     * Método main
//     *
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        try {
//            MenuGenerator menuGenerator = new MenuGenerator();
//
//            do {
//                menuGenerator.hangMan = new HangMan(menuGenerator.showInitMenu());
//                menuGenerator.showGameMenu();
//            } while (!menuGenerator.showExitMenu());
//        } catch (GenerateWordException e) {
//            if (e.isVisible()) {
//                System.out.println("Erro. Non se puido conectar coa base de datos");
//            }
//        }
//    }
//
//}
