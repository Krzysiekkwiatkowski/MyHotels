package my.application.myhotels.service;

import my.application.myhotels.model.Hotel;
import my.application.myhotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public void save(Hotel hotel){
        hotelRepository.save(hotel);
    }

    public Hotel getById(long id){
        return hotelRepository.findById(id);
    }

    public List<Hotel> findAll(){
        return hotelRepository.findAll();
    }
}
