package com.avensys.rts.addressservice.payloadrequest;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * author: Koh He Xiang This is the DTO class for the Address request
 */
@Setter
@Getter
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

	// 0 - Mailing address
	// 1 - Billing address
	@NotNull
	private Short type;

	@NotNull
	private int entityId;

	@NotEmpty
	@Length(max = 15)
	private String entityType;

}
