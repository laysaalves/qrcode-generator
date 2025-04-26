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
        String qrCodeUrl = baseAddress + "/qrcode/" + fileName;

        QrCode qrCode = new QrCode(null, baseAddress, qrCodeUrl);
        repository.save(qrCode);

        return qrCodeUrl;
    }
}

