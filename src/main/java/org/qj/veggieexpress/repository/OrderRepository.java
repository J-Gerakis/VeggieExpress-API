package org.qj.veggieexpress.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.qj.veggieexpress.entity.Order;
import org.qj.veggieexpress.mapper.EntityMapper;
import org.qj.veggieexpress.repository.dao.CustomerDAO;
import org.qj.veggieexpress.repository.dao.OrderDAO;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.UUID;

@Repository
@Transactional
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public OrderRepository() {}

    public Order getOrderById(UUID id) {
        return EntityMapper.map(entityManager.find(OrderDAO.class, id));
    }

    public UUID save(Order order) {

        CustomerDAO cDao = entityManager.find(CustomerDAO.class, order.getCustomerID());

        OrderDAO orderDAO = new OrderDAO();
        orderDAO.setCustomer(cDao);
        orderDAO.setPaid(false);
        orderDAO.setStatus(0);
        orderDAO.setOrderItemDAO(new HashSet<>());
        orderDAO.setCreatedOn(LocalDateTime.now());

        entityManager.persist(orderDAO);
        entityManager.flush();
        return orderDAO.getOrderId();
    }
}
