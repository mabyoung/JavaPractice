package DesignPattern.Factory.SimpleFactory.ReflectionVersion;

/**
 * 使用反射机制改善简单工厂,虽然符合了开放封闭原则 ，但是每一次传入的都是产品类的全部路径，这样比较麻烦
 * 如果需要改善的话可以通过 反射+配置文件 的形式来改善，这种方式使用的也是比较多的
 */
public class ShapeFactory {
    public static Shape getShape(Class<? extends Shape> clazz){
        Shape shape = null;
        try {
            shape = (Shape) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shape;
    }
}
