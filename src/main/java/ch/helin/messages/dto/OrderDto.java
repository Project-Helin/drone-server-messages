package ch.helin.messages.dto;

import ch.helin.messages.dto.way.Position;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class OrderDto {
    private UUID projectId;
    private String customerName;
    private Position deliveryPosition;
    private Set<OrderProductDto> orderProducts;
    private String state;
    private List<MissionDto> missions;

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Position getDeliveryPosition() {
        return deliveryPosition;
    }

    public void setDeliveryPosition(Position deliveryPosition) {
        this.deliveryPosition = deliveryPosition;
    }

    public Set<OrderProductDto> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProductDto> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<MissionDto> getMissions() {
        return missions;
    }

    public void setMissions(List<MissionDto> missions) {
        this.missions = missions;
    }
}
