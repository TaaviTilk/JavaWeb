package DAO;


import model.Vorm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {

    public void save(Vorm vorm);

    public List<Vorm> findAll();

    public void delete(int id);

    public void deleteAll();

    public Vorm findById(int id);

    public List<Vorm> findByKey(String key);



}
