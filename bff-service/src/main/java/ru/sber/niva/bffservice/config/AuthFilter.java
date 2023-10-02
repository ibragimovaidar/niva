package ru.sber.niva.bffservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Component
@WebFilter(urlPatterns = "/api/v1/*")
public class AuthFilter implements Filter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var session = ((HttpServletRequest) request).getSession(true);
        var user = session.getAttribute("user");
        if (user == null) {
            ((HttpServletResponse) response).sendError(403);
        }
        chain.doFilter(new RequestWrapper((HttpServletRequest) request, Map.of("X_User", objectMapper.writeValueAsString(user))), response);
    }

    static class RequestWrapper extends HttpServletRequestWrapper {

        private Map<String, String> addedHeaders = new HashMap<>();

        public RequestWrapper(HttpServletRequest request, Map<String, String> addedHeaders) {
            super(request);
        }

        public String getHeader(String name) {
            String header = super.getHeader(name);
            return (header != null) ? header : addedHeaders.get(name); // Note: you can't use getParameterValues() here.
        }

        public Enumeration getHeaderNames() {
            List<String> names = Collections.list(super.getHeaderNames());
            names.addAll(addedHeaders.keySet());
            return Collections.enumeration(names);
        }

        public void addHeaders(Map<String, String> headers) {
            addedHeaders.putAll(headers);
        }
    }
}
