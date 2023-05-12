package vn.mk.protector4j.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.mk.protector4j.entity.request.YamlFileRequest;
import vn.mk.protector4j.service.YamlFileService;

@RestController
@RequestMapping("/api/yaml-file")
public class FileYamlController {
    @Autowired
    YamlFileService yamlFileService;

    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok().body(yamlFileService.get(PageRequest.of(page-1,size)));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(YamlFileRequest request) {
        return ResponseEntity.ok().body(yamlFileService.save(request));
    }
}
