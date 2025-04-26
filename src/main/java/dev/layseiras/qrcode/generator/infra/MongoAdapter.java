package dev.layseiras.qrcode.generator.infra;

import dev.layseiras.qrcode.generator.entity.QrCode;
import dev.layseiras.qrcode.generator.ports.MongoPort;
import dev.layseiras.qrcode.generator.repository.QrCodeRepository;
import org.springframework.stereotype.Component;

@Component
public class MongoAdapter implements MongoPort {

    private final QrCodeRepository repository;

    public MongoAdapter(QrCodeRepository repository) {
        this.repository = repository;
    }

    @Override
    public String save(byte[] fileContent, String fileName, String baseAddress) {
        String publicUrl = "http://localhost:8080/qrcodes/" + fileName;

        QrCode qrCode = new QrCode(null, baseAddress, publicUrl);
        repository.save(qrCode);

        return publicUrl;
    }
}

