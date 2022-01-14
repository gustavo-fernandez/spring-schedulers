package com.example.springschedulers.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class QuartzSimpleJob implements Job {
  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    var triggerDesc = context.getTrigger().getDescription();
    log.info(">> QuartzSimpleJob.execute({}) | triggerDesc: {}", context, triggerDesc);
  }
}
