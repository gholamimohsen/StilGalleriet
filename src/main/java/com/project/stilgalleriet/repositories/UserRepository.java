package com.project.stilgalleriet.repositories;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail (String email);

    Boolean existsByEmail (String email);
}
