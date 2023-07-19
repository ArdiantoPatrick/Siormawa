package astratech.siormawa.repository;

import astratech.siormawa.model.Informasi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InformasiRepository extends CrudRepository<Informasi, Integer> {

    @Query(value = "SELECT * FROM siormawa_msinformasi WHERE inf_id_informasi= ?1 AND (inf_status = 'Aktif' OR inf_status = 'Tidak Aktif')", nativeQuery = true)
    public Informasi getInformasiByIdInformasi(int idInformasi);

    @Query(value = "SELECT * FROM siormawa_msinformasi WHERE (inf_status = 'Aktif' OR inf_status = 'Tidak Aktif')", nativeQuery = true)
    public List<Informasi> getInformasis();

    @Query(value = "SELECT * FROM siormawa_msinformasi WHERE (inf_status = 'Aktif' OR inf_status = 'Tidak Aktif') AND inf_created_by= ?1", nativeQuery = true)
    public List<Informasi> getInformasisByCreated(String namacreated);

    @Query(value = "UPDATE siormawa_msinformasi SET inf_status = 'Deleted' WHERE inf_id_informasi= ?1", nativeQuery = true)
    public Informasi DeleteStatus(int idInformasi);

    @Query(value = "SELECT * FROM siormawa_msinformasi WHERE inf_id_informasi = (SELECT MAX(inf_id_informasi) FROM siormawa_msinformasi)", nativeQuery = true)
    public Informasi getInformasiTerakhir();

    @Query(value = "UPDATE siormawa_msinformasi SET inf_status = 'Aktif' WHERE inf_id_informasi= ?1", nativeQuery = true)
    public Informasi AktifkanInformasi(int idInformasi);

    @Query(value = "UPDATE siormawa_msinformasi SET inf_status = 'Tidak Aktif' WHERE inf_id_informasi= ?1", nativeQuery = true)
    public Informasi NonaktifkanInformasi(int idInformasi);
}
