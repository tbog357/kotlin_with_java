import io.vertx.core.AbstractVerticle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloVerticle.class);
  // private static final Logger LOGGER =
  // LogManager.getLogger(HelloVerticle.class);

  @Override
  public void start() {
    LOGGER.info("Welcome to Vertx");
  }

  @Override
  public void stop() {
    LOGGER.info("Shutting down application");
  }
}
