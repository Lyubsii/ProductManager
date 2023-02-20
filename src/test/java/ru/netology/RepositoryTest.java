package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    @Test
    public void addTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book = new Book(1, "Гарри Поттер 1", 100, "Джоан Роулинг");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        manager.add(book);
        manager.add(smartphone);
        manager.add(product);

        Product[] expected = {book, smartphone, product};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneProduct() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book = new Book(1, "Гарри Поттер 1", 100, "Джоан Роулинг");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        repo.add(smartphone);
        Product[] expected = {smartphone};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddAllTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book = new Book(1, "Гарри Поттер 1", 100, "Джоан Роулинг");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        repo.add(smartphone);
        repo.add(book);
        repo.add(product);
        Product[] expected = {smartphone, book, product};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book = new Book(1, "Гарри Поттер 1", 100, "Джоан Роулинг");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        repo.add(book);
        repo.add(smartphone);
        repo.add(product);
        repo.removeById(2);
        Product[] expected = {book, product};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdAllTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book = new Book(1, "Гарри Поттер 1", 100, "Джоан Роулинг");
        Smartphone smartphone = new Smartphone(2, "Редми", 20000, "Производитель");
        Product product = new Product(3, "Бутылка", 50);

        repo.add(book);
        repo.add(smartphone);
        repo.add(product);
        repo.removeById(1);
        repo.removeById(2);
        repo.removeById(3);

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }



}
