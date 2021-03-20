/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.helpers;

import com.co.banco.convenios.exceptions.responses.BadRequestException;
import java.io.InputStream;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONTokener;

/**
 *
 * @author jhonfre
 */
public class JsonHelper {
    
    private String jsonString;
    
    public JsonHelper(String jsonString){
        this.jsonString = jsonString;
    }
    
    
    public void validateSchema(String schemaName) {
        try {
            InputStream inputStream = new ClassPathResource("/schemas/" + schemaName).getInputStream();
            JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
            Schema schema = SchemaLoader.load(rawSchema);
            schema.validate(new JSONObject(jsonString));
        }catch(Exception e){
            System.out.println(e);
            throw new BadRequestException("Error al validar la información ingresada en el json - " + e.getMessage());
        }
    }
    
}
