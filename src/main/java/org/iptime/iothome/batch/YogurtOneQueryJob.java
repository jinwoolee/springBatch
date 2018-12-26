package org.iptime.iothome.batch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.iptime.iothome.batch.model.BatchVo;
import org.iptime.iothome.batch.repository.BatchRepository;
import org.iptime.iothome.batch.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class YogurtOneQueryJob {
    
    @Autowired
    private BatchService batchService;
    
    @Scheduled(cron="* * * 1 * *")
    public void run() {
    	Calendar cal = Calendar.getInstance();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
    	String ym = sdf.format(cal.getTime());
    	
    	batchService.dailyBatchOneQuery(ym);
    }
    
}
