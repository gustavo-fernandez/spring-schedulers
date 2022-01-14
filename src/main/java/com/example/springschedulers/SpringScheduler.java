package com.example.springschedulers;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

// @Component
@Slf4j
public class SpringScheduler {

  // @Scheduled(fixedRate = 5, timeUnit = TimeUnit.SECONDS)
  @Scheduled(cron = "0/5 * * * * *")
  public void execute() {
    Mono.just("Hello Spring Scheduler!")
      .doOnNext(message -> log.info(">>> {}", message))
      .subscribe();
  }

}
