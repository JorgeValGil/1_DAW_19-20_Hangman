package model;

import java.util.ArrayList;

/**
 * Xogo do aforcado. Clase HangMan (Aforcado). Implementa todo o estado dunha
 * partida ao aforcado.
 *
 * @author Jorge Val Gil
 */
public class HangMan {

    private static final int MAX_FAILS = 6;
    HiddenWord hiddenWord;
    ArrayList<Character> fails = new ArrayList();

    /**
     * Get de hiddenword
     *
     * @return devolve hiddenword
     */
    public HiddenWord getHiddenWord() {
        return hiddenWord;
    }

    /**
     * set de hiddenword
     *
     * @param hiddenWord palabra a adiviñar(obxeto de clase hiddenword)
     */
    public void setHiddenWord(HiddenWord hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    /**
     * Get de fails
     *
     * @return devolve a lista de caracteres probados e non estén na palabra
     * oculta
     */
    public ArrayList<Character> getFails() {
        return fails;
    }

    /**
     * Set de fails
     *
     * @param fails fails lista de caracteres probados e que non están na
     * palabra oculta
     */
    public void setFails(ArrayList<Character> fails) {
        this.fails = fails;
    }

    /**
     * Constructor da clase
     *
     * @param word palabra a adiviñar
     */
    public HangMan(String word) {
        hiddenWord = new HiddenWord(word);
    }

    /**
     * Método que serve para obter a lista de caracteres fallados separados por
     * espazos en branco
     *
     * @return devolve un string, formado polos caracteres fallados separados
     * por un espazo en branco
     */
    public String getStringFails() {
        String failslist = "";
        //creamos un string valeiro, recorremos fails e vamos rellenando dito string cos fails separados por espazos en branco
        for (int i = 0; i < fails.size(); i++) {
            failslist += " " + fails.get(i);
        }

        return failslist;
    }

    /**
     * Método que devolve a palabra oculta poñendo un guión nas letras non
     * acertadas
     *
     * @return devolve a palabra oculta poñendo un guión nas letras non
     * acertadas
     */
    public String showHiddenWord() {
        //invocamos o método show da clase hiddenword
        return hiddenWord.show();
    }

    /**
     * Método que devolve a palabra oculta mostrando todas as letras
     *
     * @return devolve a palabra oculta mostrando todas as letras
     */
    public String showFullWord() {
        //invocamos o método showFullWord da clase hiddenword
        return hiddenWord.showFullWord();
    }

    /**
     * Método que comproba se un caracter está na palabra oculta, se o está
     * marca as letras como acertadas, senon engade o caracter a lista de fallos
     *
     * @param c un caracter
     */
    public void tryChar(char c) {
        //facendo uso do método checkchar da clase hiddenword comproabamos se está o caracter ou non
        if (!hiddenWord.checkChar(c)) {
            //se non está añadímolo ao arraylist fails
            fails.add(c);
        }

    }

    /**
     * método que comproba se rematou a partida
     *
     * @return devolve un boolean dependendo se a partida rematou ou no
     */
    public boolean isGameOver() {
        boolean gameover = false;
        //se o método isvisible devolve true ou se o tamaño do array dos fails é maior ou igual ca o maximo de fallos, devolvemos true xa que o xogo terminaría
        if (hiddenWord.isVisible() || fails.size() == MAX_FAILS) {
            gameover = true;
        }
        return gameover;
    }

    /**
     * Método que comproba se se chegou ao límite de fallos permitidos
     *
     * @return devolve un boolean dependendo se se chegou ao numero maximo de
     * fallos ou no
     */
    public boolean maxFailsExceeded() {
        boolean maxfails = false;
        //se o tamaño do array dos fails é maior ou igual ca o maximo de fallos, devolvemos true
        if (fails.size() == MAX_FAILS) {
            maxfails = true;
        }
        return maxfails;

    }

}
