package com.henrique.qrgen.qrcode.infrastructure;

import com.henrique.qrgen.qrcode.application.QrCodeGenerateRequest;
import com.henrique.qrgen.qrcode.application.QrCodeGenerateResponse;
import com.henrique.qrgen.qrcode.application.QrCodeGeneratorService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/qrcode")
public class QrCodeController {
    private final QrCodeGeneratorService qrCodeGeneratorService;

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generateQrCode(@RequestBody QrCodeGenerateRequest request) {

        try {
            QrCodeGenerateResponse response = this.qrCodeGeneratorService.generateAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
