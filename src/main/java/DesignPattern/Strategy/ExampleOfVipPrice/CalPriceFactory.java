package DesignPattern.Strategy.ExampleOfVipPrice;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Resource 和策略模式：
 * Spring中Resource 接口就是策略模式的典型应用
 * Resource 接口就代表资源访问策略，但具体采用哪种策略实现，Resource 接口并不理会。
 * 客户端程序只和 Resource 接口耦合，并不知道底层采用何种资源访问策略，这样应用可以在不同的资源访问策略之间自由切换。
 * 策略模式的优势：
 * 当 Spring 应用需要进行资源访问时，实际上并不需要直接使用 Resource 实现类，
 * 而是调用 ApplicationContext 实例的 getResource() 方法来获得资源，
 * ApplicationContext 将会负责选择 Resource 的实现类，也就是确定具体的资源访问策略，
 * 从而将应用程序和具体的资源访问策略分离开来，这就体现了策略模式的优势。
 * https://www.ibm.com/developerworks/cn/java/j-lo-spring-resource/
 */
public class CalPriceFactory {
    private static final String CAL_PRICE_PACKAGE = "DesignPattern.Strategy.ExampleOfVipPrice";
    private ClassLoader classLoader = getClass().getClassLoader();
    private List<Class<? extends CalPrice>> calPriceList;

    private CalPriceFactory() {
        init();
    }

    private enum Singleton {
        INSTANCE;
        private CalPriceFactory instance = new CalPriceFactory();
    }

    public static CalPriceFactory getInstacne() {
        return Singleton.INSTANCE.instance;
    }

    private void init() {
        calPriceList = new ArrayList<>();
        File[] resources = getResources();
        Class<CalPrice> calPriceClazz = null;
        try {
            calPriceClazz = (Class<CalPrice>) classLoader.loadClass(CalPrice.class.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("未找到策略接口");
        }
        for (File resource : resources) {
            try {
                Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE + "." + resource.getName().replace(".class", ""));
                if (CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClazz) {
                    calPriceList.add((Class<? extends CalPrice>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private File[] getResources() {
        try {
            File file = new File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class")) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("未找到策略资源");
        }
    }

    private PriceRegion handleAnnotation(Class<? extends CalPrice> clazz) {
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations != null && annotations.length > 0) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof PriceRegion) {
                    return (PriceRegion) annotation;
                }
            }
        }
        return null;
    }

    public CalPrice createCalPrice(Player player) {
        for (Class<? extends CalPrice> clazz : calPriceList) {
            PriceRegion priceRegion = handleAnnotation(clazz);
            if (player.getTotalAmount() > priceRegion.min() && player.getTotalAmount() < priceRegion.max()) {
                try {
                    return clazz.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException("策略获得失败");
                }
            }
        }
        throw new RuntimeException("策略获得失败");
    }
}
