package http;

import com.sun.net.httpserver.HttpServer;
import http.handler.ServiceHandler;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerHttp {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(1234), 0);
            ServiceHandler handler = new ServiceHandler();
            httpServer.createContext("/rpc", handler);
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
