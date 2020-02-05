package project;

import java.io.*;
import java.nio.file.Paths;

public class BMLProducer {
    public static void main(String[] args) {
        new BMLProducer().readFile();
    }

    private void readFile() {
        File pnml = Paths.get("/Users/xiezhenyu/Desktop/Ñ¹Ëõ°ü/¸½¼þ1","Model1.pnml").toFile();
        try(InputStream  is = new FileInputStream(pnml)){
            byte[] bytes = new byte[1024];
            int byteRead;
            if(pnml.isFile() && pnml.exists()) {
                StringBuilder sb = new StringBuilder();
                while((byteRead = is.read(bytes))!=-1) {
                    String string = new String(bytes,0,byteRead);
                    sb.append(string);
                }
                System.out.println(sb.toString());
            }
        } catch (IOException e) {

        }
    }
}
