package com.example.project.springbootrestjpa;
import org.springframework.stereotype.Component;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import javax.servlet.http.*;
import org.springframework.security.core.AuthenticationException;
import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)

      throws IOException, ServletException {

        response.addHeader("LoginUser", "Basic " +getRealmName());

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        PrintWriter writer = response.getWriter();

        writer.println("HTTP Status 401 - " + authEx.getMessage());

    }

	@Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("springboot");
        super.afterPropertiesSet();

    }

}