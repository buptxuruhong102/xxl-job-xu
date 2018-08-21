package com.xxl.job.admin.core.model;

/**
 */
public class XxlJobInfoRel {
	private int id;
	private int jobId;
	private int parentJobId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getParentJobId() {
		return parentJobId;
	}

	public void setParentJobId(int parentJobId) {
		this.parentJobId = parentJobId;
	}
}
