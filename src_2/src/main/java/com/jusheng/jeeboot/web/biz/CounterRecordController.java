package com.jusheng.jeeboot.web.biz;

import com.jusheng.jeeboot.system.RetObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当前指标采集，历史指标采集
 */
@RestController
@RequestMapping("/api/counterRecord")
public class CounterRecordController {
    @RequestMapping("listCurrent")
    @RequiresPermissions("biz:counter:view")
    public RetObject listCurrent(){
        return null;
    }

    @RequestMapping("viewCurrent")
    @RequiresPermissions("biz:counter:view")
    public RetObject viewCurrent(){
        return null;
    }

    @RequestMapping("listHistory")
    @RequiresPermissions("biz:counter:view")
    public RetObject listHistory(){
        return null;
    }

    @RequestMapping("viewHistory")
    @RequiresPermissions("biz:counter:view")
    public RetObject viewHistory(){
        return null;
    }
}
