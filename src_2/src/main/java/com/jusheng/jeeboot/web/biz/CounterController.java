package com.jusheng.jeeboot.web.biz;

import com.jusheng.jeeboot.entity.BizCounter;
import com.jusheng.jeeboot.entity.SysArea;
import com.jusheng.jeeboot.system.RetObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * 指标设置
 */
@RestController
@RequestMapping("/api/counter")
public class CounterController {


    @RequestMapping("list")
    public RetObject list(BizCounter bizCounter) {
        Map<String,Object> retMap=new HashMap<String, Object>();

        return RetObject.genSuccess("成功了",retMap);
    }

    @RequestMapping(value = "view/{id}")
    public RetObject view(@PathVariable Integer id) {
        Map<String,Object> retMap=new HashMap<String, Object>();

        return RetObject.genSuccess("成功了",retMap);
    }

    @RequestMapping(value = "delete/{id}")
    public RetObject delete(@PathVariable Integer id, RedirectAttributes ra) {

        return RetObject.genSuccess("删除成功",null);
    }


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public RetObject save(SysArea sysArea) {

        return RetObject.genSuccess("新增/更新/保存成功",null);
    }


}
