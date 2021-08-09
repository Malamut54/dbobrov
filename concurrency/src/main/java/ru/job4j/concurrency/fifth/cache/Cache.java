package ru.job4j.concurrency.fifth.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

    private final Map<Integer, Base> memory = new ConcurrentHashMap<>();

    public boolean add(Base model) {
        return memory.putIfAbsent(model.getId(), model) == null;
    }

    public boolean update(Base model) {
        return memory.computeIfPresent(model.getId(), (key, value) -> {
            if (value.getVersion() != model.getVersion()) {
                throw new OptimisticException("Error while update");
            }
            Base base = new Base(model.getId(), model.getVersion() + 1);
            base.setName(model.getName());
            return base;
        }) != null;
    }

    public boolean delete(Base model) {
        return memory.remove(model.getId()) != null;
    }
}
