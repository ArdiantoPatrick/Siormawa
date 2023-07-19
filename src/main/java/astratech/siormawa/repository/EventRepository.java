package astratech.siormawa.repository;

import astratech.siormawa.model.Event;
import astratech.siormawa.model.Informasi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {

    @Query(value = "SELECT * FROM siormawa_msevent WHERE evt_id_event= ?1 AND (evt_status = 'Aktif' OR evt_status = 'Tidak Aktif')" , nativeQuery = true)
    public Event getEventByIdEvent(int idEvent);

    @Query(value = "SELECT * FROM siormawa_msevent WHERE (evt_status = 'Aktif' OR evt_status = 'Tidak Aktif')", nativeQuery = true)
    public List<Event> getEvents();

    @Query(value = "UPDATE siormawa_msevent SET evt_status = 'Deleted' WHERE evt_id_event= ?1", nativeQuery = true)
    public Event DeleteStatus(int idEvent);

    @Query(value = "UPDATE siormawa_msevent SET evt_status = 'Aktif' WHERE evt_id_event= ?1", nativeQuery = true)
    public Event AktifkanEvent(int idEvent);

    @Query(value = "UPDATE siormawa_msevent SET evt_status = 'Tidak Aktif' WHERE evt_id_event= ?1", nativeQuery = true)
    public Event NonaktifkanEvent(int idEvent);

    @Query(value = "SELECT TOP 1 * FROM siormawa_msevent WHERE evt_status = 'Aktif'" , nativeQuery = true)
    public List<Event> getEventAktif();

    @Query(value = "SELECT TOP 1 * FROM siormawa_msevent ORDER BY evt_id_event DESC" , nativeQuery = true)
    public Event getLastEvent();
}
