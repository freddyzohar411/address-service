package com.avensys.rts.addressservice.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

/**
 * author: Koh He Xiang
 * This is the DTO class for the Address request
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {

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

    @NotNull
    private Short type;

    @NotNull
    private int entityId;

    @NotEmpty
    @Length(max = 15)
    private String entityType;

}
