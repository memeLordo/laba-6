package server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Server {

    private static final String serverName = "localhost";
    private static final int serverPort = 1234;
    private static DatagramChannel channel;
    private static SocketAddress clientAddress;
    private static final InetSocketAddress serverAdd = new InetSocketAddress(serverName, serverPort);
    private static String response;
    private static String request;


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Открытие канала, который слушает на заданном адресе serverAdd
        channel = DatagramChannel.open();
        channel.bind(serverAdd);

        while (true) {
            getRequest();
            sendResponse();
        }
    }

    private static void getRequest() throws IOException, ClassNotFoundException {

        //Создание байтбуффера для приема запроса от клиента
        ByteBuffer requestBuffer = ByteBuffer.allocate(4096);

        //Получение датаграммы в байтбуффер и сохраняем адрес клиента в remoteAdd
        clientAddress = channel.receive(requestBuffer);
        byte[] requestArr = requestBuffer.array();

        //Создаем поток ввода для считывания запроса
        ByteArrayInputStream bais = new ByteArrayInputStream(requestArr);
        ObjectInputStream ois = new ObjectInputStream(bais);

        request = (String) ois.readObject();
        System.out.println(request + " received from client at: " + clientAddress);
        response = request + " kakashka";
    }

    private static void sendResponse() throws IOException {
        ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes());
        channel.send(responseBuffer, clientAddress);
        System.out.println("'" + response + "'" + " sent to client at: " + clientAddress);
    }

}