package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobWaitQueue;
import org.apache.ibatis.annotations.Param;


/**
 */
public interface XxlJobWaitQueueDao {
	XxlJobWaitQueue select(@Param("jobId") int jobId);

	int save(XxlJobWaitQueue waitQueue);

	int delete(@Param("jobId") int jobId);

}
