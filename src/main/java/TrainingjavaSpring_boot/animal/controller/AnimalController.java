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
    private AnimalResponse create(@RequestBody AnimalRequest request){
        log.info(" === Start api create new animal === ");
        log.info(" === Request Body {} :=== ", request);
        AnimalResponse response = service.create(request);
        log.info(" === Finish api create new animal, Animal id {} : === ", response.getId());
        return response;
    }
}
