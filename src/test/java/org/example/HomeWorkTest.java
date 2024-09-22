package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {

    @Test
    void test() {
        var hw = new HomeWork();
        hw.add(1);
        hw.add(2);
        hw.add(3);
        hw.add(4);
        hw.add(5);
        hw.add(6);
        var result = hw.findMaxDigits(3, 3);
        assertAll(
                () -> assertEquals(3, result.size()),
                () -> assertEquals(3, result.get(0)),
                () -> assertEquals(2, result.get(1)),
                () -> assertEquals(1, result.get(2))
        );
    }

    @Test
    void notFindReal() {
        var hw = new HomeWork();
        hw.add(1);
        hw.add(2);
        hw.add(30);
        hw.add(45);
        hw.add(55);
        hw.add(66);
        var result = hw.findMaxDigits(3, 35);
        assertAll(
                () -> assertEquals(3, result.size()),
                () -> assertEquals(30, result.get(0)),
                () -> assertEquals(2, result.get(1)),
                () -> assertEquals(1, result.get(2))
        );
    }

    @Test
    void notFind() {
        var hw = new HomeWork();
        hw.add(1);
        hw.add(2);
        hw.add(30);
        hw.add(45);
        hw.add(55);
        hw.add(66);
        var result = hw.findMaxDigits(0, -1);
        assertAll(
                () -> assertEquals(0, result.size())
        );
    }


}