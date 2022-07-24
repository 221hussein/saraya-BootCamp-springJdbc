package com.example.springjdbc.repository;

import com.example.springjdbc.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository {
    
    Connection cnx;
    private void openConnexion(){
        try{
            if (cnx == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/java_todos";
                String user ="root";
                String pwd ="";
                cnx = DriverManager.getConnection(url,user,pwd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeConnexion(){
        try {
            if (cnx != null){
                cnx.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Product> getTodos(String sql) {
        List<Product> products =new ArrayList<>();
        try {
            openConnexion();
            Statement stmt = cnx.createStatement();
            ResultSet result =  stmt.executeQuery(sql);
        }catch (Exception e){
            e.printStackTrace();

        }finally {

            closeConnexion();
        }
        return products;
    }
}
