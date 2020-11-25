package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeaterDao extends JpaRepository<Heater, Long>{

    List<Heater> findByRoomId(Long roomId);

    //delete all heaters in a room
    @Modifying
    @Query("delete from Heater h where h.room.id= ?1")
    void deleteByRoom(Long id);

}
