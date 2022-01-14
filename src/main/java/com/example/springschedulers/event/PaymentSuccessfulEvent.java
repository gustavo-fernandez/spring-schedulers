package com.example.springschedulers.event;

import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PaymentSuccessfulEvent extends ApplicationEvent {

  private final LocalDateTime paymentTime;
  private final int customerId;

  public PaymentSuccessfulEvent(Object source, LocalDateTime paymentTime, int customerId) {
    super(source);
    this.paymentTime = paymentTime;
    this.customerId = customerId;
  }
}
