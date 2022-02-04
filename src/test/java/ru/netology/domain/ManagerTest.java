package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private final Product firstProduct = new Product(1, "N1", 1);
    private final Product secondProduct = new Product(2, "N2", 1);
    private final Book firstBook = new Book(3, "firstBook", 3, "A1");
    private final Book secondBook = new Book(4, "secondBook", 3, "A2");
    private final Smartphone firstSmartphone = new Smartphone(5, "firstSmartphone", 10, "M1");
    private final Smartphone secondSmartphone = new Smartphone(6, "secondSmartphone", 10, "M2");

    private final Manager manager = new Manager(new ProductRepository());

    @BeforeEach
    void setUp() {
        manager.add(firstProduct);
        manager.add(secondProduct);
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
    }

    @Test
    public void findPhone() {
        Product[] expected = {firstSmartphone};
        Product[] actual = manager.searchBy("firstSmartphone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void find2Phone() {
        Product[] expected = {secondSmartphone};
        Product[] actual = manager.searchBy("M2");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findBook(){
        Product[] expected = {secondBook};
        Product[] actual = manager.searchBy("A2");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void find2Book(){
        Product[] expected = {firstBook};
        Product[] actual = manager.searchBy("firstBook");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findEmptyBook(){
        Product[] expected = {};
        Product[] actual = manager.searchBy("pokpiu");

        assertArrayEquals(expected, actual);
    }

}