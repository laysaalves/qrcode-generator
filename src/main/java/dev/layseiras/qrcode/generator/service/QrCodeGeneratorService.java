package dev.layseiras.qrcode.generator.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import dev.layseiras.qrcode.generator.dtos.QrCodeDTOResponse;
import dev.layseiras.qrcode.generator.exceptions.QrCodeGenerationException;
import dev.layseiras.qrcode.generator.ports.MongoPort;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeGeneratorService {

    private final MongoPort port;

    public QrCodeGeneratorService(MongoPort port) {
        this.port = port;
    }

    public QrCodeDTOResponse generateAndSaveQrCode(String baseAddress) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(baseAddress, BarcodeFormat.QR_CODE, 200, 200);

            ByteArrayOutputStream pngOutput = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutput);

            byte[] pngQrCodeData = pngOutput.toByteArray();

            String url = port.save(pngQrCodeData, UUID.randomUUID().toString(), baseAddress);

            return new QrCodeDTOResponse(url);
        } catch (WriterException | IOException e) {
            throw new QrCodeGenerationException("Erro ao gerar o QR Code", e);
        }
    }
}

