package org.peanut.code.designpattern.singleton;

/**
 * 单例传递构造方法参数
 *
 * @author lch
 */
public class SingletonParamThree {

    private static SingletonParamThree instance = null;

    private final int paramA;

    private final int paramB;

    private SingletonParamThree() {
        this.paramA = Config.PARAM_A;
        this.paramB = Config.PARAM_B;
    }

    public synchronized static SingletonParamThree getInstance() {
        if (instance == null) {
            instance = new SingletonParamThree();
        }
        return instance;
    }
}
