package TrainingjavaSpring_boot.animal.service;

import TrainingjavaSpring_boot.animal.dto.request.AnimalRequest;
import TrainingjavaSpring_boot.animal.dto.response.AnimalResponse;

public interface AnimalService {

    AnimalResponse create(AnimalRequest request);

    AnimalResponse getById(String id);

    AnimalResponse update(AnimalRequest request, String id);

    void deleteById(String id);
}
