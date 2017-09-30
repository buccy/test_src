package com.jusheng.jeeboot.web.sys;

import com.jusheng.jeeboot.entity.SysDict;
import com.jusheng.jeeboot.entity.SysLog;
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
@RequestMapping("/api/sysLog")
public class LogController {
    @RequestMapping("list")
    @RequiresPermissions("sys:log:view")
    public RetObject list(SysLog sysLog) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("pageInfo", new PageInfo<Country>(countryList));
//        map.put("queryParam", country);
//        map.put("page", country.getPage());
//        map.put("rows", country.getRows());

        return RetObject.genSuccess("成功了",retMap);
    }

    @RequestMapping(value = "view/{id}")
    @RequiresPermissions("sys:log:view")
    public RetObject view(@PathVariable Integer id) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("record",sysArea);
        return RetObject.genSuccess("成功了",retMap);
    }


    @RequestMapping(value = "delete/{id}")
    @RequiresPermissions("sys:log:delete")
    public RetObject delete(@PathVariable Integer id, RedirectAttributes ra) {

        return RetObject.genSuccess("删除成功",null);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @RequiresPermissions("sys:log:edit")
    public RetObject save(SysLog sysLog) {


        return RetObject.genSuccess("新增/保存成功",null);
    }
}
