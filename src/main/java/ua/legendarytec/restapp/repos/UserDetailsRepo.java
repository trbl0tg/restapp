package ua.legendarytec.restapp.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.legendarytec.restapp.domain.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}