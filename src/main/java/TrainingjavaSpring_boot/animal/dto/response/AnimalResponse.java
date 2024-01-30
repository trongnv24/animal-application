package TrainingjavaSpring_boot.animal.dto.response;

import TrainingjavaSpring_boot.animal.dto.request.AnimalRequest;

public class AnimalResponse extends AnimalRequest {

    private String id;

    public AnimalResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AnimalResponse{" +
                "id='" + id + '\'' +
                ", name='" + getName() + '\'' +
                ", species='" + getSpecies() + '\'' +
                ", color='" + getColor() + '\'' +
                ", age=" + getAge() +
                ", weight='" + getWeight() + '\'' +
                '}';
    }
}
