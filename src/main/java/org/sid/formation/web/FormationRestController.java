package org.sid.formation.web;

import org.sid.formation.dao.FormationRepository;
import org.sid.formation.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;


@RestController
public class FormationRestController {
    @Autowired
    private FormationRepository formationRepository;


    @GetMapping(path = "/photofor/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") String id) throws Exception {
        Formation c = formationRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/formations/" + c.getPhotoName()));
    }

    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable String id) throws Exception {
        Formation c = formationRepository.findById(id).get();
        c.setPhotoName(id + ".jpg");
        Files.write(Paths.get(System.getProperty("user.home") + "/formations/" + c.getPhotoName()), file.getBytes());
        formationRepository.save(c);
    }
}
