package client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class Client {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String clientName = "localhost";
    private static final int clientPort = 4321;
    private static DatagramSocket ds;
    private static InetAddress serverAddress;
    private static String word;

    public static void main(String[] args) throws Exception {
        serverAddress = InetAddress.getByName(clientName);
        //Создание сокета для отправки команд
        ds = new DatagramSocket(clientPort);


        while (true) {
            processInput();
            sendRequest();
            getResponse();
        }
    }

    private static void processInput() {
        word = scanner.nextLine();
    }

    private static void sendRequest() throws IOException {

        //Создание потока вывода
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        baos.flush();
        oos.flush();

        //Запись пользовательского ввода в поток
        oos.writeObject(word);
        oos.flush();
        oos.close();
        byte[] requestArr = baos.toByteArray();


        //Упаковка запроса в датаграмму
        DatagramPacket dp = new DatagramPacket(requestArr, requestArr.length, serverAddress, 1234);
        //Отправка на сервер в порт 1234
        ds.send(dp);
        System.out.println(word + " sent to server at: " + serverAddress);

    }

    private static void getResponse() throws IOException {

        //Создание пакета для приема ответа от сервера
        byte[] responseArr = new byte[4096];
        DatagramPacket responsePacket = new DatagramPacket(responseArr, responseArr.length, serverAddress, 0);
        ds.receive(responsePacket);

        //Распаковка полученного ответа от сервера из датаграммы
        String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
        System.out.println("Received from server: " + response);

    }

}