package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {

    // Добавляет пользователя и соответствующий ему автомобиль
    void add(User user, Car car);

    // Получает список всех пользователей
    List<User> listUsers();

    // Получает пользователя по модели и серии автомобиля
    User getUserByCar(String model, int series);

}