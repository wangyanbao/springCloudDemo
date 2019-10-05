package com.wangyanbao.user.mapper;/**
 * Created by ASUS on 2019/10/5.
 */

import com.github.pagehelper.Page;
import com.wangyanbao.user.pojo.Admin;
import com.wangyanbao.user.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王彦宝
 * @description 管理员数据访问
 * @date 2019/10/511:06
 */
public interface AdminMapper {


    void insert(Admin admin);

    List<Admin> findAll();

    Page<Admin> findByPage();

    Admin findByLoginname(@Param("loginname") String loginname);

    void deleteAById(@Param("Id") String Id);
}
