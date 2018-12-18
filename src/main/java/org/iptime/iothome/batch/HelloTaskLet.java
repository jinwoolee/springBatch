package org.iptime.iothome.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloTaskLet implements Tasklet{
	
	private Logger logger = LoggerFactory.getLogger(HelloTaskLet.class);

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		logger.debug("helloTasklet execute : ");
		
		return RepeatStatus.FINISHED;
	}

}
