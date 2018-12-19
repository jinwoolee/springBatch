package org.iptime.iothome.batch;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.util.ClassUtils;

public class YogultItemReader extends AbstractItemCountingItemStreamItemReader<String>{

	private Logger logger = LoggerFactory.getLogger(YogultItemReader.class);
	
	private List<String> rangers;
	private int currentItemCount = 0;

	public YogultItemReader() {
		logger.debug("HelloItemReader consturctor " );
		setName(ClassUtils.getShortName(YogultItemReader.class));
	}
	
	@Override
	protected String doRead() throws Exception {
		logger.debug("HelloItemReader doRead, currentItemCount : {} ", currentItemCount);
		
		if(rangers.size() > currentItemCount)
			return rangers.get(currentItemCount++);
		else {
			currentItemCount = 0;
			return null;
		}
	}

	@Override
	protected void doOpen() throws Exception {
		
		logger.debug("HelloItemReader doOpen");
		
		rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("james");
		rangers.add("moon");
	}

	@Override
	protected void doClose() throws Exception {
		logger.debug("HelloItemReader doClose");
	}
}
