package Server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.NoSuchElementException;

import static Server.Server.getChannel;
import static SetOfCommands.CommandsPack.getMap;
import static SetOfCommands.CommandsPack.mapFind;

public class ServerRO { //Server Request Operator
    private static String response="";
    private static SocketAddress clientAddress;

    public static void go() {

        //Открытие канала, который слушает на заданном адресе serverAdd
        try {
            getRequest(true);
            sendResponse();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        catch(NullPointerException e2){
            e2.printStackTrace();
            addResponse("Неверная команда. Введите 'help' для справки.");
            sendResponse();
        } catch (RuntimeException e3){
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

    public static String getRequest(boolean isCommand) throws IOException, ClassNotFoundException {
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
        if(isCommand) response = getMap().get(mapFind(request)).go();
        else response = request;
        return request;
    }

    public static void sendResponse() {
        try {
            ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes());
            getChannel().send(responseBuffer, clientAddress);
            //кастомизация
            response =response.length()>11? response.toCharArray()[0] == '\n' ? response.substring(1, 11) : response.substring(0, 11) : response;

            System.out.println("'" + response + "...'" + " sent to client at: " + clientAddress);
            response = "";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}