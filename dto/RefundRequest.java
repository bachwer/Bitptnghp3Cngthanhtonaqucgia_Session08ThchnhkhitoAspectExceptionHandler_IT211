package org.example.ex3.dto;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import org.hibernate.annotations.processing.Pattern;

@Getter
@Setter
public class RefundRequest {

    @NotBlank
    @Pattern(
            regexp = "^[A-Z0-9]+$",
            message = "transactionCode không hợp lệ"
    )
    private String transactionCode;

    @NotNull
    private Double amount;

}