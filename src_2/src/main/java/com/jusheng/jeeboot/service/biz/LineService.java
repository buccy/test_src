package com.jusheng.jeeboot.service.biz;

import com.jusheng.jeeboot.dao.BizLineMapper;
import com.jusheng.jeeboot.entity.BizLine;
import com.jusheng.jeeboot.service.BaseService;
import com.jusheng.jeeboot.system.exception.BizErrorException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class LineService extends BaseService<BizLineMapper,BizLine> {
    public List<BizLine> findList(BizLine bizLine){
        return this.dao.findList(bizLine);
    }
    public void save(BizLine bizLine) throws BizErrorException {
        Example example = new Example(BizLine.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(bizLine.getName())) {
            criteria.andEqualTo("name", bizLine.getName());
        }
        if (!StringUtils.isEmpty(bizLine.getOfficeId())) {
            criteria.andEqualTo("officeId",bizLine.getOfficeId());
        }

        List<BizLine> sysRoleList=this.dao.selectByExample(example);

        if(sysRoleList.size()>0) throw new BizErrorException("已经有相同名称的角色，新增失败");

        super.save(bizLine);
    }
}
