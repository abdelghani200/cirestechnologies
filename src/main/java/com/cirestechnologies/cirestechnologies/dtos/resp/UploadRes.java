package com.cirestechnologies.cirestechnologies.dtos.resp;

import lombok.Data;

@Data
public class UploadRes {
    private Integer totalRecords;
    private Integer importedRecords;
    private Integer failedRecords;
}
