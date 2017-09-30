package com.jusheng.jeeboot.web.biz;

import com.jusheng.jeeboot.system.RetObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 推送消息给相关人员
 */
@RestController
@RequestMapping("api/notify")
public class NotifyController {
    /**
     * 发送报警信息
     * @param recvWorkerID 接收通知的人
     * @param copyWorkerID 抄送人
     * @param extraMessage 附加信息
     * @return RetObject
     */
    @RequestMapping("alarm")
    @RequiresPermissions("biz:notify:sendAlarm")
    public RetObject sendAlarm(String recvWorkerID,String copyWorkerID,String extraMessage){
        return null;
    }

    /**
     * 发送通知公告
     * @param userIds 多个用户的ids 格式:1,3,5
     * @param content 发送内容
     * @return RetObject
     */
    @RequestMapping("broadcast")
    @RequiresPermissions("biz:notify:sendBroadcast")
    public RetObject sendBroadcast(String userIds,String content){
        return null;
    }
}
