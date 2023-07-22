package astratech.siormawa.service;

import astratech.siormawa.model.Event;
import astratech.siormawa.model.Pengguna;
import astratech.siormawa.repository.EventRepository;
import astratech.siormawa.repository.PenggunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public boolean save(Event event){

        Event result = eventRepository.save(event);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return isSuccess;
    }

    public Event getEvent(Integer idEvent){
        Event event = eventRepository.getEventByIdEvent(idEvent);
        return event;
    }

    public List<Event> getEvents(){
        List<Event> events = eventRepository.getEvents();
        return events;
    }

    public boolean updatedEvent(Integer idEvent, Event updatedEvent){

        Event event = eventRepository.getEventByIdEvent(idEvent);
        if(event == null){
            return false;
        }
        event.setNama(updatedEvent.getNama());
        event.setDeskripsi(updatedEvent.getDeskripsi());
        event.setStatus(updatedEvent.getStatus());
        event.setCreatedby(updatedEvent.getCreatedby());
        event.setCreateddate(updatedEvent.getCreateddate());
        event.setModifiedby(updatedEvent.getModifiedby());
        event.setModifieddate(updatedEvent.getModifieddate());
        Event result = eventRepository.save(event);
        return result != null;
    }
//
    public boolean deleteEvent(Integer idEvent){
        try {
            eventRepository.DeleteStatus(idEvent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AktifkanEvent(Integer idEvent){
        try {
            eventRepository.AktifkanEvent(idEvent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean NonaktifkanEvent(Integer idEvent){
        try {
            eventRepository.NonaktifkanEvent(idEvent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Event getEventAktif(){
        Event event = eventRepository.getEventAktif();
        return event;
    }

    public Event getLastEvent(){
        Event event = eventRepository.getLastEvent();
        return event;
    }
}
