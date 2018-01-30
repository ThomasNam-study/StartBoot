package kr.purred.playground.startboot.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * EnableBatchProcessing : Job 생성에 필요한 핀들을 자동으로 가져온다.
 */
@Configuration
@EnableBatchProcessing
public class JobConfiguration
{
	private static final String JOB_NAME = "jobName";

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	/**
	 * Step 파일을 따로 만들경우, 해당 Step 이름으로 자동 주입시키면 되고, 아니면 Job 설정 파일에 Step 빈을 같이 설정해도 무관하다.
	 */
	@Autowired
	private Step stepName;

	@Bean public Job job()
	{
		return jobBuilderFactory.get (JOB_NAME)
			.start (stepName)
			.build ();
	}
}
