package com.sai.one.chache;

public interface Cache<T> {

    void save(String key, T value);

    void update(String key, T value);

    void upsert(String key, T value);

    void delete(String key);

    void get(String key);

}
