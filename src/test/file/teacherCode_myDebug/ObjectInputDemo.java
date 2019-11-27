package test.file.teacherCode_myDebug;

import test.file.testEntity.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputDemo {

	public static void main(String[] args) {
		//FileInputStream/ObjectInputStream
		ObjectInputStream ois=null;
		System.out.println("文件中的对象如下：");
			
		try {
			ois=new ObjectInputStream(
					new FileInputStream("d:\\persons.tmp" ));
			Object obj=ois.readObject();
			while(obj!=null){
				//将Object类型的obj对象强制转换成Person类型
				Person person=(Person)obj;
				System.out.println("学号："+person.getNo()
						+"姓名："+person.getName()
						+"年龄："+person.getAge());
				obj = ois.readObject();
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally{			
			if(ois!=null)
				try {
					ois.close();//关闭文件
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
