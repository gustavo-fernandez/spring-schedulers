package com.example.springschedulers.job;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpringBatchQuartzScheduler extends QuartzJobBean {

  private final JobLauncher jobLauncher;
  private final Job job01;

  @SneakyThrows
  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    var fireTime = context.getFireTime().toString();
    var jobParameters = new JobParametersBuilder()
      .addString("execution_time", fireTime)
      .toJobParameters();
    jobLauncher.run(job01, jobParameters);
  }
}
