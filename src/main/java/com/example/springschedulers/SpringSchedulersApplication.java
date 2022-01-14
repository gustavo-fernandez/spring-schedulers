package com.example.springschedulers;

import com.example.springschedulers.job.QuartzSimpleJob;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

  @Bean
  JobDetail firstJob() {
    return JobBuilder
      .newJob()
      .ofType(QuartzSimpleJob.class)
      .withIdentity(QuartzSimpleJob.class.getName())
      .withDescription("Primer Job de Quartz")
      .storeDurably()
      .build();
  }

  @Bean
  Trigger trigger() {
    return TriggerBuilder.newTrigger()
      .withIdentity(QuartzSimpleJob.class.getName() + "_Trigger")
      .withDescription("Trigger para el primer Job")
      .forJob(firstJob())
      // .withSchedule(CronScheduleBuilder.cronSchedule(/*cron expression*/"))
      .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(3))
      .build();
  }

}
