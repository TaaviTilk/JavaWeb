package controller;

import DAO.CustomerDao;
import model.Vorm;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Resource
    private CustomerDao customerDao;

    private List<Vorm> vorms = new ArrayList<>();


    @PostMapping("customers")
    public void save(@RequestBody Vorm vorm){
        customerDao.save(vorm);
    }

    @GetMapping("customers/{id}")
    public Vorm getCustomerById(@PathVariable @Valid int id){
        return customerDao.findById(id);
    }

    @GetMapping("customers")
    public List<Vorm> getAllCustomers(){
        return customerDao.findAll();
    }

    @DeleteMapping("customers")
    public void deleteAll(){
        customerDao.deleteAll();
    }

    @DeleteMapping("customers/{id}")
    public void deleteCustomerById(@PathVariable int id){
        customerDao.delete(id);
    }

    @GetMapping("customers/search")
    public List<Vorm> findByKey(@RequestParam (defaultValue = "") String key){
        return customerDao.findByKey(key);
    }


}