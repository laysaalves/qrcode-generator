package dev.layseiras.qrcode.generator.controller;

import dev.layseiras.qrcode.generator.dtos.QrCodeDTORequest;
import dev.layseiras.qrcode.generator.dtos.QrCodeDTOResponse;
import dev.layseiras.qrcode.generator.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeGenerate {

    private final QrCodeGeneratorService service;

    public QrCodeGenerate(QrCodeGeneratorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<QrCodeDTOResponse> generate(@RequestBody QrCodeDTORequest request) {
        try {
            QrCodeDTOResponse response = this.service.generateAndSaveQrCode(request.baseAddress());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
