/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.persistence;

import java.util.List;

public interface Persistence<T> {

    String DIRECTORY = "data";

    public void save(List<T> itens);

    public List<T> findAll();

}
