package com.avensys.rts.addressservice.service;

import com.avensys.rts.addressservice.controller.AddressController;
import com.avensys.rts.addressservice.entity.AddressEntity;
import com.avensys.rts.addressservice.payload.AddressRequestDTO;
import com.avensys.rts.addressservice.payload.AddressResponseDTO;
import com.avensys.rts.addressservice.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Koh He Xiang
 * This class is used to implement the methods for the AddressService
 */
@Service
public class AddressServiceImpl implements AddressService {

    private final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    /**
     * This method is used to create a new address
     * @param addressRequest
     * @return AddressResponseDTO
     */
    @Override
    public AddressResponseDTO createAddress(AddressRequestDTO addressRequest) {
        AddressEntity addressCreated = addressRepository.save(toAddressEntity(addressRequest));
        log.info("Address created : Service");
        return toAddressResponseDTO(addressCreated);
    }

    /**
     * @param id
     * @return AddressEntity
     */
    @Override
    public AddressResponseDTO getAddressById(int id) {
        AddressEntity address = addressRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Address with id " + id + " not found")
        );
        log.info("Address retrieved : Service");
        return toAddressResponseDTO(address);
    }

    /**
     * This method is used to update address by id
     * @param addressId
     * @param address
     * @return
     */
    @Override
    public AddressResponseDTO updateAddress(int addressId, AddressRequestDTO address) {
        AddressEntity addressUpdate = addressRepository.findById(addressId).orElseThrow(
                () -> new EntityNotFoundException("Address with id " + addressId + " not found")
        );
        addressUpdate.setLine1(address.getLine1());
        addressUpdate.setLine2(address.getLine2());
        addressUpdate.setLine3(address.getLine3());
        addressUpdate.setCity(address.getCity());
        addressUpdate.setCountry(address.getCountry());
        addressUpdate.setPostalCode(address.getPostalCode());
        AddressEntity addressUpdated = addressRepository.save(addressUpdate);
        log.info("Address updated : Service");
        return toAddressResponseDTO(addressUpdated);
    }

    @Override
    public void deleteAddress(int addressId) {
        AddressEntity address = addressRepository.findById(addressId).orElseThrow(
                () -> new EntityNotFoundException("Address with id " + addressId + " not found")
        );
        addressRepository.delete(address);
        log.info("Address deleted : Service");
    }


    /**
     * Internal method is used to convert AddressRequestDTO to AddressEntity
     * @param addressRequest
     * @return
     */
    private AddressEntity toAddressEntity(AddressRequestDTO addressRequest) {
        AddressEntity address = new AddressEntity();
        address.setLine1(addressRequest.getLine1());
        address.setLine2(addressRequest.getLine2());
        address.setLine3(addressRequest.getLine3());
        address.setCity(addressRequest.getCity());
        address.setCountry(addressRequest.getCountry());
        address.setPostalCode(addressRequest.getPostalCode());
        address.setType(addressRequest.getType());
        address.setEntityId(addressRequest.getEntityId());
        address.setEntityType(addressRequest.getEntityType());
        return address;
    }

    /**
     * Internal method is used to convert AddressEntity to AddressResponseDTO
     * @param addressEntity
     * @return
     */
    private AddressResponseDTO toAddressResponseDTO (AddressEntity addressEntity){
        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
        addressResponseDTO.setId(addressEntity.getId());
        addressResponseDTO.setLine1(addressEntity.getLine1());
        addressResponseDTO.setLine2(addressEntity.getLine2());
        addressResponseDTO.setLine3(addressEntity.getLine3());
        addressResponseDTO.setCity(addressEntity.getCity());
        addressResponseDTO.setCountry(addressEntity.getCountry());
        addressResponseDTO.setPostalCode(addressEntity.getPostalCode());
        addressResponseDTO.setType(addressEntity.getType());
        addressResponseDTO.setEntityId(addressEntity.getEntityId());
        addressResponseDTO.setEntityType(addressEntity.getEntityType());
        return addressResponseDTO;
    }
}
