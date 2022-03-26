package com.example.Operasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class OperasalesApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OperasalesApplication.class, args);

        OperaRepozitory operaRepozitory = applicationContext.getBean(OperaRepozitory.class);


        Primera newPr = new Primera(3, "Кармен", "Комик, Париж, Франция", Kategory.PG_13, 20);
        operaRepozitory.addPr(newPr);

        operaRepozitory.printAll();
        System.out.println("Выберете id премьеру:");

        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();

        Primera pr = operaRepozitory.getPremieraById(id);

        Ticket ticket = operaRepozitory.buy(pr.getName());


        System.out.println("Вы приобрели билет:");

        System.out.println(ticket);

        operaRepozitory.printAll();

    }

}
