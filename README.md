##组件化封装思想实战
+ fragment的切换有多少种方式，有区别吗？
+ 只要我们创建了Activity一定要在manifest中声明吗？
+ Activity的启动模式有几种，你能熟练主导他们各自使用的场景吗？
+ 实际开发中，对各种文件的命名有什么规范？
+ Application
    + 整个程序的入口
    + 初始化工作
    + 为整个应用的其他模块提供上下文环境

    ```java
    public class MyApplication extends Application{
        private static MyApplication mApplication = null;
        
        public void onCreate(){
            super.onCreate();
            mApplication = this;
        }
        
        public static MyApplication getInstance(){
            return mApplication;
        }
    }
    ```
