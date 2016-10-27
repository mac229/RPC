import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

/**
 * Created by maciej on 27.10.16.
 */
public class Client {


    public static void main(String[] args) throws IOException {
        System.out.println("Client");
        BasicConfigurator.configure();

        // TODO implement client

        onFinished();
    }

    private static void onFinished() throws IOException {
        int igonred = System.in.read();
    }
}