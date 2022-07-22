/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author a19jorgevg
 */
public class GenerateWordException extends Exception {

    private boolean visible;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public GenerateWordException(boolean visible, String message) {
        super(message);
        this.visible = visible;
    }

}
