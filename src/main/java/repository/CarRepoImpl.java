package repository;

import beans.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

@Component
public class CarRepoImpl implements CarRepo{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Car save(Car car) {
        String sqlQuery = "INSERT INTO car VALUES (?,?)";
        jdbcTemplate.update(sqlQuery, generateId(), car.getBrand());
        List<Car> allCars = jdbcTemplate.query("SELECT * FROM car", new RowMapper<Car>() {
            @Override
            public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
                Car c = new Car();
                c.setId(rs.getInt(1));
                c.setBrand(rs.getString(2));
                return c;
            }
        });
        return allCars.get(allCars.size()-1);
    }
    private static int generateId(){
        return new Random().nextInt();
    }
}
