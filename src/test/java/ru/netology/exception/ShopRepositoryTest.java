package ru.netology.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveIfProductFind() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(12, "стол", 13_000);
        Product product2 = new Product(16, "кровать", 34_000);
        Product product3 = new Product(23, "стул", 5_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(12);
        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testException() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(12, "стол", 13_000);
        Product product2 = new Product(16, "кровать", 34_000);
        Product product3 = new Product(23, "стул", 5_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(25);
        });
    }
}
