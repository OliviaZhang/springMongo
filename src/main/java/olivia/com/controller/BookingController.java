package olivia.com.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import olivia.com.model.Booking;
import olivia.com.repository.BookingRepository;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingRepository bookingRepository;
	
	/**
	 * GET /create --> Create a new booking and save it in the database
	 * @param booking
	 * @return
	 */
	@RequestMapping("/create")
	public Map<String, Object> create(Booking booking) {
		booking.setTravelDate(new Date());
		booking = bookingRepository.save(booking);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking created successfully");
		dataMap.put("status", "1");
		dataMap.put("booking", booking);
		
		return dataMap;
	}
	
	/**
	 * GET /read --> Read a booking by booking id from the database
	 * @param bookingId
	 * @return
	 */
	@RequestMapping("/read")
	public Map<String, Object> read(@RequestParam String bookingId) {
		Booking booking = bookingRepository.findOne(bookingId);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "booking found successfully");
		dataMap.put("status", "1");
		dataMap.put("booking", booking);
		
		return dataMap;
	}
	
	/**
	 * GET /update
	 * @param bookingId
	 * @param psngrName
	 * @return
	 */
	@RequestMapping("/update")
	public Map<String, Object> update(@RequestParam String bookingId, @RequestParam String psngrName) {
		Booking booking = bookingRepository.findOne(bookingId);
		booking.setPsngrName(psngrName);
		booking = bookingRepository.save(booking);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking updated successfully");
		dataMap.put("status", "1");
		dataMap.put("booking", booking);
		
		return dataMap;
	} 
	
	/**
	 * 
	 * @param bookingId
	 * @return
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(@RequestParam String bookingId) {
		bookingRepository.delete(bookingId);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking deleted successfully");
		dataMap.put("status", "1");
		
		return dataMap;
	}
	
	@RequestMapping("/read-all")
	public Map<String, Object> readAll() {
		List<Booking> bookings = bookingRepository.findAll();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking found successfully");
		dataMap.put("status", "1");
		dataMap.put("bookings", bookings);
		
		return dataMap;
	}
}
