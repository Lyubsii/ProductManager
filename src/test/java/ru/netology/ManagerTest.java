package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {


    @Test
    public void searchTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book = new Book(1, "Гарри Поттер 1", 100, "Джоан Роулинг");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        manager.add(book);
        manager.add(smartphone);
        manager.add(product);

        Product[] expected = {book};
        Product[] actual = manager.searchBy("Гарри");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTest2() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book = new Book(1, "Гарри Поттер", 100, "Джоан Роулинг");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "Бутылка";

        Product[] expected = {product};
        Product[] actual = manager.searchBy(name);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneNameTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Гарри Поттер", 100, "Джоан Роулинг");
        Book book2 = new Book(2, "Гарри Поттер", 100, "Джоан Роулинг1");
        Book book3 = new Book(3, "Лавр", 1000, "Водолазкин");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        manager.add(smartphone);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("Редми");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthorTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Гарри Поттер", 100, "Джоан Роулинг");
        Book book2 = new Book(2, "Гарри Поттер", 100, "Джоан Роулинг1");
        Book book3 = new Book(3, "Лавр", 1000, "Водолазкин");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        manager.add(smartphone);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Джоан Роулинг");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book = new Book(1, "Гарри Поттер", 100, "Джоан Роулинг");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        manager.add(smartphone);

        Product[] expected = {smartphone};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhenMoreThanOneItemTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Гарри Поттер", 100, "Джоан Роулинг");
        Book book2 = new Book(2, "Гарри Поттер", 100, "Джоан Роулинг");
        Book book3 = new Book(3, "Лавр", 1000, "Водолазкин");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        String name = "Гарри";

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy(name);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addAllTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book = new Book(1, "Гарри Поттер", 100, "Джоан Роулинг");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        manager.add(smartphone);
        manager.add(book);
        manager.add(product);

        Product[] expected = {smartphone, book, product};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void thereOneProductTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Product product = new Product(3, "Бутылка", 50);

        manager.add(product);

        Product[] expected = {product};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void thereSomeProductsTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Product product = new Product(3, "Бутылка", 50);
        Book book = new Book(1, "Гарри Поттер", 100, "Джоан Роулинг");

        manager.add(product);
        manager.add(book);

        Product[] expected = {product, book};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void thereSomeProductsTest2() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Гарри Поттер", 100, "Джоан Роулинг");
        Book book2 = new Book(2, "Гарри Поттер", 100, "Джоан Роулинг1");
        Book book3 = new Book(3, "Лавр", 1000, "Водолазкин");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        manager.searchBy("book1");
        manager.searchBy("book2");
        manager.searchBy("book3");
        manager.searchBy("smartphone");
        manager.searchBy("product");


        Product[] expected = {};
        Product[] actual = manager.searchBy("Лавр, Гарри Поттер, Бутылка");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void noProductsTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        String name = "Гарри";

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void noProductsTest2() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFindNullTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Product product = new Product(3, "Бутылка", 50);
        Book book = new Book(1, "Гарри Поттер", 100, "Джоан Роулинг");


        Product[] expected = {};
        Product[] actual = manager.searchBy(null);

        Assertions.assertArrayEquals(expected, actual);
    }

}
