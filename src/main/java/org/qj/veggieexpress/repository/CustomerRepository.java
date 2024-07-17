package org.qj.veggieexpress.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.qj.veggieexpress.entity.Customer;
import org.qj.veggieexpress.mapper.EntityMapper;
import org.qj.veggieexpress.repository.dao.CustomerDAO;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer getCustomerById(UUID id) {
        return EntityMapper.map(entityManager.find(CustomerDAO.class, id));
    }

    public Customer getCustomerByPhone(String phone) {
        TypedQuery<CustomerDAO> query = entityManager.createNamedQuery("Customer.findByPhone", CustomerDAO.class);
        query.setParameter("phone", phone);
        return EntityMapper.map(query.getSingleResult());
    }

    public UUID addCustomer(Customer customer) {
        CustomerDAO dao = new CustomerDAO();
        dao.setCustomerName(customer.getName());
        dao.setCustomerDeliveryAddress(customer.getAddress());
        dao.setCustomerPhone(customer.getPhone());
        dao.setCustomerNote(customer.getNote());
        entityManager.persist(dao);
        entityManager.flush();
        return dao.getCustomerId();
    }
}
