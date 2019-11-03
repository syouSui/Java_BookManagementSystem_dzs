package dao.imp;

import dao.BookDao;
import entity.Book;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImp extends DBUtil implements BookDao {
    /**
     * 数据库的基本操作二大步:
     * 1 ) 连接
     * 2 ) 操作
     * 3 ) 关闭
     */

    /**
     * books:       isbn/ bookName/ publisherID/ price /count/ description/ pic
     *              Str     Str         int       doubf   int       Str      Str
     * userdetail:  bookName/ userPass/ role/ regTime/ logNum
     *              Str         Str     int     Str     int
     */
    private String selectAllBook = "select * from books;";
    private String select_pID = "select * from books where publisherID=?";
    private String select_bname = "select * from books where bookName=?";
    private String sel_bname_pID = "select * from books where bookName=? and publisherId=?";
    private String select_isbn = "select * from books where isbn=?";

    private String insert = "insert into books values( ?, ?, ?, ?, ?, ?, ?)";

    //根据书号修改其该书库存量
    private String update_nameIncreaseCount = "update books set count=count-? where isbn=?";
    //根据书号找到该书，修改该书其他6个字段的值
    private String update_isbn = "update books set bookName=?, publisherID=?, price=?, count=?, description=?, pic=? where isbn=?";

    private String delete_isbn = "delete from books where isbn = ?";
    private String delete_name = "delete from books where bookName = ?";




    @Override
    public List<Book> findAll ( ) {
        List<Book> booklist = null;
        ResultSet rs = null;
        // 1)
        super.getConnection();
        // 2)
        String []param = new String[]{
        };
        rs = super.executeQuery( selectAllBook, param );
        try {
            booklist = new ArrayList<Book>();
            while ( rs.next( ) ) {
                // 201)生成 本书rs.next() -> Book book
                // 根据列的 索引号 取该列的值
//                    Book book = new Book (
//                            rs.getString( 1 ),
//                            rs.getString( 2 ),
//                            rs.getInt( 3 ),
//                            rs.getDouble( 4 ),
//                            rs.getInt( 5 ),
//                            rs.getString( 6 ),
//                            rs.getString( 7 )
//                    );
                // 202)生成 本书rs.next() -> Book book
                // 根据 列名 取该列的值
                booklist.add( new Book (
                        rs.getString( "isbn" ),
                        rs.getString( "bookName" ),
                        rs.getInt( "publisherID" ),
                        rs.getDouble( "price" ),
                        rs.getInt( "count" ),
                        rs.getString( "description" ),
                        rs.getString( "pic" )
                ) ); // 将概述添加到 booklist 集合中
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return booklist;
    }

    @Override
    public List<Book> findAll ( int pIDs ) {
        List<Book> booklist = null;

        // 1)
        super.getConnection();
        // 2)
        ResultSet rs = null;
        String []param = new String[]{
                pIDs+""
        };
        rs = super.executeQuery( select_pID, param );
        try {
            while ( rs.next( ) ) {
                Book book = new Book (
                        rs.getString( "isbn" ),
                        rs.getString( "bookName" ),
                        rs.getInt( "publisherID" ),
                        rs.getDouble( "price" ),
                        rs.getInt( "count" ),
                        rs.getString( "description" ),
                        rs.getString( "pic" )
                );
                booklist.add( book );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return booklist;
    }

    @Override
    public List<Book> findByName ( String bname ) /*throws SQLException*/ {
        List<Book> booklist = null;
        ResultSet rs = null;

        // 1)
        super.getConnection();
        // 2)
        String []param = new String[]{
                bname
        };
        String sql_bname;
        rs = super.executeQuery( select_bname, param );
        booklist = new ArrayList<Book>();
        try {
            while ( rs.next( ) ) {

                Book book = new Book (
                        rs.getString( "isbn" ),
                        rs.getString( "bookName" ),
                        rs.getInt( "publisherID" ),
                        rs.getDouble( "price" ),
                        rs.getInt( "count" ),
                        rs.getString( "description" ),
                        rs.getString( "pic" )
                );

                booklist.add( book );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return booklist;
    }

    @Override
    public List<Book> findByName_PID ( String bname, int pID ) {
        List<Book> booklist = null;
        ResultSet rs = null;

        // 1)
        super.getConnection();
        // 2)
        String []param = new String[]{
                bname,
                pID+""
        };
        rs = super.executeQuery( sel_bname_pID, param );
        try {
            while ( rs.next( ) ) {

                Book book = new Book (
                        rs.getString( "isbn" ),
                        rs.getString( "bookName" ),
                        rs.getInt( "publisherID" ),
                        rs.getDouble( "price" ),
                        rs.getInt( "count" ),
                        rs.getString( "description" ),
                        rs.getString( "pic" )
                );
                booklist.add( book );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return booklist;
    }

    @Override
    public Book findByIsbn ( String isbn ) {
        Book book = null;
        ResultSet rs = null;
        //1)
        super.getConnection();
        //2)
        String []param = new String[] {
             isbn
        };
        rs = super.executeQuery( select_isbn, param );
        try {

            if ( rs.next() ) {

                while ( rs.next( ) ) {

                    book = new Book (
                            rs.getString( "isbn" ),
                            rs.getString( "bookName" ),
                            rs.getInt( "publisherID" ),
                            rs.getDouble( "price" ),
                            rs.getInt( "count" ),
                            rs.getString( "description" ),
                            rs.getString( "pic" )
                    );

                }

            }
            else {
                System.out.println( "Don't find the book !" );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        // 3)
        super.closeAll();

        return book;
    }

    @Override
    public int insert ( Book book) {
        int count = 0;

        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                book.getIsbn()+"",
                book.getBookName()+"",
                book.getPublisherID()+"",
                book.getPrice()+"",
                book.getCount()+"",
                book.getDescription(),
                book.getPic()
        };
        count = super.executeUpdate ( insert, param );
        // 3)
        super.closeAll();
        return count;
    }

    @Override
    public int update( Book book, String isbn) {
        int count = 0;
        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                book.getBookName()+"",
                book.getPublisherID()+"",
                book.getPrice()+"",
                book.getCount()+"",
                book.getDescription(),
                book.getPic(),
                book.getIsbn()+"",
        };
        count = super.executeUpdate ( update_isbn, param );
        // 3)
        super.closeAll();
        return count;
    }

    @Override
    public int update_count ( int bookCount, String isbn ) {

        int count = 0;

        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                bookCount+"",
                isbn
        };
        count = super.executeUpdate ( update_nameIncreaseCount, param );
        // 3)
        super.closeAll();

        return count;


    }

    @Override
    public int delete ( String isbn ) {
        int count = 0;

        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                isbn
        };
        count = super.executeUpdate ( delete_isbn, param );
        // 3)
        super.closeAll();

        return count;
    }

    @Override
    public int delete( Book book) {
        int count = 0;
        // 1)
        super.getConnection( );
        // 2)
        String []param = new String[] {
                book.getBookName()
        };
        count = super.executeUpdate ( delete_name, param );
        // 3)
        super.closeAll();
        return count;
    }















}
