package com.jusheng.jeeboot.task;

import com.jusheng.jeeboot.service.sys.UserService;
import com.jusheng.jeeboot.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @定时任务
 *
 *
 *
 */
@Component
public class ScheduleJob {
    /**
     *  定时任务
     */
    @Scheduled(cron="${jobs.fixeMinute}")
    public void centJob() {

        LogUtils.logger.info("--------------------------定时任务查询用户数据 执行完成时间= "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
}
