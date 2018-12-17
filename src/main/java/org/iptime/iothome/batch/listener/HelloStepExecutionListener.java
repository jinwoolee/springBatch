package org.iptime.iothome.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class HelloStepExecutionListener implements StepExecutionListener{
	
	private Logger logger = LoggerFactory.getLogger(HelloStepExecutionListener.class);

	@Override
	public void beforeStep(StepExecution stepExecution) {
		logger.debug("before stepName : {} ", stepExecution.getStepName() );
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		logger.debug("after stepName : {} ", stepExecution.getStepName() );
		return null;
	}

}
