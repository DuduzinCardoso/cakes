package com.cake.controller;

import com.cake.service.S3ClientService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/file")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class S3ClientController {

    private final S3ClientService s3ClientService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Map<String, String>> uploadFile(@RequestPart("file") MultipartFile file) {
        String publicUrl = s3ClientService.uploadFile(file);
        Map<String, String> response = new HashMap<>();
        response.put("publicURL", publicUrl);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
