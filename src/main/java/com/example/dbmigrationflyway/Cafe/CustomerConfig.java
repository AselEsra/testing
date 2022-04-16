//package com.week6.api.Customer;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class CustomerConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
//        return args -> {Customer esra = new Customer(
//                "esra",
//                "ozyilmaz",
//                "+283234",
//                "bishkek"
//        );
//            Customer osman = new Customer(
//                    "osman",
//                    "ozyilmaz",
//                    "+872348257",
//                    "bishkek"
//            );
//            customerRepository.saveAll(List.of(esra,osman));
//        };
//    }
//}
