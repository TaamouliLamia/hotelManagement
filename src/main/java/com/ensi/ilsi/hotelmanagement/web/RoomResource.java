package com.ensi.ilsi.hotelmanagement.web;

import static com.ensi.ilsi.hotelmanagement.common.Web.API;
import com.ensi.ilsi.hotelmanagement.service.RoomService;
import com.ensi.ilsi.hotelmanagement.web.Dto.RoomDto;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(API + "/rooms")
public class RoomResource {
	
	private final RoomService roomService;
	
	public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }
	
	 @GetMapping
	    public List<RoomDto> findAll() {
	        return this.roomService.findAll();
	    }
	 @GetMapping("/{id}")
	    public RoomDto findById(@PathVariable Long id) {
	        return this.roomService.findById(id);
	    }
	 
	 @PostMapping
	    public RoomDto create(@PathVariable("id") Long hotelId,@RequestBody RoomDto roomDto) {
	        return this.roomService.create(hotelId,roomDto);
	    }
	 
	 @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.roomService.delete(id);
    }

    
}
