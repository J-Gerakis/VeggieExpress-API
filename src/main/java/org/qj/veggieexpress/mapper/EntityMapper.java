package org.qj.veggieexpress.mapper;

import org.qj.veggieexpress.entity.Customer;
import org.qj.veggieexpress.entity.Item;
import org.qj.veggieexpress.entity.Order;
import org.qj.veggieexpress.entity.OrderItem;
import org.qj.veggieexpress.repository.dao.CustomerDAO;
import org.qj.veggieexpress.repository.dao.ItemDAO;
import org.qj.veggieexpress.repository.dao.OrderDAO;
import org.qj.veggieexpress.repository.dao.OrderItemDAO;

import java.util.stream.Collectors;

public class EntityMapper {
    public static Item map(ItemDAO dao) {
        if (dao == null) { return Item.builder().build(); }
        return Item.builder()
                .itemId(dao.getItemId())
                .itemName(dao.getItemName())
                .itemDescription(dao.getItemDesc())
                .itemAvailable(dao.isItemAvailable())
                .build();
    }

    public static ItemDAO map(Item item) {
        ItemDAO dao = new ItemDAO();
        if (item == null) return dao;
        dao.setItemId(item.getItemId());
        dao.setItemName(item.getItemName());
        dao.setItemDesc(item.getItemDescription());
        dao.setItemAvailable(item.isItemAvailable());
        return dao;
    }

    public static OrderItem map(OrderItemDAO dao) {
        if (dao == null) { return OrderItem.builder().build(); }
        return OrderItem.builder()
                .item(map(dao.getItem()))
                .quantity(dao.getQuantity())
                .orderRef(dao.getOrderId())
                .build();

    }

    public static Order map(OrderDAO dao) {
        if (dao == null) { return Order.builder().build(); }
        return Order.builder()
                .orderID(dao.getOrderId())
                .customerID(dao.getCustomer().getCustomerId())
                .deliveryAddress(dao.getCustomer().getCustomerDeliveryAddress())
                .note(dao.getDeliveryNote())
                .orderContent(dao.getOrderItemDAO().stream().map(EntityMapper::map).collect(Collectors.toSet()))
                .createdOn(dao.getCreatedOn())
                .deliveredOn(dao.getDeliveredOn())
                .build();
    }

    public static Customer map(CustomerDAO dao) {
        if (dao == null) { return Customer.builder().build(); }
        return Customer.builder()
                .customerId(dao.getCustomerId())
                .name(dao.getCustomerName())
                .address(dao.getCustomerDeliveryAddress())
                .phone(dao.getCustomerPhone())
                .note(dao.getCustomerNote())
                .build();
    }

}
