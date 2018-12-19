package org.iptime.iothome.batch;

import java.util.List;

import org.iptime.iothome.batch.model.CycleVo;
import org.iptime.iothome.batch.model.DailyVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class YogultItemWriter implements ItemWriter<List<DailyVo>>{
	private Logger logger = LoggerFactory.getLogger(YogultItemWriter.class);

	@Override
	public void write(List<? extends List<DailyVo>> items) throws Exception {
		logger.debug("HelloItemWriter start ");
		for(List<DailyVo> list : items) {
			for(DailyVo dailyVo : list)
				logger.debug("dailyVo : {} ", dailyVo);
		}
		logger.debug("HelloItemWriter end ");
	}
}