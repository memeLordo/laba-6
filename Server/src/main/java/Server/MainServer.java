package Server;

import SetOfCommands.CommandsPack;

public class MainServer {
    public static void main(String[] args) {
        CommandsPack.go();
        Server.go();
    }

}
