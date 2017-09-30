package com.jusheng.jeeboot.service.sys;

import com.jusheng.jeeboot.dao.SysRoleMapper;
import com.jusheng.jeeboot.entity.SysRole;
import com.jusheng.jeeboot.service.BaseService;
import com.jusheng.jeeboot.system.exception.BizErrorException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RoleService extends BaseService<SysRoleMapper,SysRole> {
    public List<SysRole> findList(SysRole sysRole){
        return this.dao.findList(sysRole);
    }

    @Override
    public void save(SysRole sysRole) throws BizErrorException {
        Example example = new Example(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(sysRole.getName())) {
            criteria.andEqualTo("name", sysRole.getName());
        }
        if (!StringUtils.isEmpty(sysRole.getOfficeId())) {
            criteria.andEqualTo("officeId",sysRole.getOfficeId());
        }

        List<SysRole> sysRoleList=this.dao.selectByExample(example);

        if(sysRoleList.size()>0) throw new BizErrorException("已经有相同名称的角色，新增失败");

        super.save(sysRole);
    }
}
