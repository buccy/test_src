package com.jusheng.jeeboot.web.biz.report;

import com.jusheng.jeeboot.entity.BizBox;
import com.jusheng.jeeboot.system.RetObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *  冷链箱告警统计
 */
@RestController
@RequestMapping("/api/report/boxAlarm")
public class BoxAlarmController {

    /**
     *
     * @api {list} /api/report/boxAlarm/list
     * @apiDescription  冷链箱告警统计 查询条件,箱号，箱名，电话卡号，负责人，负责人号，线路
     * @apiGroup BizBox
     * @apiName list
     * @apiVersion 1.0.0
     *
     * @apiParam {String} page 第几页
     * @apiParam {String} rows 每页总共记录数
     * @apiParam {String} beginDate 开始时间 (必填) 格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} endDate 结束 (必填)格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} code 箱号（条件）
     * @apiParam {String} name 箱名（条件）
     * @apiParam {String} phone 电话卡号（条件）
     * @apiParam {String} master 负责人（条件）
     * @apiParam {String} userCode 负责人号（条件）
     * @apiParam {String} lineName线路（条件）
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com//api/report/boxAlarm/list?page=2&rows=10&beginDate=2017-09-10 23:15:09&endDate=2017-09-10 23:15:09&HZname=华中
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回BizBox的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":[
    {
    "id":null,"code":null,"name":null,"msisdn":null,"type":null,"status":null,"remark":null,
    "worker":null,"line":null,"departTime":null,"backTime":null,"positionType":null,"handleTime":null,
    "officeId":null
    }
    ]
    }
     *
     */
    @RequestMapping("list")
    @RequiresPermissions("sys:dict:edit")
    public RetObject list(BizBox bizBox) {
        Map<String,Object> retMap=new HashMap<String, Object>();

        return RetObject.genSuccess("成功了",retMap);
    }

}
