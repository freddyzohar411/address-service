package com.avensys.rts.addressservice.service;

import com.avensys.rts.addressservice.entity.AddressEntity;
import com.avensys.rts.addressservice.payload.AddressRequestDTO;
import com.avensys.rts.addressservice.payload.AddressResponseDTO;

/**
 * @author Koh He Xiang
 * This interface is used to define the methods for the AddressService
 */
public interface AddressService {

    /**
     * This method is used to create a new address
     * @param address
     * @return
     */
    AddressResponseDTO createAddress(AddressRequestDTO address);

    /**
     * This method is used to get address by id
     * @param addressId
     * @return
     */
    AddressResponseDTO getAddressById(int addressId);

    /**
     * This method is used to update address by id
     * @param addressId
     * @param address
     * @return
     */
    AddressResponseDTO updateAddress(int addressId, AddressRequestDTO address);

    /**
     * This method is used to delete address by id
     * @param addressId
     */
    void deleteAddress(int addressId);
}
