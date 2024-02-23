package com.avensys.rts.addressservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * @author Koh He Xiang This is the entity class for the address table in the
 *         database
 */
@Entity
@Table(name = "address")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "line_1", length = 100)
	private String line1;

	@Column(name = "line_2", length = 100)
	private String line2;

	@Column(name = "line_3", length = 100)
	private String line3;

	@Column(name = "city", length = 20)
	private String city;

	@Column(name = "country", length = 20) // CHANGE
	private String country;

	@Column(name = "postal_code", length = 20)
	private String postalCode;

	/**
	 * 0 - Mailing address 1 - Billing address
	 */
	@Column(name = "type")
	private Short type;

	@Column(name = "entity_id")
	private int entityId;

	/**
	 * Account Candidate Job
	 */
	@Column(name = "entity_type", length = 15)
	private String entityType;

}
