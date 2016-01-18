package com.maxleap.maxpaytest;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

/**
 * Created by SidneyXu on 2016/01/04.
 */
public class HookService {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();

        Router rootRouter = Router.router(vertx);
        rootRouter.route("/pay").handler(routingContext -> {
            HttpServerRequest request = routingContext.request();
            request.bodyHandler(buffer -> {
                System.out.println(buffer.getString(0, buffer.length()));
            });

            HttpServerResponse response = routingContext.response();
            response.setStatusCode(400);
            response.putHeader("content-type", "text/plain");
            response.end("Hello World from Vert.x-Web!");
        });

        server.requestHandler(rootRouter::accept);
        server.listen(1234);
    }
}
