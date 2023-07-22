package astratech.siormawa.controller;

import astratech.siormawa.model.Event;
import astratech.siormawa.model.Pengguna;
import astratech.siormawa.service.EventService;
import astratech.siormawa.service.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/saveEvent")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "nama") String nama,
                                     @RequestParam(name = "deskripsi") String deskripsi){
        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Event event = new Event (0, nama, deskripsi, "Tidak Aktif", "a", date, null, null);
        eventService.save(event);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getEvent")
    public Event getEvent(HttpServletResponse response, @RequestParam("id") Integer id){
        Event event = eventService.getEvent(id);
        return event;
    }

    @GetMapping("/getEvents")
    public List<Event> getEvents(HttpServletResponse response){
        List<Event> events = eventService.getEvents();
        return events;
    }

    @GetMapping("/UpdateEvent")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idEvent") String idEvent,
                                       @RequestParam(name = "nama") String nama,
                                       @RequestParam(name = "deskripsi") String deskripsi) {

        Event event2 = eventService.getEvent(Integer.parseInt(idEvent));
        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Event event = new Event(Integer.parseInt(idEvent), nama, deskripsi, event2.getStatus(), event2.getCreatedby(), event2.getCreateddate(), "b", date);
        eventService.updatedEvent(Integer.parseInt(idEvent), event);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Event/index.html")).build();
    }

    @GetMapping("/deleteEvent")
    public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Event with ID: " + id + ". Deleted Successfully");
    }

    @GetMapping("/aktifkanEvent")
    public ResponseEntity<String> aktifkanById(@RequestParam("id") Integer id) {
        eventService.AktifkanEvent(id);
        return ResponseEntity.ok("Event with ID: " + id + ". Activate Successfully");
    }

    @GetMapping("/nonaktifkanEvent")
    public ResponseEntity<String> nonaktifkanById(@RequestParam("id") Integer id) {
        eventService.NonaktifkanEvent(id);
        return ResponseEntity.ok("Event with ID: " + id + ". Deactivate Successfully");
    }

    @GetMapping("/getEventAktif")
    public Event getEvent(HttpServletResponse response){
        Event event = eventService.getEventAktif();
        return event;
    }
//    @GetMapping("/getEventAktif")
//    public ResponseEntity<Event> getEvent(HttpServletResponse response){
//    Optional<Event> eventOptional = eventService.getEventAktif();
//        if (eventOptional.isPresent()) {
//            Event event = eventOptional.get();
//            return ResponseEntity.ok(event);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/getLastEvent")
    public Event getLastEvent(HttpServletResponse response){
        Event event = eventService.getLastEvent();
        return event;
    }
}
