package com.ensi.ilsi.hotelmanagement.web;

import static com.ensi.ilsi.hotelmanagement.common.Web.API;
import com.ensi.ilsi.hotelmanagement.service.HotelService;
import com.ensi.ilsi.hotelmanagement.web.Dto.HotelDto;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(API + "/hotels")
public class HotelResource {
	
	private final HotelService hotelService;

    public HotelResource(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<HotelDto> findAll() {
        return this.hotelService.findAll();
    }

    @GetMapping("/{id}")
    public HotelDto findById(@PathVariable Long id) {
        return this.hotelService.findById(id);
    }

    @PostMapping
    public HotelDto create(HotelDto categoryDto) {
        return this.hotelService.create(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.hotelService.delete(id);
    }

}
