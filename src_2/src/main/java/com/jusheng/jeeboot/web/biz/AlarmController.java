package com.jusheng.jeeboot.web.biz;

import com.jusheng.jeeboot.entity.BizAlarm;
import com.jusheng.jeeboot.entity.SysArea;
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
 * 报警设置
 */
@RestController
@RequestMapping("/api/alarm")
public class AlarmController {

    /**
     *
     * @api {get} /api/alarm/list
     * @apiDescription 报警设置
     * @apiGroup Alarm
     * @apiName list
     * @apiVersion 1.0.0
     *
     * @apiParam {String} page 第几页
     * @apiParam {String} rows 每页总共记录数
     * @apiParam {String} code 报警编码 (可选)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/alarm/list?page=2&rows=10&name=Kami
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回数据
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
    @RequestMapping("list")
    @RequiresPermissions("sys:dict:edit")
    public RetObject list(BizAlarm bizAlarm) {
        Map<String,Object> retMap=new HashMap<String, Object>();

        return RetObject.genSuccess("成功了",retMap);
    }

    /**
     *
     * @api {view} /api/alarm/view
     * @apiDescription 报警设置 1.查看单条记录信息
     * @apiGroup Alarm
     * @apiName view
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键(条件)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/alarm/view/1
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
    @RequestMapping(value = "view/{id}")
    public RetObject view(@PathVariable Integer id) {
        Map<String,Object> retMap=new HashMap<String, Object>();

        return RetObject.genSuccess("成功了",retMap);
    }


    /**
     *
     * @api {delete} /api/alarm/delete
     * @apiDescription 报警设置 1.通过Id删除数据,2.通过id数组 批量删除数据
     * @apiGroup Alarm
     * @apiName delete
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键
     * @apiParam {String} ids  多个主键
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/alarm/delete/1
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
    @RequestMapping(value = "delete/{id}")
    public RetObject delete(@PathVariable Integer id, RedirectAttributes ra) {

        return RetObject.genSuccess("删除成功",null);
    }

    /**
     *
     * @api {save} /api/alarm/save
     * @apiDescription 区域 1.新增数据 item为数据项通过Id,2.更新数据 item为某行所有数据
     * @apiGroup Alarm
     * @apiName save
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
     *增加 http://api.demo.com/api/alarm/save
     *编辑 http://api.demo.com/api/alarm/save
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
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public RetObject save(BizAlarm bizAlarm) {

        return RetObject.genSuccess("新增/更新/保存成功",null);
    }

}
