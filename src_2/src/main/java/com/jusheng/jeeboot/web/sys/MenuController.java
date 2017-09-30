package com.jusheng.jeeboot.web.sys;

import com.jusheng.jeeboot.entity.SysDict;
import com.jusheng.jeeboot.entity.SysMenu;
import com.jusheng.jeeboot.entity.SysUser;
import com.jusheng.jeeboot.service.sys.MenuService;
import com.jusheng.jeeboot.system.LoginedUser;
import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/menu")
public class MenuController extends BaseController{
    @Autowired
    private MenuService menuService;



    /**
     *
     * @api {list} /api/menu/list
     * @apiDescription  菜单 1.条件查询 条件可以为空 为空时返回所有condition：{ search ：code or name }
     * @apiGroup Menu
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
     * http://api.demo.com/api/menu/list?page=2&rows=10&beginDate=2017-09-10 23:15:09&endDate=2017-09-10 23:15:09&naem=冷链箱
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Menu的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":[
    {"id":null,"parentId":null,"parentIds":null,"name":null,"sort":null,"href":null,
    "target":null,"icon":null,"isShow":null,"permission":null,"createBy":null,"createDate":null,
    "updateBy":null,"updateDate":null,"remarks":null,"delFlag":null}
    ]
    }
     *
     */
    @RequestMapping("list")
    @RequiresPermissions("sys:menu:view")
    public RetObject list(SysMenu sysMenu) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("pageInfo", new PageInfo<Country>(countryList));
//        map.put("queryParam", country);
//        map.put("page", country.getPage());
//        map.put("rows", country.getRows());

        return RetObject.genSuccess("成功了",retMap);
    }

    /**
     *
     * @api {get} /api/menu/findCurrentUserMenu
     * @apiDescription 获取当前用户权限菜单
     * @apiGroup Menu
     * @apiName findCurrentUserMenu
     * @apiVersion 1.0.0
     *
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/menu/findCurrentUserMenu
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回数据
     * @apiSuccessExample {json} Success-Response:
     *  {
            "retCode": 0000,
            "retMsg": 成功,
            "data": [
                {
                "id": null,"parentId": null,"parentIds": null,"name": null,
                "sort": null,"href": null,"target": null,"icon": null,"isShow": null,
                "permission": null,"remarks": null,"delFlag": null,
                }
                ,
                {
                "id": null,"parentId": null,"parentIds": null,"name": null,
                "sort": null,"href": null,"target": null,"icon": null,"isShow": null,
                "permission": null,"remarks": null,"delFlag": null,
                }
                ]
         }
     *
     */
    @RequestMapping("findCurrentUserMenu")
    @RequiresUser
    public RetObject findCurrentUserMenu() {
        List<Map<String,Object>> list=menuService.findCurrentUserMenu(LoginedUser.getCurrentUser());
        return RetObject.genSuccess("成功了",list);
    }
//

    /**
     *
     * @api {view} /api/menu/view
     * @apiDescription 菜单 1.查看单条记录信息
     * @apiGroup Menu
     * @apiName view
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键(条件)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/menu/view/1
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Menu的对象数组
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
    @RequiresPermissions("sys:menu:view")
    public RetObject view(@PathVariable Integer id) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("record",sysArea);
        return RetObject.genSuccess("成功了",retMap);
    }


    /**
     *
     * @api {delete} /api/menu/delete
     * @apiDescription 菜单 1.通过Id删除数据,2.通过id数组 批量删除数据
     * @apiGroup Menu
     * @apiName delete
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/menu/delete/1
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
    @RequiresPermissions("sys:menu:delete")
    public RetObject delete(@PathVariable Integer id, RedirectAttributes ra) {

        return RetObject.genSuccess("删除成功",null);
    }


    /**
     *
     * @api {save} /api/menu/save
     * @apiDescription 菜单 1.新增数据 ,2.更新数据
     * @apiGroup Menu
     * @apiName save
     * @apiVersion 1.0.0
     * @apiParam {String} id  仅更新传
     * @apiParam {String} parentId 父级编号
     * @apiParam {String} parentIds 所有父级编号
     * @apiParam {String} sort 排序
     * @apiParam {String} href 链接
     * @apiParam {String} target 目标
     * @apiParam {String} icon 图标
     * @apiParam {String} is_show 是否在菜单中显示
     *
     * @apiExample {curl} 访问示例：
     *
     *增加 http://api.demo.com/api/menu/save
     *编辑 http://api.demo.com/api/menu/save
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Menu的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }
     *
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @RequiresPermissions("sys:menu:edit")
    public RetObject save(SysMenu sysMenu) {


        return RetObject.genSuccess("新增/保存成功",null);
    }


}
