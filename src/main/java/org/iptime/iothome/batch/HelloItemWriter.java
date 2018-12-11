package org.iptime.iothome.batch;

import java.util.List;

import org.iptime.iothome.batch.model.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class HelloItemWriter implements ItemWriter<Report>{
	private Logger logger = LoggerFactory.getLogger(HelloItemWriter.class);

	@Override
	public void write(List<? extends Report> items) throws Exception {
		logger.debug("HelloItemWriter start ");
		for(Report report : items)
			logger.debug("report : {} ", report);
		logger.debug("HelloItemWriter end ");
	}

	

}