package jdbc.demo;

import java.util.List;
import jdbc.dao.userManager;
import jdbc.pojo.detail;


public class demo2 {
    public static void main(String[] args){
        userManager um=new userManager();

        //查询数据库内所有用户
        List<detail> alluser = um.getAll();
        System.out.println(alluser);

        detail man=um.getman("01");
        System.out.println(man);
        //注册用户（会输出添加前有多少个用户）
        //public boolean userReg(String name,String password,String loc,String tel,String pay,String pro,String isadmin)
        //um.reg("bot","1234","earth","114514",1000,1,1);
        //boolean a=um.login("02","test");\
        boolean a=um.go("update user set isadmin=-2 where id=2020006");
        System.out.println(a);

        //查看所有用户中有没有添加新注册的用户
        //alluser = um.getAll();
        //System.out.println(alluser);
    }
}
