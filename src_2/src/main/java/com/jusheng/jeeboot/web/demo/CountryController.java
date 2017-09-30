/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.jusheng.jeeboot.web.demo;

import com.jusheng.jeeboot.entity.BaseEntity;
import com.jusheng.jeeboot.entity.demo.Country;
import com.jusheng.jeeboot.service.demo.CountryService;
import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.system.SysCode;
import com.github.pagehelper.PageInfo;
import com.jusheng.jeeboot.system.exception.BizErrorException;
import com.jusheng.jeeboot.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author liuzh
 * @since 2015-12-19 11:10
 */
@RestController
@RequestMapping("/demo/countries")
public class CountryController extends BaseController{
    @Autowired
    CountryService countryService;

    @RequestMapping("list")
    @ResponseBody
    public RetObject list(Country country) {
        List<Country> countryList = countryService.getAll(country);

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageInfo", new PageInfo<Country>(countryList));
        map.put("queryParam", country);
        map.put("page", country.getPage());
        map.put("rows", country.getRows());

        return RetObject.genRetObject(SysCode.RET_Succ,messageSource.getMessage("common.success",null,locale),map);
    }

    @RequestMapping(value = "view/{id}")
    @ResponseBody
    public RetObject view(@PathVariable String id) {
        Country country = countryService.getById(id);
        return RetObject.genRetObject(SysCode.RET_Succ,"获取成功",country);
    }

    @RequestMapping(value = "delete/{id}")
    public RetObject deleteByJson(@PathVariable String id, RedirectAttributes ra) {
        countryService.deleteById(id);
        return RetObject.genRetObject(SysCode.RET_Succ,"删除成功",null);
    }

    //根据id是否为空来判断增加成功还是更新成功
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public RetObject save(Country country) throws BizErrorException {

        String msg="";
        if(country.getOpFlag().equals(BaseEntity.OpFlag.add)) {
            msg="新增成功";
        }else if (country.getOpFlag().equals(BaseEntity.OpFlag.update)) {
            msg="修改成功";
        }else{
            msg="请传送操作标志";
            return RetObject.genBizErr(msg,null);
        }

        this.countryService.save(country);
        return RetObject.genSuccess("成功",null);
    }

//    //根据id是否为空来判断增加成功还是更新成功
//    @RequestMapping(value = "deleteBatch", method = RequestMethod.POST)
//    public RetObject deleteBatch(Country country) {
//
//
//    }

}
