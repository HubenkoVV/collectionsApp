package com.company.hashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Vladyslava_Hubenko on 7/18/2018.
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity + 1, 1.1F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }
}
