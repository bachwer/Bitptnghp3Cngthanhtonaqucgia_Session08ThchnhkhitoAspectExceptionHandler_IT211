package org.example.ex3.dto;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class PaymentRequest {

    @NotNull
    private Double amount;

    @NotNull
    private String currency;

}