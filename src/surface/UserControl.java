package surface;

import dao.UserDao;
import dao.imp.UserDaoImp;
import entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserControl extends Surface {

	static ArrayList<User> userlist = null;
	static UserDaoImp userdao = new UserDaoImp();



	/**
	 * 菜单界面 -> 用户管理界面
	 */
	public static void show ( ) {
		boolean ext_userControl = true;
		while ( ext_userControl ) {

			Surface.clear( );

			System.out.println( "\n\n\n\n\n\n\t\t\t\t Welcom to Interface_UserControl !\n\n\n\n" );
			System.out.println( "\t\t\t\t 1. Search User Information \n" );
			System.out.println( "\t\t\t\t 2. Add    User Information \n" );
			System.out.println( "\t\t\t\t 3. Modify User Information \n" );
			System.out.println( "\t\t\t\t 4. Delete User Information \n" );
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
				ext_userControl = false; break;
			}
		}
	}

	/**
	 *  做一次全查信息, 将结果把结果保存, 每次进入用户界面显示一次
	 */
	private static void getInformation ( ) {
		System.out.println( "\n\n\t\t\t The User Information are as follows :  \n" );

		userlist = new ArrayList<User>( );
		// 一次全查
		userlist = (ArrayList<User>) userdao.findAllUser();
		// 输出结果
		showInformation( );
	}

	/**
	 * 输出 全查的信息
	 */
	private static void showInformation ( ) {
		System.out.println( );
		User.showInfoTable();
		for ( User i : userlist )
			i.showInfo();
		System.out.println( "\n" );
	}


	private static void Search ( ) {
		boolean ext_search = true;
		while ( ext_search ) {
			Surface.clear( );

			showInformation( );

			System.out.println( "\n\t\t Search information ! \n\n" );

			System.out.print( "\t Please input userNname :  \n" );
			String uname = sc.next( );

			User user = null;
			user = new User();
			user = userdao.findByName( uname );
			if ( user != null ) {
			System.out.println( "\nThe query is successful and the results are as follows :\n" );
				User.showInfoTable();
				user.showInfo();
			} else {
				System.out.println( "Can't find the user ..." );
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
			System.out.print( "\t Please input userNname :  \n" );
			String uname = sc.next( );
			System.out.print( "\t Please input userPassword :  \n" );
			String upass = sc.next( );
			System.out.print( "\t Please input userCharacter( 0/General | 1/Administrator:  \n" );
			int urole = sc.nextInt( );
		 	String udate = Surface.getDate( );
		 	int ulog = 0;

			if ( userdao.insert( new User( uname, upass, urole, udate, ulog ) ) == 1 ) {
				System.out.println( "Add Successflly ! " );
			} else {
				System.out.println( "Add Information Error !! This account already exists !" );
			}

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

			// 想要修改的用户名
			System.out.println( "Please input you want to Modify username :" );
			String uname = sc.next();
			System.out.print( "\t Please input the New userPassword :  \n" );
			String upass = sc.next( );
			System.out.print( "\t Please input the New userCharacter( 0/General | 1/Administrator:  \n" );
			int urole = sc.nextInt( );
//			System.out.print( "\t Please input the New regtime :  \n" );
//			String udate = sc.next()
			String udate = Surface.getDate();
			System.out.print( "\t Please input the New lognum :  \n" );
			int ulog = sc.nextInt();

			System.out.println( "\t\nModifying, please wait ... \n" );

			if ( userdao.update( new User( uname, upass, urole, udate, ulog ), uname ) == 1 ) {
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

			System.out.print( "\t Please input userNname : ! \n" );
			String uname = sc.next( );

			System.out.println( "\t\nDeleting, please wait ... \n" );

			if ( userdao.delete( uname ) == 1 ) {
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
















//	public static void displayUser ( ) {
//		System.out.println( "Displaying User ..." );
//
//		User user = null;
//		List<User> userlist = null;
//		UserDao userdao = new UserDaoImp( );
//
//		boolean ext_displayUser = true;
//		while ( ext_displayUser ) {
//
//			System.out.println( "Condition Search ? Y/y or N/n" );
//			String cmd = sc.next();
//
//			switch ( cmd ) {
//				case "Y" :
//				case "y" :
//					System.out.println( "Please input user's name :" );
//					String uname = sc.next();
//					System.out.println( "Please input user's password :" );
//					String upwd = sc.next();
//
//					user = userdao.findByName_pwd( uname, upwd ); // 用户名做主键, 每个用户名是唯一的, 要么有一个用户要没有
//
//					System.out.println( "The User Informatin as follows :\n\n" );
//					User.showInfoTable();
//					user.showInfo();
//					break;
//				case "N" :
//				case "n" :
//					userlist = userdao.findAllUser( );
//					System.out.println( "The User Informatin as follows :\n\n" );
//					User.showInfoTable();
//					for ( User u : userlist ) {
//						u.showInfo();
//					}
//					break;
//			}
//
//			System.out.println( "Continue to Delete User ? Y/y or N/n" );
//			String continueDisplayUser = sc.next();
//			if ( continueDisplayUser.equals( "Y" ) || continueDisplayUser.equals( "y" ) ) continue;
//			else ext_displayUser = false;
//
//		}
//	}
//
//	public static int insertUser ( ) {
//		System.out.println( "Inserting User ..." );
//
//		int count = 0;
//		UserDao userdao = new UserDaoImp( );
//
//		boolean ext_insert = true;
//		while ( ext_insert ) {
//			System.out.println( "Please input user's name :" );
//			String userName = sc.next();
//			System.out.println( "Please input user's password :" );
//			String userPassword = sc.next();
//			System.out.println( "Please input user's role :" );
//			int userRole = sc.nextInt();
//
//			Date date = new Date( );
//			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
////			String udate = sdf.format( date );
//
//
//			String userRegtime = sdf.format( date );//getDate();
//			int userLognum = 0;
//
//			User user = new User( userName, userPassword, userRole, userRegtime, userLognum );
//
//			int tempCount = 0;
//			tempCount = userdao.insert( user );
//			count += tempCount;
//
//			if ( tempCount==0 )
//				System.out.println( "Insert Error !" );
//			else
//				System.out.println( "Insert Successfully !" );
//
//			System.out.println( "Continue to Delete User ? Y/y or N/n" );
//			String continueInsert = sc.next();
//			if ( continueInsert.equals( "Y" ) || continueInsert.equals( "y" ) ) continue;
//			else ext_insert = false;
//
//		}
//		return count;
//	}
//
//	public static int editUser ( ) {
//        System.out.println( "Inserting User ..." );
//
//        int count = 0;
//        UserDao userdao = new UserDaoImp( );
//
//        boolean ext_editUser = true;
//        while ( ext_editUser ) {
//            System.out.println( "Please input user's name :" );
//            String userName = sc.next();
//            System.out.println( "Please input user's password :" );
//            String userPassword = sc.next();
//            System.out.println( "Please input user's role :" );
//            int userRole = sc.nextInt();
//            System.out.println( "Please input logTime : " );
//            int userLognum = sc.nextInt( );
//
//
//            Date date = new Date( );
//            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
////			String udate = sdf.format( date );
//
//
//            String userRegtime = sdf.format( date );//getDate();
//
//            User user = new User( userName, userPassword, userRole, userRegtime, userLognum );
//
//            int tempCount = 0;
//            tempCount = userdao.update( user, userName );
//            count += tempCount;
//
//            if ( tempCount==0 )
//                System.out.println( "Edit Error !" );
//            else
//                System.out.println( "Edit Successfully !" );
//
//            System.out.println( "Continue to Delete User ? Y/y or N/n" );
//            String continueInsert = sc.next();
//            if ( continueInsert.equals( "Y" ) || continueInsert.equals( "y" ) ) continue;
//            else ext_editUser = false;
//
//        }
//        return count;
//    }
//
//	public static int deleteUser ( ) {
//		System.out.println( "Deleting User ... " );
//
//		int count = 0;
//		UserDaoImp userdao = new UserDaoImp( );
//
//		boolean ext_deleteBook = true;
//		while ( ext_deleteBook ) {
//			System.out.println( "Please input user's name :" );
//			String name = sc.next();
//			System.out.println( "Please input user's password :" );
//			String password = sc.next();
//
//			int tempCount = 0;
//			tempCount =  userdao.delete( name, password );
//			count += tempCount;
//
//			if ( tempCount!=0 )
//				System.out.println( "Delete Successfully !" );
//			else
//				System.out.println( "Delete Error !" );
//
//			System.out.println( "Continue to Delete Book ? Y/y or N/n" );
//			String continueDelte = sc.next();
//			if ( continueDelte.equals( "Y" ) || continueDelte.equals( "y" ) ) continue;
//			else ext_deleteBook = false;
//
//		}
//		return count;
//	}

}
