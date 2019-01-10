package ua.legendarytec.restapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.legendarytec.restapp.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
