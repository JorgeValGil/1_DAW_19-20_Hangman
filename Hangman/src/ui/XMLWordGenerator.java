/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Usuario
 */
public class XMLWordGenerator implements WordGenerator {

    @Override
    public String generateWord() throws GenerateWordException {
        String xmlword = "";
        File file = new File("src/documento.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            NodeList nList = doc.getElementsByTagName("word");
            int numeropalabras = nList.getLength();

            int word = new java.util.Random().nextInt(numeropalabras);
            xmlword = nList.item(word).getTextContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlword;
    }

}
