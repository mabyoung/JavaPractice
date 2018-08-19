package DesignPattern.Strategy.ExampleOfVipPrice;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class CalPriceFactory {
    private static final String CAL_PRICE_PACKAGE = "DesignPattern.Strategy.ExampleOfVipPrice";
    private ClassLoader classLoader = getClass().getClassLoader();
    private List<Class<? extends CalPrice>> calPriceList;

    private CalPriceFactory(){
        init();
    }

    private enum Singleton{
        INSTANCE;
        private CalPriceFactory instance = new CalPriceFactory();
    }
    public static CalPriceFactory getInstacne(){
        return Singleton.INSTANCE.instance;
    }

    private void init(){
        calPriceList = new ArrayList<>();
        File[] resources = getResources();
        Class<CalPrice> calPriceClazz = null;
        try {
            calPriceClazz = (Class<CalPrice>)classLoader.loadClass(CalPrice.class.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("未找到策略接口");
        }
        for (File resource : resources) {
            try {
                Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE + "." + resource.getName());
                if (CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClazz){
                    calPriceList.add((Class<? extends CalPrice>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private File[] getResources(){
        try {
            File file = new File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class")){
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
            if (player.getTotalAmount() > priceRegion.min() && player.getTotalAmount() <priceRegion.max()){
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
