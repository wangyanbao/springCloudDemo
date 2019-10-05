package com.wangyanbao.base.service;


import com.github.pagehelper.Page;
import com.wangyanbao.base.pojo.Label;

import java.util.List;

/**
 * @author 王彦宝
 * @description 标签接口
 * @date 2019/10/218:11
 */
public interface ILabelService {

     void save(Label label);

     List<Label> findAll();

     Page<Label> findByPage(int pageNo, int pageSize);

     Label findAById(String Id);

     void deleteAById(String Id);

     void update(Label label);
}
