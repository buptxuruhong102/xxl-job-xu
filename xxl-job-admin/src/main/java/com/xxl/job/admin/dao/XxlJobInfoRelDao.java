package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobInfoRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * job info
 * @author xuxueli 2016-1-12 18:03:45
 */
public interface XxlJobInfoRelDao {
	List<XxlJobInfoRel> select(XxlJobInfoRel rel);

	int save(XxlJobInfoRel rel);

	int deleteByJobId(@Param("jobId") int jobId);

}
