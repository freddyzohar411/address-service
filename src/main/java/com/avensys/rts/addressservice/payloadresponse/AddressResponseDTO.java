package com.avensys.rts.addressservice.payloadresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * author: Koh He Xiang This is the DTO class for the Address response
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDTO {
	private Integer id;
	private String line1;
	private String line2;
	private String line3;
	private String city;
	private String country;
	private String postalCode;
	private Short type;
	private int entityId;
	private String entityType;
}
