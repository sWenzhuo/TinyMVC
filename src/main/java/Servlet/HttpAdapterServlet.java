package Servlet;


import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

//在适配器中实现相关的方法
public class HttpAdapterServlet implements HttpExchangeRequest,HttpExchangeResponse{
    private HttpExchange httpExchange;


    public HttpAdapterServlet(HttpExchange httpExchange){
        this.httpExchange = httpExchange;
    }

    @Override
    public String getMethod() {
        return "";
    }

    @Override
    public URI getRequestURI() {
        return null;
    }

    @Override
    public Headers getResponseHeaders() {
        return null;
    }

    @Override
    public void sendResponseHeaders(int status, long responseLength) throws IOException {

    }

    @Override
    public OutputStream getResponseBody() throws IOException {
        return null;
    }
}
