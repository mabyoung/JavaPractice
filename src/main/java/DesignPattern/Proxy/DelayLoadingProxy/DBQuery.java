package DesignPattern.Proxy.DelayLoadingProxy;

public class DBQuery implements IDBQuery{
    public DBQuery(){
        try {
            //假设数据库连接等耗时操作
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "真实对象被创建了";
    }
}
