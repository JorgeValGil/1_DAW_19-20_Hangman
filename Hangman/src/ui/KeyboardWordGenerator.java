/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class KeyboardWordGenerator implements WordGenerator {

    @Override
    public String generateWord() throws GenerateWordException {
        String word;
        Scanner sc = new Scanner(System.in);
        System.out.println("--- BENVIDO AO XOGO DO AFORCADO ---");
        System.out.println("Escribe a palabra que se adiviñará: ");
        if (System.console() == null) {
            word = sc.nextLine();
        } else {
            word = String.valueOf(System.console().readPassword());
        }
        return word;
    }

}
