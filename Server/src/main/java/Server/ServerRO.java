package Server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

import static Server.Server.getChannel;
import static SetOfCommands.CommandsPack.getMap;
import static SetOfCommands.CommandsPack.mapFind;

public class ServerRO { //Server Request Operator
    private static String response;
    private static SocketAddress clientAddress;

    public static void go() {

        //Открытие канала, который слушает на заданном адресе serverAdd
        try {
            getRequest();
            sendResponse();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            ServerRO.go();
        }

    }

    public static void addResponse(String response1) {
        ServerRO.response = response + response1;
    }

    public static String getResponse() {
        return response;
    }

    private static void getRequest() throws IOException, ClassNotFoundException {

        //Создание байтбуффера для приема запроса от клиента
        ByteBuffer requestBuffer = ByteBuffer.allocate(4096);

        //Получение датаграммы в байтбуффер и сохраняем адрес клиента в remoteAdd
        clientAddress = getChannel().receive(requestBuffer);
        byte[] requestArr = requestBuffer.array();

        //Создаем поток ввода для считывания запроса
        ByteArrayInputStream bais = new ByteArrayInputStream(requestArr);
        ObjectInputStream ois = new ObjectInputStream(bais);


        String request = (String) ois.readObject();


        System.out.println(request + " received from client at: " + clientAddress);
        //response = request + " kakashka";
        response = getMap().get(mapFind(request)).go();

    }

    public static void sendResponse() throws IOException {
        ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes());
        getChannel().send(responseBuffer, clientAddress);
        System.out.println("'" + response + "'" + " sent to client at: " + clientAddress);
        response = null;
    }


}