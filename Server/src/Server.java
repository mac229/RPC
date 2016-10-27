import com.googlecode.jsonrpc4j.JsonRpcServer;
import org.apache.log4j.BasicConfigurator;

/**
 * Created by maciej on 27.10.16.
 */
public class Server {

    public static void main(String[] args) {
        System.out.println("Server");
        BasicConfigurator.configure();

        JsonRpcServer jsonRpcServer;

        User user = new User();
    }
}
