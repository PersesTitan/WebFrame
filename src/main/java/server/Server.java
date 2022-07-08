package server;

import items.Color;
import items.Temporary;

public class Server implements Temporary {

    public void connectServer() {
        HttpServerManager httpServerManager = new HttpServerManager();
        try {
            httpServerManager.start();
            if (path.isEmpty()) System.out.printf("%s경로가 존재하지 않습니다.%s\n", Color.red, Color.exit);
            else {
                while (true) {}
            }
        } finally {
            httpServerManager.stop();
        }
    }
}
