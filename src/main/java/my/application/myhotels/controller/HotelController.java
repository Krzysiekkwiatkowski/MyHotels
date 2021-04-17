package my.application.myhotels.controller;

import my.application.myhotels.model.Hotel;
import my.application.myhotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public void save(@RequestBody Hotel hotel){
        hotelService.save(hotel);
    }

    @PutMapping
    public void edit(@RequestBody Hotel hotel){
        hotelService.save(hotel);
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") Long id){
        return hotelService.getById(id);
    }

    @GetMapping
    public List<Hotel> findAll(){
        return hotelService.findAll().stream()
                .map(h -> {
                    h.setApartments(new ArrayList<>());
                    return h;
                })
                .collect(Collectors.toList());
    }
}
