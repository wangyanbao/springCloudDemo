package com.wangyanbao.recruit.mapper;/**
 * Created by ASUS on 2019/10/4.
 */


import com.github.pagehelper.Page;
import com.wangyanbao.recruit.pojo.Recruit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王彦宝
 * @description 职位数据接口
 * @date 2019/10/416:32
 */
public interface RecruitMapper {

    void insert(Recruit recruit);

    List<Recruit> findAll();

    Page<Recruit> findByPage();

    Recruit findById(@Param("Id") String Id);

    void deleteAById(@Param("Id") String Id);

}
