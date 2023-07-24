package astratech.siormawa.repository;

import astratech.siormawa.model.Kandidat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KandidatRepository extends CrudRepository<Kandidat, Integer> {

    @Query(value = "SELECT * FROM siormawa_mskandidat WHERE kdt_id_kandidat = ?1 AND (kdt_status = 'Aktif' OR kdt_status = 'Tidak Aktif')", nativeQuery = true)
    public Kandidat getKandidatByIdKandidat(int idKandidat);

    @Query(value = "SELECT * FROM siormawa_mskandidat WHERE kdt_username = ?1 AND kdt_status = 'Aktif' AND kdt_id_event = ?2", nativeQuery = true)
    public Kandidat getKandidatByUsername(int username, int idEvent);

    @Query(value = "SELECT * FROM siormawa_mskandidat WHERE kdt_username = ?1 AND (kdt_status = 'Aktif' OR kdt_status = 'Menunggu Disetujui' OR kdt_status = 'Tidak Aktif') AND kdt_id_event = ?2", nativeQuery = true)
    public Kandidat getKandidatByUsernameValidasi(int username, int idEvent);

    @Query(value = "SELECT * FROM siormawa_mskandidat WHERE (kdt_status = 'Aktif' OR kdt_status = 'Tidak Aktif')", nativeQuery = true)
    public List<Kandidat> getKandidats();

    @Query(value = "SELECT * FROM siormawa_mskandidat WHERE kdt_id_event = ?1 ORDER BY kdt_status ASC", nativeQuery = true)
    public List<Kandidat> getKandidatsByIdEvent(int idEvent);

    @Query(value = "UPDATE siormawa_mskandidat SET kdt_status = 'Deleted' WHERE kdt_id_kandidat= ?1", nativeQuery = true)
    public Kandidat DeleteStatus(int idPengguna);

    @Query(value = "UPDATE siormawa_mskandidat SET kdt_status = 'Aktif' WHERE kdt_id_kandidat= ?1", nativeQuery = true)
    public Kandidat AktifkanKandidat(int idPengguna);

    @Query(value = "UPDATE siormawa_mskandidat SET kdt_status = 'Tidak Aktif' WHERE kdt_id_kandidat= ?1", nativeQuery = true)
    public Kandidat NonaktifkanKandidat(int idPengguna);


}
