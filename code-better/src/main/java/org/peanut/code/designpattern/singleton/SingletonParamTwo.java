package org.peanut.code.designpattern.singleton;

/**
 * 单例传递构造方法参数
 *
 * @author lch
 */
public class SingletonParamTwo {

    private static SingletonParamTwo instance = null;

    private final int paramA;

    private final int paramB;

    private SingletonParamTwo(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    @Deprecated
    public synchronized static SingletonParamTwo getInstance(int paramA, int paramB) {
        if (instance == null) {
            instance = new SingletonParamTwo(paramA, paramB);
        }
        return instance;
    }

    public synchronized static SingletonParamTwo getInstanceGraceful(int paramA, int paramB) {
        if (instance == null) {
            instance = new SingletonParamTwo(paramA, paramB);
        } else {
            if (paramA != instance.paramA || paramB != instance.paramB) {
                throw new RuntimeException("SingletonParamTwo has been initialized!");
            }
        }
        return instance;
    }
}
