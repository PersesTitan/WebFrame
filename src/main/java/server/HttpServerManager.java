package server;

import com.sun.net.httpserver.HttpServer;
import items.Color;
import items.Temporary;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerManager implements Temporary {
    private final String DEF_HOST = "localhost";
    private final int DEF_PORT = 9090;
    private HttpServer server;

    public HttpServerManager() {createServer(DEF_HOST, DEF_PORT);}
    public HttpServerManager(String host) {createServer(host, DEF_PORT);}
    public HttpServerManager(int port) {createServer(DEF_HOST, port);}
    public HttpServerManager(String host, int port) {createServer(host, port);}

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop(0);
    }

    //서버 생성
    private void createServer(String host, int port) {
        System.out.printf("URL http://%s:%d/%n", host, port);
        try {
            server = HttpServer.create(new InetSocketAddress(host, port), 0);
            Temporary.path.forEach((k, v) -> server.createContext(k, new RootHandler()));
        } catch (IOException e) {
            System.out.println("서버 생성에 실패하였습니다.");
        }
    }
}
