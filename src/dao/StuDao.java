package dao;

import entity.Student;

import java.util.List;

public interface StuDao {

    public List<Student> findAll ( );

    public List<Student> findBySno ( String sno );

    public List<Student> findByName ( String sname );

    public List<Student> findBySno_Name ( String sno, String sname );

    public List<Student> findBySex ( int sex );


    public int insert ( Student stu );

    public int update ( Student stu, String sname );

    public int delete ( String sname );

}
