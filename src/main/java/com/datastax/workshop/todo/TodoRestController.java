package com.datastax.workshop.todo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/todos")
public class TodoRestController {
    
    private TodoRepositoryCassandra repo;
    
    public TodoRestController(TodoRepositoryCassandra todoRepo) {
        this.repo = todoRepo;
    }
    
    @GetMapping
    public Stream<Todo> findAll() {
        return repo.findAll().stream();
    }
    
    @GetMapping("/{uid}")
    public ResponseEntity<?> findById(@PathVariable(value = "uid") String uid) {
        return repo
                .findById(UUID.fromString(uid))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
     
    @PostMapping
    public ResponseEntity<Todo> create(HttpServletRequest req, @RequestBody Todo todoReq)
    throws URISyntaxException {
        repo.save(todoReq);
        return ResponseEntity
                .created(new URI(req.getRequestURI() + "/" + todoReq.getUid()))
                .body(todoReq);
    }

    @PutMapping("/{uid}")
    public ResponseEntity<Todo> update(@PathVariable String uid, @RequestBody Todo todo) {
        UUID todoId = UUID.fromString(uid);
        if (!repo.existsById(todoId)) {
            return ResponseEntity.notFound().build();
        }
        todo.setUid(todoId);
        repo.save(todo);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("{uid}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "uid") String uid) {
        UUID todoId = UUID.fromString(uid);
        if (!repo.existsById(todoId)) return ResponseEntity.notFound().build();
        repo.deleteById(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
