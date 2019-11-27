package test.file.teacherCode_myTest;

import test.file.testEntity.Person;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputDemo {

	public static void main(String[] args) {
		//FileOutputStream/ObjectOutputStream
		ObjectOutputStream obs=null;
		Person p1=new Person("001","徐翠霞",55);
		Person p2=new Person("002","徐翠霞2",50);
		Person p3=new Person("002","徐翠霞3",40);
		try {
			obs=new ObjectOutputStream(
					new FileOutputStream("d:\\persons.tmp"));
			obs.writeObject(p1);//将一个对象写入文件中
			obs.writeObject(p2);
			obs.writeObject(p3);
			obs.writeObject( null );
			obs.flush();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(obs!=null)
				try {
					obs.close();//关闭文件
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
