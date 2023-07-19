package astratech.siormawa.repository;

import astratech.siormawa.model.Informasi;
import astratech.siormawa.model.InformasiSeleksi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InformasiSeleksiRepository extends CrudRepository<InformasiSeleksi, Integer> {

    @Query(value = "SELECT * FROM siormawa_msinformasiseleksi WHERE slk_id_infseleksi= ?1 AND (slk_status='Aktif' OR slk_status='Tidak Aktif')", nativeQuery = true)
    public InformasiSeleksi getInformasiSeleksiByIdInformasiSeleksi(int idInformasiSeleksi);

    @Query(value = "SELECT * FROM siormawa_msinformasiseleksi WHERE (slk_status='Aktif' OR slk_status='Tidak Aktif')", nativeQuery = true)
    public List<InformasiSeleksi> getInformasiSeleksis();

    @Query(value = "SELECT * FROM siormawa_msinformasiseleksi WHERE (slk_status='Aktif' OR slk_status='Tidak Aktif') AND slk_created_by= ?1", nativeQuery = true)
    public List<InformasiSeleksi> getInformasiSeleksisByCreated(String namacreated);

    @Query(value = "UPDATE siormawa_msinformasiseleksi SET slk_status = 'Deleted' WHERE slk_id_infseleksi= ?1", nativeQuery = true)
    public InformasiSeleksi DeleteStatus(int idInformasiSeleksi);

    @Query(value = "SELECT * FROM siormawa_msinformasiseleksi WHERE slk_id_infseleksi = (SELECT MAX(slk_id_infseleksi) FROM siormawa_msinformasiseleksi)", nativeQuery = true)
    public InformasiSeleksi getInformasiSeleksiTerakhir();

    @Query(value = "UPDATE siormawa_msinformasiseleksi SET slk_status = 'Aktif' WHERE slk_id_infseleksi= ?1", nativeQuery = true)
    public Informasi AktifkanInformasiSeleksi(int idInformasiSeleksi);

    @Query(value = "UPDATE siormawa_msinformasiseleksi SET slk_status = 'Tidak Aktif' WHERE slk_id_infseleksi= ?1", nativeQuery = true)
    public Informasi NonaktifkanInformasiSeleksi(int idInformasiSeleksi);

}
