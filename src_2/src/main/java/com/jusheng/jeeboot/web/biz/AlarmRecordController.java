package com.jusheng.jeeboot.web.biz;

import com.jusheng.jeeboot.entity.*;
import com.jusheng.jeeboot.system.RetObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * 当前报警，历史报警
 */
@RestController
@RequestMapping("/api/alarmRecord")
public class AlarmRecordController {

    /**
     *
     * @api {get} /api/alarmRecord/listCurrent
     * @apiDescription 列出当前告警信息
     * @apiGroup Alarm
     * @apiName list
     * @apiVersion 1.0.0
     *
     * @apiParam {String} page 第几页
     * @apiParam {String} rows 每页总共记录数
     * @apiParam {String} beginDate 开始时间 (必填) 格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} endDate 结束 (必填)格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} codeOrName 箱子编码/名字 (可选)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/alarmRecord/listCurrent?page=2&rows=10&beginDate=2017-09-10 23:15:09&endDate=2017-09-10 23:15:09&codeOrName=BOX1101
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回BizAlarmCurrent的对象数组
     * @apiSuccessExample {json} Success-Response:
        {
        "retCode": 0000,
        "retMsg": 成功,
        "data": [
            {"id":null,"alarmCode":null,"boxCode":null,"level":null,"content":null,"reportTime":null,"officeId":null},
            {"id":null,"alarmCode":null,"boxCode":null,"level":null,"content":null,"reportTime":null,"officeId":null}
        ]
        }
     *
     */
    @RequestMapping("listCurrent")
    @RequiresPermissions("sys:dict:edit")
    public RetObject listCurrent(){
        return RetObject.genSuccess("",null);
    }

    /**
     *
     * @api {get} /api/alarmRecord/listCurrent
     * @apiDescription 失控处理
     * @apiGroup Alarm
     * @apiName list
     * @apiVersion 1.0.0
     *
     * @apiParam {String} page 第几页
     * @apiParam {String} rows 每页总共记录数
     * @apiParam {String} beginDate 开始时间 (必填) 格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} endDate 结束 (必填)格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} codeOrName 箱子编码/名字 (可选)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/alarmRecord/listCurrent?page=2&rows=10&beginDate=2017-09-10 23:15:09&endDate=2017-09-10 23:15:09&codeOrName=BOX1101
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回BizAlarmCurrent的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data": [
    {"id":null,"alarmCode":null,"boxCode":null,"level":null,"content":null,"reportTime":null,"officeId":null},
    {"id":null,"alarmCode":null,"boxCode":null,"level":null,"content":null,"reportTime":null,"officeId":null}
    ]
    }
     *
     */
    @RequestMapping("listLoseControll")
    @RequiresPermissions("sys:dict:edit")
    public RetObject listTopLevel(){
        return RetObject.genSuccess("",null);
    }

    /**
     *
     * @api {get} /api/alarmRecord/listCurrent
     * @apiDescription 列出当前告警信息
     * @apiGroup Alarm
     * @apiName list
     * @apiVersion 1.0.0
     *
     * @apiParam {String} page 第几页
     * @apiParam {String} rows 每页总共记录数
     * @apiParam {String} beginDate 开始时间 (必填) 格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} endDate 结束 (必填)格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} codeOrName 箱子编码/名字 (可选)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/alarmRecord/listCurrent?page=2&rows=10&beginDate=2017-09-10 23:15:09&endDate=2017-09-10 23:15:09&codeOrName=BOX1101
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回BizAlarmCurrent的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data": [
    {"id":null,"alarmCode":null,"boxCode":null,"level":null,"content":null,"reportTime":null,"officeId":null},
    {"id":null,"alarmCode":null,"boxCode":null,"level":null,"content":null,"reportTime":null,"officeId":null}
    ]
    }
     *
     */
    @RequestMapping("listHistory")
    @RequiresPermissions("sys:dict:edit")
    public RetObject listHistory(){
        return RetObject.genSuccess("",null);
    }



    /**
     *
     * @api {viewCurrent} /api/alarmRecord/viewCurrent
     * @apiDescription 列出当前告警信息 1.查看单条记录信息
     * @apiGroup Alarm
     * @apiName viewCurrent
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键(条件)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/alarm/viewCurrent/1
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Alarm的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data": [
    {"id":null,"alarmCode":null,"boxCode":null,"level":null,"content":null,"reportTime":null,"officeId":null},
    {"id":null,"alarmCode":null,"boxCode":null,"level":null,"content":null,"reportTime":null,"officeId":null}
    ]
    }
     *
     */
    @RequestMapping(value = "viewCurrent/{id}")
    public RetObject viewCurrent(@PathVariable Integer id) {
        Map<String,Object> retMap=new HashMap<String, Object>();

        return RetObject.genSuccess("成功了",retMap);
    }


    /**
     *
     * @api {viewHistory} /api/alarmRecord/viewHistory
     * @apiDescription  列出历史告警信息 1.查看单条记录信息
     * @apiGroup Alarm
     * @apiName view
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键(条件)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/alarmRecord/viewHistory/1
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Alarm的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data": [
    {"id":null,"code":null,"type":null,"level":null,"reason":null,"suggestion":null,"title":null,"remark":null,"status":null,"lastReportTime":null,"content":null,"handleTimeLimit":null,"officeId":null,"admin":false},
    {"id":null,"code":null,"type":null,"level":null,"reason":null,"suggestion":null,"title":null,"remark":null,"status":null,"lastReportTime":null,"content":null,"handleTimeLimit":null,"officeId":null,"admin":false}
    ]
    }
     *
     */
    @RequestMapping(value = "viewHistory/{id}")
    public RetObject viewHistory(@PathVariable Integer id) {
        Map<String,Object> retMap=new HashMap<String, Object>();

        return RetObject.genSuccess("成功了",retMap);
    }

    /**
     *
     * @api {deleteCurrent} /api/alarmRecord/deleteCurrent
     * @apiDescription 当前告警记录 1.通过Id删除数据,2.通过id数组 批量删除数据
     * @apiGroup Alarm
     * @apiName deleteCurrent
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键
     * @apiParam {String} ids  多个主键
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/alarmRecord/deleteCurrent/1
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }
     *
     */
    @RequestMapping(value = "deleteCurrent/{id}")
    public RetObject deleteCurrent(@PathVariable Integer id, RedirectAttributes ra) {

        return RetObject.genSuccess("删除成功",null);
    }


    /**
     *
     * @api {deleteHistory}/api/alarmRecord/deleteHistory
     * @apiDescription 历史告警记录 1.通过Id删除数据,2.通过id数组 批量删除数据
     * @apiGroup Alarm
     * @apiName deleteHistory
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键
     * @apiParam {String} ids  多个主键
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/alarmRecord/deleteHistory/1
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }
     *
     */
    @RequestMapping(value = "deleteHistory/{id}")
    public RetObject deleteHistory(@PathVariable Integer id, RedirectAttributes ra) {

        return RetObject.genSuccess("删除成功",null);
    }

    /**
     *
     * @api {saveCurrent}/api/alarmRecord/saveCurrent
     * @apiDescription 当前告警 1.新增数据 2.更新数据
     * @apiGroup Alarm
     * @apiName saveCurrent
     * @apiVersion 1.0.0
     * @apiParam {String} id  仅更新传
     * @apiParam {String} code 报警号
     * @apiParam {Short} type 1-系统 2-业务 3-通讯
     * @apiParam {Short}  level 级别 0-已清楚 1-通知 2-警告 3-错误 4-严重
     * @apiParam {String} reason  原因
     * @apiParam {String} suggestion  处理预案
     * @apiParam {String}  title 标题
     * @apiParam {String}  remark 备注
     * @apiParam {Short}  status 状态 0-未激活 1-已激活
     * @apiParam {Date}  lastReportTime  最后一次上报的时间
     * @apiParam {String} content  内容
     * @apiParam {Integer} handleTimeLimit  处理期限
     * @apiParam {String} officeId  机构编号
     *
     * @apiExample {curl} 访问示例：
     *
     *增加 http://api.demo.com/api/alarmRecord/saveCurrent
     *编辑 http://api.demo.com/api/alarmRecord/saveCurrent
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Alarm的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }
     *
     */
    @RequestMapping(value = "saveCurrent", method = RequestMethod.POST)
    public RetObject saveCurrent(BizAlarmCurrent bizAlarmCurrent) {

        return RetObject.genSuccess("保存成功",null);
    }

    /**
     *
     * @api {saveHistory}/api/alarmRecord/saveHistory
     * @apiDescription 历史告警 1.新增数据 2.更新数据
     * @apiGroup Alarm
     * @apiName saveHistory
     * @apiVersion 1.0.0
     * @apiParam {String} id  仅更新传
     * @apiParam {String} code 报警号
     * @apiParam {Short} type 1-系统 2-业务 3-通讯
     * @apiParam {Short}  level 级别 0-已清楚 1-通知 2-警告 3-错误 4-严重
     * @apiParam {String} reason  原因
     * @apiParam {String} suggestion  处理预案
     * @apiParam {String}  title 标题
     * @apiParam {String}  remark 备注
     * @apiParam {Short}  status 状态 0-未激活 1-已激活
     * @apiParam {Date}  lastReportTime  最后一次上报的时间
     * @apiParam {String} content  内容
     * @apiParam {Integer} handleTimeLimit  处理期限
     * @apiParam {String} officeId  机构编号
     *
     * @apiExample {curl} 访问示例：
     *
     *增加 http://api.demo.com/api/alarmRecord/saveHistory
     *编辑 http://api.demo.com/api/alarmRecord/saveHistory
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Alarm的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }
     *
     */
    @RequestMapping(value = "saveHistory", method = RequestMethod.POST)
    public RetObject saveHistory(BizAlarmHistory bizAlarmHistory) {

        return RetObject.genSuccess("保存成功",null);
    }
}
