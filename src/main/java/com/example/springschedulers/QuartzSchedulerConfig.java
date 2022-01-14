package com.example.springschedulers;

import com.example.springschedulers.job.SpringBatchQuartzScheduler;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzSchedulerConfig {

  @Bean
  JobDetail firstJob() {
    return JobBuilder
      .newJob()
      .ofType(SpringBatchQuartzScheduler.class)
      .withIdentity(SpringBatchQuartzScheduler.class.getName())
      .withDescription("Job de Quartz que ejecuta Job Spring Batch")
      .storeDurably()
      .build();
  }

  @Bean
  Trigger trigger() {
    return TriggerBuilder.newTrigger()
      .withIdentity(SpringBatchQuartzScheduler.class.getName() + "_Trigger")
      .withDescription("Trigger para el primer Job de Spring Batch")
      .forJob(firstJob())
      // .withSchedule(CronScheduleBuilder.cronSchedule(/*cron expression*/"))
      .withSchedule(SimpleScheduleBuilder.simpleSchedule()
        .withIntervalInSeconds(3) // cada 3 segundos
        .withRepeatCount(3)) // repetir 3 veces
      .build();
  }


}
