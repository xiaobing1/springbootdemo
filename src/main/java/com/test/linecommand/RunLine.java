package com.test.linecommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 * @author xiaobin.wang
 * @date 2018/3/15
 */
public class RunLine implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(RunLine.class);

    public void run(String... strings) throws Exception {
        logger.info("hello world");
    }
}
