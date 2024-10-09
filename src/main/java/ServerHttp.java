import Servlet.HttpAdapterServlet;
import Servlet.HttpExchangeRequest;
import Servlet.HttpServletRequestImp;
import Servlet.HttpServletResponseImp;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.logging.Logger;

// 建立一个连接对象，其属性有服务对象和连接,通过HttpHander来处理请求
public class ServerHttp implements HttpHandler, AutoCloseable {

    private final HttpServer server; // 包装 Http 请求
    private static final Logger logger = Logger.getLogger(ServerHttp.class.getName());

    // 构造函数，创建并启动服务器
    public ServerHttp(String host, int port) throws IOException {
        this.server = HttpServer.create(new InetSocketAddress(host, port), 0); // 创建 HttpServerImpl的实例对象，在这里生成httpExchange对象
        this.server.createContext("/", this); // 绑定对应的handler方法
        this.server.setExecutor(null); // 使用默认的线程池
        this.server.start(); // 启动服务器
        logger.info("服务器启动成功，监听地址：" + host + "，端口：" + port);
    }

    // 关闭服务器
    @Override
    public void close() {
        if (this.server != null) {
            this.server.stop(3); // 停止服务器，3秒内完成
            logger.info("服务器已停止");
        }
    }

    // 处理 HTTP 请求
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        HttpAdapterServlet httpAdapterServlet = new HttpAdapterServlet(httpExchange);
        HttpServletRequestImp httpRequest = new HttpServletRequestImp(httpAdapterServlet);
        HttpServletResponseImp httpResponse = new HttpServletResponseImp(httpAdapterServlet);
        this.process(httpRequest,httpResponse);
    }


    public void process(HttpServletRequestImp httpRequest, HttpServletResponseImp httpResponse) throws IOException {
        System.out.println("处理request和response");
    }

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8001;
        try (ServerHttp serverHttp = new ServerHttp(host, port)) { // 创建并启动服务器
            // 服务器运行中，循环保持活跃
            for (;;) {
                try {
                    Thread.sleep(1000); // 每秒检测一次
                } catch (InterruptedException e) {
                    break; // 当线程中断时，跳出循环
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
