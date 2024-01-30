package TrainingjavaSpring_boot.animal.service.mapping;


import TrainingjavaSpring_boot.animal.dto.request.AnimalRequest;
import TrainingjavaSpring_boot.animal.dto.response.AnimalResponse;
import TrainingjavaSpring_boot.animal.entity.AnimalEntity;

public class AnimalMapping  {
    public static AnimalEntity convertDtoToEntity(AnimalRequest dto){
        AnimalEntity entity = new AnimalEntity();
        entity.setName(dto.getName());
        entity.setSpecies(dto.getSpecies());
        entity.setColor(dto.getColor());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        return entity;
    }
    public static AnimalResponse convertEntityToAnimalResponse(AnimalEntity entity){
        AnimalResponse dto = new AnimalResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSpecies(entity.getSpecies());
        dto.setColor(entity.getColor());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        return dto;
    }
}
