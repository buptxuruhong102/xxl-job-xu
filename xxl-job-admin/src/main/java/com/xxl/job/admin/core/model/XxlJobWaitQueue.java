package com.xxl.job.admin.core.model;

import java.util.Date;

/**
 */
public class XxlJobWaitQueue {
	private int jobId;
	private Date createTime;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
