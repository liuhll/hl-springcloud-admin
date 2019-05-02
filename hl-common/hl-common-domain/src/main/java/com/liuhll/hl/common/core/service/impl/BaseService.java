package com.liuhll.hl.common.core.service.impl;

import com.liuhll.hl.common.auth.runtime.session.HlContextSession;
import com.liuhll.hl.common.constant.CommonConstants;
import com.liuhll.hl.common.core.domain.auditing.ICreationAudited;
import com.liuhll.hl.common.core.domain.auditing.IDeletionAudited;
import com.liuhll.hl.common.core.domain.auditing.IModificationAudited;
import com.liuhll.hl.common.core.domain.auditing.ISoftDelete;
import com.liuhll.hl.common.exception.UserFriendlyException;
import com.liuhll.hl.common.core.service.IService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Data
public abstract class BaseService<M extends Mapper<T>, T>  implements IService<T> {

    @Autowired
    protected M mapper;

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(T entity) {
        if (entity instanceof ISoftDelete){
            ((ISoftDelete)entity).setIsDeleted(CommonConstants.UN_DELETE_FLAGE);
        }
        if (entity instanceof ICreationAudited){
            ((ICreationAudited)entity).setCreateBy(Long.parseLong(HlContextSession.getUserId()));
            ((ICreationAudited)entity).setCreateTime(new Date());
        }
        return mapper.insert(entity);
    }

    @Override
    public int delete(Object key) {
        T entity =mapper.selectByPrimaryKey(key);
        if (entity == null){
            throw new UserFriendlyException("不存在Id为".concat(key.toString()).concat("的记录"));
        }
        if (entity instanceof IDeletionAudited){
            ((IDeletionAudited)entity).setDeleteBy(Long.parseLong(HlContextSession.getUserId()));
            ((IDeletionAudited)entity).setDeleteTime(new Date());
        }
        return mapper.deleteByPrimaryKey(entity);
    }

    @Override
    public int batchDelete(List<String> list, String property, Class<T> clazz) {
        Example example = new Example(clazz);
        example.createCriteria().andIn(property, list);
        return this.mapper.deleteByExample(example);
    }

    @Override
    public int update(T entity) {
        if (entity instanceof IModificationAudited){
            ((IModificationAudited)entity).setUpdateBy(Long.parseLong(HlContextSession.getUserId()));
            ((IModificationAudited)entity).setUpdateTime(new Date());
        }
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(T entity) {
        if (entity instanceof IModificationAudited){
            ((IModificationAudited)entity).setUpdateBy(Long.parseLong(HlContextSession.getUserId()));
            ((IModificationAudited)entity).setUpdateTime(new Date());
        }
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }


}
