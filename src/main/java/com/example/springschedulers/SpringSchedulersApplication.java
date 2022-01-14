package com.example.springschedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class SpringSchedulersApplication {

  public static void main(String[] args) {
    var appContext = SpringApplication.run(SpringSchedulersApplication.class, args);
    log.info(appContext + "");
  }

  // @Bean
  ScheduledExecutorService scheduledExecutorService() {
    return Executors.newScheduledThreadPool(5);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationReadyEvent(ApplicationReadyEvent event) {
    log.info("onApplicationReadyEvent");
  }
}
