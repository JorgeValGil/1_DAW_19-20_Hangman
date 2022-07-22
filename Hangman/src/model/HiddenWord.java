package model;

/**
 * Xogo do aforcado. Clase HiddenWord (Palabra oculta). Implementa a palabra a
 * adiviñar.
 *
 * @author Jorge Val Gil
 */
public class HiddenWord {

    private char characters[];
    private boolean hits[];

    /**
     * Get de characters
     *
     * @return devolve characters
     */
    public char[] getCharacters() {
        return characters;
    }

    /**
     * Set de characters
     *
     * @param characters caracteres da palabra
     */
    public void setCharacters(char[] characters) {
        this.characters = characters;
    }

    /**
     * Get de hits
     *
     * @return devolve hits
     */
    public boolean[] getHits() {
        return hits;
    }

    /**
     * Set de Hits
     *
     * @param hits caracteres da palabra acertados ou non acertados
     */
    public void setHits(boolean[] hits) {
        this.hits = hits;
    }

    /**
     * Constructor da clase
     *
     * @param hiddenword palabra a adiviñar
     */
    public HiddenWord(String hiddenword) {
        //o constructor recibe a palabra a adiviñar mediante un String. Incializa os dous array (characters e hits). o array hits inicializao con todolos elementos a valor false
        characters = hiddenword.toCharArray();
        hits = new boolean[characters.length];
        for (int i = 0; i < hits.length; i++) {
            hits[i] = false;
        }
    }

    /**
     * Método que comproba se un caracter aparece na palabra ou non.
     *
     * @param c un caracter
     * @return devolve true se o caracter está na palabra, devolve false se non
     * está na palabra
     */
    public boolean checkChar(char c) {
        boolean checkchar = false;
        for (int i = 0; i < characters.length; i++) {
            //recorremos o array, comprobando se está o caracter, para devolver true ou false
            if (c == characters[i]) {
                hits[i] = true;
                checkchar = true;
            }
        }
        return checkchar;
    }

    /**
     * Método que devolve a palabra substituíndo os caracteres non acertados por
     * guións
     *
     * @return devolve a palabra substituíndo os caracteres non acertados por
     * guións
     */
    public String show() {
        String word = "";
        //creamos un string valeiro, iremos comprobando os valores de hits, se hits[i] nos devolve true amosaremos añadiremos o caracter, senon un guion
        for (int i = 0; i < characters.length; i++) {
            if (hits[i]) {
//                word += word + characters[i];
                word += characters[i];
            } else {
//                word += word + "-";
                word += "-";
            }
        }
        return word;
    }

    /**
     * Método que devolve a palabra completa, úsase cando o usuario perda
     *
     * @return devolve a palabra completa
     */
    public String showFullWord() {
        //devolvemos o array characters en forma de string
//        return characters.toString();
        return new String(characters);
    }

    /**
     * Método que indica se a palabra está totalmente acertada, serve para saber
     * se o usuario gañou
     *
     * @return indica se a palabra é visible (totalmente resolta)
     */
    public boolean isVisible() {
        boolean win = false;
        int hitstrue = 0;
        for (int i = 0; i < hits.length; i++) {
            //recorremos o array contando os hits de valor true
            if (hits[i]) {
                hitstrue++;
            }
        }
        //se temos tantos hists de valor true, o usuario gañou, devolvemos true
        if (hitstrue == characters.length) {
            win = true;
        }
        return win;
    }
}
