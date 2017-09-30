package com.jusheng.jeeboot.web.biz;

import com.jusheng.jeeboot.entity.BizWorker;
import com.jusheng.jeeboot.system.RetObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-9-24.
 */
@RestController
@RequestMapping("api/worker")
public class WorkerController {

    /**
     *
     * @api {get} /api/worker/list
     * @apiDescription 获取员工信息
     * @apiGroup Worker
     * @apiName list
     * @apiVersion 1.0.0
     *
     * @apiParam {String} page 第几页
     * @apiParam {String} rows 每页总共记录数
     * @apiParam {String} name 姓名
     *
     * @apiExample {curl} 访问示例：
     * http://api.demo.com/api/menu/list?page=2&rows=10&name=Kami
     *
     * @apiSuccess {String} retCode 返回结果码
     * @apiSuccess {String} retMsg 返回处理信息
     * @apiSuccess {Object[]} data 返回数据
     * @apiSuccessExample {json} Success-Response:
     *  {
        "retCode": 0000,
        "retMsg": 成功,
        "data": [
            {"id":null,"name":null,"phone":null,"line":null,"status":null,"email":null,"areaId":null,"regionId":null,"officeId":null,"remark":null,"bizRegion":null,"admin":false},
            {"id":null,"name":null,"phone":null,"line":null,"status":null,"email":null,"areaId":null,"regionId":null,"officeId":null,"remark":null,"bizRegion":null,"admin":false}
        ]
        }
     *
     */
    @RequestMapping("list")
    public RetObject list(BizWorker bizWorker) {
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
    public RetObject save(BizWorker bizWorker) {

        return RetObject.genSuccess("新增/更新/保存成功",null);
    }
}
