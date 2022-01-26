package test.file;

import java.io.*;

public class _myFileDemo {

    static BufferedWriter bw = null;
    static BufferedReader br = null;

    public static void init() {
        try {
            bw = new BufferedWriter(new FileWriter("D://test.txt"));

            bw.write("Hello java!");
            bw.newLine();
            // bw.write( "Hello BufferedWriter !" );
            // bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void copy(String from, String to) {
        try {
            br = new BufferedReader(new FileReader(from));

            bw = new BufferedWriter(new FileWriter(to));

            String line = null;
            while ((line = br.readLine()) != null) {
                // System.out.println( line );
                bw.write(line);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void delete(String path) {
        new File(path).delete();

    }

    public static void main(String[] args) {
        // init( );

        copy("D://test.txt", "E://test.txt");

        delete("D://test.txt");
        // delete( "E://test.txt" );

    }
}
