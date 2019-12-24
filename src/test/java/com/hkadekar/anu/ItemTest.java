package com.hkadekar.anu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class ItemTest {

    @Test
    void verifyItemSort(){
        Item it1 = new Item(UUID.randomUUID(), "test2", 50.2, "type1", Boolean.TRUE);
        Item it2 = new Item(UUID.randomUUID(), "test1", 50.2, "type2", Boolean.TRUE);
        Item it3 = new Item(UUID.randomUUID(), "test3", 100.4, "type1", Boolean.TRUE);
        Item[] its = {it1, it2, it3};
        Item[] sortedArr = {it2, it1, it3};
        Arrays.sort(its);
        Assertions.assertArrayEquals(its, sortedArr);
    }

    @Test
    void verifyOrderItemSort(){
        UUID testItemID = UUID.randomUUID();
        OrderedItem it1 = new OrderedItem(UUID.randomUUID(), 4, OrderStatus.ORDERED, new Date(), testItemID, "test1", 50.2, "type2", Boolean.TRUE);
        OrderedItem it2 = new OrderedItem(UUID.randomUUID(), 2, OrderStatus.ORDERED, new Date(), testItemID, "test1", 50.2, "type2", Boolean.TRUE);
        OrderedItem it3 = new OrderedItem(UUID.randomUUID(), 1, OrderStatus.ORDERED, new Date(), UUID.randomUUID(), "test0", 24.1, "type2", Boolean.TRUE);
        OrderedItem[] its = {it1, it2, it3};
        OrderedItem[] sortedArr = {it3, it1, it2};
        Arrays.sort(its);
        Assertions.assertArrayEquals(its, sortedArr);

    }

    @Test
    void verifyOrderItemSpecialSort(){
        UUID testItemID = UUID.randomUUID();
        OrderedItem it1 = new OrderedItem(UUID.randomUUID(), 4, OrderStatus.ORDERED, new Date(), testItemID, "test1", 50.2, "type2", Boolean.TRUE);
        OrderedItem it2 = new OrderedItem(UUID.randomUUID(), 2, OrderStatus.ORDERED, new Date(), testItemID, "test1", 50.2, "type2", Boolean.TRUE);
        OrderedItem it3 = new OrderedItem(UUID.randomUUID(), 1, OrderStatus.ORDERED, new Date(), UUID.randomUUID(), "test0", 24.1, "type2", Boolean.TRUE);
        OrderedItem[] its = {it1, it2, it3};
        OrderedItem[] sortedArr = {it3, it2, it1};
        Arrays.sort(its, new OrderItemComparator());
        Assertions.assertArrayEquals(its, sortedArr);

    }

    @Test
    void verifyOrderItemLambdaSort(){
        UUID testItemID = UUID.randomUUID();
        OrderedItem it1 = new OrderedItem(UUID.randomUUID(), 4, OrderStatus.ORDERED, new Date(), testItemID, "test1", 50.2, "type2", Boolean.TRUE);
        OrderedItem it2 = new OrderedItem(UUID.randomUUID(), 2, OrderStatus.ORDERED, new Date(), testItemID, "test1", 50.2, "type2", Boolean.TRUE);
        OrderedItem it3 = new OrderedItem(UUID.randomUUID(), 1, OrderStatus.ORDERED, new Date(), UUID.randomUUID(), "test0", 24.1, "type2", Boolean.TRUE);
        OrderedItem[] its = {it1, it2, it3};
        OrderedItem[] sortedArr = {it3, it2, it1};
        Arrays.sort(its, (x, y) -> x.getQuantity() - y.getQuantity());
        Assertions.assertArrayEquals(its, sortedArr);
    }
}
