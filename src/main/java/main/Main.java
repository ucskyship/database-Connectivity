package main;

import beans.Car;
import config.CarRepoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import repository.CarRepo;
import repository.CarRepoImpl;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "beans")
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setId(1);
        car.setBrand("Toyota");

        Car car2 = new Car();
        car2.setId(2);
        car2.setBrand("Benz");

        List<Car> cars = List.of(new Car(3, "Lambo"), new Car(4, "Passat"), new Car(5, "Picanto"), new Car(6, "Peugot"), new Car(7, "Tesla"));

        var context = new AnnotationConfigApplicationContext(CarRepoConfig.class);

        CarRepo carRepo = context.getBean(CarRepoImpl.class);
        Car savedCar = carRepo.save(car);
        cars.forEach(car1 -> carRepo.save(car1));
        System.out.println("saved car --> " + savedCar);
    }
}
