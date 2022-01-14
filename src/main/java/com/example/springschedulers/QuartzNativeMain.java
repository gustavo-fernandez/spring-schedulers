package com.example.springschedulers;

import com.example.springschedulers.job.QuartzSimpleJob;
import org.quartz.JobBuilder;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzNativeMain {

  public static void main(String[] args) throws Exception {
    Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

    var jobDetail = JobBuilder
      .newJob()
      .ofType(QuartzSimpleJob.class)
      .withIdentity(QuartzSimpleJob.class.getName())
      .withDescription("Primer Job de Quartz")
      .storeDurably()
      .build();

    var trigger = TriggerBuilder.newTrigger()
      .withIdentity(QuartzSimpleJob.class.getName() + "_Trigger")
      .withDescription("Trigger para el primer Job")
      .forJob(jobDetail)
      .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(3))
      .build();

    defaultScheduler.scheduleJob(jobDetail, trigger);

    defaultScheduler.start();

    // defaultScheduler.shutdown();
  }

}
