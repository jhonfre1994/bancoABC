/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.client;

import com.co.banco.convenios.exceptions.responses.HttpResponseException;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import feign.codec.ErrorDecoder.Default;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 *
 * @author jhonfre
 */
public class MyErrorDecoder implements Decoder {
    
    @Override
    public Object decode(Response rspns, Type type) throws IOException, DecodeException, FeignException {
        if(rspns.status() != 200){
            throw new HttpResponseException(200, "", "");
        }
        return null;
    }
    
}
