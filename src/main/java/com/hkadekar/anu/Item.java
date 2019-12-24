package com.hkadekar.anu;

import java.util.UUID;

public class Item implements Comparable<Item> {
    private UUID itemId;
    private String name;
    private Double price;
    private String group;
    private Boolean isAvailable;

    public Item(UUID itemId, String name, Double price, String group, Boolean isAvailable) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.group = group;
        this.isAvailable = isAvailable;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public int compareTo(Item it) {
        if(Double.compare(this.price, it.price) == 0){
            return this.name.compareTo(it.name);
        } else {
            return Double.compare(this.price, it.price);
        }

    }
}
