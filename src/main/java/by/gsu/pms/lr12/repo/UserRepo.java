package by.gsu.pms.lr12.repo;

import by.gsu.pms.lr12.domain.Ticket;
import by.gsu.pms.lr12.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAllByTicketId(Long id);

}
