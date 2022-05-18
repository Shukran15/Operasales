package com.example.operasales;

import com.example.operasales.model.Kategory;
import com.example.operasales.service.OperaService;
import com.example.operasales.model.Primera;
import com.example.operasales.model.Ticket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;


@SpringBootApplication
public class OperasalesApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OperasalesApplication.class, args);

        OperaService operaService = applicationContext.getBean(OperaService.class);

        Primera newPr = new Primera(3, "Кармен", "Комик, Париж, Франция", Kategory.PG_13, 20);

        operaService.addPr(newPr);


        operaService.printAll();
        System.out.println("Выберете id премьеру:");

        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();

        Primera pr = operaService.getPremieraById(id);

        Ticket ticket = operaService.buy(pr.getName());


        System.out.println("Вы приобрели билет:");

        System.out.println(ticket);

        operaService.printAll();


    }

}