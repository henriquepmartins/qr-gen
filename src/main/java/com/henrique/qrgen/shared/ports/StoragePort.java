package com.henrique.qrgen.shared.ports;

public interface StoragePort {
    public String uploadFile(byte[] fileData, String fileName, String contentType);
    
}
