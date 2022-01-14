package com.example.springschedulers;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class JavaSimpleScheduler {

  private final ScheduledExecutorService scheduledExecutorService;

  @PostConstruct
  public void postConstruct() {
    log.info(">>> Starting down scheduledExecutorService");
    scheduledExecutorService.scheduleAtFixedRate(() -> log.info("process executed!"),
      5, 3, TimeUnit.SECONDS);
  }

  @PreDestroy
  public void preDestroy() {
    log.info(">>> Shutting down scheduledExecutorService");
    scheduledExecutorService.shutdown();
  }

}
