package org.iptime.iothome.batch.repository;

import java.util.List;

import org.iptime.iothome.batch.model.BatchVo;
import org.iptime.iothome.batch.model.CycleVo;
import org.iptime.iothome.batch.model.DailyVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BatchRepositoryImpl implements BatchRepository {
    
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<CycleVo> getCycleList() {
        return sqlSessionTemplate.selectList("batch.getCycleList");
    }

	@Override
	public int mergeDaily(DailyVo dailyVo) {
		return sqlSessionTemplate.insert("batch.mergeDaily", dailyVo);
	}

    @Override
    public int dailyBatchOneQuery(String ym) {
    	return sqlSessionTemplate.insert("batch.dailyBatchOneQuery", ym);
    }

	@Override
	public int startBatchJobStart(BatchVo batchVo) {
		return sqlSessionTemplate.insert("batch.startBatchJob", batchVo);
	}

	@Override
	public int endBatchJobStart(BatchVo batchVo) {
		return sqlSessionTemplate.insert("batch.endBatchJob", batchVo);
	}

}
