package com.avensys.rts.addressservice.service;

import com.avensys.rts.addressservice.payloadrequest.AddressRequestDTO;
import com.avensys.rts.addressservice.payloadrequest.AddressUpdateRequestDTO;
import com.avensys.rts.addressservice.payloadresponse.AddressResponseDTO;

/**
 * @author Koh He Xiang
 * This interface is used to define the methods for the AddressService
 */
public interface AddressService {

    /**
     * This method is used to create a new address
     * @param address
     * @return AddressResponseDTO
     */
    AddressResponseDTO createAddress(AddressRequestDTO address);

    /**
     * This method is used to get address by id
     * @param addressId
     * @return AddressResponseDTO
     */
    AddressResponseDTO getAddressById(int addressId);

    /**
     * This method is used to update address by id
     * @param addressId
     * @param addressRequest
     * @return AddressResponseDTO
     */
    AddressResponseDTO updateAddress(int addressId, AddressUpdateRequestDTO addressRequest);

    /**
     * This method is used to delete address by id
     * @param addressId
     */
    void deleteAddress(int addressId);
}
