package com.avensys.rts.addressservice.payloadrequest;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
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
