# 2019-2020 第一学期 外包复习提纲

> Written By  就是爱吃肉肉(http://csdn.acmaker.vip) & Cafu-chino(https://cafu-chino.top)

## 第一章 初识java

### 1) 区别 javac命令 和 java命令
### 2) 单行注释, 多行注释, 块注释

> **单行注释**
>
> ```java
> //
> ```


> **多行注释**
>
> ```java
> /*...*/
> ```


> **块注释**
>
> ```java
> /**
> 	*/
> ```

---



## 第二章 java基础知识

### 1) 类型转换相关, 区别显示类转换 和 隐式类型转换
### 2) 数组的两种声明并创建的方式

```java
int arr_1[11]; 
int []arr_2 = new int[4];
```



---


## 第三章 类与对象

### 1) 理解构造方法, Getter, Setter
```java
public Dog ( ) { };
public Dog ( String _name, short age ) {
    supper( );
    this.name = _name;
    this.age = age;
}
public String getName ( ) {
    return name;
}
public void setName ( String _name ) {
    this.name = _name;
}
```

### 2) 三种访问修饰符 和 缺省访问修饰符 之间的区别,作用

#### 访问权限

> private > friendly > public


### 3) static方法和变量 是 此类及其子类共有的

### 4) 重载和重写 区别 :
> 重写是子类重写父类的方法, 方法签名不变. 

> 重载只是名字一样, 方法签名不同, 返回值也可以不同

---


## 第四章 类之间的关系

### 对于这次考试没啥好写的吧...

---

## 第五章 抽象类,接口和内部类

### 1) 抽象类, 接口 都不能被实例化

> 抽象类的子类不一定是抽象类, 
> 如果子类没有声明 abstract 那么就不是抽象类. 
> 此时, 该子类必须实现抽象类的所有抽象方法

### 2) 内部类 看代码（lambda表达式）

---


## 第六章 异常处理

### 1) 常见异常分类

| 常见的非检查型异常 |                  |
|----| ---- |
| ClassCastException | 错误类型转化异常 |
| ArrayIndexOutOfBoundException | 数组下标越界异常 |
| NullPointerException | 空指针访问异常 |
| ArithmeticException | 除以0异常 |

| 常见的检查型异常 |            |
| ---- | ---- |
| SQLException | 操作数据库异常 |
| IOEXception | 操作文件异常 |
| FileNotFoundException | 文件不存在异常 |
| ClassNotFoundException | 找不到指定类异常 |
| NumberFormatException | 数字格式化异常 |

### 2) 父类异常捕获所有异常

### 3) 多重嵌套异常处理

#### Example 【1】多重异常处理

```java
try {
    int x = 10/0;
} catch ( Exception e ) {
    ...
} catch ( ArithmeticException e) {
    ...
}
```

##### 运行结果

```txt
Exception e抛出异常
# 多重嵌套相当于if else
```

#### Example 【2】嵌套异常处理

```java
public class ExceptionDemo {
	public static void main(String args[]) {
		try {
			try {
				int x = 10 / 0;
			} catch (Exception e) {
				System.out.println("wwww");
			}
		} catch (ArithmeticException e) {
			System.out.println("hhhh");
		} finally {
			System.out.println("All right...");
		}
	}
}
```
##### 运行结果

```txt
wwww
All right...
```

#### Example 【3】嵌套异常处理

```java
public class ExceptionDemo {
	public static void main(String args[]) {
		try {
			try {
				int x = 10 / 0;
			} catch (ArithmeticException e) {
				System.out.println("wwww");
			}
		} catch (Exception e) {
			System.out.println("hhhh");
		} finally {
			System.out.println("All right...");
		}
	}
}
```

##### 运行结果

```txt
wwww
All right...
```

### 4) throw 和 throws 

---

## 第七章 泛型和集合

### 1) 泛型类型不能是基本数据类型

### 2) 泛型不能别实例化

### 3) 泛型不能处理异常

### 4) 集合, 具体方法实现看代码

---

## 第八章 流和文件 具体看代码

---

## 第九章 jdbc 本学期不考

---

## 第十,十一章 Swing图形不考, 考 javaFX

### JavaFX代码样例

#### 带有事件的测试程序

```java
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HandleEvent_lambda extends Application {

	private TextField tf= new TextField("this is a text filed.");
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox pane=new HBox(10);
		Button btOK = new Button("OK");
		Button btCancel= new Button("Cancel");

    //（1）/（2）
		
		pane.getChildren().addAll(tf,btOK,btCancel);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Handle Event");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
}
```

##### 1）lambda表达式写事件监听器

```java
//		使用lambda表达式注册处理器(监听器)
//		显示指定参数类型(e)->{重写方法的方法体代码}或e->{重写方法的方法体代码}
		btOK.setOnAction(e->{
			tf.setText("OK button clicked");
		});
		
//		显示指定参数类型(ActionEvent e)->{重写方法的方法体代码}
		btCancel.setOnAction((ActionEvent e)->{
			tf.setText("Cancel button clicked");
		});
```

##### 2）使用匿名类写事件监听器

```java
//		 使用匿名类的方式注册处理器（监听器）
		btOK.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				tf.setText("OK button clicked");
			}
		});
		
		btCancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				tf.setText("Cancel button clicked");
			}
		});
```

> *注意：主程序**后四行**也要考

---

## 第十二章 线程 具体看代码

> 同步需在Run方法前加上**synchronized**（具体请看书P.309）

---

## 第十三章 网络套接字 具体看代码（客户端，服务端）

---