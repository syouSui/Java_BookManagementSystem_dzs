package test.thread;

class Share { // 资源类, 三个任务, 由三个线程共享
    void print (String str ) {
        System.out.print( "[" );
        try {
            Thread.sleep(1000);
        } catch ( InterruptedException e ) {
            e.printStackTrace( );
        }
        System.out.print( "]" );
    }
}

class Caller implements Runnable { // 任务类
    String str;
    Share share;
    Thread thread;
    public Caller ( Share share, String str ) {
        this.share = share;
        this.str = str;
        thread = new Thread( this );
        thread.start( );
    }

    synchronized void print ( String str ) {
        System.out.print( "[" );
    }


    @Override
    public void run ( ) {

    }
}


public class NoSyn {


    public static void main ( String[] args ) throws InterruptedException {
        Share share = new Share ( );
        Caller call1 = new Caller ( share, "A" );
        Caller call2 = new Caller ( share, "B" );
        Caller call3 = new Caller ( share, "C" );

        call1.thread.join( );
        call2.thread.join( );
        call3.thread.join( );
    }
}
