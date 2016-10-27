import com.googlecode.jsonrpc4j.StreamServer;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

/**
 * Created by maciej on 27.10.16.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Server");
        BasicConfigurator.configure();

        StreamServer streamServer = null;
        // TODO implement server

        onFinish(streamServer);
    }

    private static void onFinish(StreamServer streamServer) throws IOException {
        int ignored = System.in.read();
        try {
            if (streamServer != null) {
                streamServer.stop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
