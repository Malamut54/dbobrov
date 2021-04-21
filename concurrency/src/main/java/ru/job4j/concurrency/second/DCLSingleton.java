package ru.job4j.concurrency.second;

public class DCLSingleton {
    private volatile static DCLSingleton inst;

    public static DCLSingleton instOf() {
        DCLSingleton localInstance = inst;
        if (localInstance == null) {
            synchronized (DCLSingleton.class) {
                localInstance = inst;
                if (localInstance == null) {
                    localInstance = inst = new DCLSingleton();
                }
            }
        }
        return localInstance;
    }


    private DCLSingleton() {
    }
}
