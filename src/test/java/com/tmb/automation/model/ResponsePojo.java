package com.tmb.automation.model;

import java.util.List;

public class ResponsePojo {
	private StatusPojo status;
	private List<DataPojo> data;

	public StatusPojo getStatus() {
		return status;
	}

	public void setStatus(StatusPojo status) {
		this.status = status;
	}

	public List<DataPojo> getData() {
		return data;
	}

	public void setData(List<DataPojo> data) {
		this.data = data;
	}

}
