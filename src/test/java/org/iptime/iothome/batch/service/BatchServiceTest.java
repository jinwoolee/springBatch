package org.iptime.iothome.batch.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/org/iptime/iothome/config/spring/context.xml",
                                  "classpath:/org/iptime/iothome/config/spring/batch-context.xml"})
public class BatchServiceTest {

	private Logger logger = LoggerFactory.getLogger(BatchServiceTest.class);
    
    @Autowired
    private BatchService batchService;
    
	@Test
    public void testDailyBatchOneQuery() {
        /***given***/
        String ym = "201812";
        
        /***when***/
        int insertCnt = batchService.dailyBatchOneQuery(ym);

        /***then***/
        assertEquals(63, insertCnt);
    }

}
