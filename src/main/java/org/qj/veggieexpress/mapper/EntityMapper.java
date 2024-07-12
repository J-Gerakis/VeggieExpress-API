package org.qj.veggieexpress.mapper;

import org.qj.veggieexpress.entity.Item;
import org.qj.veggieexpress.entity.Order;
import org.qj.veggieexpress.entity.OrderItem;
import org.qj.veggieexpress.repository.dao.ItemDAO;
import org.qj.veggieexpress.repository.dao.OrderDAO;
import org.qj.veggieexpress.repository.dao.OrderItemDAO;

import java.util.UUID;
import java.util.stream.Collectors;

public class EntityMapper {
    public static Item map(ItemDAO dao) {
        return Item.builder()
                .itemId(dao.getItemId())
                .itemName(dao.getItemName())
                .itemDescription(dao.getItemDesc())
                .itemAvailable(dao.isItemAvailable())
                .build();
    }

    public static ItemDAO map(Item item) {
        ItemDAO dao = new ItemDAO();
        dao.setItemId(item.getItemId());
        dao.setItemName(item.getItemName());
        dao.setItemDesc(item.getItemDescription());
        dao.setItemAvailable(item.isItemAvailable());
        return dao;
    }

    public static OrderItem map(OrderItemDAO dao) {
        return OrderItem.builder()
                .item(map(dao.getItem()))
                .quantity(dao.getQuantity())
                .orderRef(dao.getOrderId())
                .build();

    }

    public static Order map(OrderDAO dao) {
        return Order.builder()
                .orderID(dao.getOrderId())
                .customerID(dao.getCustomer().getCustomerId())
                .deliveryAddress(dao.getCustomer().getCustomerDeliveryAddress())
                .note(dao.getCustomer().getCustomerNote())
                .orderContent(dao.getOrderItemDAO().stream().map(EntityMapper::map).collect(Collectors.toSet()))
                .createdOn(dao.getCreatedOn())
                .deliveredOn(dao.getDeliveredOn())
                .build();
    }

}
