package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test // prep
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    // isPrime
    @Test
    void returnsTrueForTwo() {
        boolean result = CourseToolkit.isPrime(2);

        assertTrue(result);
    }
    @Test
    void returnsFalseForLessThanTwo() {
        boolean result = CourseToolkit.isPrime(1);

        assertFalse(result);
    }
    @Test
    void returnsFalseForNotPrimeNumber() {
        boolean result = CourseToolkit.isPrime(16);

        assertFalse(result);
    }
    @Test
    void returnsTrueForPrimeNumber() {
        boolean result = CourseToolkit.isPrime(97);

        assertTrue(result);
    }

    // isPalindrome
    @Test
    void returnsTrueForPalindrome() {
        boolean result = CourseToolkit.isPalindrome("abcddcba");

        assertTrue(result);
    }
    @Test
    void returnsFalseForNotPalindrome() {
        boolean result = CourseToolkit.isPalindrome("abCddcBa");

        assertFalse(result);
    }
    @Test
    void returnsTrueForEmptyBrackets() {
        boolean result = CourseToolkit.isPalindrome("");

        assertTrue(result);
    }
    @Test
    void returnsErrorForNoText() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }

    // average
    @Test
    void returnsAverageForPositiveNumbers() {
        int[] values = {2, 4, 6};

        double result = CourseToolkit.average(values);

        assertEquals(4.0, result);
    }
    @Test
    void returnsAverageForNegativeNumbers() {
        int[] values = {-2, -4, -6};

        double result = CourseToolkit.average(values);

        assertEquals(-4.0, result);
    }
    @Test
    void returnsErrorForEmptyArray() {
        int[] values = {};

        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(values));
    }
}
