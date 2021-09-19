package ru.job4j.lsp;

import java.util.Date;

public record Food(String name,
                   Date createDate,
                   Date expiryDate,
                   double price,
                   int discount) {
}
