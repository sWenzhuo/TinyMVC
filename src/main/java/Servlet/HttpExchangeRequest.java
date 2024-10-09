package Servlet;


import java.net.URI;

//定义需要适配的request相关的接口
public interface HttpExchangeRequest {
    String getMethod();//得到请求类型
    URI getRequestURI();//得到请求地址

}
