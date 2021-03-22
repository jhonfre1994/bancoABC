/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.helpers;

import com.co.banco.convenios.exceptions.ExceptionResponse;
import com.co.banco.convenios.exceptions.responses.HttpResponseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author jhonfre
 */
public class ErrorDecoderFeign implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {

        String message = null;
        String url = null;
        Reader reader = null;

        try {
            reader = response.body().asReader();
            String result = CharStreams.toString(reader);
            ObjectMapper mapper = new ObjectMapper();    
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            ExceptionResponse exceptionMessage = mapper.readValue(result,
                    ExceptionResponse.class);

            message = exceptionMessage.getErrors().getDetail();
            url = exceptionMessage.getErrors().getApiFail();

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (response.status() != 200) {
            throw new HttpResponseException(response.status(), url, message);
        }
        return errorDecoder.decode(s, response);
    }
}
