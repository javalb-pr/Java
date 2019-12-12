package by.gsu.pms.lr12.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String departureDate;
    private int capacity;
    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private Set<Ticket> tickets = new HashSet<>();
}
