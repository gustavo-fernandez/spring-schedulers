package com.example.springschedulers;

import com.example.springschedulers.tasks.Task01;
import com.example.springschedulers.tasks.Task02;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

  @Bean
  Step step01(StepBuilderFactory stepBuilderFactory, Task01 task01) {
    return stepBuilderFactory
      .get("step01")
      .tasklet(task01)
      .build();
  }

  @Bean
  Step step02(StepBuilderFactory stepBuilderFactory, Task02 task02) {
    return stepBuilderFactory
      .get("step02")
      .tasklet(task02)
      .build();
  }

  @Bean
  Job job01(JobBuilderFactory jobBuilderFactory, Step step01, Step step02) {
    return jobBuilderFactory
      .get("job01")
      .start(step01)
      .next(step02)
      .build();

  }

}
