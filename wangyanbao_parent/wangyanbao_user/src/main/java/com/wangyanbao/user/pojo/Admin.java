package com.wangyanbao.user.pojo;/**
 * Created by ASUS on 2019/10/4.
 */

import java.io.Serializable;

/**
*   @author   王彦宝
*   @description 管理员
*   @date 2019/10/422:43
*/
public class Admin implements Serializable {


    private String id;
    private String loginname;
    private String password;
    private String state;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
