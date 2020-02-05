package mutiThread.threadpool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>();
    static String basePath;
    static ServerSocket serverSocket;

    static int port = 8080;

    public static void setPort(int port) {
        if (port > 0) {
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath) {
        if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
            SimpleHttpServer.basePath = basePath;
        }
    }

    //start http server
    public static void start() throws Exception{
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }

    static class HttpRequestHandler implements Runnable {
        private Socket socket;
        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            PrintWriter out = null;
            BufferedReader bufferedReader = null;
            InputStream in = null;
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                //由相对路径计算出绝对路径
                out = new PrintWriter(socket.getOutputStream());
                String filePath = basePath + header.split(" ")[1];
                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                    in = new FileInputStream(filePath);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = in.read()) != -1) {
                        byteArrayOutputStream.write(i);
                    }
                    byte[] array = byteArrayOutputStream.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length: " + array.length);
                    out.println("");
                    socket.getOutputStream().write(array, 0, array.length);
                } else {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    String line;
                    while ((line = bufferedReader.readLine())!=null) {
                        out.println(line);
                    }
                }
                out.flush();
            } catch (Exception e) {
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            } finally {
                close(bufferedReader, in, reader, out, socket);
            }
        }

        private static void close(Closeable... closeables) {
            if (closeables != null) {
                for (Closeable closeable : closeables) {
                    if (closeable!=null) {
                        try {
                            closeable.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }
}
