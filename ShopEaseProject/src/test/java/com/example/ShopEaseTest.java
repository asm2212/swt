package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShopEaseTest {

    @Test
    public void testCalculateDiscountRegular() {
        double discount = ShopEase.calculateDiscount(MembershipStatus.REGULAR, 150.0);
        assertEquals(7.5, discount, "Discount for REGULAR membership with order value >= 100 should be 5%");
    }

    @Test
    public void testCalculateDiscountSilver() {
        double discount = ShopEase.calculateDiscount(MembershipStatus.SILVER, 150.0);
        assertEquals(22.5, discount, "Discount for SILVER membership with order value >= 100 should be 15%");
    }

    @Test
    public void testCalculateDiscountGold() {
        double discount = ShopEase.calculateDiscount(MembershipStatus.GOLD, 150.0);
        assertEquals(30.0, discount, "Discount for GOLD membership with order value >= 100 should be 20%");
    }

    @Test
    public void testCalculateDiscountNegativeOrderValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShopEase.calculateDiscount(MembershipStatus.REGULAR, -50.0);
        }, "Order value cannot be negative");
    }
}