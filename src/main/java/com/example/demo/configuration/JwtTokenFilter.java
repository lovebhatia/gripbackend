<<<<<<< HEAD
package com.example.demo.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtTokenFilter extends GenericFilterBean {

    private JwtTokenProvider jwtTokenProvider;
    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
        if (token != null && jwtTokenProvider.validateToken(token)) {
            Authentication authentication = token != null ? jwtTokenProvider.getAuthentication(token) : null;
            System.out.println(authentication.getCredentials()+" "+authentication.getName()+" "+authentication.getDetails());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("--------- In DoFilter Method ----------------");
        }
        chain.doFilter(request, response);
    }
}
=======
package com.example.demo.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtTokenFilter extends GenericFilterBean {

    private JwtTokenProvider jwtTokenProvider;
    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
        if (token != null && jwtTokenProvider.validateToken(token)) {
            Authentication authentication = token != null ? jwtTokenProvider.getAuthentication(token) : null;
            System.out.println(authentication.getCredentials()+" "+authentication.getName()+" "+authentication.getDetails());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("--------- In DoFilter Method ----------------");
        }
        chain.doFilter(request, response);
    }
}
>>>>>>> 89a419feabd7269af9a59533c57c6a8a2a0c79b5
