package dev.layseiras.qrcode.generator.ports;

public interface MongoPort {
    String save(byte[] fileContent, String fileName, String contentType);
}
