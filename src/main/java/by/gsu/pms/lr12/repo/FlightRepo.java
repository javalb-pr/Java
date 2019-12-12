package by.gsu.pms.lr12.repo;

import by.gsu.pms.lr12.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
}
