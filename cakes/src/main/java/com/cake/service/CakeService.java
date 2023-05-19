package com.cake.service;

import com.cake.domain.Cake;
import com.cake.dto.cake.CreateCakeDto;
import com.cake.dto.cake.UpdateCakeDto;
import com.cake.repository.CakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CakeService {

    private final CakeRepository cakeRepository;

    public List<Cake> findAllCake() {
        List<Cake> cakeList = cakeRepository.findAll();
        if (cakeList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhum Bolo cadastrado!");
        }
        return cakeList;
    }

    public Cake findCakeByIdOrThrowNotFoundException(long id) {
        return cakeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cake not found"));
    }

    public Cake save(CreateCakeDto createCakeDto) {
        Cake cake = Cake.builder()
                .cakeName(createCakeDto.getCakeName())
                .cakeDescription(createCakeDto.getCakeDescription())
                .cakeCreatedDate(createCakeDto.getCakeCreatedDate())
                .cakeURL(createCakeDto.getCakeURL())
                .build();
        return cakeRepository.save(cake);
    }

    public void delete(long id) {
        cakeRepository.delete(findCakeByIdOrThrowNotFoundException(id));
    }

    public void replace(UpdateCakeDto updateCakeDto) {
        Cake savedCake = findCakeByIdOrThrowNotFoundException(updateCakeDto.getCakeId());
        Cake cake = Cake.builder()
                .cakeId(savedCake.getCakeId())
                .cakeName(updateCakeDto.getCakeName())
                .cakeDescription(updateCakeDto.getCakeDescription())
                .cakeCreatedDate(updateCakeDto.getCakeCreatedDate())
                .cakeURL(updateCakeDto.getCakeURL())
                .build();
        cakeRepository.save(cake);
    }

}
