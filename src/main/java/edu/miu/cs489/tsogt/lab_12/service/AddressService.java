package edu.miu.cs489.tsogt.lab_12.service;


import edu.miu.cs489.tsogt.lab_12.dto.address.AddressResponse;
import edu.miu.cs489.tsogt.lab_12.model.Address;

import java.util.List;

public interface AddressService {
    Address addAddress(Address address);

    List<AddressResponse> getAllAddressesWithPatients();
}
