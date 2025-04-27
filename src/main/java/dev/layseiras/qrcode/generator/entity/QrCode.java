package dev.layseiras.qrcode.generator.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "qrcode")
public class QrCode {
    @Id
    private String id;

    private String baseAddress;
    private String qrCodeUrl;

    public QrCode(){}

    public QrCode(String id, String baseAddress, String qrCodeUrl) {
        this.id = id;
        this.baseAddress = baseAddress;
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }
}
