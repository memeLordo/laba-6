package Server;

import java.nio.channels.DatagramChannel;
import java.net.InetSocketAddress;




public class Server {

    private static final String serverName = "localhost";
    private static final int serverPort = 1234;
    private static final InetSocketAddress serverAdd = new InetSocketAddress(serverName, serverPort);
    private static DatagramChannel channel;


    public static void go() {

        try {
            channel = DatagramChannel.open();
            channel.bind(serverAdd);
            ServerRO.go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DatagramChannel getChannel() {
        return channel;
    }

}
