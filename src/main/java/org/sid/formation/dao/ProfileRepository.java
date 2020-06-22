package org.sid.formation.dao;

import org.sid.formation.entities.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProfileRepository extends MongoRepository<Profile, String> {
}
