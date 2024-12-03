package com.backEnd.Tecnolo.model;

import com.backEnd.Tecnolo.model.Item;

public class BaseEntityValidator {

    public static void validarItem(Item item) {
        if (item.getNome() == null || item.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }

        if (item.getPreco() == null) {
            throw new IllegalArgumentException("O preço não pode ser nulo.");
        }

        // Adicione outras validações conforme necessário
    }
}
