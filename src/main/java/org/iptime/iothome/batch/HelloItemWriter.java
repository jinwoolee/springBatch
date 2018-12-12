package org.iptime.iothome.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class HelloItemWriter implements ItemWriter<String>{
	private Logger logger = LoggerFactory.getLogger(HelloItemWriter.class);

	@Override
	public void write(List<? extends String> items) throws Exception {
		logger.debug("HelloItemWriter start ");
		for(String str : items)
			logger.debug("ranger : {} ", str);
		logger.debug("HelloItemWriter end ");
	}
}