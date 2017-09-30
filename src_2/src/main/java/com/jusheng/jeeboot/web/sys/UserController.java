package com.jusheng.jeeboot.web.sys;

import com.jusheng.jeeboot.entity.SysMenu;
import com.jusheng.jeeboot.entity.SysUser;
import com.jusheng.jeeboot.service.sys.MenuService;
import com.jusheng.jeeboot.service.sys.UserService;
import com.jusheng.jeeboot.system.LoginedUser;
import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.system.SysCode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     *
     * @api {list} /api/user/list
     * @apiDescription 条件查询获取用户
     * @apiGroup User
     * @apiName list
     * @apiVersion 1.0.0
     *
     * @apiParam {String} page 第几页
     * @apiParam {String} rows 每页总共记录数
     * @apiParam {String} beginDate 开始时间 (必填) 格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} endDate 结束 (必填)格式:YYYY-MM-DD HH:NN:SS
     * @apiParam {String} name 账号/用户名（条件）

     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/user/list?page=2&rows=10&beginDate=2017-09-10 23:15:09&endDate=2017-09-10 23:15:09&name=系统管理员
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回User的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":[
    {"id":null,"companyId":null,"officeId":null,"loginName":null,"password":null,"no":null,"name":null,"email":null,"phone":null,"mobile":null,"userType":null,"photo":null,"loginIp":null,"loginDate":null,"loginFlag":null,"createBy":null,"createDate":null,"updateBy":null,"updateDate":null,"remarks":null,"delFlag":null}    ]
    }
     *
     */
    @RequestMapping("list")
    @RequiresPermissions("sys:user:view")
    public RetObject list(SysUser sysUser) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("pageInfo", new PageInfo<Country>(countryList));
//        map.put("queryParam", country);
//        map.put("page", country.getPage());
//        map.put("rows", country.getRows());

        return RetObject.genSuccess("成功了",retMap);
    }


    /**
     *
     * @api {view} /api/user/view
     * @apiDescription 用户 查看 1.通过id 获取用户信息
     * @apiGroup User
     * @apiName view
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键(条件)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/user/view/1
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回User的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data": [
    {"id":null,"companyId":null,"officeId":null,"loginName":null,"password":null,"no":null,"name":null,"email":null,"phone":null,"mobile":null,"userType":null,"photo":null,"loginIp":null,"loginDate":null,"loginFlag":null,"createBy":null,"createDate":null,"updateBy":null,"updateDate":null,"remarks":null,"delFlag":null}    ]
    }
     *
     */
    @RequestMapping(value = "view/{id}")
    @RequiresPermissions("sys:user:view")
    public RetObject view(@PathVariable Integer id) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("record",sysArea);
        return RetObject.genSuccess("成功了",retMap);
    }


    /**
     *
     * @api {delete} /api/user/delete
     * @apiDescription 用户 删除1.通过Id删除用户
     * @apiGroup User
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
    @RequiresPermissions("sys:user:delete")
    public RetObject delete(@PathVariable Integer id, RedirectAttributes ra) {

        return RetObject.genSuccess("删除成功",null);
    }


    /**
     *
     * @api {save} /api/user/save
     * @apiDescription 用户 1.新增数据  2.通过用户Id 修改自身信息
     * @apiGroup User
     * @apiName save
     * @apiVersion 1.0.0
     * @apiParam {String} id  仅更新传
     * @apiParam {String} no  账号
     * @apiParam {String} name  昵称
     * @apiParam {String} roleId 角色
     * @apiParam {String} mobile 手机
     * @apiParam {String} email  邮件
     * @apiParam {String}  password 密码
     * @apiParam {String} status  状态 1-激活 0-冻结

     *
     * @apiExample {curl} 访问示例：
     *
     *增加 http://api.demo.com/api/user/save
     *编辑 http://api.demo.com/api/user/save
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回User的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }roleId
     *
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @RequiresPermissions("sys:user:edit")
    public RetObject save(SysUser sysUser) {

        return RetObject.genSuccess("新增/保存成功",null);
    }
}
