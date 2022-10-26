package Server;

import ServerOperation.Message;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

import static Server.Server.getChannel;
import static SetOfCommands.CommandsPack.getMap;
import static SetOfCommands.CommandsPack.startCommand;

public class ServerRO { //Server Request Operator
    private static String response = "";
    private static SocketAddress clientAddress;

    public static void go() {

        //Открытие канала, который слушает на заданном адресе serverAdd
        try {
            getRequest();
            sendResponse();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            addResponse("Неверная команда. Введите 'help' для справки.");
            sendResponse();
        } catch (RuntimeException e3) {
            addResponse(e3.getMessage());
            sendResponse();
        } finally {
            ServerRO.go();
        }

    }

    public static void addResponse(String response1) {
        response = response + response1;
    }

    public static String getResponse() {
        return response;
    }

    public static void getRequest() throws IOException, ClassNotFoundException {
        /** Создание байтбуффера для приема запроса от клиента */
        ByteBuffer requestBuffer = ByteBuffer.allocate(4096);
        /** Получение датаграммы в байтбуффер и сохраняем адрес клиента в remoteAdd */
        clientAddress = getChannel().receive(requestBuffer);
        byte[] requestArr = requestBuffer.array();

        /** Создаем поток ввода для считывания запроса */
        ByteArrayInputStream bais = new ByteArrayInputStream(requestArr);
        ObjectInputStream ois = new ObjectInputStream(bais);

        Message requestObject = (Message) ois.readObject();
        String command = requestObject.getCommand();


        System.out.println(command + " received from client at: " + clientAddress);
        //response = command + " kakashka";
        if(getMap().containsKey(command))
        {
            response = startCommand(requestObject);
        } else throw new NullPointerException();
    }

    public static void sendResponse() {
        try {
            ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes());
            getChannel().send(responseBuffer, clientAddress);
            //кастомизация
            response = response.length() > 11 ? response.toCharArray()[0] == '\n' ? response.substring(1, 11) : response.substring(0, 11) : response;

            System.out.println("'" + response + "...'" + " sent to client at: " + clientAddress);
            response = "";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}