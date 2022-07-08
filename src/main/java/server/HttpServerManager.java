package server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerManager {
    private final String DEF_HOST = "localhost";
    private final int DEF_PORT = 9090;
    private HttpServer server;

    public HttpServerManager(String path) {
        createServer(path, DEF_HOST, DEF_PORT);
    }
    public HttpServerManager(String path, int port) {
        createServer(path, DEF_HOST, port);
    }
    public HttpServerManager(String path, String host) {
        createServer(path, host, DEF_PORT);
    }
    public HttpServerManager(String path, String host, int port) {
        createServer(path, host, port);
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop(0);
    }

    //서버 생성
    private void createServer(String path, String host, int port) {
        try {
            server = HttpServer.create(new InetSocketAddress(host, port), 0);
            server.createContext(path, new RootHandler());
        } catch (IOException e) {
            System.out.println("서버 생성에 실패하였습니다.");
        }
    }
}
