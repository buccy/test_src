package com.jusheng.jeeboot.web.biz;

import com.github.pagehelper.PageInfo;
import com.jusheng.jeeboot.entity.BizLine;
import com.jusheng.jeeboot.service.biz.LineService;
import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.system.SysCode;
import com.jusheng.jeeboot.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jusheng.jeeboot.entity.BaseEntity;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 线路
 */
@RestController
@RequestMapping("/api/line")
public class LineController extends BaseController {
    @Autowired
    LineService lineService;
    @RequestMapping("list")
//    @RequiresPermissions("biz:line:view")
    public RetObject list(BizLine bizLine) {
        List<BizLine> bizLineList = lineService.findList(bizLine);

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageInfo", new PageInfo<BizLine>(bizLineList));
        map.put("queryParam", bizLine);
        map.put("page", bizLine.getPage());
        map.put("rows", bizLine.getRows());

        return RetObject.genRetObject(SysCode.RET_Succ,messageSource.getMessage("common.success",null,locale),map);
    }

    @RequestMapping(value = "view/{id}")
//    @RequiresPermissions("sys:line:view")
    public RetObject view(@PathVariable String id) {
        BizLine bizLine=lineService.getById(id);
        return RetObject.genSuccess("成功",bizLine);
    }


    @RequestMapping(value = "delete/{id}")
//    @RequiresPermissions("sys:line:edit")
    public RetObject delete(@PathVariable String id, RedirectAttributes ra) {

        lineService.deleteById(id);
        return RetObject.genRetObject(SysCode.RET_Succ,"删除成功",null);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
//    @RequiresPermissions("sys:line:edit")
    public RetObject save(BizLine bizLine) {

        String msg="";
        if(bizLine.getOpFlag().equals(BaseEntity.OpFlag.add)) {
            msg="新增成功";
        }else if (bizLine.getOpFlag().equals(BaseEntity.OpFlag.update)) {
            msg="修改成功";
        }else{
            msg="请传送操作标志";
            return RetObject.genBizErr(msg,null);
        }

//        this.lineService.save(bizLine);
        return RetObject.genSuccess("成功",null);
    }


}
