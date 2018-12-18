package org.iptime.iothome.batch.repository;

import java.util.List;

import org.iptime.iothome.batch.model.CycleVo;

public interface BatchRepository {

    List<CycleVo> getCycleList();

}
