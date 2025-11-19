package ru.klgd.javadev.homework19.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.klgd.javadev.homework19.Service.TelevisionService;
import ru.klgd.javadev.homework19.dto.TelevisionRequest;
import ru.klgd.javadev.homework19.dto.TelevisionResponse;
import ru.klgd.javadev.homework19.entities.Television;
import ru.klgd.javadev.homework19.mapper.TelevisionMapper;
import ru.klgd.javadev.homework19.repositories.TelevisionRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TelevisionServiceImpl implements TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final TelevisionMapper televisionMapper;

    @Override
    public TelevisionResponse createTelevision(TelevisionRequest televisionRequest) {

        Television television = televisionMapper.fromTelevisionCreateRequest(televisionRequest);
        Television savedTelevision = televisionRepository.saveAndFlush(television);
        TelevisionResponse televisionResponse = televisionMapper.toTelevisionResponse(savedTelevision);

        return televisionResponse;
    }

    @Override
    public TelevisionResponse getTelevisionById(Long id) {

        Optional<Television> television = televisionRepository.findById(id);

        if (television.isEmpty()) {
            throw new NoSuchElementException("Телевизор не найден!");
        }

        return televisionMapper.toTelevisionResponse(television.get());
    }

    @Override
    public TelevisionResponse updateTelevision(Long id, TelevisionRequest televisionRequest) {

        Television television;

        Optional<Television> existingTelevision = televisionRepository.findById(id);

        if (existingTelevision.isPresent()) {
            television = existingTelevision.get();
        } else {
            throw new NoSuchElementException("Телевизор не найден!");
        }

        television.setCompany(televisionRequest.company());
        television.setModel(televisionRequest.model());
        television.setRelease(televisionRequest.release());
        television.setPrice(televisionRequest.price());
        television.setCountInStock(televisionRequest.countInStock());

        Television updatedTelevision = televisionRepository.saveAndFlush(television);

        return televisionMapper.toTelevisionResponse(updatedTelevision);
    }

    @Override
    public void deleteTelevision(Long id) {

        Optional<Television> existingTelevision = televisionRepository.findById(id);

        if (existingTelevision.isPresent()) {
            televisionRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Телевизор не найден!");
        }

    }
}
