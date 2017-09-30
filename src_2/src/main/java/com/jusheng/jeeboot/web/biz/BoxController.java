package com.jusheng.jeeboot.web.biz;

import com.jusheng.jeeboot.entity.BizBox;
import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.web.BaseController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * 冷链箱
 */
@RestController
@RequestMapping("/api/box")
public class BoxController extends BaseController{

    @RequestMapping("list")
    public RetObject list(BizBox bizBox) {
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
    public RetObject save(BizBox bizBox) {

        return RetObject.genSuccess("新增/更新/保存成功",null);
    }

    /**
     * 获取设备的最近状态，温湿度，倾斜度，电量，信号
     * @param bizBox
     * @return
     */
    @RequestMapping(value = "getBoxStatus", method = RequestMethod.POST)
    public RetObject getBoxStatus(BizBox bizBox) {

        return RetObject.genSuccess("新增/更新/保存成功",null);
    }

}
