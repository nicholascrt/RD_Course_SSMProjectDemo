package com.softeem.dto.requestDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @project_name: com.softeem.dao.requestDTO
 * @description:
 * @author: Nicholas Chen
 * @time: 18/02/2021 4:57 PM
 * @version: v1.0
 */

/**
 * 1. 当清酒数据前有SpringMVC的@RequestBody，用于封装请求的数据，常用属性有description
 * 2. 当相应数据被SpringMVC的@ResponseBody修饰，用于对放回对象的描述
 */
@ApiModel(description = "登录请求的DTO")
public class LoginRequestDTO implements Serializable {

    private static final long serialVersionUID = 6123862434504850517L;

    //用户名
    @ApiModelProperty(value = "用户名",required = true,example = "13100000001")
    private String userName;

    //密码
    @ApiModelProperty(value = "密码",required = true,example = "123456")
    private String password;

    //判断是否需要输入验证码
    @ApiModelProperty(value = "是否需要输入验证码",required = false,example = "false",hidden = true)
    private Boolean needVerify;

    //用户输入的验证码
    @ApiModelProperty(value = "用户输入的验证码",required = false,hidden = true)
    private String verificationCode;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getNeedVerify() {
        return needVerify;
    }

    public void setNeedVerify(Boolean needVerify) {
        this.needVerify = needVerify;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
