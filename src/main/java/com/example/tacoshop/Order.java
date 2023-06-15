package com.example.tacoshop;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.stereotype.Component;


@Data
@Component
public class Order {
    @NotEmpty(message = "Name is required")
    @Size(min = 2,message = "Name must be at least 2 characters long")
    private String name;

    @NotEmpty(message = "Address is required")
    @Size(min = 10, message = "Address must be at least 10 characters long")
    private String address;

    @NotEmpty(message = "City is required")
    private String city;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String cardNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String cardExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String cardCVV;
}
