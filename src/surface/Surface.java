package surface;
//import entity.*;

import java.awt.AWTException;



import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.Statement; 		
import java.awt.AWTException;



import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 
 *   注意  ! ! ! ! ! !  ! ! 用到的是 java.sql.Statement; java.sql.Connection; 而并非 com.jdbc.mysql.Statement; com.jdbc.mysql.Connection;
 *   
 */


public abstract class Surface { 
	static Scanner sc = new Scanner ( System.in ); // 使用 Scanner类 输入
	static String cmd; // 选择菜单的命令

	static void show ( ) {} // 派生类重写方法
	
	
	/**
	 * 获取系统时间R
	 */
	public static String getDate ( ) { 
		Date date = new Date( ); 
//		System.out.println( data ); 
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
		String strdate = sdf.format( date );
//		System.out.println( strdate );
		return strdate;
	}

	/**
 	 * 通过 鼠标右键+R 实现清屏
 	 */
	public static void clear ( ) {
		/**
		 *    由于后期使用的 Intellij Idea 撸的代码, 虽然可以自定义清屏快捷键, 但是有问题总是连后带输出也清除了
		 * 不得以, 只能在 Idea中用 for循环 的方式"清屏", 对于最终版版本则要在 Eclipse 的控制台中使用.经过这几个
		 * 小时的 Idea瞎搞, 是在不想浪费时间了 ...
		 */

//		for Idea
		for ( int i = 0; i < 40; ++i ) System.out.println( );

////		for Eclipse
//		try {
//
//			Robot r = new Robot( ); // 会产生 AWTException异常,  catch一下
//
//			r.mousePress( InputEvent.BUTTON3_DOWN_MASK );       // 按下鼠标右键
//			r.mouseRelease( InputEvent.BUTTON3_DOWN_MASK );    	// 释放鼠标右键
////			r.keyPress( KeyEvent.VK_CONTROL );             		// 按下Ctrl键
//			r.keyPress( KeyEvent.VK_SHIFT );
//			r.keyPress( KeyEvent.VK_R );                    	// 按下R键
//			r.keyRelease( KeyEvent.VK_R );                  	// 释放R键
//			r.keyRelease( KeyEvent.VK_SHIFT );
////			r.keyRelease( KeyEvent.VK_CONTROL );            	// 释放Ctrl键
//			r.delay( 100 );
//
//
//		}
//		catch ( AWTException e ) {
//			e.printStackTrace( );
//		}

		
	}	
	
	
}
