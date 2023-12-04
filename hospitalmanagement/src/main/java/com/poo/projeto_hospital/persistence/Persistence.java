package com.poo.projeto_hospital.persistence;

import java.util.List;

public interface Persistence <T> {
    String DIRECTORY = "data";
    public void save(List<T> list);
    public List<T> findAll();
    
} 
    

