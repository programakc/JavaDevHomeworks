package ru.klgd.javadev.homework19.Service;

import ru.klgd.javadev.homework19.dto.TelevisionRequest;
import ru.klgd.javadev.homework19.dto.TelevisionResponse;

public interface TelevisionService {

    TelevisionResponse createTelevision(TelevisionRequest userRequest);

    TelevisionResponse getTelevisionById(Long id);

    TelevisionResponse updateTelevision(Long id, TelevisionRequest userRequest);

    void deleteTelevision(Long id);
}
