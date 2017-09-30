package com.jusheng.jeeboot.web.sys;


import com.jusheng.jeeboot.entity.SysArea;
import com.jusheng.jeeboot.entity.SysDict;
import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dict")
public class DictController extends BaseController {


    /**
     *
     * @api {list} /api/dict/list
     * @apiDescription 字典 1.条件查询 条件可以为空 为空时返回所有condition：{ search ：code or name }
     * @apiGroup Dict
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
     * http://api.demo.com/api/dict/list?page=2&rows=10&beginDate=2017-09-10 23:15:09&endDate=2017-09-10 23:15:09&value=1
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Dict的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":[
    {
    "id":null,"value":null,"label":null,"type":null,"description":null,
    "sort":null,"parentId":null,"createBy":null,"createDate":null,"updateBy":null,
    "updateDate":null,"remarks":null,"delFlag":null
    }
    ]
    }
     *
     */
    @RequestMapping("list")
    @RequiresPermissions("sys:dict:view")
    public RetObject list(SysDict sysDict) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("pageInfo", new PageInfo<Country>(countryList));
//        map.put("queryParam", country);
//        map.put("page", country.getPage());
//        map.put("rows", country.getRows());

        return RetObject.genSuccess("成功了",retMap);
    }


    /**
     *
     * @api {view} /api/dict/view
     * @apiDescription 字典 1.查看单条记录信息
     * @apiGroup Dict
     * @apiName view
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键(条件)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/menu/view/1
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Dict的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data": [
    {
    "id":null,"value":null,"label":null,"type":null,"description":null,
    "sort":null,"parentId":null,"createBy":null,"createDate":null,"updateBy":null,
    "updateDate":null,"remarks":null,"delFlag":null
    }
    ]
    }
     *
     */
    @RequestMapping(value = "view/{id}")
    @RequiresPermissions("sys:dict:view")
    public RetObject view(@PathVariable Integer id) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("record",sysArea);
        return RetObject.genSuccess("成功了",retMap);
    }

    /**
     *
     * @api {delete} /api/dict/delete
     * @apiDescription 字典 1.通过Id删除数据,2.通过id数组 批量删除数据
     * @apiGroup Dict
     * @apiName delete
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键
     * @apiParam {String} ids  多个主键
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/dict/delete/1
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
    @RequiresPermissions("sys:dict:delete")
    public RetObject delete(@PathVariable Integer id, RedirectAttributes ra) {

        return RetObject.genSuccess("删除成功",null);
    }

    /**
     *
     * @api {save} /api/dict/save
     * @apiDescription 字典 1.新增数据 ,2.更新数据
     * @apiGroup Dict
     * @apiName save
     * @apiVersion 1.0.0
     * @apiParam {String} id  仅更新传
     * @apiParam {String} value 数据值
     * @apiParam {String} label 标签名
     * @apiParam {String} description 描述
     * @apiParam {String}  type 类型
     * @apiParam {String} sort 排序（升序）
     * @apiParam {String} parentId 父级编号
     * @apiParam {String}  remarks 备注信息
     *
     * @apiExample {curl} 访问示例：
     *
     *增加 http://api.demo.com/api/dict/save
     *编辑 http://api.demo.com/api/dict/save
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Dict的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }
     *
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @RequiresPermissions("sys:dict:edit")
    public RetObject save(SysDict sysDict) {

        return RetObject.genSuccess("新增/保存成功",null);
    }

}
