package test;

import java.sql.*;

public class MySqlOperation {


    public static void main ( String[] args ) {
        findAll( );
        finduserByname_password( "hhh", "123" );
    }

    public static void findAll ( ) {        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;

        // 第一 二 四 步( 查询版和更新版 只执行一次 )
        // 第三步 写到子类的 UserDao


        // 第一步 加载类驱动
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace( );
        }

        try {
            // 第二步 创建数据库连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://acmaker.vip:3306/myJava_BookSystem?userUnicode=true&characterEncodeing=utf8",
                    "javaUser",
                    "java"
            );
            // 第三步 定义 SQL语句， 创建执行 SQL 语句的对象，给 SQL 语句中的问号复制
            final String sql = "select * from userdetail ";
//            final String sql = "select * from userdetail ";

            pstmt = conn.prepareStatement( sql );
            // 给 SQL 语句中的问号赋值
//            pstmt.setString( 1, "hhh" );
            // 第四步 得到查询结果集
            rs = pstmt.executeQuery();
            // 第五步 遍历结果集并输出
            while ( rs.next() ) {
                // 输出 rs 的各个字段的值
                System.out.println(
                        rs.getString( "userName" ) +
                                rs.getString( "userPass" ) +
                                rs.getInt( "role" ) +
                                rs.getString( "regTime") +
                                rs.getInt( "lognum" )
                );
            }

        } catch ( SQLException e ) {
            e.printStackTrace( );
        } finally {
            // 第六步 关闭数据库
            if ( rs!=null ) {
                try {
                    rs.close();
                } catch ( SQLException e ) {
                    e.printStackTrace( );
                }
            }
            if ( pstmt!=null ) {

                try {
                    rs.close();
                } catch ( SQLException e ) {
                    e.printStackTrace( );
                }
            }
            if ( conn!=null ) {
                try {
                    rs.close();
                } catch ( SQLException e ) {
                    e.printStackTrace( );
                }
            }
        }
    }

    public static void finduserByname_password( String name, String pwd) {

        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;

        // 第一 二 四 步( 查询版和更新版 只执行一次 )
        // 第三步 写到子类的 UserDao


        // 第一步 加载类驱动
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace( );
        }

        try {
            // 第二步 创建数据库连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://acmaker.vip:3306/myJava_BookSystem?userUnicode=true&characterEncodeing=utf8",
                    "javaUser",
                    "java"
            );
            // 第三步 定义 SQL语句， 创建执行 SQL 语句的对象，给 SQL 语句中的问号复制
            final String sql = "select * from userdetail where username = ? and userpass = ?";
//            final String sql = "select * from userdetail ";

            pstmt = conn.prepareStatement( sql );
            // 给 SQL 语句中的问号赋值
            pstmt.setString( 1, name );
            pstmt.setString( 2, pwd );
            // 第四步 得到查询结果集
            rs = pstmt.executeQuery();
            // 第五步 遍历结果集并输出
            while ( rs.next() ) {
                System.out.println( "Find Successfully ! " );
                // 输出 rs 的各个字段的值
                System.out.println(
                        rs.getString( "userName" ) +
                                rs.getString( "userPass" ) +
                                rs.getInt( "role" ) +
                                rs.getString( "regTime") +
                                rs.getInt( "lognum" )
                );
            }

        } catch ( SQLException e ) {
            e.printStackTrace( );
        } finally {
            // 第六步 关闭数据库
            if ( rs!=null ) {
                try {
                    rs.close();
                } catch ( SQLException e ) {
                    e.printStackTrace( );
                }
            }
            if ( pstmt!=null ) {

                try {
                    rs.close();
                } catch ( SQLException e ) {
                    e.printStackTrace( );
                }
            }
            if ( conn!=null ) {
                try {
                    rs.close();
                } catch ( SQLException e ) {
                    e.printStackTrace( );
                }
            }
        }
    }




}
