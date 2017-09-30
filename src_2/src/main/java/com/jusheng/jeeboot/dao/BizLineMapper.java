package com.jusheng.jeeboot.dao;

import com.jusheng.jeeboot.entity.BizLine;
import com.jusheng.jeeboot.system.BaseMapper;

import java.util.List;

public interface BizLineMapper extends BaseMapper<BizLine> {
    List<BizLine> findList(BizLine bizLine);
}