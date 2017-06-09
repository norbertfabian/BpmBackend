package cz.xfabian.bpm.controller;

import cz.xfabian.bpm.domain.Package;
import cz.xfabian.bpm.domain.Rma;
import cz.xfabian.bpm.repository.PackageRepository;
import cz.xfabian.bpm.repository.RmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Norbert Fábián on 6/6/2017.
 */

@RestController
@RequestMapping("/rma")
public class RmaController {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private RmaRepository rmaRepository;

    @RequestMapping(value = "/{code}/save", method = RequestMethod.POST)
    public Package save(@PathVariable("code") String code, @RequestBody Package box) {
        Package pack = packageRepository.findByCode(code);
        pack.getRma().setDescription(box.getRma().getDescription());
        pack.getRma().setApproved(box.getRma().isApproved());
        pack.getRma().setHarm(box.getRma().getHarm());
        pack.getRma().setNote(box.getRma().getNote());
        pack.getRma().setStatement(box.getRma().getStatement());
        pack.getRma().setMoneyToRefund(box.getRma().getMoneyToRefund());
        rmaRepository.save(pack.getRma());
        packageRepository.save(pack);
        return pack;
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.POST)
    public Package processInitForm(@PathVariable("code") String code, @RequestBody Package box) {
        Package pack = packageRepository.findByCode(code);
        Rma rma = new Rma();
        rma.setDescription(box.getRma().getDescription());
        rma.setPack(pack);
        rma.setApproved(false);
        pack.setRma(rma);
        rmaRepository.save(rma);
        packageRepository.save(pack);

        Package test = packageRepository.findByCode(code);
        return pack;
    }

    @RequestMapping(value = "/{code}/bank", method = RequestMethod.POST)
    public Package transferMoney(@PathVariable("code") String code, @RequestBody Package box) {
        Package pack = packageRepository.findByCode(code);
        System.out.println(pack.getRma().getMoneyToRefund() + " CZK has been transferred to bank.");
        return pack;
    }
}
