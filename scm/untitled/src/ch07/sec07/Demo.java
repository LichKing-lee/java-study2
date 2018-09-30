package ch07.sec07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class Demo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/user/programming/private-workspace/java10-start/text");
/*
        try(Stream<String> stringStream = Files.lines(path)) {
            Map<String, Long> map = stringStream.flatMap(line -> Stream.of(line.split(" ")))
                    .collect(groupingBy(Function.identity(), counting()));

            Map<String, Long> treeMap = new TreeMap<>(map);
            System.out.println(treeMap);
        }
*/
    }
}
