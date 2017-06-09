package cz.xfabian.bpm.controller;

import cz.xfabian.bpm.domain.Customer;
import cz.xfabian.bpm.domain.Package;
import cz.xfabian.bpm.repository.CustomerRepository;
import cz.xfabian.bpm.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Norbert Fábián on 5/25/2017.
 */
@RestController
@RequestMapping("/changeAddress")
public class ChangeAddressController {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public Package changeAddress(@RequestBody Package box) {
        Package persistedPackage = packageRepository.findByCode(box.getCode());
        Customer receiver = persistedPackage.getReceiver();
        receiver.setAddress(box.getReceiver().getAddress());
        receiver.setName(box.getReceiver().getName());
        customerRepository.save(receiver);
        return box;
    }
}