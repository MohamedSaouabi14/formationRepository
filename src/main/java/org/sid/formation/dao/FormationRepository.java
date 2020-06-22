package org.sid.formation.dao;

import org.sid.formation.entities.Formation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface FormationRepository extends MongoRepository<Formation, String> {
    @RestResource(path = "/forByName")
    Formation findByName(@Param("name") String name);
}
