package com.wangyanbao.recruit.service;/**
 * Created by ASUS on 2019/10/4.
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wangyanbao.recruit.mapper.RecruitMapper;
import com.wangyanbao.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
*   @author   王彦宝
*   @description 位置业务
*   @date 2019/10/416:33
*/
@Service
public class RecruitService {

    @Autowired
    private RecruitMapper recruitMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;


    public void save(Recruit recruit) {
        recruit.setId(idWorker.nextId()+"");
        recruitMapper.insert(recruit);
    }

    public List<Recruit> findAll() {
        return recruitMapper.findAll();
    }


    public Page<Recruit> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return recruitMapper.findByPage();
    }

    public Recruit findAById(String Id) {
        Recruit recruit= (Recruit)redisTemplate.opsForValue().get("Label_"+Id);
        if(null ==recruit){
            recruit=recruitMapper.findById(Id);
            redisTemplate.opsForValue().set("Label_"+Id,recruit);
        }
        return recruit;
    }

    public void deleteAById(String Id) {
        redisTemplate.delete("Label_"+Id);
        recruitMapper.deleteAById(Id);
    }

    public void update(Recruit label) {
        redisTemplate.delete("Label_"+label.getId());
    }
}
