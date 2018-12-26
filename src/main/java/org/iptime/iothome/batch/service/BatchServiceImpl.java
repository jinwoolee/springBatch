package org.iptime.iothome.batch.service;

import org.iptime.iothome.batch.model.BatchVo;
import org.iptime.iothome.batch.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchRepository batchRepository;
	
	@Override
	public int dailyBatchOneQuery(String ym) {
		
		BatchVo batchVo = new BatchVo();
    	batchVo.setBcd("01");		//일실적 생성 배치
    	batchVo.setSt("01");		//배치 시작
    	
		batchRepository.startBatchJobStart(batchVo);
		int inseretCnt = batchRepository.dailyBatchOneQuery(ym);
		
		batchVo.setSt("02");		//배치 종료
		batchRepository.endBatchJobStart(batchVo);
		
		return inseretCnt;
	}

}
