package cz.xfabian.bpm.controller;

import cz.xfabian.bpm.domain.Package;
import cz.xfabian.bpm.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Norbert Fábián on 6/3/2017.
 */
@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private PackageRepository packageRepository;

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Package getInfo(@PathVariable("code") String code) {
        return packageRepository.findByCode(code);
    }
}
