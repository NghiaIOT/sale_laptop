package com.hcm.sale_laptop.data.enums;

public enum OrderStatus {
    PENDING_CONFIRMATION("Chờ xác nhận"),
    AWAITING_PICKUP("Chờ lấy hàng"),
    AWAITING_DELIVERY("Chờ giao"),
    CANCELED("Hủy đơn"),
    COMPLETED("Thành công");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
