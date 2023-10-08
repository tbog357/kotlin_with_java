package com.test
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
class Test {
  
  companion object {
    private val logger = LoggerFactory.getLogger(Test::class.java);
    @JvmStatic
    fun main(args: Array<String>) {
      logger.info("test")
    }
  }
}
