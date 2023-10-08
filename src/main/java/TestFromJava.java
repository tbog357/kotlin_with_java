import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.logging.SLF4JLogDelegateFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// local import
import com.test.Test;

public class TestFromJava {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloVerticle.class);

  public static void main(String[] args) {

    String logFactory = System.getProperty("org.vertx.logger-delegate-factory-class-name");
    if (logFactory == null) {
      System.setProperty("org.vertx.logger-delegate-factory-class-name", SLF4JLogDelegateFactory.class.getName());
    }
    Test.main(args);

    Vertx vertx = Vertx.vertx();
    HelloVerticle helloVerticle = new HelloVerticle();
    vertx.deployVerticle(helloVerticle, new Handler<AsyncResult<String>>() {
      public void handle(AsyncResult<String> asyncResult) {
        LOGGER.info("Running");
        if (asyncResult.succeeded()) {
          LOGGER.info("Deployed succeed");
          String deploymentId = helloVerticle.deploymentID();
          vertx.undeploy(deploymentId);
        } else {
          
        }
      }
    });
    HttpServer httpServer = new HttpServer();
    vertx.deployVerticle(httpServer);
    // String deploymentId = helloVerticle.deploymentID();
    // System.out.println(deploymentId);
    // vertx.undeploy(deploymentId);

  }
}
