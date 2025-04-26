package dev.layseiras.qrcode.generator.repository;

import dev.layseiras.qrcode.generator.entity.QrCode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QrCodeRepository extends MongoRepository<QrCode, String> {
}
