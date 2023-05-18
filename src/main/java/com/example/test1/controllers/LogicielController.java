package com.example.test1.controllers;

import com.example.test1.entities.Application;
import com.example.test1.entities.LogKey;
import com.example.test1.entities.Logiciel;
import com.example.test1.entities.Version;
import com.example.test1.repositories.ApplicationRepository;
import com.example.test1.repositories.LogicielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "application")
public class LogicielController {
    @Autowired
    ApplicationRepository applicationRepository ;

    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    @GetMapping
    ResponseEntity<List<Application>> getLogiciels(){

        List<Application> logicielList = applicationRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(logicielList);
    }

    @PostMapping
    ResponseEntity<Application> addLogiciel(@RequestBody Application app){

        Application ap = new Application();
        ap.setId(app.getId());
        ap.setDescription(app.getDescription());
        ap.setUrl(app.getUrl());
        applicationRepository.save(ap);
        return ResponseEntity.status(HttpStatus.OK).body(ap);

    }

    @PutMapping
    ResponseEntity<Void> updateLogiciel(@RequestParam (value = "nom") String nom,
                                        @RequestParam (value = "versionmaj") int versionmaj,
                                        @RequestParam (value = "versionmin") int versionmin ,
                                        @RequestBody Application app){
        LogKey lg =new LogKey();
        Version version = new Version(versionmaj,versionmin);
        lg.setVersion(version);
        lg.setNom(nom);

        System.out.println("Voici l'id "+lg.toString());

        Optional<Application> app1 = applicationRepository.findById(lg);
        if (app1.isPresent()){
            Application app2 = app1.get();
            app2.setDescription(app.getDescription());
            app2.setUrl(app.getUrl());
            applicationRepository.save(app2);
        }
        else {
            System.out.println("object not found");
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping
    ResponseEntity<Void> deleteLogiciel(@RequestParam(value = "nom") String nom,
                                    @RequestParam (value = "versionmaj") int versionmaj,
                                     @RequestParam (value = "versionmin") int versionmin){

        LogKey lg = new LogKey();
        Version v =  new Version(versionmaj,versionmin);
        lg.setNom(nom);
        lg.setVersion(v);

        applicationRepository.deleteById(lg);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}
