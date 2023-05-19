package com.cake.controller;

import com.cake.domain.Cake;
import com.cake.dto.cake.CreateCakeDto;
import com.cake.dto.cake.UpdateCakeDto;
import com.cake.service.CakeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cakes")
@Log4j2
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class CakeController {

    private final CakeService cakeService;

    @GetMapping()
    public ResponseEntity<List<Cake>> findAll() {
        return ResponseEntity.status(200).body(cakeService.findAllCake());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cake> findCakeById(@PathVariable long id) {
        Cake cake = cakeService.findCakeByIdOrThrowNotFoundException(id);
        return ResponseEntity.status(200).body(cake);
    }

    @PostMapping()
    public ResponseEntity<Cake> save(
            @RequestBody() CreateCakeDto createCakeDto
            ) {
        return ResponseEntity.status(201).body(cakeService.save(createCakeDto));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateCakeDto updateCakeDto) {
        cakeService.replace(updateCakeDto);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        cakeService.delete(id);
        return ResponseEntity.status(200).build();
    }
}
