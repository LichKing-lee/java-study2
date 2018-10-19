package ch09.sec02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        Path tempPath = Files.createTempDirectory("corejava");

        // work폴더 생성
        Path workDir = Files.createDirectory(tempPath.resolve("work"));
        System.out.println(workDir);
        // test...txt파일생성
        Path tempFile = Files.createTempFile(workDir, "test", ".txt");
        System.out.println(tempFile);
        Files.write(tempFile, "Hello".getBytes(StandardCharsets.UTF_8));
        Files.copy(tempFile, workDir.resolve("hello.txt"));

        // hello2.txt파일을 move하고 삭제한다.
        Path target2 = workDir.resolve("hello2.txt");
        Files.move(tempFile, target2, StandardCopyOption.ATOMIC_MOVE);
        boolean deleted = Files.deleteIfExists(target2);
        if (deleted) System.out.println("Deleted " + target2);
    }
}
