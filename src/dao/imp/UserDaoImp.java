package dao.imp;

import dao.UserDao;
import entity.User;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp extends DBUtil implements UserDao { // UserDao接口的实现类

    /**
     * books:       isbn/ bookName/ publisherID/ price /count/ description/ pic
     *              Str     Str         int       doubf   int       Str      Str
     * userdetail:  userName/ userPass/ role/ regTime/ logNum
     *              Str         Str     int     Str     int
     */
    private String selectAllUser = "select * from userdetail;";
    private String select_name = "select * from userdetail where 1=1 and username=?";
    private String select_name_password = "select * from userdetail where 1=1 and username=? and userPass=?";

    private String insert = "insert into userdetail values( ?, ?, ? ,?, ? )";

    // 根据用户名修改该用户的登录次数加一
    private String update_namelogNumAddOne = "update userdetail set logNum=logNum+1 where username = ?";
    // 根据用户名修改完整该用户的其他字段值
    private String update_name = "update userdetail set userPass=?, role=?, regTime=?, logNum=? where username=?";

    private String delete_name = "delete from userdetail where username=?";
    private String delete_name_psd = "delete from userdetail where username=?, userPassword=?";




    @Override
    public List<User> findAllUser ( ) {
        List<User> userlist = new ArrayList<User>();

        // 1)
        super.getConnection();
        // 2)
        ResultSet rs = null;
        String []param = new String[]{

        };
        rs = super.executeQuery( selectAllUser, param );
        try {
            while ( rs.next( ) ) {
                userlist.add( new User (
                        rs.getString( "userName" ),
                        rs.getString( "userPass" ),
                        rs.getInt( "role" ),
                        rs.getString( "regTime" ),
                        rs.getInt( "logNum" )
                ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return userlist;
    }

    @Override
    public User findByName ( String name ) {
        User user = null;

        // 1)
        super.getConnection();
        // 2)
        ResultSet rs = null;
        String []param = new String[]{
            name
        };
        rs = super.executeQuery( select_name, param );
        try {
            while ( rs.next() ) {

                user = new User (
                    rs.getString( "username" ),
                    rs.getString( "userPass" ),
                    rs.getInt( "role" ),
                    rs.getString( "regTime" ),
                    rs.getInt( "logNum" )
                );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return user;
    }

    @Override
    public User findByName_pwd ( String name, String pwd ) {
        User user = null;

        // 1)
        super.getConnection();
        // 2)
        ResultSet rs = null;
        String []param = new String[]{
            name, pwd
        };
        rs = super.executeQuery( select_name_password, param );
        try {
            while ( rs.next() ) {
                user = new User (
                        rs.getString( "username" ),
                        rs.getString( "userPass" ),
                        rs.getInt( "role" ),
                        rs.getString( "regTime" ),
                        rs.getInt( "logNum" )
                );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return user;
    }

    @Override
    public int insert ( User user ) {
        int count = 0;

        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                user.getUserName(),
                user.getUserPass()+"",
                user.getRole()+"",
                user.getRegTime()+"",
                user.getLogNum()+""
        };
        count = super.executeUpdate ( insert, param );
        // 3)
        super.closeAll();

        return count;
    }

    @Override
    public int Uupdate_logNum ( String name ) {
        int count = 0;

        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                name
        };
        count = super.executeUpdate ( update_namelogNumAddOne, param );
        // 3)
        super.closeAll();

        return count;
    }

    @Override
    public int update ( User user, String name ) {
        int count = 0;

        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                user.getUserPass()+"",
                user.getRole()+"",
                user.getRegTime()+"",
                user.getLogNum()+"",
                user.getUserName()
        };
        count = super.executeUpdate ( update_name, param );
        // 3)
        super.closeAll();

        return count;
    }

    @Override
    public int delete ( String name ) {
        int count = 0;

        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                name
        };
        count = super.executeUpdate ( delete_name, param );
        // 3)
        super.closeAll();

        return count;
    }

    @Override
    public int delete ( String name, String psd ) {
        int count = 0;

        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                name, psd
        };
        count = super.executeUpdate ( delete_name_psd, param );
        // 3)
        super.closeAll();

        return count;
    }










}
