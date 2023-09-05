package com.avensys.rts.addressservice.payloadrequest;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressUpdateRequestDTO {

    @Length(max = 100)
    private String line1;

    @Length(max = 100)
    private String line2;

    @Length(max = 100)
    private String line3;

    @Length(max = 20)
    private String city;

    @Length(max = 20)
    private String country;

    @Length(max = 20)
    private String postalCode;

    // 0 - Mailing address
    // 1 - Billing address
    @NotNull
    private Short type;

}
