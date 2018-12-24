package org.iptime.iothome.batch;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class HelloItemReader implements ItemReader<String>{

	private Logger logger = LoggerFactory.getLogger(HelloItemReader.class);
	
	private List<String> rangers;
	private int currentItemCount = 0;

	public HelloItemReader() {
		logger.debug("HelloItemReader consturctor " );

		rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("james");
		rangers.add("moon");
	}

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		logger.debug("read currentItemCount : {} ", currentItemCount);
		if(rangers.size() > currentItemCount)
			return rangers.get(currentItemCount++);
		else {
			currentItemCount = 0;
			return null;
		}
	}
}
