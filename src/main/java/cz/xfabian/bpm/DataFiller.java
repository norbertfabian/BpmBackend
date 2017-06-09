package cz.xfabian.bpm;

import cz.xfabian.bpm.domain.*;
import cz.xfabian.bpm.domain.Package;
import cz.xfabian.bpm.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Norbert Fábián on 6/6/2017.
 */
@Component
public class DataFiller {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private RmaRepository rmaRepository;

    public void fillData() {
        Customer customer1 = new Customer("Norbert Fabian", "Vinarska 5, Brno",
                "Czech republic", 60200);
        customer1.setEmail("Sender@sender.com");
        customer1.setPhoneNumber("+123 456 789 159");
        Customer customer2 = new Customer("Fakulta informatiky MU", "Botanicka 5, Brno",
                "Czech republic", 60200);
        Customer customerToEdit = new Customer("Fakulta informatiky MU", "Botanicka 5, Brno",
                "Czech republic", 60200);

        Package box = new Package(customer1, customer2, "TestPackage", "Sent", "Brno post office", false);

        Log log1 = new Log("Package received", "2/17/2017", box);
        Log log2 = new Log("Package registered", "2/17/2017", box);
        Log log3 = new Log("Package sent to Brno", "2/18/2017", box);

        box.getLogs().add(log1);
        box.getLogs().add(log2);
        box.getLogs().add(log3);

        Package editableBox = new Package(customer1, customerToEdit, "Editable", "Sent", "Brno post office", true);

        Package notEditableBox = new Package(customer1, customer2, "NotEditable", "Sent", "Brno post office", false);

        Package insured = new Package(customer1, customer2, "Insured", "Sent", "Brno post office", false);
        Package notInsured = new Package(customer1, customer2, "NotInsured", "Sent", "Brno post office", false);

        Insurance insurance = new Insurance(insured, 8000, "Basic insurance");
        Insurance withoutInsurance = new Insurance(insured, 5000, "No insurance");

        insured.setInsurance(insurance);
        notInsured.setInsurance(withoutInsurance);

        insuranceRepository.save(insurance);
        insuranceRepository.save(withoutInsurance);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customerToEdit);

        packageRepository.save(box);
        packageRepository.save(editableBox);
        packageRepository.save(notEditableBox);
        packageRepository.save(insured);
        packageRepository.save(notInsured);


        logRepository.save(log1);
        logRepository.save(log2);
        logRepository.save(log3);


        // TEST DATA WITH ALL FILLED FIELDS
        Customer testSender = new Customer();
        testSender.setPhoneNumber("123456");
        testSender.setEmail("Email");
        testSender.setAddress("Address");
        testSender.setCountry("Country");
        testSender.setName("Name");
        testSender.setPostalCode(123456);
        Customer testReceiver = new Customer();
        testReceiver.setPhoneNumber("123456");
        testReceiver.setEmail("Email");
        testReceiver.setAddress("Address");
        testReceiver.setCountry("Country");
        testReceiver.setName("Name");
        testReceiver.setPostalCode(123456);
        Insurance testInsurence = new Insurance();
        testInsurence.setHighestCoverage(10000);
        testInsurence.setInsuranceType("TestType");
        Rma testRma = new Rma();
        testRma.setApproved(false);
        testRma.setDescription("Description");
        testRma.setEmail("RmaEmail");
        testRma.setHarm(500);
        testRma.setNote("Note");
        testRma.setStatement("Statement");
        testRma.setMoneyToRefund(10000);
        Log testLog = new Log();
        testLog.setDate("1.1.2010");
        testLog.setText("Text");
        Package testPackage = new Package(testSender, testReceiver, "TestCode", "Sent", "Location", false);
        testPackage.setRma(testRma);
        testRma.setPack(testPackage);
        testPackage.getLogs().add(testLog);
        testLog.setPack(testPackage);
        testPackage.setInsurance(testInsurence);
        testInsurence.setPack(testPackage);

        insuranceRepository.save(testInsurence);
        rmaRepository.save(testRma);
        customerRepository.save(testSender);
        customerRepository.save(testReceiver);
        packageRepository.save(testPackage);
        logRepository.save(testLog);
    }
}
