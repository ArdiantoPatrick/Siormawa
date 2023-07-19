package astratech.siormawa.repository;

import astratech.siormawa.model.Jabatan;
import astratech.siormawa.model.Periode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JabatanRepository extends CrudRepository<Jabatan, Integer> {

    @Query(value = "SELECT * FROM siormawa_msjabatan WHERE jbt_id_jabatan= ?1 AND (jbt_status = 'Aktif' OR jbt_status = 'Tidak Aktif')", nativeQuery = true)
    public Jabatan getJabatanByIdJabatan(int idJabatan);

    @Query(value = "SELECT * FROM siormawa_msjabatan WHERE (jbt_status = 'Aktif' OR jbt_status = 'Tidak Aktif')", nativeQuery = true)
    public List<Jabatan> getJabatans();

    @Query(value = "SELECT * FROM siormawa_msjabatan WHERE jbt_status = 'Aktif'", nativeQuery = true)
    public List<Jabatan> getJabatansAktif();

    @Query(value = "UPDATE siormawa_msjabatan SET jbt_status = 'Deleted' WHERE jbt_id_jabatan= ?1", nativeQuery = true)
    public Jabatan DeleteStatus(int idJabatan);

    @Query(value = "UPDATE siormawa_msjabatan SET jbt_status = 'Aktif' WHERE jbt_id_jabatan= ?1", nativeQuery = true)
    public Jabatan AktifkanJabatan(int idJabatan);

    @Query(value = "UPDATE siormawa_msjabatan SET jbt_status = 'Tidak Aktif' WHERE jbt_id_jabatan= ?1", nativeQuery = true)
    public Jabatan NonaktifkanJabatan(int idJabatan);
}
