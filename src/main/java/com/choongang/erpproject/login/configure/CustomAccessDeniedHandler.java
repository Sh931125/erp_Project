package com.choongang.erpproject.login.configure;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
//인가 실패 시 처리를 위한 클래스
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException, NoSuchElementException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }

}
