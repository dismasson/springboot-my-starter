package com.sxli.mystarter.service;

public class DefaultSayHelloService implements SayHelloService {
    @Override
    public String say() {
        return "hello!";
    }
}
