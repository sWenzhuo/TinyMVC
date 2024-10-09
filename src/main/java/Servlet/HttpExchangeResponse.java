package Servlet;

import com.sun.net.httpserver.Headers;

import java.io.IOException;
import java.io.OutputStream;

//定义response需要适配的结构
public interface HttpExchangeResponse {
    Headers getResponseHeaders();//返回请求头
    void sendResponseHeaders(int status,long responseLength)throws IOException;//设置请求头
    OutputStream getResponseBody() throws IOException;//返回response结果
}
