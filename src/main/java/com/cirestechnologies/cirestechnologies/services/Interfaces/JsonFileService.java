package com.cirestechnologies.cirestechnologies.services.Interfaces;

import com.cirestechnologies.cirestechnologies.dtos.resp.UploadRes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface JsonFileService {
    UploadRes saveJsonFile(MultipartFile jsonFile) throws IOException;
}
