package surface;

import dao.BookDao;
import dao.UserDao;
import dao.imp.BookDaoImp;
import dao.imp.UserDaoImp;
import entity.User;

import java.sql.SQLException;
import java.sql.DriverManager;
//import java.sql.Connection;

public class Welcom extends Surface {

    static UserDaoImp userdao = new UserDaoImp();
	
	/**
	 * 欢迎界面
	 */
	public static void show ( ) {
		boolean ext_welcom = true; 
		while ( ext_welcom ) {

			Surface.clear( );

			System.out.println( "\n\n\n\n\n\n\n\t\t\t\t Welcom to myConsoles !\n\n\n\n" );
			System.out.println( "\t\t\t\t 1. Log in \n" );
			System.out.println( "\t\t\t\t 2. register in \n" );
			System.out.println( "\t\t\t\t 0. exit \n" );
		
			System.out.println( "Please Input comond : " );
			cmd = sc.next( );

			switch ( cmd ) { 
			    case "1" : 
		    		logIn( ); break;
			    case "2" : 
		    		registerIn( ); break;
			    case "0" : 
			    	ext_welcom = false; break; 
			}
		}
	}
	
	public static void logIn ( ) {
		boolean ext_logIn = true;
		while ( ext_logIn ) {

			Surface.clear( );

			System.out.print( "\n\n\n\n\n\n\t\t\t\t\n\t\t\t\t Please Input the Account : " );
			String uname = sc.next( );
			System.out.print( "\t\t\t\t\n\t\t\t\t Please Input the Password : " );
			String upass = sc.next( );
			System.out.println( );

			if ( userdao.findByName_pwd( uname, upass ) != null )
				Menu.show( );
			else {
				System.out.println( "Wrong Answer ! Please press any key and press 'Enter' to return." );
				String controlNoUse = sc.next( );
				ext_logIn = false;
			}
		}
	}
	
	public static void registerIn ( ) {
		boolean ext_reg = true;
		while ( ext_reg ) {

			Surface.clear( );

			System.out.print( "\n\n\n\n\n\n\t\t\t\t\n\t\t\t\t Welcome to register user : " );

			System.out.println( "\n\t\t Register information ! \n\n" );
			System.out.print( "\t Please input userNname :  \n" );
			String uname = sc.next( );
			System.out.print( "\t Please input userPassword :  \n" );
			String upass = sc.next( );
			System.out.print( "\t Please input userCharacter( 0/General | 1/Administrator:  \n" );
			int urole = sc.nextInt( );
			String udate = Surface.getDate( );
			int ulog = 0;
			System.out.println( );

			if ( userdao.insert( new User( uname, upass, urole, udate, ulog ) ) == 1 ) {
				System.out.println( "Register Successflly ! " );
				ext_reg = false;
				System.out.println( "Please press any key and press 'Enter' to return." );
				String controlNoUse = sc.next( );
			} else {
				System.out.println( "\nRegister Information Error !! This account already exists !\n\n" );
				System.out.println( "\nPlease press '1' and 'Enter' to continue reister or press any key to return ..." );
				String controlNoUse = sc.next( );
				if ( controlNoUse.equals( "1" ) ) ext_reg = true;
				else ext_reg = false;
			}
		}
	}
	
	
	
	
	
	
	
}
