/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Usuario
 */
public class GUIKeyboardWordGenerator implements WordGenerator {

    @Override
    public String generateWord() throws GenerateWordException {

        JPasswordField password = new JPasswordField();
        Object[] ob = {password};
        int result = JOptionPane.showConfirmDialog(null, ob, "Introduce a palabra secreta", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            char[] pass = password.getPassword();
            String passvalid = new String(pass);
            boolean valid = isValid(passvalid);
            if (valid) {
                return passvalid;
            }
        }
        if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
            throw new GenerateWordException(false, "O usuario cancelou ou pechou a ventá");
        }
        return null;
    }

    private boolean isValid(String word) {
        boolean valid = false;
        if (word.equals(word.toLowerCase())) {
            valid = true;
        } else {
            try {
                int result = JOptionPane.showConfirmDialog(null, "A palabra só pode conter tetras minúsculas da a a z!", "Palabra incorrecta", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    this.generateWord();
                }
            } catch (GenerateWordException ex) {
                System.out.println("Erro" + ex.getMessage());
            }
        }
        return valid;
    }
}
