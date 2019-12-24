package com.hkadekar.anu;

import java.util.Comparator;

public class OrderItemComparator implements Comparator<OrderedItem> {
    @Override
    public int compare(OrderedItem item1, OrderedItem item2) {
        return item1.getQuantity() - item2.getQuantity();
    }
}
