package astratech.siormawa.repository;

import astratech.siormawa.model.Event;
import astratech.siormawa.model.Tahapan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TahapanRepository extends CrudRepository<Tahapan, Integer> {

    @Query(value = "SELECT * FROM siormawa_mstahapan WHERE thp_id_tahapan= ?1 AND (thp_status = 'Aktif' OR thp_status = 'Tidak Aktif')" , nativeQuery = true)
    public Tahapan getTahapanByIdTahapan(int idTahapan);

    @Query(value = "SELECT * FROM siormawa_mstahapan WHERE thp_id_event= ?1 AND (thp_status = 'Aktif' OR thp_status = 'Tidak Aktif')" , nativeQuery = true)
    public Tahapan getTahapanByIdEvent(int idEvent);

    @Query(value = "SELECT * FROM siormawa_mstahapan WHERE (thp_status = 'Aktif' OR thp_status = 'Tidak Aktif')", nativeQuery = true)
    public List<Tahapan> getTahapans();

    @Query(value = "SELECT * FROM siormawa_mstahapan WHERE thp_id_event= ?1 AND (thp_status = 'Aktif' OR thp_status = 'Tidak Aktif' OR thp_status = 'Selesai') ORDER BY thp_urutan ASC", nativeQuery = true)
    public List<Tahapan> getTahapansByIdEvent(int idEvent);

    @Query(value = "UPDATE siormawa_mstahapan SET thp_status = 'Deleted' WHERE thp_id_tahapan= ?1", nativeQuery = true)
    public Tahapan DeleteStatus(int idEvent);

    @Query(value = "UPDATE siormawa_mstahapan SET thp_status = 'Aktif' WHERE thp_id_tahapan= ?1", nativeQuery = true)
    public Tahapan AktifkanTahapan(int idTahapan);

    @Query(value = "UPDATE siormawa_mstahapan SET thp_status = 'Tidak Aktif' WHERE thp_id_tahapan= ?1", nativeQuery = true)
    public Tahapan NonaktifkanTahapan(int idTahapan);

    @Query(value = "SELECT * FROM siormawa_mstahapan WHERE thp_status = 'Aktif'" , nativeQuery = true)
    public List<Tahapan> getTahapanAktif();

    @Query(value = "UPDATE siormawa_mstahapan SET thp_status = 'Tidak Aktif' WHERE thp_id_event= ?1 AND thp_status = 'Aktif'" , nativeQuery = true)
    public Tahapan semuaStatusTidakAktif(int idEvent);

    @Query(value = "UPDATE siormawa_mstahapan SET thp_status = 'Aktif' WHERE thp_id_event= ?1 AND thp_urutan= ?2", nativeQuery = true)
    public Tahapan AktifkanTahapanByUrutan(int idEvent, int urutan);

    @Query(value = "UPDATE siormawa_mstahapan SET thp_status = 'Selesai' WHERE thp_id_event= ?1 AND thp_urutan= ?2", nativeQuery = true)
    public Tahapan SelesaikanTahapanByUrutan(int idEvent, int urutan);
}
