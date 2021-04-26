package com.yc.springboot.helloworld.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "yc")
//@Configuration
public class YcProperties {
    private String tname;
    private int age;

    public String getTname() {
        return tname;
    }

    public int getAge() {
        return age;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
