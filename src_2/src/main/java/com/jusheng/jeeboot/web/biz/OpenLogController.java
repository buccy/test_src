package com.jusheng.jeeboot.web.biz;

import com.jusheng.jeeboot.entity.SysUser;
import com.jusheng.jeeboot.system.RetObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 开箱操作
 */
@RestController
@RequestMapping("/api/openLog")
public class OpenLogController {
    @RequestMapping("list")
    @RequiresPermissions("biz:openLog:view")
    public RetObject list(SysUser sysUser) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("pageInfo", new PageInfo<Country>(countryList));
//        map.put("queryParam", country);
//        map.put("page", country.getPage());
//        map.put("rows", country.getRows());

        return RetObject.genSuccess("成功了",retMap);
    }

    @RequestMapping(value = "view/{id}")
    @RequiresPermissions("sys:openLog:view")
    public RetObject view(@PathVariable Integer id) {
        Map<String,Object> retMap=new HashMap<String, Object>();
//        map.put("record",sysArea);
        return RetObject.genSuccess("成功了",retMap);
    }


}
