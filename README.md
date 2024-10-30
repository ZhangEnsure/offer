# offer

## 值得回顾的题目

| 方法               | 题目                                                                     | 其他 |
| ------------------ | ------------------------------------------------------------------------ | ---- |
| 优先队列、单调队列 | [239. 滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/) |      |
|                    |                                                                          |      |

## Java选择题

1. 线程安全的集合：喂（vector）、SHE!（stack  hashtable enumeration）
2. Integer类型在-128-->127范围之间是被缓存了的，也就是每个对象的内存地址是相同的，赋值就直接从缓存中取，不会有新的对象产生，而大于这个范围，将会重新创建一个Integer对象，也就是new一个对象出来，当然地址就不同了，也就！=；
3. List和Set是collectin的子接口，Map是单独的一个。
4. 方法重载要求：**方法名称必须相同**；**参数列表必须不同**（个数不同、或类型不同、参数类型排列顺序不同等）；对返回值没有要求。
5. 重载就是一句话：同名不同参，返回值无关。覆盖/重写：同名同参。
6. 抽象类存在的意义在于被其它类继承然后实现其内部方法的，而被final关键字修饰的类不能被继承，这样final和抽象类之间就产生了矛盾。因此，final并不能修饰抽象类。
7. 重载的实现是编译器根据函数的不同的参数表，对同名函数的名称做修饰，那么对于编译器而言，这些同名函数就成了不同的函数。但重写则是子类方法对父类的方法的延申，即子类不仅继承了父类的方法，还向父类的方法中添加了属于自己的内容，改变了父类方法原本的内容，而final代表了一种不可变，这明显与重写形成了冲突。因此被final修饰的类可以被重载但不能被重写。
8. **final修饰类，则类不能被继承；final修饰方法，则方法不能被重写，可以被重载**。
9. java创建对象的5种方法：

* 使用 new 关键字（最常用）： ObjectName obj = new ObjectName();
* 使用反射的Class类的newInstance()方法： ObjectName obj = ObjectName.class.newInstance();
* 使用反射的Constructor类的newInstance()方法： ObjectName obj = ObjectName.class.getConstructor.newInstance();
* 使用对象克隆clone()方法： ObjectName obj = obj.clone();
* 使用反序列化（ObjectInputStream）的readObject()方法： try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) { ObjectName obj = ois.readObject(); }

10. Java的跨平台特性是因为JVM的存在， 它可以执行.class字节码文件，而不是.java源代码。
11. Java对象初始化过程：

**初始化父类中的静态成员变量和静态代码块**

- 静态成员变量和静态代码块首先被初始化，按照它们在父类中出现的顺序。

**初始化子类中的静态成员变量和静态代码块**

- 静态成员变量和静态代码块接着被初始化，按照它们在子类中出现的顺序。

**初始化父类的普通成员变量和代码块，再执行父类的构造方法**

- 普通成员变量和代码块首先按照它们在父类中出现的顺序被初始化，然后执行父类的构造方法。

**初始化子类的普通成员变量和代码块，再执行子类的构造方法**

- 普通成员变量和代码块按照它们在子类中出现的顺序被初始化，然后执行子类的构造方法。

12. 方法调用时，会创建栈帧在栈中，调用完是程序自动出栈释放，而不是gc释放.
13. 类初始化，先执行父类静态成员变量默认初始化，随后是执行父类静态方法，子类静态成员变量默认初始化，执行子类静态方法。
14. 抽象类是没有方法体的。

```Java
// wrong
abstract class Animal{abstract void growl(){System.out.println( “growl”);};}
// right
abstract class Animal{abstract void growl();}
```

15. 在Java中，创建并启动线程主要有以下两种方式：

> 1. 通过继承 Thread 类
>    这种方式涉及创建一个新的类，该类继承自 Thread 类，并重写其 run 方法。然后，你可以创建这个类的实例并调用其 start 方法来启动线程。

```java
class MyThread extends Thread {
    @Override
    public void run() {
        // 线程执行的代码
        System.out.println("Thread running...");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start(); // 启动线程
    }
}
```

> 2. 通过实现 Runnable 接口
>    这种方式涉及创建一个新的类，该类实现 Runnable 接口，并实现其 run 方法。然后，你可以创建这个类的实例，并将其作为参数传递给 Thread 类的构造器。最后，调用 Thread 实例的 start 方法来启动线程。

```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // 线程执行的代码
        System.out.println("Thread running...");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start(); // 启动线程
    }
}
```
16. Thread.sleep()是占用着锁，但释放CPU，












