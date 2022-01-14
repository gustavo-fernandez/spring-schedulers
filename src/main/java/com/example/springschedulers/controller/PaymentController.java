package com.example.springschedulers.controller;

import com.example.springschedulers.event.PaymentSuccessfulEvent;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

  private final ApplicationEventPublisher eventPublisher;

  @GetMapping("api/payment")
  public Mono<String> payment() {
    var customerId = 1_000;
    var paymentTime = LocalDateTime.now();
    var event = new PaymentSuccessfulEvent(this, paymentTime, customerId);
    return Mono.fromRunnable(() -> {
      log.info("Payment in controller");
      eventPublisher.publishEvent(event);
    })
      .then(Mono.just("Ok"));
  }

}
