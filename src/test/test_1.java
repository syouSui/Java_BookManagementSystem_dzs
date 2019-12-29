package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Scanner;

public class test_1 extends Test{

    public static void internet_test( ) {
        try {
            Scanner scan=new Scanner(System.in);    //创建输入扫描器
            System.out.println("请输入一个完整的网址：");
            String line=scan.nextLine();    //获取用户输入文本
            URL url=new URL(line);    //创建URL对象
            System.out.println("这个网址的主机名称是："+url.getHost());    //获取主机名称
            System.out.println("这个网址的URL协议名称是："+url.getProtocol());    //获取协议名称
        }
        catch( MalformedURLException e) {
            System.out.println("输入的是非法网址");    //提示错误信息
        }
    }

    protected void cout ( ) {
        System.out.println( "123123123132" );
    }

    public static void main ( String[] args ) {
//        Test ta = new Test();
//        ta.cout();
//
//        test_1 t1 = new test_1();
//        t1.cout( );
//
//        try {
//            ServerSocket ss = new ServerSocket( );
//            ss.accept();
//        } catch ( IOException e ) {
//            e.printStackTrace( );
//        }
        internet_test();
    }
}
