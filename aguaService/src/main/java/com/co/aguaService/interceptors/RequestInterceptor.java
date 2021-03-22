package com.co.aguaService.interceptors;

import com.co.aguaService.exceptions.responses.HttpResponseException;
import javax.servlet.RequestDispatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object object) throws Exception {
        String header = request.getHeader("Reference");
        String requestURI = request.getRequestURI();
        if (requestURI.toLowerCase().contains("swagger".toLowerCase()) ||
                requestURI.toLowerCase().contains("v3/api-docs".toLowerCase())) {  
            return true;
        } 
        if (header != null) {
            if (!header.equals("agua-service")) {
                  return true;
            }
        }
        throw new HttpResponseException(403, "Las solicitudes para el servicio agua-service"
                + " unicamente deben ser ejecutadas por medio del servicio de convenio-service", "ERROR");
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }

}
