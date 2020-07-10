package servlet;

import com.google.gson.Gson;

//import jdbc.*;
import jdbc.dao.userManager;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class dayevent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        // 设置响应的编码格式
        resp.setContentType("application/json; charset=utf-8");
        // 获取用户输入的用户名
        String tempdayday = req.getParameter("now");
        int dayday=Integer.parseInt(tempdayday);
        // 获取用户输入的密码
        String id = req.getParameter("id");
        System.out.println("myid2:"+id);
        // 实例化Gson
        Gson gson = new Gson();
        // 判断是否登录成功
        userManager um = new userManager();

        int temp=um.dayevent(dayday, id);
        if (temp!=-1) {
            String result = gson.toJson(new dayevent_return(1, temp+1));
            //传递信息给前台
            resp.getWriter().write(result);
        } else {
            // 登录失败也输出提示信息
            String result = gson.toJson(new dayevent_return(0, temp));
            resp.getWriter().write(result);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
