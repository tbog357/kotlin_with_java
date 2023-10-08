
import io.vertx.core.AbstractVerticle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpServer extends AbstractVerticle {

  private static final Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

  @Override
  public void start() {
    LOGGER.info("Starting server at port", config().getInteger("http.port", 9090));
    vertx.createHttpServer()
        .requestHandler(r -> {
          r.response().end("Welcom to Vert.x Intro");
        })
        .listen(config().getInteger("http.port", 9090),
            result -> {
              if (result.succeeded()) {
                LOGGER.info("not gg");
              } else {
                LOGGER.info("gg");
              }
            });
  }

}
