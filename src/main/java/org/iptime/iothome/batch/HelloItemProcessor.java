package org.iptime.iothome.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class HelloItemProcessor implements ItemProcessor<String, String>{
	
	private Logger logger = LoggerFactory.getLogger(HelloItemProcessor.class);
	 
	@Override
	public String process(String ranger) throws Exception {
		logger.debug("HelloItemProcessor start ");
		
		logger.debug("before : {} ", ranger);
		ranger += "_modified";
		logger.debug("after : {} ", ranger);
		logger.debug("HelloItemProcessor end ");
		
		return ranger;
	}
}
