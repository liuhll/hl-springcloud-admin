package com.liuhll.hl.basicdata.service;

import com.liuhll.hl.basicdata.domain.entity.HlDictionary;
import com.liuhll.hl.basicdata.mapper.HlDictionaryMapper;
import com.liuhll.hl.basicdata.vo.dict.CreateDictInput;
import com.liuhll.hl.common.core.service.impl.BaseService;
import com.liuhll.hl.common.exception.BussinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HlDictService extends BaseService<HlDictionaryMapper, HlDictionary> {

    public void saveDict(CreateDictInput input){

        if (input.getParentid() != 0){
            HlDictionary parentDict = mapper.selectByPrimaryKey(input.getParentid());
            if (parentDict == null){
                throw new BussinessException("不存在ParentId为".concat(input.getParentid().toString()).concat("字典记录"));
            }
            if (parentDict.getHaschild() == 0){
                throw new BussinessException("ParentId为" + input.getParentid() + "字典值的记录不允许是子类型");
            }
            if (StringUtils.isEmpty(input.getTypename())){
                input.setTypename(parentDict.getTypename());
            }
        }
        HlDictionary query = new HlDictionary();
        query.setCode(input.getCode());
        HlDictionary exsitDict = mapper.selectOne(query);
        if (exsitDict != null){
            throw new BussinessException("已经存在字典值为".concat(input.getCode()).concat("的记录"));
        }
        HlDictionary entity = new HlDictionary();
        BeanUtils.copyProperties(input,entity);
        save(entity);
    }
}
