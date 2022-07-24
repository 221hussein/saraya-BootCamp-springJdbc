package com.example.springjdbc.service;


import com.example.springjdbc.model.Product;
import com.example.springjdbc.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepository repository;
        public List<Product> getTodos(){

            String sql ="SELECT * FROM todos";
            return repository.getTodos(sql);
        }
}
