package dao.imp;

import dao.StuDao;
import entity.Student;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuDaoImp extends DBUtil implements StuDao {

    private final String select_findAll = "select * from student;";
    private final String select_findBySno = "select * from student where sno=?";
    private final String selec__findByName = "select * from student where sname=?;";
    private final String select_findBySno_Name = "select * from student where sno=? and sname=?;";
    private final String select_findBySex = "select * from student where sex=?";
    private final String insert_aStudent = "insert into student values( ?, ?, ?, ? );";
    private final String update_bySno = "update student set sname=?, age=?, sex=? where sno=?;";
    private final String delete_bySno = "delete from student where sno=?;";


    @Override
    public List<Student> findAll ( ) {
        List<Student> stulist = new ArrayList<Student>();

        // 1)
        super.getConnection();
        // 2)
        ResultSet rs = null;
        String []param = new String[]{

        };
        rs = super.executeQuery( select_findAll, param );
        try {
            while ( rs.next( ) ) {
                stulist.add( new Student (
                        rs.getString( "sno" ),
                        rs.getString( "sname" ),
                        rs.getInt( "age" ),
                        rs.getInt( "sex" ) ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return stulist;
    }
    @Override
    public List<Student> findBySno ( String sno ) {
        List<Student> stulist = new ArrayList<Student>();

        // 1)
        super.getConnection();
        // 2)
        ResultSet rs = null;
        String []param = new String[]{
            sno
        };
        rs = super.executeQuery( select_findBySno, param );
        try {
            while ( rs.next( ) ) {
                stulist.add( new Student (
                        rs.getString( "sno" ),
                        rs.getString( "sname" ),
                        rs.getInt( "age" ),
                        rs.getInt( "sex" ) ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return stulist;
    }
    @Override
    public List<Student> findByName ( String sname ) {
        ArrayList<Student> stulist = new ArrayList<Student>();

        // 1)
        super.getConnection();
        // 2)
        ResultSet rs = null;
        String []param = new String[]{
                sname
        };
        rs = super.executeQuery( selec__findByName, param );
        try {
            while ( rs.next( ) ) {
                stulist.add( new Student (
                        rs.getString( "sno" ),
                        rs.getString( "sname" ),
                        rs.getInt( "age" ),
                        rs.getInt( "sex" ) ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return stulist;
    }
    @Override
    public List<Student> findBySno_Name ( String sno, String sname ) {
        List<Student> stulist = new ArrayList<Student>();

        // 1)
        super.getConnection();
        // 2)
        ResultSet rs = null;
        String []param = new String[]{
                sno,
                sname
        };
        rs = super.executeQuery( select_findBySno_Name, param );
        try {
            while ( rs.next( ) ) {
                stulist.add( new Student (
                        rs.getString( "sno" ),
                        rs.getString( "sname" ),
                        rs.getInt( "age" ),
                        rs.getInt( "sex" ) ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return stulist;
    }
    @Override
    public List<Student> findBySex ( int sex ) {
        List<Student> stulist = new ArrayList<Student>();

        // 1)
        super.getConnection();
        // 2)
        ResultSet rs = null;
        String []param = new String[]{
                sex+""
        };
        rs = super.executeQuery( select_findBySex, param );
        try {
            while ( rs.next( ) ) {
                stulist.add( new Student (
                        rs.getString( "sno" ),
                        rs.getString( "sname" ),
                        rs.getInt( "age" ),
                        rs.getInt( "sex" ) ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return stulist;
    }
    @Override
    public int insert ( Student stu ) {
        int count = 0;

        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                stu.getSno(),
                stu.getSname(),
                stu.getAge()+"",
                stu.getSex()+""
        };
        count = super.executeUpdate ( insert_aStudent, param );
        // 3)
        super.closeAll();

        return count;
    }
    @Override
    public int update ( Student stu, String sno ) {
        int count = 0;

        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                stu.getSname(),
                stu.getAge()+"",
                stu.getSex()+"",
                sno
        };
        count = super.executeUpdate ( update_bySno, param );
        // 3)
        super.closeAll();

        return count;
    }
    @Override
    public int delete ( String sname ) {
        int count = 0;

        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                sname
        };
        count = super.executeUpdate ( delete_bySno, param );
        // 3)
        super.closeAll();

        return count;
    }


}