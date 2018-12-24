package org.iptime.iothome.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

public class SpringBatchScheduler {
private Logger logger = LoggerFactory.getLogger(SpringBatchScheduler.class);
	
	@Autowired
	private JobLauncher launcher;
	
	@Autowired
	@Qualifier("helloWorldJob")
	private Job helloWorldJob;
	
	@Scheduled( cron="*/5 * * * * *")
	public void run() {
		
		logger.debug("=====================SpringBatchScheduler run=====================");
				
		try {
			launcher.run(helloWorldJob, new JobParameters());
		
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
