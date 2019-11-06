package test.JavaProgram;

public class AiYinSiTanJieTi {

    public static void main ( String[] args ) {

    // 爱因斯坦阶梯问题 : 2|1 3|2 5|4 6|5 7|0
    // 最小台阶数?

    for ( int i = 7; i <= 1000; i += 14 ) {
        if ( i%3==2 && i%5==4 && i%6==5 ) {
            System.out.println( i );
            break;
        }
    }

    

    }
}
