package com.wangyanbao.user.mapper;/**
 * Created by ASUS on 2019/10/4.
 */

import com.github.pagehelper.Page;
import com.wangyanbao.user.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
*   @author   王彦宝
*   @description 用户数据层
*   @date 2019/10/423:16
*/
public interface  UserMapper {

    void insert(User user);

    List<User> findAll();

    Page<User> findByPage();

    User findBynickname(@Param("nickname") String nickname);

    void deleteAById(@Param("Id") String Id);
}
