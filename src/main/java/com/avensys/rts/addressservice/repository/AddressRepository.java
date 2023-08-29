package com.avensys.rts.addressservice.repository;

import com.avensys.rts.addressservice.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Koh He Xiang
 * This is the repository class for the address table in the database
 */
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

}
