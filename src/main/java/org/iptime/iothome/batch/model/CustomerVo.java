package org.iptime.iothome.batch.model;

import lombok.Data;


@Data
public class CustomerVo {
	
	private Integer cid;
	private String cnm;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
}
