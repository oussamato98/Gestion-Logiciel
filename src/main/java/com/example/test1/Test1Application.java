package com.example.test1;

import com.example.test1.entities.*;
import com.example.test1.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URL;

@SpringBootApplication
public class Test1Application {

    public static void main(String[] args) {
        SpringApplication.run(Test1Application.class, args);
    }
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    LogicielRepository logicielRepository;
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    ComposantRepository composant ;
    @Autowired
    LicenceRepository licenceRepository;
    @Autowired
    LibrairieRepository librairieRepository ;
    @Autowired
    private ComposantRepository composantRepository;

    @Bean
    CommandLineRunner start(){
        return args -> {
            Version version1 = new Version(100,200);
            Version version2 = new Version(900,600);

            URL url1 = new URL("https://www.example1.com");
            URL url2 = new URL("https://www.example2.com");


            LogKey logid1 = new LogKey();
            logid1.setNom("log1");
            logid1.setVersion(version1);

            LogKey logid2 = new LogKey();
            logid2.setNom("log2");
            logid2.setVersion(version2);

            Application logiciel1 = new Application();
            logiciel1.setId(logid1);
            logiciel1.setUrl(url1);
            logiciel1.setDescription("description1");
            applicationRepository.save(logiciel1);

            Application logiciel2 = new Application();
            logiciel2.setId(logid2);
            logiciel2.setUrl(url2);
            logiciel2.setDescription("description2");
            applicationRepository.save(logiciel2);

            Categorie categorie1 = new Categorie();
            categorie1.setNom("nom");
            categorieRepository.save(categorie1);

            CompKey compkey = new CompKey();
            compkey.setVersion(version1);
            compkey.setCode("code");

            Composant composant = new Composant();
            composant.setId(compkey);
            composant.setDescription("desc");
            composant.setUrl(url1);
            composantRepository.save(composant);

            LicKey licKey = new LicKey();
            licKey.setNom("licence1");
            licKey.setVersion(version1);
            licKey.setLangue("english");

            Licence licence = new Licence();
            licence.setId(licKey);
            licence.setTexte("Bonjour texte");
            licenceRepository.save(licence);





        };
    }

}
