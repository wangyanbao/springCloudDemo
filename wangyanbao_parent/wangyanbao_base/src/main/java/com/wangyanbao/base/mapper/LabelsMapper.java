package com.wangyanbao.base.mapper;/**
 * Created by ASUS on 2019/10/2.
 */

import com.github.pagehelper.Page;
import com.wangyanbao.base.pojo.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王彦宝
 * @description 数据接口
 * @date 2019/10/218:12
 */
public interface LabelsMapper {

    void insert(Label label);

    List<Label> findAll();

    Page<Label> findByPage();

    Label findById(@Param("Id") String Id);

    void deleteAById(@Param("Id") String Id);
}
