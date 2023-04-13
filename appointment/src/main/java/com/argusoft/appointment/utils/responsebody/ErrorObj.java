package com.argusoft.appointment.utils.responsebody;

public class ErrorObj<K,V> {
    private K key;
    private V message;
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getMessage() {
        return message;
    }
    public void setMessage(V message) {
        this.message = message;
    }
    public ErrorObj(K key, V message) {
        this.key = key;
        this.message = message;
    }
    public ErrorObj() {
    }


    
    
}
