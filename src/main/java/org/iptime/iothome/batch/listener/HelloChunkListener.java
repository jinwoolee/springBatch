package org.iptime.iothome.batch.listener;

import org.iptime.iothome.batch.YogultItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class HelloChunkListener implements ChunkListener{
	
	private Logger logger = LoggerFactory.getLogger(HelloChunkListener.class);
	
	@Override
	public void beforeChunk(ChunkContext context) {
		logger.debug("before Chunk");
	}

	@Override
	public void afterChunk(ChunkContext context) {
		logger.debug("after Chunk");
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		logger.debug("after Chunk Error");
	}

}
