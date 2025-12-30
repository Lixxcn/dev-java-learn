package cn.lixx.designpatterns.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * Context (环境类)
 * Stores global information, specifically the mapping between variable names and their integer values.
 */
public class Context {
    private Map<String, Integer> map = new HashMap<>();

    public void assign(String key, int value) {
        map.put(key, value);
    }

    public int getValue(String key) {
        return map.getOrDefault(key, 0);
    }
}
