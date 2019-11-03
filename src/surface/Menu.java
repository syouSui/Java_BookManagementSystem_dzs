package surface;

public class Menu extends Surface {
	/**
	 * 菜单界面
	 */
	public static void show ( ) { 
		boolean ext_Menu = true; 
		while ( ext_Menu ) { 

			Surface.clear( );

			System.out.println( "Connect Successfully ! " );

			System.out.println( "\n\n\n\n\n\n\t\t\t\t Welcom to this Book_System !\n\n\n\n" );
			System.out.println( "\t\t\t\t 1. Get into User control interface \n" );
			System.out.println( "\t\t\t\t 2. Get into Book control interface \n" );
			System.out.println( "\t\t\t\t 3. Get into Student control interface \n" );
			System.out.println( "\t\t\t\t 0. Back to \n" );
			
			System.out.println( "Please Input command : " ); 

			cmd = sc.next( );
			switch ( cmd ) { 
			    case "1" : 
			    	UserControl.show( ); break;
			    case "2" : 
			    	BookControl.show( ); break;
				case "3" :
					StudentControl.show( ); break;
			    case "0" :
			    	ext_Menu = false; break; 
			}
		}
	}

	
}
