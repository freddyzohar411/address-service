package com.avensys.rts.addressservice.controller;

import com.avensys.rts.addressservice.constant.MessageConstants;
import com.avensys.rts.addressservice.payloadrequest.AddressRequestDTO;
import com.avensys.rts.addressservice.payloadrequest.AddressUpdateRequestDTO;
import com.avensys.rts.addressservice.payloadresponse.AddressResponseDTO;
import com.avensys.rts.addressservice.service.AddressServiceImpl;
import com.avensys.rts.addressservice.util.ResponseUtil;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * @author Koh He Xiang
 * This class is used to define the endpoints for the AddressController
 */
@RestController
public class AddressController {
    private final Logger log = LoggerFactory.getLogger(AddressController.class);
    private final AddressServiceImpl addressService;
    private final MessageSource messageSource;

    public AddressController(AddressServiceImpl addressService, MessageSource messageSource) {
        this.addressService = addressService;
        this.messageSource = messageSource;
    }

    /**
     * Create an address
     * @param addressRequest
     * @return HttpResponse
     */
    @PostMapping("/addresses")
    public ResponseEntity<Object> createAddress(@Valid @RequestBody AddressRequestDTO addressRequest) {
        log.info("Create address : Controller ");
        AddressResponseDTO createdAddress = addressService.createAddress(addressRequest);
        return ResponseUtil.generateSuccessResponse(createdAddress, HttpStatus.CREATED, messageSource.getMessage(MessageConstants.MESSAGE_CREATED, null, LocaleContextHolder.getLocale()));
    }

    /**
     * Get address by Id
     * @param addressId
     * @return HttpResponse
     */
    @GetMapping("/addresses/{addressId}")
    public ResponseEntity<Object> getAddressById(@PathVariable int addressId) {
        log.info("Get an address by id : Controller ");
        AddressResponseDTO address = addressService.getAddressById(addressId);
        return ResponseUtil.generateSuccessResponse(address, HttpStatus.OK, messageSource.getMessage(MessageConstants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
    }

    /**
     * Update address by Id
     * @param addressId
     * @param address
     * @return HttpResponse
     */
    @PutMapping("/addresses/{addressId}")
    public ResponseEntity<Object> updateAddress(@PathVariable int addressId, @Valid @RequestBody AddressUpdateRequestDTO address) {
        log.info("Update an address by Id : Controller ");
        AddressResponseDTO updatedAddress = addressService.updateAddress(addressId, address);
        return ResponseUtil.generateSuccessResponse(updatedAddress, HttpStatus.OK, "Address updated successfully");
    }

    /**
     * Delete address by Id
     * @param addressId
     * @return
     */
    @DeleteMapping("/addresses/{addressId}")
    public ResponseEntity<Object> deleteAddress(@PathVariable int addressId) {
        log.info("Delete an address by Id : Controller ");
        addressService.deleteAddress(addressId);
        return ResponseUtil.generateSuccessResponse(null, HttpStatus.OK, "Address deleted successfully");
    }
}
