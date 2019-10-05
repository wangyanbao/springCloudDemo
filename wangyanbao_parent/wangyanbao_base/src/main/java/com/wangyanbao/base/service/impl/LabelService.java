package com.wangyanbao.base.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wangyanbao.base.mapper.LabelsMapper;
import com.wangyanbao.base.pojo.Label;
import com.wangyanbao.base.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
*   @author   王彦宝
*   @description 业务实现层
*   @date 2019/10/218:12
*/
@Service
public class LabelService implements ILabelService{

   @Autowired
    private LabelsMapper labelMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public void save(Label label) {
        label.setId(idWorker.nextId()+"");
        labelMapper.insert(label);
    }

    @Override
    public List<Label> findAll() {
        return labelMapper.findAll();
    }


    @Override
    public Page<Label> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return labelMapper.findByPage();
    }

    @Override
    public Label findAById(String Id) {
        Label label= (Label)redisTemplate.opsForValue().get("Label_"+Id);
        if(null ==label){
            label=labelMapper.findById(Id);
            redisTemplate.opsForValue().set("Label_"+Id,label);
        }
        return label;
    }

    @Override
    public void deleteAById(String Id) {
        redisTemplate.delete("Label_"+Id);
        labelMapper.deleteAById(Id);
    }

    @Override
    public void update(Label label) {
        redisTemplate.delete("Label_"+label.getId());
    }
}
