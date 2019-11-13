package util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DBUtil {

	private Connection conn = null;
	private PreparedStatement psm = null;
	private ResultSet rs = null;
	private static Properties pr = new Properties( );

	private static String driver;
	static String url;
	static String uname;
	static String pwd;

    /** 静态代码块: 初始化静态变量,
     * 可以看成一个特殊的方法,
     * 没有方法名,
     * 没有参数,
     * 没有返回值,
     * 不能进方法的调用
     * 当类被加载到 JVM 的时候, 静态块开始执行, 只是执行一次
     *
     */
    static  {
//        try {
            // 配置文件的加载和获取只执行一次
//            pr.load( DBUtil.class.getClassLoader().getResourceAsStream( "mysql.properties" ) );
//
//            driver = pr.getProperty( "driver" );
//            url = pr.getProperty("url" );
//            uname = pr.getProperty("username" );
//            pwd = pr.getProperty("password" );

            driver = "mysql-connector-java-5.1.48.jar";
            url = "jdbc:mysql://acmaker.vip/myJava_BookSystem";
            uname = "javaUser";
            pwd = "java";

            //加载 MySQL 的驱动类
            try {
                Class.forName( driver );
            } catch ( ClassNotFoundException e ) {
                e.printStackTrace( );
            }

    //        }catch ( IOException e ) {
    //              e.printStackTrace( );
    //        }

    }

	
	public Connection getConnection ( ) {
        try {
            conn = DriverManager.getConnection( url, uname, pwd );
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        return conn;
    }

    public ResultSet executeQuery ( String preparedSql, String []param ) {
        try {
            psm = conn.prepareStatement( preparedSql );
            if ( param!=null ) {
                // 给 preparedSql 语句中的问号赋值
                for ( int i = 0; i < param.length; ++i ) {
                    psm.setString( i+1, param[i] );
                }
            }
            rs = psm.executeQuery();
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate ( String preparedSql, String []param ) {
        int count = 0; // 更新记录数
        try {
            psm = conn.prepareStatement( preparedSql );
            if ( param!=null ) {
                // 给 preparedSql 语句中的问号赋值
                for ( int i = 0; i < param.length; ++i ) {
                    psm.setString( i+1, param[i] );
                }
            }
            count = psm.executeUpdate();
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        return count;
    }

    public void closeAll ( ) {
        if ( rs != null ) {
            try {
                rs.close( );
            } catch ( SQLException e ) {
                e.printStackTrace( );
            }
        }
        if ( psm!= null ) {
            try {
                psm.close( );
            } catch ( SQLException e ) {
                e.printStackTrace( );
            }

        }
        if ( conn != null ) {
            try {
                conn.close( );
            } catch ( SQLException e ) {
                e.printStackTrace();
            }

        }
    }











































}
