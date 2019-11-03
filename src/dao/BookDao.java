package dao;

import entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    public List<Book> findAll (  );

    public List<Book> findAll ( int pIDs );

    public List<Book> findByName ( String bname ) throws SQLException;

    public List<Book> findByName_PID ( String bname, int pID );

    public Book findByIsbn ( String isbn );

    public int insert ( Book book );

    public int update( Book book, String isbn);

    public int update_count ( int bcount, String isbn );

    public int delete ( String isbn );

    public int delete ( Book book );















}
