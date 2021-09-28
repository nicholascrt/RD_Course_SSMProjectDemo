package com.softeem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @project_name: com.softeem.controller
 * @description: Controller控制器基类
 * @author: Nicholas Chen
 * @time: 19/02/2021 4:15 PM
 * @version: v1.0
 */
public class BaseController {

    @Autowired
    protected HttpServletRequest request;
}
