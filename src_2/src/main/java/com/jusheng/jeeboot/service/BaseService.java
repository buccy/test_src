package com.jusheng.jeeboot.service;

import com.jusheng.jeeboot.entity.BaseEntity;
import com.jusheng.jeeboot.system.BaseMapper;
import com.jusheng.jeeboot.system.LoginedUser;
import com.jusheng.jeeboot.system.exception.BizErrorException;
import com.jusheng.jeeboot.web.sys.LoginController;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.UUID;

/**
 * 基础Service
 */
public class BaseService<M extends BaseMapper,T extends BaseEntity> {

    @Autowired
    protected M dao;

    public void save(T t) throws BizErrorException {

        //通过反射设置create_by,create_date,update_by.update_date的字段，没有的会自动省略
        setCreateByAndUpdateBy(t);

        if (t.getOpFlag().equals(BaseEntity.OpFlag.add)) {
            t.setId(UUID.randomUUID().toString().replace("-",""));
            dao.insertSelective(t);
        } else if(t.getOpFlag().equals(BaseEntity.OpFlag.update)) {
            dao.updateByPrimaryKeySelective(t);
        }
    }

    public T getById(String id) {
        return (T)dao.selectByPrimaryKey(id);
    }

    /**
     * 硬删除
     * @param id
     * @return
     */
    public int deleteById(String id) {
        return dao.deleteByPrimaryKey(id);
    }

    /**
     * 软删除，只置del_flag=1,并不真正删除数据，只有含有del_flag的表才可以用，否则报错
     * @param id
     * @return
     */
    public int deleteByIdWithFlag(T t) throws BizErrorException {
        //通过反射设置del_flag的值为1，如果没有这个字段，则更新失败
        Class clazz=t.getClass();
        Field field= null;
        try {
            field = clazz.getDeclaredField("delFlag");

            field.setAccessible(true);
            try {
                field.set(t,"1");
            } catch (IllegalAccessException e) {

            }
        } catch (NoSuchFieldException e) {
            throw new BizErrorException("该表不支持软删除，请检查del_flag");
        }

        //更新表
        return dao.updateByPrimaryKeySelective(t);
    }

    /**
     * 通过反射设置create_by,create_date,update_by.update_date的字段，没有的会自动省略
     * @param t
     */
    private void setCreateByAndUpdateBy(T t){

        Class clazz=t.getClass();
        Field field= null;

        try {
            if (t.getOpFlag().equals(BaseEntity.OpFlag.add)) {
                field = clazz.getDeclaredField("createBy");
                field.setAccessible(true);
                try {
                    if(LoginedUser.getCurrentUser()==null) {
                        field.set(t, "1");
                    }else{
                        field.set(t, LoginedUser.getCurrentUser().getId());
                    }
                } catch (Exception e) {

                }
                field = clazz.getDeclaredField("createDate");
                field.setAccessible(true);
                try {
                    field.set(t, new Date());
                } catch (Exception e) {

                }
            }

            field = clazz.getDeclaredField("updateBy");
            field.setAccessible(true);
            try {
                if(LoginedUser.getCurrentUser()==null) {
                    field.set(t, "1");
                }else{
                    field.set(t, LoginedUser.getCurrentUser().getId());
                }
            } catch (Exception e) {

            }

            field = clazz.getDeclaredField("updateDate");
            field.setAccessible(true);
            try {
                field.set(t, new Date());
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
    }
}
