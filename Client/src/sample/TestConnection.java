package sample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);

            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(osw);

            writer.write("Hello server!\n");
            writer.flush();

            writer.close();
            socket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
