/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.hotelmanagement.service;

import com.ensi.ilsi.hotelManagement.Entities.Hotel;
import com.ensi.ilsi.hotelManagement.Entities.Room;
import com.ensi.ilsi.hotelmanagement.repository.HotelRepository;
import com.ensi.ilsi.hotelmanagement.repository.RoomRepository;
import com.ensi.ilsi.hotelmanagement.web.Dto.RoomDto;
import java.util.Collections;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author asys
 */
@Service
@Transactional
public class RoomService {
    
private final Logger log = LoggerFactory.getLogger(RoomService.class);

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
         this.hotelRepository = hotelRepository;
    }

      public RoomDto create(Long hotelId,RoomDto roomDto) {
        
            Hotel hotel = this.hotelRepository.findById(hotelId)
                    .orElseThrow(() -> new IllegalStateException("The Hotel does not exist!"));

            log.debug("Request to create Room : {}", roomDto);
        return mapToDto(
                this.roomRepository.save(
                        
                       new Room(
                                roomDto.getNumber(),
                                roomDto.getNbBeds(),
                                roomDto.getPrice(),
                                Boolean.FALSE, 
                               hotel
                        )
                )
        );
       
    }

    public List<RoomDto> findAll() {
        log.debug("Request to get all Rooms");
        return this.roomRepository.findAll()
                .stream()
                .map(RoomService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RoomDto findById(Long id) {
        log.debug("Request to get Room : {}", id);
        return this.roomRepository.findById(id).map(RoomService::mapToDto).orElse(null);
    }

    public List<RoomDto> findAllOccupied() {
        log.debug("Request to get all Rooms occupied");
        return this.roomRepository.findAllByOccupied(true)
                .stream()
                .map(RoomService::mapToDto)
                .collect(Collectors.toList());
    }

    public List<RoomDto> findAllUnoccupied() {
        log.debug("Request to get all Rooms");
        return this.roomRepository.findAllByOccupied(false)
                .stream()
                .map(RoomService::mapToDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        log.debug("Request to delete Room : {}", id);

        Room room = this.roomRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Room with id " + id));

        room.setOccupied(false);
        this.roomRepository.save(room);
    }

    public static RoomDto mapToDto(Room room) {
        if (room != null) {
            return new RoomDto(
                 room.getId(),
            		room.getNumber(),
                    room.getNbBeds(),
                    room.getPrice(),
                    room.getOccupied(),
                    HotelService.mapToDto(room.getHotel())    
            );
        }
        return null;
    }
}
