package org.iptime.iothome.batch;

import java.text.SimpleDateFormat;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] {"classpath:/org/iptime/iothome/config/spring/context.xml",
								  "classpath:/org/iptime/iothome/config/spring/batch-context.xml"});
		
		JobLauncher launcher = context.getBean("jobLauncher", JobLauncher.class);
		Job yogultMotnhlyCycleJob = context.getBean("yogultMotnhlyCycleJob", Job.class);
		
		try {
			//launcher.run(yogultMotnhlyCycleJob, new JobParameters());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
			
			launcher.run(yogultMotnhlyCycleJob, 
					new JobParametersBuilder().addParameter("ym", new JobParameter(sdf.format(System.currentTimeMillis())))
											  .addLong("st_dt", System.currentTimeMillis()).toJobParameters());
		
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
			e.printStackTrace();
		}
		
		context.close();
	}
}
