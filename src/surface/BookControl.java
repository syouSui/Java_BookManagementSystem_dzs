package surface;

import dao.imp.BookDaoImp;
import entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookControl extends Surface {

	static ArrayList<Book> booklist = null;
	static BookDaoImp bookdao = new BookDaoImp();

	/**
	 * 菜单界面-> 图书管理界面
	 */
	public static void show ( ) {
		boolean ext_bookControl = true;
		while ( ext_bookControl ) {

			Surface.clear( );

			System.out.println( "\n\n\n\n\n\n\t\t\t\t Welcom to Interface_BookControl !\n\n\n\n" );
			System.out.println( "\t\t\t\t 1. Search Book Information \n" );
			System.out.println( "\t\t\t\t 2. Add    Book Information \n" );
			System.out.println( "\t\t\t\t 3. Modify Book Information \n" );
			System.out.println( "\t\t\t\t 4. Delete Book Information \n" );
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
				ext_bookControl = false; break;
			}
		}
	}

	/**
	 *  做一次全查信息, 将结果把结果保存, 每次进入用户界面显示一次
	 */
	private static void getInformation ( ) {
		System.out.println( "\n\n\t\t\t The Book Information are as follows :  \n" );

		booklist = new ArrayList<Book>( );
		// 一次全查
		booklist = (ArrayList<Book>) bookdao.findAll();
		// 输出结果
		showInformation( );
	}

	/**
	 * 输出 全查的信息
	 */
	private static void showInformation ( ) {
		System.out.println( );
		Book.showInfoTable();
		for ( Book i : booklist )
			i.showInfo();
		System.out.println( "\n" );
	}







	private static void Search ( ) {
		boolean ext_search = true;
		while ( ext_search ) {
			Surface.clear( );

			showInformation( );

			System.out.println( "\n\t\t Search information ! \n\n" );

			System.out.print( "\t Please input bookName :  \n" );
			String bname = sc.next( );

			ArrayList<Book> booklist = new ArrayList<Book>();
			booklist = (ArrayList<Book>) bookdao.findByName( bname );
			if ( booklist != null ) {
				System.out.println( "\nThe query is successful and the results are as follows :\n" );
				Book.showInfoTable();
				for ( Book i : booklist )
					i.showInfo();
			} else {
				System.out.println( "Can't find the book ..." );
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
			System.out.println( "Insert Book Information ... \n" );

			System.out.println( "Please input book's isbn :" );
			String bisbn = sc.next();
			System.out.println( "Please input book's name :" );
			String bname = sc.next();
			System.out.println( "Please input book's publisherID :" );
			int pid = sc.nextInt();
			System.out.println( "Please input book's price :" );
			double bprice = sc.nextDouble();
			System.out.println( "Please input book's count :" );
			int bcount = sc.nextInt();
			System.out.println( "Please input book's description :" );
			String des = sc.next();
			System.out.println( "Please input book's picture :" );
			String bpic = sc.next();

			if ( bookdao.insert( new Book( bisbn, bname, pid, bprice, bcount, des, bpic ) ) == 1 ) {
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

			System.out.println( "Insert Book Information ... " );

			System.out.println( "Please input you want to modify book's isbn :" );
			String bisbn = sc.next();
			System.out.println( "Please input book's name :" );
			String bname = sc.next();
			System.out.println( "Please input book's publisherID :" );
			int pid = sc.nextInt();
			System.out.println( "Please input book's price :" );
			double bprice = sc.nextDouble();
			System.out.println( "Please input book's count :" );
			int bcount = sc.nextInt();
			System.out.println( "Please input book's description :" );
			String des = sc.next();
			System.out.println( "Please input book's picture :" );
			String bpic = sc.next();
			
			System.out.println( "\t\nModifying, please wait ... \n" );

			if ( bookdao.update( new Book( bisbn, bname, pid, bprice, bcount, des, bpic ), bisbn ) == 1 ) {
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

			System.out.print( "\t Please input bookIsbn : ! \n" );
			String bisbn = sc.next( );

			System.out.println( "\t\nDeleting, please wait ... \n" );

			if ( bookdao.delete( bisbn ) == 1 ) {
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











	
	
	
	
//
//
////				System.out.println( "书号 :" + book.getIsbn() +
////						"书名: " + book.getBookName() +
////						"出版社号: " + book.getPublisherID() +
////						"单价: " + book.getPrice() +
////						"库存量: " + book.getCount() +
////						"简介: " + book.getDescription() +
////						"封面: " + book.getPic() );
//
//	public static void displayBook ( ) {
//		System.out.println( "Displaying Book ...\n\n" );
//
//		List<Book> booklist = null;
//		BookDaoImp bookdao = new BookDaoImp( );
//
//		boolean ext_displayBook = true;
//		while ( ext_displayBook ) {
//
//			System.out.println( "Condition Search ? Y or N" );
//			String cmd = sc.next();
//
//			switch ( cmd ) {
//				case "Y" :
//				case "y" :
//					System.out.println( "Please input book's name :" );
//					String bname = sc.next();
//					System.out.println( "Please input book's publisherID :" );
//					int pid = sc.nextInt();
//
//					booklist = bookdao.findByName_PID( bname, pid );
//
//					System.out.println( "The Book Informatin as follows :\n\n" );
//					Book.showInfoTable();
//					for ( Book book : booklist ) {
//						book.showInfo();
//					}
//					break;
//				case "N" :
//				case "n" :
//					booklist = bookdao.findAll( );
//
//					for ( Book book : booklist ) {
//						book.showInfo();
//					}
//					break;
//			}
//
//			System.out.println( "Continue to Delete Book ? Y/y or N/n" );
//			String continueDisplayBook = sc.next();
//			if ( continueDisplayBook.equals( "Y" ) || continueDisplayBook.equals( "y" ) ) continue;
//			else ext_displayBook = false;
//		}
//
//
//	}
//
//	public static int insertBook ( ) {
//		System.out.println( "Inserting Book ... \n\n" );
//
//		int count = 0;
//		BookDaoImp bookdao = new BookDaoImp( );
//
//		boolean ext_insertBook = true;
//		while ( ext_insertBook ) {
//
//			System.out.println( "Insert Book Information ... " );
//
//			System.out.println( "Please input book's isbn :" );
//			String bisbn = sc.next();
//			System.out.println( "Please input book's name :" );
//			String bname = sc.next();
//			System.out.println( "Please input book's publisherID :" );
//			int pid = sc.nextInt();
//			System.out.println( "Please input book's price :" );
//			double bprice = sc.nextDouble();
//			System.out.println( "Please input book's count :" );
//			int bcount = sc.nextInt();
//			System.out.println( "Please input book's description :" );
//			String des = sc.next();
//			System.out.println( "Please input book's picture :" );
//			String bpic = sc.next();
//
//			Book book = new Book( bisbn, bname, pid, bprice, bcount, des, bpic );
//
//			int tempCount = bookdao.insert( book );
//			count += tempCount;
//
//			if ( tempCount==0 )
//				System.out.println( "Insert Error !" );
//			else
//				System.out.println( "Insert Successfully !" );
//
//			System.out.println( "Continue to Delete Book ? Y/y or N/n" );
//			String continueInsert = sc.next();
//			if ( continueInsert.equals( "Y" ) || continueInsert.equals( "y" ) ) continue;
//			else ext_insertBook = false;
//
//		}
//		return count;
//	}
//
//	public static int deleteBook ( ) {
//		System.out.println( "Deleting Book ... \n\n" );
//
//		BookDaoImp bookdao = new BookDaoImp( );
//
//		int count = 0;
//
//		boolean ext_deleteBook = true;
//		while ( ext_deleteBook ) {
//
//			System.out.println( "Please Input The _isbn :");
//			String bisbn = sc.next();
//
//
//			int tempCount = bookdao.delete( bisbn );
//
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
//
//	public static int editBook ( ) {
//		System.out.println( "Inserting Book ... \n\n" );
//
//		int count = 0;
//		BookDaoImp bookdao = new BookDaoImp( );
//
//		boolean ext_editBook = true;
//		while ( ext_editBook ) {
//
//			System.out.println( "Insert Book Information ... " );
//
//			System.out.println( "Please input book's isbn :" );
//			String bisbn = sc.next();
//			System.out.println( "Please input book's name :" );
//			String bname = sc.next();
//			System.out.println( "Please input book's publisherID :" );
//			int pid = sc.nextInt();
//			System.out.println( "Please input book's price :" );
//			double bprice = sc.nextDouble();
//			System.out.println( "Please input book's count :" );
//			int bcount = sc.nextInt();
//			System.out.println( "Please input book's description :" );
//			String des = sc.next();
//			System.out.println( "Please input book's picture :" );
//			String bpic = sc.next();
//
//			Book book = new Book( bisbn, bname, pid, bprice, bcount, des, bpic );
//
//			int tempCount = bookdao.update( book, bisbn );
//			count += tempCount;
//
//			if ( tempCount==0 )
//				System.out.println( "Edit Error !" );
//			else
//				System.out.println( "Edit Successfully !" );
//
//			System.out.println( "Continue to Edit Book ? Y/y or N/n" );
//			String continueInsert = sc.next();
//			if ( continueInsert.equals( "Y" ) || continueInsert.equals( "y" ) ) continue;
//			else ext_editBook = false;
//
//		}
//		return count;
//	}


}
