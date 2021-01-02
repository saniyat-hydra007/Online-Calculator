package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class Controller {
    @FXML
    TextField inputA;
    @FXML
    TextField inputB;
    @FXML
    TextArea resultTA;

    BufferedReader reader;
    BufferedWriter writer;

    public Controller() {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addFunction() {
        String a = inputA.getText();
        String b = inputB.getText();

        try {
            Double.parseDouble(a);
            Double.parseDouble(b);

            writer.write("add\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.flush();

            String res = reader.readLine();
            resultTA.setText(res);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @FXML
    void subFunction() {
        String a = inputA.getText();
        String b = inputB.getText();

        try {
            Double.parseDouble(a);
            Double.parseDouble(b);

            writer.write("sub\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.flush();

            String res = reader.readLine();
            resultTA.setText(res);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }

    @FXML
    void multFunction() {
        String a = inputA.getText();
        String b = inputB.getText();

        try {
            Double.parseDouble(a);
            Double.parseDouble(b);

            writer.write("mult\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.flush();

            String res = reader.readLine();
            resultTA.setText(res);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }

    @FXML
    void divFunction() {
        String a = inputA.getText();
        String b = inputB.getText();

        try {
            Double.parseDouble(a);
            Double.parseDouble(b);

            writer.write("div\n");

            writer.write(a);
            writer.newLine();

            writer.write(b);
            writer.newLine();

            writer.flush();

            String res = reader.readLine();
            resultTA.setText(res);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }

    @FXML
    void HistoryFunction() {
        try {

            writer.write("history\n");
            writer.flush();

            String line;
            resultTA.setText(" ");
            while ((line = reader.readLine()) != null) {
                if (line.equals("<eof>")) break;
                resultTA.appendText(line + "\n");
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}