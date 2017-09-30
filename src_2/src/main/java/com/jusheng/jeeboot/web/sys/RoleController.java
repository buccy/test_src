package com.jusheng.jeeboot.web.sys;

import com.github.pagehelper.PageInfo;
import com.jusheng.jeeboot.entity.BaseEntity;
import com.jusheng.jeeboot.entity.SysRole;
import com.jusheng.jeeboot.service.sys.RoleService;
import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.system.exception.BeanValidException;
import com.jusheng.jeeboot.system.exception.BizErrorException;
import com.jusheng.jeeboot.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/role")
public class RoleController extends BaseController{
    @Autowired
    RoleService roleService;

    /**
     *
     * @api {list} /api/role/list
     * @apiDescription  角色 1.条件查询 条件可以为空 为空时返回所有condition：{ search ：code or name }
     * @apiGroup Role
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
     * http://api.demo.com/api/role/list?page=2&rows=10&beginDate=2017-09-10 23:15:09&endDate=2017-09-10 23:15:09&name=客服
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Role的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":[
    {"id":null,"officeId":null,"name":null,"enname":null,"roleType":null,"dataScope":null,
    "isSys":null,"useable":null,"createBy":null,"createDate":null,"updateBy":null,"updateDate":null,
    "remarks":null,"delFlag":null}
    ]
    }
     *
     */
    @RequestMapping("list")
//    @RequiresPermissions("sys:role:view")
    public RetObject list(SysRole sysRole) {

        List<SysRole> roleList = roleService.findList(sysRole);

        Map<String,Object> retMap=new HashMap<String, Object>();

        retMap.put("pageInfo", new PageInfo<SysRole>(roleList));
        retMap.put("queryParam", sysRole);
        retMap.put("page", sysRole.getPage());
        retMap.put("rows", sysRole.getRows());

        List<SysRole> list=roleService.findList(sysRole);
        return RetObject.genSuccess("成功",retMap);
    }


    /**
     *
     * @api {view} /api/role/view
     * @apiDescription 角色 查看 1.通过roleid 获取角色权限
     * @apiGroup Role
     * @apiName view
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id  主键(条件)
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/role/view/1
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Role的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data": [
    {"id":null,"officeId":null,"name":null,"enname":null,"roleType":null,"dataScope":null,
    "isSys":null,"useable":null,"createBy":null,"createDate":null,"updateBy":null,"updateDate":null,
    "remarks":null,"delFlag":null}
    ]
    }
     *
     */
    @RequestMapping(value = "view/{id}")
//    @RequiresPermissions("sys:role:view")
    public RetObject view(@PathVariable String id) {
        SysRole sysRole=roleService.getById(id);
        return RetObject.genSuccess("成功",sysRole);
    }


    /**
     *
     * @api {delete} /api/role/delete
     * @apiDescription 角色 删除1.通过Id删除数据,2.通过id数组 批量删除数据
     * @apiGroup Role
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
//    @RequiresPermissions("sys:role:delete")
    public RetObject delete(@PathVariable String id, RedirectAttributes ra) throws BizErrorException {
        SysRole sysRole=new SysRole();
        sysRole.setId(id);
        roleService.deleteByIdWithFlag(sysRole);
        return RetObject.genSuccess("删除成功",null);
    }

    /**
     *
     * @api {save} /api/role/save
     * @apiDescription 角色 1.新增数据  2.通过roleId 修改角色权限
     * @apiGroup Role
     * @apiName save
     * @apiVersion 1.0.0
     * @apiParam {String} id  仅更新传
     * @apiParam {String} officeId 归属机构
     * @apiParam {String} remarks 描述
     *
     * @apiExample {curl} 访问示例：
     *
     *增加 http://api.demo.com/api/role/save
     *编辑 http://api.demo.com/api/role/save
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回Role的对象数组
     * @apiSuccessExample {json} Success-Response:
    {
    "retCode": 0000,
    "retMsg": 成功,
    "data":null
    }
     *
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
//    @RequiresPermissions("sys:role:edit")
    public RetObject save(@Valid SysRole sysRole,BindingResult bindingResult, HttpServletRequest request) throws BizErrorException, BeanValidException {
        //如果有校验不通过信息，则返回校验出错信息
        beanValidator(bindingResult);

        String msg="";
        if(sysRole.getOpFlag().equals(BaseEntity.OpFlag.add)) {
            msg="新增成功";
        }else if (sysRole.getOpFlag().equals(BaseEntity.OpFlag.update)) {
            msg="修改成功";
        }else{
            msg="请传送操作标志";
            return RetObject.genBizErr(msg,null);
        }

        this.roleService.save(sysRole);
        return RetObject.genSuccess(msg,null);
    }
}
