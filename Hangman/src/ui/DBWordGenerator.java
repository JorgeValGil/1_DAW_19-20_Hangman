/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jorge Val Gil e Adrián Fernández Pérez
 */
public class DBWordGenerator implements WordGenerator {

    @Override
    public String generateWord() throws GenerateWordException {
        String palabra = "";
        int generateword;
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:src/word.db", "", "");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS WORD FROM WORD");
            generateword = new java.util.Random().nextInt(rs.getInt("WORD")) + 1;
            rs.close();
            ResultSet rs2 = st.executeQuery("SELECT * FROM WORD");
            while (rs2.next()) {
                if (rs2.getRow() == generateword) {
                    palabra = rs.getString("WORD");
                }
            }
            rs2.close();
            st.close();
            c.close();
        } catch (SQLException ex) {
            System.out.println("A conexión co servidor de bases de datos non se puido establecer" + ex.getMessage());
        }
        return palabra;
    }

}
