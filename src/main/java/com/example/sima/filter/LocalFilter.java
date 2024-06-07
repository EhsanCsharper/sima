package com.example.sima.filter;

import com.example.sima.utilities.Messages;
import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;

@Component
public class LocalFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // todo: if ML supported then read LOCAL from HTTP HEADER
        Messages.setLocale(new Locale("fa"));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Messages.unsetLocale();
        Filter.super.destroy();
    }
}
