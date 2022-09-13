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
            channel.bind(serverAdd);
            channel = DatagramChannel.open();
            ServerRO.go();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ServerRO.go();
        }


    }

    public static DatagramChannel getChannel() {
        return channel;
    }


}
