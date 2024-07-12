package com.poscodx.mysite.handler;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

public class CustomResourceHttpRequestHandler extends ResourceHttpRequestHandler {

    @Override
    protected Resource getResource(HttpServletRequest request) throws IOException {
        Resource resource = super.getResource(request);
        if (resource == null || !resource.exists()) {
            throw new FileNotFoundException("Resource not found: " + request.getRequestURI());
        }
        return resource;
    }
}