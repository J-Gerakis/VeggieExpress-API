package org.qj.veggieexpress.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.qj.veggieexpress.controller.dto.NewOrderItemRequestDTO;
import org.qj.veggieexpress.controller.dto.NewOrderRequestDTO;
import org.qj.veggieexpress.entity.Order;
import org.qj.veggieexpress.entity.OrderItem;
import org.qj.veggieexpress.mapper.EntityMapper;
import org.qj.veggieexpress.repository.dao.CustomerDAO;
import org.qj.veggieexpress.repository.dao.ItemDAO;
import org.qj.veggieexpress.repository.dao.OrderDAO;
import org.qj.veggieexpress.repository.dao.OrderItemDAO;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Transactional
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public OrderRepository() {}

    public Optional<Order> getOrderById(UUID id) {
        OrderDAO orderDAO = entityManager.find(OrderDAO.class, id);
        if (orderDAO == null) {
            return Optional.empty();
        }
        return Optional.of(EntityMapper.map(entityManager.find(OrderDAO.class, id)));
    }

    public List<Order> getOrdersByCustomerId(UUID customerId) { return null; }

    public List<Order> getAll(){
        TypedQuery<OrderDAO> query1 = entityManager.createNamedQuery("getAllOrders", OrderDAO.class);
        return query1.getResultList().stream().map(EntityMapper::map).toList();
    }

    public UUID create(NewOrderRequestDTO orderRequestDTO) {
        UUID cuid = orderRequestDTO.customerId();
        CustomerDAO cDao = entityManager.find(CustomerDAO.class, cuid);

        OrderDAO orderDAO = new OrderDAO();
        orderDAO.setCustomer(cDao);
        orderDAO.setPaid(false);
        orderDAO.setStatus(0);
        orderDAO.setOrderItemDAO(convertList(orderRequestDTO.content()));
        orderDAO.setCreatedOn(LocalDateTime.now());
        orderDAO.setDeliveryNote(orderRequestDTO.deliveryNote());

        entityManager.persist(orderDAO);
        entityManager.flush();
        return orderDAO.getOrderId();
    }

    public void addToOrder(NewOrderItemRequestDTO orderItemRequestDTO) {
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        orderItemDAO.setOrderId(orderItemRequestDTO.orderId());
        orderItemDAO.setQuantity(orderItemRequestDTO.quantity());
        orderItemDAO.setItem(entityManager.find(ItemDAO.class, orderItemRequestDTO.itemId()));
        entityManager.persist(orderItemDAO);
        entityManager.flush();
    }

    private Set<OrderItemDAO> convertList(List<OrderItem> itemList) {
        return itemList.stream().map(this::convert).collect(Collectors.toSet());
    }

    private OrderItemDAO convert(OrderItem orderItem) {
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        orderItemDAO.setOrderId(orderItem.getOrderRef());
        orderItemDAO.setItem(EntityMapper.map(orderItem.getItem()));
        orderItemDAO.setQuantity(orderItem.getQuantity());
        return orderItemDAO;
    }
}
