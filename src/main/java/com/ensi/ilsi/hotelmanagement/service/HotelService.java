/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.hotelmanagement.service;

import com.ensi.ilsi.hotelManagement.Entities.Hotel;
import com.ensi.ilsi.hotelmanagement.repository.HotelRepository;
import com.ensi.ilsi.hotelmanagement.web.Dto.HotelDto;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author asys
 */
@Service
@Transactional
public class HotelService {
      private final Logger log = LoggerFactory.getLogger(HotelService.class);

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public HotelDto create(HotelDto hotelDto) {
        log.debug("Request to create Hotel : {}", hotelDto);
        return mapToDto(
                this.hotelRepository.save(
                        new Hotel(
                        		hotelDto.getName(),
                        		hotelDto.getAddress(),
                                hotelDto.getStars(),
                                hotelDto.getNbRoom()                                
                        )
                )
        );
    }

    public List<HotelDto> findAll() {
        log.debug("Request to get all Hotels");
        return this.hotelRepository.findAll()
                .stream()
                .map(HotelService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public HotelDto findById(Long id) {
        log.debug("Request to get Hotel : {}", id);
        return this.hotelRepository.findById(id).map(HotelService::mapToDto).orElse(null);
    }

    

   

    public void delete(Long id) {
        
        log.debug("Request to delete Hotel : {}", id);
        this.hotelRepository.deleteById(id);
        
    }

    public static HotelDto mapToDto(Hotel hotel) {
        if (hotel != null) {
            return new HotelDto(
                        hotel.getId(),
            		hotel.getName(),
                    hotel.getAddress(),
                    hotel.getStars(),
                    hotel.getNbRoom()
            );
        }
        return null;
    }
    
    }
