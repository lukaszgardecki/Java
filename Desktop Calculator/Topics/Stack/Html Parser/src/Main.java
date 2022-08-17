import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sb = reader.readLine();
        Deque<Integer> tags = new ArrayDeque<>();
        Pattern p = Pattern.compile("</?[^>]+>");
        Matcher m = p.matcher(sb);

        while (m.find()) {
            if (!m.group().startsWith("</")) {
                tags.push(m.start() + m.group().length());
            } else {
                System.out.println(sb.substring(tags.pop(), m.start()));
            }
        }
    }
}