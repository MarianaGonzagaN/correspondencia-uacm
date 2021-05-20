package uacm.edu.mx.auth.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uacm.edu.mx.auth.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAllByEnabledIsFalseAndCreatedDateBefore(Instant dateTime);
    Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	Optional<User> findOneByEmailIgnoreCase(String email);
	Optional<User> findOneByResetKey(String resetKey);
}
