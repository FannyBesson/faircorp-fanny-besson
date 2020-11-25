package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;
    private final HeaterDao heaterDao;
    private final WindowDao windowDao;

    public RoomController(RoomDao roomDao,HeaterDao heaterDao, WindowDao windowDao) {
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        //ne marche pas
        Room room = null;
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getName(), dto.getFloor()));
        }
        else {
            room=roomDao.getOne(dto.getId());
        }
        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/switchWindow")
    public RoomDto switchStatusWindows(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        for (Window window : room.getWindows()){
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        }
        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/switchHeaters")
    public RoomDto switchStatusHeaters(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        for (Heater heater : room.getHeaters()){
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        }
        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        for (Heater heater : room.getHeaters()){
            heaterDao.deleteById(heater.getId());
        }
        for (Window window : room.getWindows()){
            windowDao.deleteById(window.getId());
        }
        roomDao.deleteById(id);
    }
}
