package com.jusheng.jeeboot.web.sys;

import com.jusheng.jeeboot.entity.SysDict;
import com.jusheng.jeeboot.entity.SysOffice;
import com.jusheng.jeeboot.system.RetObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/office")
public class OfficeController {


    /**
     *
     * @api {list} /api/office/list
     * @apiDescription  机构 1.条件查询 条件可以为空 为空时返回所有condition：{ search ：code or name }
     * @apiGroup Office
     * @apiName list
     * @apiVersion 1.0.0
     *
     * @apiParam {String} page 第几页
     * @apiParam {String} rows 每页总共记录数
     * @apiParam {String} beginDate 开始时间 (必填) 格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} endDate 结束 (必填)格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} name 名称（条件）
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/office/list?page=2&rows=10&beginDate=2017-09-10 23:15:09&endDate=2017-09-10 23:15:09&naem=冷链箱
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Office的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":[
    {"id":null,"parentId":null,"parentIds":null,"name":null,"sort":null,"areaId":null,"code":null,"type":null,
    "grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,
    "primaryPerson":null,"deputyPerson":null,"createBy":null,"createDate":null,"updateBy":null,"updateDate":null,
    "remarks":null,"delFlag":null
    }
    ]
    }
     *
     */
    @RequestMapping("list")
    @RequiresPermissions("sys:office:view")
    public RetObject list(SysOffice sysOffice) {
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
     * @apiDescription 机构 1.查看单条记录信息
     * @apiGroup Office
     * @apiName view
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键(条件)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/area/view/1
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Office的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data": [
    {"id":null,"parentId":null,"parentIds":null,"name":null,"sort":null,"areaId":null,"code":null,"type":null,
    "grade":null,"address":null,"zipCode":null,"master":null,"phone":null,"fax":null,"email":null,"useable":null,
    "primaryPerson":null,"deputyPerson":null,"createBy":null,"createDate":null,"updateBy":null,"updateDate":null,
    "remarks":null,"delFlag":null
    }
    ]
    }
     *
     */
    @RequestMapping(value = "view/{id}")
    @RequiresPermissions("sys:office:view")
    public RetObject view(@PathVariable Integer id) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("record",sysArea);
        return RetObject.genSuccess("成功了",retMap);
    }

    /**
     *
     * @api {delete} /api/office/delete
     * @apiDescription 机构 1.通过Id删除数据,2.通过id数组 批量删除数据
     * @apiGroup Office
     * @apiName delete
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/office/delete/1
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
    @RequiresPermissions("sys:office:delete")
    public RetObject delete(@PathVariable Integer id, RedirectAttributes ra) {

        return RetObject.genSuccess("删除成功",null);
    }


    /**
     *
     * @api {save} /api/office/save
     * @apiDescription 机构 1.新增数据过Id,2.更新数据
     * @apiGroup Office
     * @apiName save
     * @apiVersion 1.0.0
     * @apiParam {String} id  仅更新传
     * @apiParam {String} parentId 父级编号
     * @apiParam {String} parentIds 所有父级编号
     * @apiParam {String} name 名称
     * @apiParam {String} sort 排序
     * @apiParam {String} areaId 归属区域
     * @apiParam {String} code 区域编码
     * @apiParam {String} type 机构类型
     * @apiParam {String} grade 机构等级
     * @apiParam {String} address 联系地址
     * @apiParam {String} zipCode 邮政编码
     * @apiParam {String} master 负责人
     * @apiParam {String} phone 电话
     * @apiParam {String} fax 传真
     * @apiParam {String} email 邮箱
     *
     * @apiExample {curl} 访问示例：
     *
     *增加 http://api.demo.com/api/office/save
     *编辑 http://api.demo.com/api/offic/save
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Office的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }
     *
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @RequiresPermissions("sys:office:edit")
    public RetObject save(SysOffice sysOffice) {


        return RetObject.genSuccess("新增/保存成功",null);
    }
}
