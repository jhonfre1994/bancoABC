/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.banco.convenios.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 * @author jhonfre
 */
@Component
public class InfoFeignClient {

    interface MyCall {

        @RequestMapping(value = "/rest-service", method = GET)
        void callService();
    }

    FeignClientBuilder feignClientBuilder;

    public InfoFeignClient(@Autowired ApplicationContext appContext) {
        this.feignClientBuilder = new FeignClientBuilder(appContext);
    }

    /*
   * Dynamically call a service registered in the directory.
     */
    public void doCall(String serviceId) {

        // create a feign client
        MyCall fc
                = this.feignClientBuilder.forType(MyCall.class, serviceId).build();

        // make the call
        fc.callService();
    }
}
