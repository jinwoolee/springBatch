package org.iptime.iothome.batch.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.iptime.iothome.batch.model.CycleVo;
import org.iptime.iothome.batch.model.DailyVo;
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
public class BatchRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(BatchRepositoryTest.class);
    
    @Autowired
    private BatchRepository batchRepository;
    
    @Test
    public void testBatchRepositoryBean() {
        /***given***/
        
        /***when***/

        /***then***/
        assertNotNull(batchRepository);
    }
    
    @Test
    public void testGetCycleList() {
        /***given***/
        
        /***when***/
        List<CycleVo> cycleList = batchRepository.getCycleList();
        logger.debug("cycleList : {}", cycleList);
        
        /***then***/
        assertEquals(15, cycleList.size());
    }
    
    @Test
    public void testMergeDaily() {
    	/***given***/
		DailyVo dailyVo = new DailyVo();
		dailyVo.setCid(1);
		dailyVo.setPid(100);
		dailyVo.setDt("20181219");
		dailyVo.setCnt(5);

		/***when***/
		int mergeCnt = batchRepository.mergeDaily(dailyVo);

		/***then***/
		assertEquals(1, mergeCnt);
    }
    
    @Test
    public void testDailyBatchOneQuery() {
        /***given***/
        String ym = "201812";
        
        /***when***/
        int insertCnt = batchRepository.dailyBatchOneQuery(ym);

        /***then***/
        assertEquals(63, insertCnt);
    }

}
