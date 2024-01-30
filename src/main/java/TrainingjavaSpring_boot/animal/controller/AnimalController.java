package TrainingjavaSpring_boot.animal.controller;

import TrainingjavaSpring_boot.animal.dto.request.AnimalRequest;
import TrainingjavaSpring_boot.animal.dto.response.AnimalResponse;
import TrainingjavaSpring_boot.animal.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/animal")
@Slf4j
public class AnimalController {
    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalResponse create(@RequestBody AnimalRequest request){
        log.info(" === Start api create new animal === ");
        log.info(" === Request Body {} :=== ", request);
        AnimalResponse response = service.create(request);
        log.info(" === Finish api create new animal, Animal id {} : === ", response.getId());
        return response;
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse getById(@PathVariable ("id") String id){
        log.info(" === Start api getById animal === ");
        log.info( " === String id {} : === ", id);
        AnimalResponse response = service.getById(id);
        log.info(" === Finish api getById animal, Animal id {Ư : ", response.getId());
        return response;
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse update(@RequestBody AnimalRequest request, @PathVariable ("id")String id){
        log.info(" === Start api update animal === ");
        log.info(" === Request Body {} :, String id {}:", request,id);
        AnimalResponse response = service.update(request, id);
        log.info(" === Finish api update animal, Animal id {} : ", response.getId());
        return response;
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable ("id")String id){
        log.info(" Start api deleteById animal === ");
        log.info(" === String id {} : === ", id);
        log.info(" === Finish api deleteById animal, Animal id {} : === ");
        service.deleteById(id);
    }
}
