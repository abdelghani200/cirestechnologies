package com.cirestechnologies.cirestechnologies.web;

import com.cirestechnologies.cirestechnologies.dtos.resp.UploadRes;
import com.cirestechnologies.cirestechnologies.services.Interfaces.JsonFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class JsonFileController {

    private final JsonFileService jsonFileService;

    public ResponseEntity<UploadRes> uploadUsers(@RequestParam("file")MultipartFile file) throws IOException {
        return ResponseEntity.ok(jsonFileService.saveJsonFile(file));
    }

}
