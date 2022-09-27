package org.sample.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.sample.config.ConstantsApp.USER_V1;

@RestController
@RequestMapping(USER_V1)
public class SampleController {
    @GetMapping
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("hello Word");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("Hello, friend");
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> getHelloName(@PathVariable String name){
        return ResponseEntity.ok("Hello " + name);
    }

    @PostMapping
    public ResponseEntity<List<String>> post(@RequestBody List<String> names){
        return ResponseEntity.ok(names);
    }

    @PutMapping
    public ResponseEntity<String> put(@RequestParam Integer param){
        return ResponseEntity.ok(param.toString());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok("deleted friend: " + id);
    }
}
