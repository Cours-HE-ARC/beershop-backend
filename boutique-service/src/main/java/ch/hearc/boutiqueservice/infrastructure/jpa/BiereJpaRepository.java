package ch.hearc.boutiqueservice.infrastructure.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.hearc.boutiqueservice.infrastructure.repository.entity.BiereEntity;

@Repository
public interface BiereJpaRepository extends CrudRepository<BiereEntity, Long> {

}
