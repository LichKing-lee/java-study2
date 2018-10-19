package ch09.sec01;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// http://en.wikipedia.org/wiki/BMP_file_format 참고

public class BinaryIO {
    public static void main(String[] args) throws IOException {

//        try {
//            ////////////////////////////////////////////////////////////////
//            BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
//            String s = "출력 파일에 저장될 이런 저런 문자열입니다.";
//
//            out.write(s); out.newLine();
//            out.write(s); out.newLine();
//
//            out.close();
//            ////////////////////////////////////////////////////////////////
//        } catch (IOException e) {
//            System.err.println(e); // 에러가 있다면 메시지 출력
//            System.exit(1);
//        }


        // chart.bmp파일을 Path객체를 얻어와서
        // newInputStream으로 Stream을 생성한다.
        // DataInputStream으로 객체를 얻어와서 in에 할당하여
        // in객체로 readFully(), readInt(), readShort()를 사용하여 값을 읽는다.

        // swap()은 Big-endian과 Little-endian을 전환한다.

        Path path = Paths.get("chart.bmp");
        try (InputStream inStream = Files.newInputStream(path)) {            
            DataInput in = new DataInputStream(inStream);
            byte[] header = new byte[2];
            in.readFully(header);   // stream으로부터 buffer크기만큼 바이트를 읽어 저장한다. (여기서는 2바이트)
            int size = swap(in.readInt());  // 파일사이즈 4바이트를 읽는다.
            in.readInt();
            in.readInt();
            int headerSize = swap(in.readInt());    // header size (4byte)
            int width = swap(in.readInt());         // width
            int height = swap(in.readInt());        // height
            short planes = swap(in.readShort());    // color plane
            short depth = swap(in.readShort());     // bit per pixel
            int compressionMode = swap(in.readInt());   // 압축유무
            System.out.println("Header: " + new String(header, StandardCharsets.US_ASCII));
            System.out.println("Size: " + size);
            System.out.println("Header size : " + headerSize);
            System.out.println("Width : " + width);
            System.out.println("Height : " + height);
            System.out.println("Planes : " + planes);
            System.out.println("Depth : " + depth);
            System.out.println("Compression mode : " + compressionMode);
        }

    }
    
    public static int swap(int n) {
        return (n & 0xFF000000) >> 24 | (n & 0xFF0000) >> 8 | (n & 0xFF00) << 8 | (n & 0xFF) << 24; 
    }

    public static short swap(short n) {
        return (short) ((n & 0xFF00) >> 8 | (n & 0xFF) << 8); 
    }

}
