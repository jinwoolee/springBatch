package org.iptime.iothome.batch;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class HelloItemReader implements ItemReader<List<String>>{
	private Logger logger = LoggerFactory.getLogger(HelloItemReader.class);

	@Override
	public List<String> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		logger.debug("HelloItemReader readItem");
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("james");
		rangers.add("moon");
		return rangers;
	}
}
