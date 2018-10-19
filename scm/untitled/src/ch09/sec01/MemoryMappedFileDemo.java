package ch09.sec01;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// http://en.wikipedia.org/wiki/BMP_file_format 참고

public class MemoryMappedFileDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("chart.bmp");
        // FileChannel객체를 사용한다.
        try (FileChannel channel = FileChannel.open(path,
                StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            // 파일의 한 영역을 맵핑한다. (File이 크지 않을경우 전체영역을 맵핑한다.)
            ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE,
                    0, channel.size());
            // 바이트오더방식을 Little Endian으로 변경한다. (Default는 Big Endian)
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            // getInt()를 사용하여, 값을 읽어오는데 index 값을 사용하여 임의의 위치에서 값을 읽어올수있다.
            int size = buffer.getInt(2);
            int headerSize = buffer.getInt(14);
            int width = buffer.getInt(18);
            int height = buffer.getInt(22);
            short planes = buffer.getShort(26);
            short depth = buffer.getShort(28);
            int compressionMode = buffer.getInt(30);;
            System.out.println("Size: " + size);
            System.out.println("Header size : " + headerSize);
            System.out.println("Width : " + width);
            System.out.println("Height : " + height);
            System.out.println("Planes : " + planes);
            System.out.println("Depth : " + depth);
            System.out.println("Compression mode : " + compressionMode);
            
        }
    }
}
