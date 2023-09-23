import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.io.InputStreamReader;
    public class HttpRequestServer {
        static int portNumber = 2306;
        public void serverRequest() throws IOException {

            try(ServerSocket serverSocket = new ServerSocket(portNumber)) {
                System.out.println("Server running on port " + portNumber);
                while (true) {
                    
                    // create a client server that helps the server listen for connection from another client server
                    try (Socket socket = serverSocket.accept()) {
                        // Read input from the client server
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                        // get the line of request from the client server
                        String requestLine = reader.readLine();

                        // get the path-type/endpoint and request method from the beginning of the request line
                        String endpoint = requestLine.split(" ")[1];
                        String requestMethod = requestLine.split(" ")[0];
                        System.out.println(requestLine);
                        Thread thread = new Thread(() -> {
                            if (Objects.equals(requestMethod, "GET") && Objects.equals(endpoint, "/")) {
                                try {
                                    socket.getOutputStream()
                                            .write(("HTTP/1.1 200 OK" + "\r\n\r\n" + "<html>"+
                                                    "<h1>"+
                                                    "Arsenal FC"+
                                                    "</h1>"+
                                                    "<main>" +
                                                    "<h2>"+
                                                    "Team Photo" +
                                                    "</h2>" +
                                                    "<img alt='"+
                                                    "Picture of Saka '" +
                                                    "src='" +
                                                    "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Saka_1510x850_0.jpg?auto=webp&itok=yZpptHcr'>"
                                                    +"</main>"+
                                                    "</html>")
                                                    .getBytes());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else if (Objects.equals(requestMethod, "GET") && Objects.equals(endpoint, "/json")) {
                                try {
                                    String jsonData = "{\"name\":\"Bukayo Saka\",\"age\":22,\"city\":\"London\"}";
                                    String header = "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\n\r\n";
                                    socket.getOutputStream().write(header.getBytes());
                                    socket.getOutputStream()
                                            .write((jsonData).getBytes());

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                try {
                                    String header = "HTTP/1.1" + "\r\n\r\n" + "<html>" +
                                            "<h1>"+
                                            "Error 404"+
                                            "</h1>";
                                    socket.getOutputStream().write(header.getBytes());
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });

                        thread.start();
                        thread.join();

                    } catch(IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        }

        public static void main(String[] args) {

        }
}
