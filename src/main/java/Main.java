import items.Temporary;
import server.CreateHTML;
import server.HttpServerManager;
import server.Server;

import java.io.IOException;

public class Main implements Temporary {
    public static void main(String[] args) {
        Temporary.startSetting();
        tem.put("aaa", "안녕");
        path.put("/", "index.html");

        HttpServerManager httpServerManager = null;
        try {
            httpServerManager = new HttpServerManager("/");
            httpServerManager.start();

            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert httpServerManager != null;
            httpServerManager.stop();
        }

//        Server server = new Server();
//        server.connectServer();
    }
}
