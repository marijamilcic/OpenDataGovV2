/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import domain.Skole;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author marij
 */
public class JsonToObj {
ObjectMapper mapper = new ObjectMapper();


public void createJson(){
    try {
        //JSON from file to Object
        Config obj = mapper.readValue(new File("c:\\get.json"), Config.class);
        String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        
      
    } catch (IOException ex) {
        Logger.getLogger(JsonToObj.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    public static void main(String[] args) {
        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        
        
    }

}
