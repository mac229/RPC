package http.handler;

import com.googlecode.jsonrpc4j.JsonRpcServer;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import http.service.IEchoInterface;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;


public class ServiceHandler implements com.sun.net.httpserver.HttpHandler {

    private IEchoInterface echoService;
    private JsonRpcServer jsonRpcServer;

    public ServiceHandler(){
        super();
        this.jsonRpcServer = new JsonRpcServer(this.echoService);
    }

    @Override
    public void handle(HttpExchange exchange) {
        System.out.println("Handle");
        if (exchange.getRequestMethod().equals("POST")) {
            OutputStream os = null;
            try {
                Headers responseHeaders = exchange.getResponseHeaders();
                responseHeaders.set("Content-Type", "application/json");
                os = exchange.getResponseBody();
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                jsonRpcServer.handleRequest(exchange.getRequestBody(), os);
                exchange.getRequestBody().close();
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                close(os);
            }
        }
    }

    private void close(Closeable stream){
        if (stream != null)
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
