package org.iptime.iothome.batch.model;

import java.util.Date;

import lombok.Data;

@Data
public class BatchVo {
	private Integer bid;	//배치 번호
	private String bcd;		//배치 작업		//01 : 일실적 생성 배치
	private String st;		//배치 상태		//01 : 시작, 02:정상완료, 99:에러
	private Date st_dt;		//배치 시작일자
	private Date ed_dt;		//배치 종료일자
}
