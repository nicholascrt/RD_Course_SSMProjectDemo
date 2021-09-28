package com.softeem.utils;

import com.google.code.kaptcha.Constants;
import com.softeem.dto.requestDTO.LoginRequestDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * @project_name: com.softeem.utils
 * @description: 验证码校验工具类
 * @author: Nicholas Chen
 * @time: 27/01/2021 1:49 AM
 * @version: v1.0
 */
public class VerificationCodeUtil {

    /*
     * @Description 校验验证码
     * @Date 1:50 AM 27/01/2021
     * @Param [request]
     * @return boolean
     */
    public static boolean checkVerificationCode(HttpServletRequest request, String verificationCode){
        /**
         * 1. 获取用户输入的验证码
         * 2. 获取实际生成的验证码
         * 3. 对比两个验证码
         */
        String verificationCodeInput = verificationCode.toUpperCase();
        String verificationCodeActual = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(verificationCodeInput == null || !verificationCodeInput.equals(verificationCodeActual)){
            return false;
        }
        return true;
    }
}
