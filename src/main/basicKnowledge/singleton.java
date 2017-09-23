/**
 * Created by yu on 17-9-19.
 */
//

// guideline:
// 1. 基础防止多线程的单例模式之饿汉模式
// 2. 懒汉模式
// 3. 参考effective java 的枚举模式 & 更进一步防止反射攻击的模式
// 4. JAVA 23 种常用设计模式 http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
//
/**
 *
 * 饿汉式单例，不管以后用不用这个对象，我们一开始就创建这个对象的实例，
 * 需要的时候就返回已创建好的实例对象，所以比较饥饿，故此叫饿汉式单例。
 *
 * http://blog.csdn.net/qq_29542611/article/details/52905516
 *
 */

//public class SingletonHanger {
//    private static final SingletonHanger instance = new SingletonHanger();
//    private SingletonHanger() {
//    }
//    public static SingletonHanger getInstance(){
//        return instance;
//    }
//}
/**
 * 懒汉汉式单例，在需要单例对象的时候，才创建唯一的单例对象，以后再次调用，返回的也是第一创建的单例对象
 * 将静态成员初始化为null，在获取单例的时候才创建，故此叫懒汉式。
 * @author qq1013985957
 *
 */
class SingletonLazy{
    private static SingletonLazy instance = null;
    private SingletonLazy() {
    }
    /**
     * 此方法实现的单例，无法在多线程中使用，多线可以同时进入if方法，会导致生成多个单例对象。
     * @return
     */
    public static SingletonLazy getInstance1(){
        if(instance==null){
            instance = new SingletonLazy();
        }
        return instance;
    }
    /**
     * 大家都会想到同步，可以同步方法实现多线程的单例
     * 但是这种方法不可取，严重影响性能，因为每次去取单例都要检查方法，所以只能用同步代码块的方式实现同步。
     * @return
     */
    public static synchronized SingletonLazy getInstance2(){
        if(instance==null){
            instance = new SingletonLazy();
        }
        return instance;
    }
    /**
     * 用同步代码块的方式，在判断单例是否存在的if方法里使用同步代码块，在同步代码块中再次检查是否单例已经生成，
     * 这也就是网上说的 双重检查加锁的方法
     * @return
     */
    public static synchronized SingletonLazy getInstance3(){
        if(instance==null){
            synchronized (SingletonLazy.class) {
                if(instance==null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
