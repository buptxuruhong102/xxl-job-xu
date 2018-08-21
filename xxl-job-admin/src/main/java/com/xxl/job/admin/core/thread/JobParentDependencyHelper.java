package com.xxl.job.admin.core.thread;

import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.model.XxlJobInfoRel;
import com.xxl.job.admin.core.model.XxlJobWaitQueue;
import com.xxl.job.admin.core.schedule.XxlJobDynamicScheduler;
import com.xxl.job.admin.core.util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by xuruhong on 2018/8/16.
 */
public class JobParentDependencyHelper {
    private JobParentDependencyHelper(){
    }


    public static boolean checkDependency(int jobId){
        XxlJobInfoRel rel = new XxlJobInfoRel();
        rel.setJobId(jobId);
        List<XxlJobInfoRel> parentJobs = XxlJobDynamicScheduler.xxlJobInfoRelDao.select(rel);

        if (parentJobs != null) {
            for(XxlJobInfoRel parentJob: parentJobs){
                int parentJobId = parentJob.getParentJobId();
                if(!executeSuccess(parentJobId)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean executeSuccess(int jobId){
        XxlJobInfo xxlJobInfo = XxlJobDynamicScheduler.xxlJobInfoDao.loadById(jobId);

        int offset = 0;
        int pagesize = 10;
        int jobGroup = xxlJobInfo.getJobGroup();
        Date triggerTimeStart = DateUtil.getToday0();
        Date triggerTimeEnd = null;
        int logStatus = 1;

        int cnt = XxlJobDynamicScheduler.xxlJobLogDao.pageListCount(offset, pagesize, jobGroup, jobId, triggerTimeStart, triggerTimeEnd, logStatus);

        return cnt > 0;
    }

    public static void save2WaitQueue(int jobId){
        XxlJobWaitQueue oldQueue = XxlJobDynamicScheduler.xxlJobWaitQueueDao.select(jobId);
        if(oldQueue == null){
            XxlJobWaitQueue waitQueue = new XxlJobWaitQueue();
            waitQueue.setJobId(jobId);
            waitQueue.setCreateTime(new Date());
            XxlJobDynamicScheduler.xxlJobWaitQueueDao.save(waitQueue);
        }
    }

    public static void deleteWaitQueue(int jobId){
        XxlJobDynamicScheduler.xxlJobWaitQueueDao.delete(jobId);
    }


}
