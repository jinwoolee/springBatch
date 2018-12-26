package org.iptime.iothome.batch;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/org/iptime/iothome/config/spring/context.xml",
                                  "classpath:/org/iptime/iothome/config/spring/batch-context.xml",
                                  "classpath:/org/iptime/iothome/config/spring/batch-test-context.xml"})
public class HelloWorldJobTest {

	private Logger logger = LoggerFactory.getLogger(HelloWorldJobTest.class);

	@Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Test
	public void testHelloWorldJob() throws Exception {
		/***given***/
		
		/***when***/
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		
		/***then***/
		assertEquals(new ExitStatus("COMPLETED"), jobExecution.getExitStatus());
	}


}
