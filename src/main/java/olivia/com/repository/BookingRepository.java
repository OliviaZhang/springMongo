package olivia.com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import olivia.com.model.Booking;

@Transactional
public interface BookingRepository extends MongoRepository<Booking, String> {
	public Booking findByDepature(String depature);

}
