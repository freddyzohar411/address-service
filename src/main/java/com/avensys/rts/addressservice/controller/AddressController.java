package com.avensys.rts.addressservice.controller;

import com.avensys.rts.addressservice.constant.MessageConstants;
import com.avensys.rts.addressservice.entity.AddressEntity;
import com.avensys.rts.addressservice.payload.AddressRequestDTO;
import com.avensys.rts.addressservice.payload.AddressResponseDTO;
import com.avensys.rts.addressservice.service.AddressServiceImpl;
import com.avensys.rts.addressservice.util.ResponseUtil;
import feign.Response;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
     * Get industry by  path variable
     * @param addressId
     * @return HttpResponse
     */
    @GetMapping("/addresses/{addressId}")
    public ResponseEntity<Object> getIndustryByName(@PathVariable int addressId) {
        log.info("Get an address by id : Controller ");
        AddressResponseDTO address = addressService.getAddressById(addressId);
        return ResponseUtil.generateSuccessResponse(address, HttpStatus.OK, messageSource.getMessage(MessageConstants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
    }

    /**
     * Update industry by path variable
     * @param addressId
     * @param address
     * @return HttpResponse
     */
    @PutMapping("/addresses/{addressId}")
    public ResponseEntity<Object> updateIndustry(@PathVariable int addressId, @Valid @RequestBody AddressRequestDTO address) {
        log.info("Update an address by Id : Controller ");
        AddressResponseDTO updatedAddress = addressService.updateAddress(addressId, address);
        return ResponseUtil.generateSuccessResponse(updatedAddress, HttpStatus.OK, "Address updated successfully");
    }
}
