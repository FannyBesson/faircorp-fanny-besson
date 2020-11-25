package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WindowDao extends JpaRepository<Window, Long>,WindowDaoCustom{

    List<Window> findByRoomId(Long roomId);

    @Query("select c from Window c where c.name=:name")
    WindowStatus findByName(@Param("name") String name);

    //delete all windows in a room
    @Modifying
    @Query("delete from Window w where w.room.id= ?1")
    void deleteByRoom(Long id);

}