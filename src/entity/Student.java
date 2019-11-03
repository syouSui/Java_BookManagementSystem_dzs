package entity;

public class Student {

    private String sno;
    private String sname;
    private int age;
    private int sex;

    public static void showInfoTable ( ) {
        System.out.printf( "\t %-10s\t %-10s %-10s %-10s \n\n",
                "sno", "sname", "age", "sex" );
    }
    public void showInfo ( ) {
        System.out.printf( "\t %-10s\t %-10s %-10d %-10d  \n",
                this.sno, this.sname, this.age, this.sex );
    }




















    public Student ( ) {
    }
    public Student ( String sno, String sname, int age, int sex ) {
        this.sno = sno;
        this.sname = sname;
        this.age = age;
        this.sex = sex;
    }


    public String getSno ( ) {
        return sno;
    }
    public void setSno ( String sno ) {
        this.sno = sno;
    }
    public String getSname ( ) {
        return sname;
    }
    public void setSname ( String sname ) {
        this.sname = sname;
    }
    public int getAge ( ) {
        return age;
    }
    public void setAge ( int age ) {
        this.age = age;
    }
    public int getSex ( ) {
        return sex;
    }
    public void setSex ( int sex ) {
        this.sex = sex;
    }

}
