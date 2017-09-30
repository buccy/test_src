package com.jusheng.jeeboot.web.biz.report;

import com.jusheng.jeeboot.entity.BizAlarm;
import com.jusheng.jeeboot.entity.BizBox;
import com.jusheng.jeeboot.system.RetObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/22.
 * @冷链箱状态统计
 */
@RestController
@RequestMapping("/api/report/boxStatus")
public class BoxStatusController {

    /**
     *
     * @api {list} /api/report/boxStatus/list
     * @apiDescription  冷链箱状态统计 查询条件,箱号，箱名，警告日期范围，区域，分区，线路,类型,状态
     * @apiGroup BizAlarm
     * @apiName list
     * @apiVersion 1.0.0
     *
     * @apiParam {String} page 第几页
     * @apiParam {String} rows 每页总共记录数
     * @apiParam {String} beginDate 开始时间 (必填) 格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} endDate 结束 (必填)格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} code 箱号（条件）
     * @apiParam {String} name 箱名（条件）
     * @apiParam {String} areaName 区域（条件）
     * @apiParam {String} userCode 分区（条件）
     * @apiParam {String} lineName  线路（条件）
     * @apiParam {String} type  类型（条件）
     * @apiParam {String} status  状态（条件）
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com///api/report/boxStatus/list?page=2&rows=10&beginDate=2017-09-10 23:15:09&endDate=2017-09-10 23:15:09&HZname=华中
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回BizAlarm的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":[
    {
    {"
    id":null,"code":null,"type":null,"level":null,"reason":null,"suggestion":null,"title":null,
    "remark":null,"status":null,"lastReportTime":null,"content":null,"handleTimeLimit":null,"officeId":null
    }
    }
    ]
    }
     *
     */
    @RequestMapping("list")
    @RequiresPermissions("sys:dict:edit")
    public RetObject list(BizAlarm bizAlarm) {
        Map<String,Object> retMap=new HashMap<String, Object>();

        return RetObject.genSuccess("成功了",retMap);
    }

    /**
     *
     * @api {save} /api/area/save
     * @apiDescription 冷链箱状态更新 1.更新状态，6-锁定，7-开启，2-关闭
     * @apiGroup BizAlarm
     * @apiName save
     * @apiVersion 1.0.0
     * @apiParam {String} id  仅更新传
     * @apiParam {String} status  状态（条件）
     *
     * @apiExample {curl} 访问示例：
     *
     *编辑 http://api.demo.com/api/report/boxStatus/save
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回BizAlarm的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }
     *
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public RetObject save(BizBox bizBox) {

        return RetObject.genSuccess("更新/状态",null);
    }
}
