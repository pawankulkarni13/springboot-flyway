package com.stark.springbootflyway.migrations;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class V3__InsertDataIntoUsersUsingJavaMigration extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws SQLException {

        final JdbcTemplate jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true));

        // Create 10 random users
        for (int i = 1; i <= 10; i++) {
            jdbcTemplate.execute(String.format("INSERT INTO users(username, first_name, last_name)"
                    + "values('%d@dev', 'Pawan_%d', 'Kulkarni_%d')", i, i, i));
        }
    }
}