/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class FileWordGenerator implements WordGenerator {

    @Override
    public String generateWord() throws GenerateWordException {
        String word = "";
        FileReader reader = null;
        try {
            reader = new FileReader("src/words.TXT");
            BufferedReader bufReader = new BufferedReader(reader);
            String linea = "";
            ArrayList<String> palabras = new ArrayList<String>();
            while ((linea = bufReader.readLine()) != null) {
                palabras.add(linea);
            }
            int generateword = new java.util.Random().nextInt(palabras.size());
            word = palabras.get(generateword);

        } catch (IOException ex) {
            System.out.println("Erro en generateWord da clase generateWord: " + ex.getMessage());
        }
        return word;
    }

}
