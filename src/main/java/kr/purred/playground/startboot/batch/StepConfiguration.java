package kr.purred.playground.startboot.batch;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfiguration
{
	private static final String STEP_NAME = "stepName";

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step step ()
	{
		return stepBuilderFactory.get (STEP_NAME)
			.tasklet (myWork ())
			.build ();
	}

	@Bean
	public Tasklet myWork ()
	{
		return (contribution, chunkContext) -> {
			System.out.println ("TEST!!!");
			return RepeatStatus.FINISHED;
		};
	}

}
