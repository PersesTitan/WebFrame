package items;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public interface Temporary {
    Map<String, String> tem = new HashMap<>();
    //url, html 경로
    Map<String, String> path = new HashMap<>();

    static void startSetting() {
        System.out.printf("[%s]%s[OTL Server 시작]%s ",
                new SimpleDateFormat("yyyy-MM-dd H:mm:ss").format(new Date()),
                Color.green,
                Color.exit);

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
            System.out.printf("[%s]%s[OTL Server 종료]%s ",
                    new SimpleDateFormat("yyyy-MM-dd H:mm:ss").format(new Date()),
                    Color.green,
                    Color.exit)));
    }
}
