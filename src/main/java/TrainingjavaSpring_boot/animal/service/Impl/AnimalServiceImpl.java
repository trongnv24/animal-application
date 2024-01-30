package TrainingjavaSpring_boot.animal.service.Impl;

import TrainingjavaSpring_boot.animal.dto.request.AnimalRequest;
import TrainingjavaSpring_boot.animal.dto.response.AnimalResponse;
import TrainingjavaSpring_boot.animal.entity.AnimalEntity;
import TrainingjavaSpring_boot.animal.repository.AnimalRepository;
import TrainingjavaSpring_boot.animal.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static TrainingjavaSpring_boot.animal.service.mapping.AnimalMapping.convertDtoToEntity;
import static TrainingjavaSpring_boot.animal.service.mapping.AnimalMapping.convertEntityToAnimalResponse;

@Service
@Slf4j
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public AnimalResponse create(AnimalRequest request) {
        log.info(" === Start api create new animal === ");
        log.info(" === Request Body : {} === ", request);
        AnimalEntity animalEntity = convertDtoToEntity(request);
        animalEntity = animalRepository.save(animalEntity);
        AnimalResponse response = convertEntityToAnimalResponse(animalEntity);
        log.info(" === Finish api create new animal, Animal id {} : ",response.getId());
        return response ;
    }

    @Override
    public AnimalResponse getById(String id) {
        log.info(" === Start api getById animal === ");
        log.info(" === String id {} : === ", id);
        Optional<AnimalEntity>optionalAnimal=animalRepository.findById(id);
        if(!optionalAnimal.isPresent()){
            throw new RuntimeException();
        }
        AnimalEntity animalEntity = optionalAnimal.get();
        AnimalResponse response = convertEntityToAnimalResponse(animalEntity);
        log.info(" === Finish api getById animal, Animal id {} : ===", response.getId());
        return response;
    }

    @Override
    public AnimalResponse update(AnimalRequest request, String id) {
        log.info(" === Start api update animal === ");
        log.info(" Request Body {} :, String id {} : ", request, id);
        Optional<AnimalEntity>optionalAnimal=animalRepository.findById(id);
        if(!optionalAnimal.isPresent()){
            throw new RuntimeException();
        }
        AnimalEntity animalEntity = optionalAnimal.get();
        animalEntity.setName(request.getName());
        animalEntity.setSpecies(request.getSpecies());
        animalEntity.setColor(request.getColor());
        animalEntity.setAge(request.getAge());
        animalEntity.setWeight(request.getWeight());
        animalEntity = animalRepository.save(animalEntity);
        AnimalResponse response = convertEntityToAnimalResponse(animalEntity);
        log.info(" === Finish api update animal, Animal id {} : === ", response.getId());
        return response;
    }

    @Override
    public void deleteById(String id) {
        log.info(" === Start api deleteById animal === ");
        log.info(" === String id {} : === ", id );
        Optional<AnimalEntity>optionalAnimal=animalRepository.findById(id);
        if(!optionalAnimal.isPresent()){
            throw new RuntimeException();
        }
        log.info(" === Finish api deleteById animal, Animal id {} : ");
        animalRepository.deleteById(id);
    }

}
