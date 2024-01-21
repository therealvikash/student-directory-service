package com.bma.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CommonErrorVO {
    @Schema(description = "Specifies the error code")
    private String errorCode;

    @Schema(description = "Specifies the error description")
    private String errorDescription;
}
