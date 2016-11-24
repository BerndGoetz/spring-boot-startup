package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@Component
class SampleDataCLR implements CommandLineRunner {

	private final ReservationRepository reservationRepository;

	public SampleDataCLR(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		Stream.of("Bernd", "Joseph", "Roland", "Samuel").forEach(
				name -> reservationRepository.save(new Reservation(name)));
		reservationRepository.findAll().forEach(System.out::println);
	}

}

@RepositoryRestResource
interface ReservationRepository extends JpaRepository<Reservation, Long> {

}

@Entity
class Reservation {

	@Id
	@GeneratedValue
	private Long id;

	private String reservationName;

    protected Reservation() {} // for Hibernate

    public Reservation(String reservationName) {
        this.reservationName = reservationName;
    }

    public Long getId() {
		return id;
	}

	public String getReservationName() {
		return reservationName;
	}

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationName='" + reservationName + '\'' +
                '}';
    }
}