package com.sai.one.chache;

import com.couchbase.client.java.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CouchBaseImpl implements Cache {

    @Autowired
    @Qualifier("createCouchCluster")
    private Bucket bucket;

    @Override
    public void save(String key, Object value) {
        bucket.insert(key,value);
    }

    @Override
    public void update(String key, Object value) {
        bucket.replace(key,value)
    }

    @Override
    public void upsert(String key, Object value) {
        bucket.upsert(key);
    }

    @Override
    public void delete(String key) {
        bucket.remove(key);
    }

    @Override
    public void get(String key, boolean touch, short timer) {
        if(touch)
        {
            bucket.getAndTouch(key,timer);
        }else{
            bucket.get(key);
        }

    }
}
