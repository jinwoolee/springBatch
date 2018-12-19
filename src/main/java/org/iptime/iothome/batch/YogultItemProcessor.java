package org.iptime.iothome.batch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.iptime.iothome.batch.model.CycleVo;
import org.iptime.iothome.batch.model.DailyVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class YogultItemProcessor implements ItemProcessor<CycleVo, List<DailyVo>>{
	
	private Logger logger = LoggerFactory.getLogger(YogultItemProcessor.class);
	 
	@Override
	public List<DailyVo> process(CycleVo cycleVo) throws Exception {
		
		logger.debug("itemProcessor process : {}", cycleVo);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2018);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date endDate = calendar.getTime();
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		List<DailyVo> dailyVoList = new ArrayList<DailyVo>();
		
		while(endDate.getTime() >= calendar.getTimeInMillis() ) {
			
			if(cycleVo.getDay().equals(calendar.get(Calendar.DAY_OF_WEEK))) {
				DailyVo dailyVo = new DailyVo();
				dailyVo.setCid(cycleVo.getCid());
				dailyVo.setPid(cycleVo.getPid());
				dailyVo.setCnt(cycleVo.getCnt());
				dailyVo.setDt(sdf.format(calendar.getTime()));
				dailyVoList.add(dailyVo);
				
				logger.debug(sdf.format(calendar.getTime()));
			}
			
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) +1);
		}
		
		return dailyVoList;
	}
}
