package com.jusheng.jeeboot.web.sys;


import com.jusheng.jeeboot.entity.BizRegion;
import com.jusheng.jeeboot.entity.SysArea;
import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.web.BaseController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/area")
public class AreaController extends BaseController{



    /**
     *
     * @api {list} /api/area/list
     * @apiDescription  区域 1.条件查询 条件可以为空 为空时返回所有condition：{ search ：code or name }
     * @apiGroup Area
     * @apiName list
     * @apiVersion 1.0.0
     *
     * @apiParam {String} page 第几页
     * @apiParam {String} rows 每页总共记录数
     * @apiParam {String} beginDate 开始时间 (必填) 格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} endDate 结束 (必填)格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} code 区域编码（条件）
     * @apiParam {String} name 名称（条件）
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/area/list?page=2&rows=10&beginDate=2017-09-10 23:15:09&endDate=2017-09-10 23:15:09&HZname=华中
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回BizAlarmCurrent的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":[
    {
    "id": null,
    "page": 1,
    "rows": 10,
    "opFlag": "undefined",
    "parentId": null,
    "parentIds": null,
    "name": null,
    "sort": null,
    "code": null,
    "type": null,
    "createBy": null,
    "createDate": null,
    "updateBy": null,
    "updateDate": null,
    "remarks": null,
    "delFlag": null,
    "admin": false
    }
    ]
    }
     *
     */
    @RequestMapping("list")
    public RetObject list(SysArea sysArea) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("pageInfo", new PageInfo<Country>(countryList));
//        map.put("queryParam", country);
//        map.put("page", country.getPage());
//        map.put("rows", country.getRows());

        return RetObject.genSuccess("成功了",retMap);
    }


    /**
     *
     * @api {view} /api/area/view
     * @apiDescription 区域 1.查看单条记录信息
     * @apiGroup Area
     * @apiName view
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键(条件)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/area/view/1
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回BizAlarmCurrent的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data": [
    {
    "id": null,
    "page": 1,
    "rows": 10,
    "opFlag": "undefined",
    "parentId": null,
    "parentIds": null,
    "name": null,
    "sort": null,
    "code": null,
    "type": null,
    "createBy": null,
    "createDate": null,
    "updateBy": null,
    "updateDate": null,
    "remarks": null,
    "delFlag": null,
    "admin": false
    }
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
     * @api {delete} /api/area/delete
     * @apiDescription 区域 1.通过Id删除数据,2.通过id数组 批量删除数据
     * @apiGroup Area
     * @apiName delete
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键
     * @apiParam {String} ids  多个主键
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/area/delete/1
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
     * @api {save} /api/area/save
     * @apiDescription 区域 1.新增数据 item为数据项通过Id,2.更新数据 item为某行所有数据
     * @apiGroup Area
     * @apiName save
     * @apiVersion 1.0.0
     * @apiParam {String} id  仅更新传
     * @apiParam {String} code 区域编码
     * @apiParam {String} name 名称
     * @apiParam {String} workerId 负责人
     * @apiParam {String} remarks 备注
     *
     * @apiExample {curl} 访问示例：
     *
     *增加 http://api.demo.com/api/area/save
     *编辑 http://api.demo.com/api/area/save
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回BizAlarmCurrent的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }
     *
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public RetObject save(BizRegion bizRegion) {

        return RetObject.genSuccess("新增/保存成功",null);
    }

}
