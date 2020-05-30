package com.qa.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.qa.service.UserDaoService;
import com.qa.service.impl.UserDaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResetUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和id
        String jsonString = request.getParameter("myData");
        JSONObject userObject = JSONObject.parseObject(jsonString);
        int id = userObject.getInteger("id");
        String password = userObject.getString("username");
        //调用service方法，进行用户匹配
        UserDaoService userService = new UserDaoServiceImpl();
        boolean flag = userService.updateUsername(id,password);
        response.getWriter().write(String.valueOf(flag));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
