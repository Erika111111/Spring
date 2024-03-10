package ru.geekbrains.example3sem3homeTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//  rest приложение для работы с пользователем

/*
создать сервис который принимает на вход данные о пользователе(имя, возраст, email), создает пользователя с помощью userServise, а затем использует dataprosesicServise для добавления пользователя в список и выполнение оппераций над этим списком. После выполнения каждой опперации использовать natificationServise для вывода информации о выполненной опперации в консоль
 */
public class Example3sem3homeTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(Example3sem3homeTaskApplication.class, args);
	}

}
