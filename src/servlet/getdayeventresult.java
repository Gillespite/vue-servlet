package servlet;

import com.google.gson.Gson;

import jdbc.dao.userManager;
import jdbc.pojo.detail;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getdayeventresult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        // 设置响应的编码格式
        resp.setContentType("application/json; charset=utf-8");
        // 获取用户输入的用户名
        //String id = req.getParameter("id");
        // 获取用户输入的密码
        // 实例化Gson
        Gson gson = new Gson();
        // 判断是否登录成功
        userManager um=new userManager();
        double man=um.dayeventresult();
        if (man!=-1) {
            // 登录成功则输出提示信息
            String result = gson.toJson(new getdetail_return(1,gson.toJson(man)));
            //传递信息给前台
            resp.getWriter().write(result);
        } else {
            // 登录失败也输出提示信息
            String result = gson.toJson(new getdetail_return(0, "用户名或密码错误"));
            resp.getWriter().write(result);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}

