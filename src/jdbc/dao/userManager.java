package jdbc.dao;

import jdbc.pojo.detail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userManager extends daoBas {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    private PreparedStatement ps2;
    private ResultSet rs2;
    //查询所有对象
    public List<detail> getAll(){
        //创建连接对象
        conn = getConnection();
        //创建sql语句
        String sqlStr = "select * from user where isadmin=0";

        try {
            //创建数据库操作对象
            ps = conn.prepareStatement(sqlStr);
            //执行数据库操作
            rs = ps.executeQuery();
            //创建用户数据保存集合
            List<detail> userList = new ArrayList<>();
            //遍历获取查询数据并封装到对象里
            while(rs.next()) {
                detail user = new detail();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setLoc(rs.getString("loc"));
                user.setTel(rs.getString("tel"));
                user.setPay(rs.getInt("pay"));
                user.setPro(rs.getString("pro"));
                user.setIsadmin(rs.getInt("isadmin"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<detail> search(String str){
        //创建连接对象
        conn = getConnection();
        //创建sql语句
        String sqlStr = str;

        try {
            //创建数据库操作对象
            ps = conn.prepareStatement(sqlStr);
            //执行数据库操作
            rs = ps.executeQuery();
            //创建用户数据保存集合
            List<detail> userList = new ArrayList<>();
            //遍历获取查询数据并封装到对象里
            while(rs.next()) {
                detail user = new detail();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setLoc(rs.getString("loc"));
                user.setTel(rs.getString("tel"));
                user.setPay(rs.getInt("pay"));
                user.setPro(rs.getString("pro"));
                user.setIsadmin(rs.getInt("isadmin"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //通过id获取人信息
    public detail getman(String id) {
        //创建sql语句
        String sqlStr = "select * from user where id=?";
        try {
            //创建连接对象    sql注入
            conn = getConnection();
            //创建数据库操作对象
            ps = conn.prepareStatement(sqlStr);
            //给数据库操作对象赋值
            ps.setString(1, id);
            //执行数据库操作
            rs = ps.executeQuery();
            detail alluser = null;
            //遍历获取查询数据并封装到对象里
            if(rs.next()) {
                alluser = new detail();
                alluser.setId(rs.getString("id"));
                alluser.setName(rs.getString("name"));
                alluser.setPassword(rs.getString("password"));
                alluser.setLoc(rs.getString("loc"));
                alluser.setTel(rs.getString("tel"));
                alluser.setPay(rs.getInt("pay"));
                alluser.setPro(rs.getString("pro"));
                alluser.setIsadmin(rs.getInt("isadmin"));
            }
            System.out.println("ok了");
            return alluser;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //注册
    public String reg(String name,String password,String loc,String tel,int pay,String pro,int isadmin) {
        //创建sql语句
        String sqlStr = "insert into user (id,name,password,loc,tel,pay,pro,isadmin) values (?,?,?,?,?,?,?,?)";
        String sqlcount="select count(*) as cnt from user";
        try {
            //创建连接对象
            conn = getConnection();
            //创建数据库操作对象
            ps2=conn.prepareStatement(sqlcount);
            rs2=ps2.executeQuery();
            String aa="";
            if(rs2.next()){
                aa=rs2.getString("cnt");
                System.out.println(aa);
            }
            int temp=Integer.parseInt( aa );

            ps = conn.prepareStatement(sqlStr);
            //给数据库操作对象赋值
            aa=String.format("%03d",temp);
            ps.setString(1,"2020"+aa);
            ps.setString(2, name);
            ps.setString(3, password);
            ps.setString(4, loc);
            ps.setString(5, tel);
            ps.setInt(6, pay);
            ps.setString(7, pro);
            ps.setInt(8, isadmin);
            //执行数据库操作
            if(ps.executeUpdate()>0){
                return "2020"+aa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //修改
    public boolean fix(String id,String name,String password,String loc,String tel,int pay,String pro,int isadmin) {
        //创建sql语句
        String sqlStr = "update user set name=?,password=?,loc=?,tel=?,pay=?,pro=?,isadmin=? where id=?;";
        try {
            //创建连接对象
            conn = getConnection();
            //创建数据库操作对象
            ps = conn.prepareStatement(sqlStr);
            //给数据库操作对象赋值
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, loc);
            ps.setString(4, tel);
            ps.setInt(5, pay);
            ps.setString(6, pro);
            ps.setInt(7, isadmin);
            ps.setString(8,id);
            //执行数据库操作
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int now() {
        //创建sql语句
        String sqlStr = "select * from world";
        try {
            //创建连接对象    sql注入
            conn = getConnection();
            //创建数据库操作对象
            ps = conn.prepareStatement(sqlStr);
            rs = ps.executeQuery();
            //遍历获取查询数据并封装到对象里
            int nownow = 0;
            if(rs.next()) {
                nownow=rs.getInt("myday");
            }
            System.out.println("time");
            return nownow;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean timefix() {
        //创建sql语句
        String sqlStr = "update world set myday=myday+1 where id=1";
        try {
            //创建连接对象    sql注入
            conn = getConnection();
            //创建数据库操作对象
            ps = conn.prepareStatement(sqlStr);
            if(ps.executeUpdate()>0){
                return true;
            }
            System.out.println("timefix");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int dayevent(int now,String id) {
        //创建sql语句
        String sqlStr = "insert into dayevent (dayday,id,isover) values (?,?,1)";
        String sqlcount="select count(*) as cnt from dayevent where dayday=?";
        try {
            //创建连接对象
            conn = getConnection();

            ps=conn.prepareStatement(sqlcount);
            ps.setInt(1,now);
            rs=ps.executeQuery();
            String aa="";
            if(rs.next()){
                aa=rs.getString("cnt");
                System.out.println(aa);
            }
            int temp=Integer.parseInt( aa );

            ps2 = conn.prepareStatement(sqlStr);
            //给数据库操作对象赋值
            System.out.println(now);
            System.out.println(id);
            ps2.setInt(1,now);
            ps2.setString(2, id);
            //执行数据库操作
            if(ps2.executeUpdate()>0){
                System.out.println("tttttt");
                return temp;
            }
        } catch (SQLException e) {
            System.out.println("bad");
            e.printStackTrace();
        }
        return -1;
    }


    public boolean isover(int now,String id) {
        //创建sql语句
        String sqlcount="select count(*) as cnt from dayevent where dayday=? and id=?";
        try {
            //创建连接对象
            conn = getConnection();
            System.out.println("now:"+now+" id:"+id);
            ps=conn.prepareStatement(sqlcount);
            ps.setInt(1,now);
            ps.setString(2,id);
            rs=ps.executeQuery();
            String aa="";
            if(rs.next()){
                aa=rs.getString("cnt");
                System.out.println("whatthfuck"+aa);
            }
            int temp=Integer.parseInt( aa );
            if(temp>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            System.out.println("bad");
            e.printStackTrace();
        }
        return false;
    }
    public boolean wantfix(String id,String event,String str,String want) {
        //创建sql语句
        String sqlStr = "insert into act (actid,id,str,want,event,ispass) values (?,?,?,?,?,-1)";
        String sqlcount="select count(*) as cnt from act";
        try {
            //创建连接对象
            conn = getConnection();
            //创建数据库操作对象
            ps=conn.prepareStatement(sqlcount);
            rs=ps.executeQuery();
            String aa="";
            if(rs.next()){
                aa=rs.getString("cnt");
                System.out.println(aa);
            }
            int temp=Integer.parseInt( aa );
            //给数据库操作对象赋值
            aa=String.format("%03d",temp);

            ps = conn.prepareStatement(sqlStr);
            ps.setString(1, "act"+aa);
            ps.setString(2, id);
            ps.setString(3, str);
            ps.setString(4, want);
            ps.setString(5, event);
            //执行数据库操作
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public double dayeventresult() {
        //创建sql语句
        String str1 = "select count(*) as cnt from user where isadmin=0";
        String str2="select count(*) as cnt from dayevent where dayday="+now();
        try {
            //创建连接对象
            conn = getConnection();
            //创建数据库操作对象
            ps=conn.prepareStatement(str1);
            rs=ps.executeQuery();
            String aa="";
            if(rs.next()){
                aa=rs.getString("cnt");
                System.out.println(aa);
            }
            double temp1=Double.parseDouble( aa );

            ps=conn.prepareStatement(str2);
            rs=ps.executeQuery();
            aa="";
            if(rs.next()){
                aa=rs.getString("cnt");
                System.out.println(aa);
            }
            double temp2=Double.parseDouble( aa );
            System.out.println("temp1 "+temp1+"  temp2 "+temp2);
            //给数据库操作对象赋值
            return temp2/temp1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public boolean go(String a) {
        //创建sql语句
        String str1 =a;
        try {
            //创建连接对象
            conn = getConnection();
            //创建数据库操作对象
            ps=conn.prepareStatement(str1);
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


