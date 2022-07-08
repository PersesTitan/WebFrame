package variable;

import items.Temporary;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class PortVariable implements HttpWork, Temporary {
    //=(^ㅇㅅㅇ^)= [키]:[값]
    private final String webVar = "^\\s*=\\(\\^ㅇㅅㅇ\\^\\)= \\S+:\\S+";
    private final Pattern pattern = Pattern.compile(webVar);

    @Override
    public boolean check(String line) {
        return pattern.matcher(line).find();
    }

    //변수를 넣음
    @Override
    public void start(String line) {
        line = line.replaceFirst("\\d*=\\(\\^ㅇㅅㅇ\\^\\)= ", "");
        StringTokenizer tokenizer = new StringTokenizer(line, ":");
        String key = tokenizer.nextToken().strip();
        String value = tokenizer.nextToken();
        portMap.put(key, value);
    }
}
