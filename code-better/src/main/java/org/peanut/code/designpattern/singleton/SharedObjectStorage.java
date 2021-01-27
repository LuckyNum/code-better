package org.peanut.code.designpattern.singleton;

public class SharedObjectStorage {

    public Object load(Class clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    public void save(Object object, Class clazz) {
        System.out.println("保存Class文件");
    }
}
