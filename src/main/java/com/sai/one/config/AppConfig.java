package com.sai.one.config;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.sai.one.constants.PropertyConstants;
import com.sai.one.model.UserOptional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = PropertyConstants.App.BASE_PACKAGE)
class AppConfig {

    @Bean
    @Scope(PropertyConstants.App.SCOPE_PROTOTYPE)
    public UserOptional userOptional() {
        return new UserOptional();
    }

    @Bean
    public Bucket createCouchCluster() {
        // Connect to localhost
        Cluster cluster = CouchbaseCluster.create();
        return cluster.openBucket();
    }
}