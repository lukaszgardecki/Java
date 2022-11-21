package com.example.zad_66_jee_mysql;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao {
    private final DataSource dataSource;

    public RecipeDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException();
        }
    }

    List<Recipe> findAll() {
        final String sql = "SELECT id, title, description, ingredients, preptime FROM recipe";
        List<Recipe> resultList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String ingredients = resultSet.getString("ingredients");
                String description = resultSet.getString("description");
                int prepTime = resultSet.getInt("preptime");
                resultList.add(new Recipe(id, title, description, ingredients, prepTime));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }
}
