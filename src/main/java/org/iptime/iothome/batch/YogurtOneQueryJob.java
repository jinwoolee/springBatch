package org.iptime.iothome.batch;

import org.iptime.iothome.batch.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class YogurtOneQueryJob {
    
    @Autowired
    private BatchRepository batchRepository;
    
    @Scheduled(cron="* * * * * *")
    public void run() {
        
    }
    
}
