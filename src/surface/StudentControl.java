package surface;

import dao.StuDao;
import dao.imp.StuDaoImp;
import entity.Student;

import java.util.ArrayList;

public class StudentControl extends Surface {

    static ArrayList<Student> stulist = null;
    static StuDaoImp studao = new StuDaoImp();



    /**
     * 菜单界面 -> 学生管理界面
     */
    public static void show ( ) {
        boolean ext_stuControl = true;
        while ( ext_stuControl ) {

            Surface.clear( );

            System.out.println( "\n\n\n\n\n\n\t\t\t\t Welcom to Interface_StudentControl !\n\n\n\n" );
            System.out.println( "\t\t\t\t 1. Search Student Information \n" );
            System.out.println( "\t\t\t\t 2. Add    Student Information \n" );
            System.out.println( "\t\t\t\t 3. Modify Student Information \n" );
            System.out.println( "\t\t\t\t 4. Delete Student Information \n" );
            System.out.println( "\t\t\t\t 0. Back to \n" );

            getInformation( );

            System.out.println( "Please Input command : " );
            cmd = sc.next( );


            switch ( cmd ) {
                case "1" :
                    Search( ); break;
                case "2" :
                    add( ); break;
                case "3" :
                    modify( ); break;
                case "4" :
                    delete( ); break;
                case "0" :
                    ext_stuControl = false; break;
            }
        }
    }

    /**
     *  做一次全查信息, 将结果把结果保存, 每次进入用户界面显示一次
     */
    private static void getInformation ( ) {
        System.out.println( "\n\n\t\t\t The Student Information are as follows :  \n" );

        stulist = new ArrayList<Student>( );
        // 一次全查
        stulist = (ArrayList<Student>) studao.findAll();
        // 输出结果
        showInformation( );
    }

    /**
     * 输出 全查的信息
     */
    private static void showInformation ( ) {
        System.out.println( );
        Student.showInfoTable();
        for ( Student i : stulist )
            i.showInfo();
        System.out.println( "\n" );
    }


    private static void Search ( ) {
        boolean ext_search = true;
        while ( ext_search ) {
            Surface.clear( );

            showInformation( );

            System.out.println( "\n\t\t Search information ! \n\n" );

            System.out.print( "\t Please input student sname :  \n" );
            String sname = sc.next( );


            ArrayList<Student> stulist = null;
            stulist = (ArrayList<Student>) studao.findByName( sname );
            if ( stulist != null ) {
                System.out.println( "\nThe query is successful and the results are as follows :\n" );
                Student.showInfoTable();
                for ( Student i : stulist )
                        i.showInfo();
            } else {
                System.out.println( "Can't find the student ..." );
            }

            System.out.println( "\n\nPress 1 to continue the query, press 0 to return to the previous level ! " );
            boolean ext_fin = true;
            while ( ext_fin ){
                String noRes = sc.next( );
                switch ( noRes ) {
                    case "0":
                        ext_search = false;
                        ext_fin = false;
                        break;
                    default :
                        ext_fin = false;
                        break;
                }
            }
        }
    }

    private static void add ( ) {
        boolean ext_add = true;
        while ( ext_add ) {
            Surface.clear( );
            showInformation( );
            System.out.println( "\n\t\t Add information ! \n\n" );
            System.out.print( "\t Please input student sno :  \n" );
            String sno = sc.next( );
            System.out.print( "\t Please input student sname :  \n" );
            String sname = sc.next( );
            System.out.print( "\t Please input student age :  \n" );
            int age = sc.nextInt();
            System.out.print( "\t Please input student sex :  \n" );
            int sex = sc.nextInt();

            if ( studao.insert( new Student( sno, sname, age, sex ) ) == 1 ) {
                System.out.println( "Add Successflly ! " );
            } else {
                System.out.println( "Add Information Error !! This account already exists !" );
            }

            System.out.println( "\t\nSearching, please wait ... \n" );

            System.out.println( "If you want go on, Please press on 1 , else press on 0 !" );
            boolean ext_fin = true;
            while ( ext_fin ){
                String noRes = sc.next( );
                switch ( noRes ) {
                    case "0":
                        ext_add = false;
                        ext_fin = false;
                        break;
                    default :
                        ext_fin = true;
                        break;
                }
            }
        }
    }

    private static void modify ( ) {
        boolean ext_modify = true;
        while ( ext_modify ) {

            Surface.clear( );

            showInformation( );

            System.out.println( "\n\t\t Modify information ! \n" );

            // 想要修改的学生名
            System.out.print( "\t Please input student sno :  \n" );
            String sno = sc.next( );
            System.out.print( "\t Please input student sname :  \n" );
            String sname = sc.next( );
            System.out.print( "\t Please input student age :  \n" );
            int age = sc.nextInt();
            System.out.print( "\t Please input student sex :  \n" );
            int sex = sc.nextInt();

            System.out.println( "\t\nModifying, please wait ... \n" );

            if ( studao.update( new Student( sno, sname, age, sex ), sno ) == 1 ) {
                System.out.println( "\nModify Succesfly !\n" );
            } else {
                System.out.println( "\n Modify Error !\n" );
            }

            System.out.println( "If you want go on, Please press on 1 , else press on 0 !" );
            boolean ext_fin = true;
            while ( ext_fin ) {
                String noRes = sc.next( );
                switch ( noRes ) {
                    case "0":
                        ext_modify = false;
                        ext_fin = false;
                        break;
                    default :
                        ext_fin = false;
                        break;

                }
            }
        }
    }

    private static void delete ( ) {
        boolean ext_delete = true;
        while ( ext_delete ) {

            Surface.clear( );

            showInformation( );

            System.out.println( "\n\t\t Delete information ! \n" );

            System.out.print( "\t Please input student sno : ! \n" );
            String sno = sc.next( );

            System.out.println( "\t\nDeleting, please wait ... \n" );

            if ( studao.delete( sno ) == 1 ) {
                System.out.println( "\nDelete Successflly ! \n" );
            } else {
                System.out.println( "Delete Information Error !" );
            }

            System.out.println( "If you want go on, Please press on 1 , else press on 0 !" );
            boolean ext_fin = true;
            while ( ext_fin ){
                String noRes = sc.next( );
                switch ( noRes ) {
                    case "0":
                        ext_delete = false;
                        ext_fin = false;
                        break;
                    default :
                        ext_fin = false;
                        break;

                }
            }
        }
    }






}
