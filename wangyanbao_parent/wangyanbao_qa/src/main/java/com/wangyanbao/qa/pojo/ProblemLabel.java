package com.wangyanbao.qa.pojo;/**
 * Created by ASUS on 2019/10/4.
 */

import java.io.Serializable;

/**
*   @author   王彦宝
*   @description 关联表
*   @date 2019/10/417:00
*/
public class ProblemLabel implements Serializable {

    private String problemid;
    private String labelid;

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }
}
