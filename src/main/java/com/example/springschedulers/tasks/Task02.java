package com.example.springschedulers.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Task02 implements Tasklet {
  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
    var jobParameters = chunkContext.getStepContext().getJobParameters();
    log.info(">>> Task02 executed! fireTime from quartz: {}", jobParameters.get("execution_time"));
    return RepeatStatus.FINISHED;
  }
}
