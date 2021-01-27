package org.peanut.code.designpattern.singleton;

/**
 * 单例传递构造方法参数
 *
 * @author lch
 */
public class SingletonParamOne {

    private static SingletonParamOne instance = null;

    private final int paramA;

    private final int paramB;

    private SingletonParamOne(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static SingletonParamOne getInstance() {
        if (instance == null) {
            throw new RuntimeException("Run SingletonParamOne#init() first!");
        }
        return instance;
    }

    public synchronized static SingletonParamOne init(int paramA, int paramB) {
        if (instance != null) {
            throw new RuntimeException("SingletonParamOne has been created!");
        }
        instance = new SingletonParamOne(paramA, paramB);
        return instance;
    }
}
