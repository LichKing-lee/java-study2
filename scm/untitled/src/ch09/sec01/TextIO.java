package ch09.sec01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class TextIO {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("alice.txt");
        // alice.txt의 모든 Data를 읽어서 content에 저장한다.
        String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        System.out.println("Characters: " + content.length());
        // alice.txt의 모든 Line을 읽어서 List<String>에 저장한다.
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println("Lines: " + lines.size());
        // 각 Line의 평균길이를 구한다.
        try (Stream<String> lineStream = Files.lines(path, StandardCharsets.UTF_8)) {
            System.out.println("Average line length: " + lineStream.mapToInt(String::length).average().orElse(0));
        }
        // 워드의 숫자를 구한다.
        try (Scanner in = new Scanner(path, "UTF-8")) {
            // 정규식 \pL : 문자를 가져온다. \PL : 문자가 아닌것만 가져온다.
            // 해당 정규식을 사용하여 , 단어를 분리한다. (' : 이것도 분리함)
            in.useDelimiter("\\PL+");
            int words = 0;
            while (in.hasNext()) {
                in.next();
                words++;
            }
            System.out.println("Words: " + words);
        }
        
        // index.html문서안의 라인의 평균길이를 구한다.
        URL url = new URL("http://horstmann.com/index.html");
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(url.openStream()))) {
            Stream<String> lineStream = reader.lines();
            System.out.println("Average line length: " + lineStream.mapToInt(String::length).average().orElse(0));
        }

        // Hello.txt에 "Hello World"를 저장한다.
        path = Paths.get("hello.txt");
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))) {
            out.println("Hello");
        }
        content = "World\n";
        Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        // alice.txt를 읽은 lines을 copyOfAlice.txt에 저장한다. (alice.txt ==> copyOfAlice.txt에 복사한다.)
        path = Paths.get("copyOfAlice.txt");
        Files.write(path, lines, StandardCharsets.UTF_8);

        // ???????
        StringWriter writer = new StringWriter();
        Throwable throwable = new IllegalStateException();
        throwable.printStackTrace(new PrintWriter(writer));
        String stackTrace = writer.toString();
        System.out.println("Stack trace: " + stackTrace);
    }
}
