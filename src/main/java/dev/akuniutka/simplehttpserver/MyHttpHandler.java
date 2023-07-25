package dev.akuniutka.simplehttpserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

public class MyHttpHandler implements HttpHandler {
    private static final Logger LOGGER = Logger.getLogger(MyHttpHandler.class.getName());

    public void handle(HttpExchange httpExchange) throws IOException {
        handleRequest(httpExchange);
        LOGGER.info("handleOtherRequest finished");
    }

    private void handleRequest(HttpExchange httpExchange) throws IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        String htmlResponse = "<html>\n" +
                "<body>\n" +
                "<h1>\n" +
                "Method: " + httpExchange.getRequestMethod() +
                " on url: " + httpExchange.getRequestURI() + "\n" +
                "</h1>\n" +
                "</body>\n" +
                "</html>\n";
        httpExchange.sendResponseHeaders(200, htmlResponse.length());
        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
