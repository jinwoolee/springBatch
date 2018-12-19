package org.iptime.iothome.batch.repository;

import java.util.List;

import org.iptime.iothome.batch.model.CycleVo;
import org.iptime.iothome.batch.model.DailyVo;

public interface BatchRepository {

    List<CycleVo> getCycleList();

	int mergeDaily(DailyVo dailyVo);

}
