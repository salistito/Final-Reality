package com.github.salix07.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnifeTest {

    private static final String KNIFE_NAME = "Test Knife";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;

    private Knife testKnife;

    @BeforeEach
    void setUp() {
        testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
        var anotherKnife1 = new Knife("Duskblade of Draktharr", DAMAGE, SPEED);
        var anotherKnife2 = new Knife(KNIFE_NAME, 10, SPEED);
        var anotherKnife3 = new Knife(KNIFE_NAME, DAMAGE, 15);
        var expectedStaff = new Staff(KNIFE_NAME, DAMAGE, 20, SPEED);

        assertEquals(expectedKnife, testKnife);
        assertEquals(expectedKnife.hashCode(), testKnife.hashCode());

        assertEquals(testKnife, testKnife);
        assertEquals(testKnife.hashCode(), testKnife.hashCode());

        assertEquals(expectedKnife, testKnife);
        assertNotEquals(anotherKnife1, testKnife);
        assertNotEquals(anotherKnife2, testKnife);
        assertNotEquals(anotherKnife3, testKnife);
        assertNotEquals(expectedStaff, testKnife);
    }

    @Test
    void gettersTest() {
        assertEquals(KNIFE_NAME, testKnife.getName());
        assertEquals(DAMAGE, testKnife.getDamage());
        assertEquals(SPEED, testKnife.getWeight());
    }

    @Test
    void toStringTest() {
        String expectedString = "Knife";
        assertEquals(expectedString, testKnife.toString());
    }
}