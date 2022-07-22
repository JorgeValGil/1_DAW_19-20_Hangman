package ui;

/**
 * Xogo do aforcado. Clase WordGenerator (Xeradora de palabras). Esta clase
 * encárgase de xerar a palabra a adiviñar.
 *
 * @author Jorge Val Gil
 */
public class ArrayWordGenerator implements WordGenerator {

    private static String WORDLIST[] = new String[]{"antonio", "programacion", "animais", "galiza", "informatica"};

    /**
     * Get de WORDLIST
     *
     * @return devolve WORDLIST
     */
    public static String[] getWORDLIST() {
        return WORDLIST;
    }

    /**
     * Set de WORDLIST
     *
     * @param WORDLIST lista de palabras posibles
     */
    public static void setWORDLIST(String[] WORDLIST) {
        ArrayWordGenerator.WORDLIST = WORDLIST;
    }

    /**
     * Método que devolve a palabra a adiviñar
     *
     * @return devolve unha palabra aleatoria do array WORDLIST
     */
    @Override
    public String generateWord() throws GenerateWordException {
        //xera un número aleatorio entre 0 e length-1
        int generateword = new java.util.Random().nextInt(WORDLIST.length - 1);
        //devolve a palabra da posicion xerada
        return WORDLIST[generateword];
    }
}
