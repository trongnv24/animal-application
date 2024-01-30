package TrainingjavaSpring_boot.animal.repository;

import TrainingjavaSpring_boot.animal.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, String> {
}
