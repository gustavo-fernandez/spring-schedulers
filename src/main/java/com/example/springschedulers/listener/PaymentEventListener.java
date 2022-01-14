package com.example.springschedulers.listener;

import com.example.springschedulers.event.PaymentSuccessfulEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentEventListener implements ApplicationListener<PaymentSuccessfulEvent> {
  @Override
  public void onApplicationEvent(PaymentSuccessfulEvent event) {
    log.info("Payment successful received: {} | {}", event.getPaymentTime(), event.getCustomerId());
  }
}
