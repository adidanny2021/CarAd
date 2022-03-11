package masini.anunturi.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdDao extends JpaRepository<Ad, UUID> {
}
