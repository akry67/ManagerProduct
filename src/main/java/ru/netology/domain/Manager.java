package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class Manager {
    // добавьте необходимые поля, конструкторы и методы

    private ProductRepository repository;
    Product[] products = new Product[0];

    public Manager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        // ваш код
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getMaker().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
            }
        }
        return false;
    }
}
//    public boolean matches(Product product, String search) {
//        if (product instanceof Book) { // если в параметре product лежит объект класса Book
//            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
//            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
//                return true;
//            }
//            if (book.getName().contains(search)) {
//                return true;
//            }
//            return false;
//        }
//    ...
//        return false;
//        }
//    }

