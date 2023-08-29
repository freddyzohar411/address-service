//package com.avensys.rts.addressservice.bootstrap;
//
//import com.avensys.rts.industryservice.entity.IndustryEntity;
//import com.avensys.rts.industryservice.repository.IndustryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Optional;
//
///**
// * author: Koh He Xiang
// * This class is used to seed in the industries into the database
// */
//
//@Configuration
//public class SeedAddressCommandLineRunner implements CommandLineRunner {
//
//    @Autowired
//    private IndustryRepository industryRepository;
//
//    public String[][] industries = {
//            {"Automotive", "Manufacturing"},
//            {"Pharmaceuticals", "Healthcare"},
//            {"Cloud Computing", "Information Technology"},
//            {"Retail Banking", "Financial Services"},
//            {"Renewable Energy", "Energy"},
//            {"E-commerce", "Retail"},
//            {"Fast Food", "Food and Beverage"},
//            {"Asset Management", "Financial Services"},
//            {"Television Broadcasting", "Media"},
//            {"Digital Marketing", "Marketing"},
//            {"Film Production", "Media and Entertainment"},
//            {"Agricultural Machinery", "Agriculture"},
//            {"Biotechnology", "Healthcare"},
//            {"Consumer Electronics", "Technology"},
//            {"Video Game Development", "Media and Entertainment"},
//            {"Oil and Gas Exploration", "Energy"},
//            {"Commercial Airlines", "Aviation"},
//            {"Rail Transport", "Transportation and Logistics"},
//            {"Software Development", "Information Technology"},
//            {"Legal Services", "Professional Services"}
//    };
//
//    /**
//     * This method is used to seed in the industries into the database
//     * @param args
//     * @throws Exception
//     */
//    @Override
//    public void run(String... args) throws Exception {
//
//        // Seed in parent industry
//        for (int i = 0; i < industries.length; i++) {
//            Optional<IndustryEntity> industryFound = industryRepository.findByName(industries[i][1]);
//            if (!industryFound.isPresent()) {
//                System.out.println("Parent industry does not exist");
//                IndustryEntity industryEntity = new IndustryEntity(industries[i][1], null);
//                industryRepository.save(industryEntity);
//            }
//        }
//
//        // Seed in industry
//        for (int i = 0; i < industries.length; i++) {
//            Optional<IndustryEntity> industryFound = industryRepository.findByName(industries[i][0]);
//            if (!industryFound.isPresent()) {
//                System.out.println("Industry does not exist");
//                IndustryEntity industryEntity = new IndustryEntity(industries[i][0], industryRepository.findByName(industries[i][1]).get());
//                industryRepository.save(industryEntity);
//            }
//        }
//
//    }
//}
