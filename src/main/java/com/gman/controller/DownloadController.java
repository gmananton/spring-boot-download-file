package com.gman.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by Anton Mikhaylov on 29.12.2020.
 */
@RestController
public class DownloadController {

    private static final String PDF_RESOURCE = "/static/doc.pdf";

    @GetMapping(value = "pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getPdf(@RequestParam(value = "disposition", required = false, defaultValue = "attachment") String contentDisposition) {

        byte[] file = loadFile(PDF_RESOURCE);

        StringBuilder dispositionSB = "inline".equalsIgnoreCase(contentDisposition) ? new StringBuilder("inline") : new StringBuilder("attachment");
        String disposition = dispositionSB.append(";filename=doc.pdf").toString();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, disposition)
                .body(file);
    }



    //NOT WORKING
    @GetMapping("base64")
    public ResponseEntity<byte[]> getAsBase64() {
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf;base64"))
                .body(Base64Utils.encode(loadFile(PDF_RESOURCE)));
    }


    private static byte[] loadFile(String filename) {

        byte buffer[] = new byte[0x100];
        int count;
        try (BufferedInputStream bis = new BufferedInputStream(DownloadController.class.getResourceAsStream(filename));
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            while ((count = bis.read(buffer, 0, 0x100)) > 0) {
                baos.write(buffer, 0, count);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load file filename=" + filename + " error=" + e.getMessage(), e);
        }
    }


}

