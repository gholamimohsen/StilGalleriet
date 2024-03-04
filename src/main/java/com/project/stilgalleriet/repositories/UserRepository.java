package com.project.stilgalleriet.repositories;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
