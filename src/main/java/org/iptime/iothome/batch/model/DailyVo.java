package org.iptime.iothome.batch.model;

import lombok.Data;

@Data
public class DailyVo {

    private Integer cid;
    private Integer pid;
    private String dt;
    private Integer cnt;
}
