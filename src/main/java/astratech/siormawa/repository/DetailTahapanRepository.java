package astratech.siormawa.repository;

import astratech.siormawa.model.DetailTahapan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetailTahapanRepository extends CrudRepository<DetailTahapan, Integer> {

    @Query(value = "SELECT * FROM siormawa_msdetailtahapan WHERE dthp_status = 'Aktif' AND dthp_id_tahapan = (SELECT thp_id_tahapan FROM siormawa_mstahapan WHERE thp_status = 'Aktif')", nativeQuery = true)
    public List<DetailTahapan> getDetailTahapansByTahapanAktif();

    @Query(value = "SELECT * FROM siormawa_msdetailtahapan WHERE dthp_id_tahapan= ?1", nativeQuery = true)
    public List<DetailTahapan> getDetailTahapansByIdTahapan(int idTahapan);

//    @Query(value = "UPDATE siormawa_msdetailtahapan SET pgn_status = 'Deleted' WHERE pgn_id_pengguna= ?1", nativeQuery = true)
//    public Pengguna DeleteStatus(int idPengguna);
//
//    @Query(value = "UPDATE siormawa_msdetailtahapan SET pgn_status = 'Aktif' WHERE pgn_id_pengguna= ?1", nativeQuery = true)
//    public Pengguna AktifkanPengguna(int idJabatan);
//
//    @Query(value = "UPDATE siormawa_msdetailtahapan SET pgn_status = 'Tidak Aktif' WHERE pgn_id_pengguna= ?1", nativeQuery = true)
//    public Pengguna NonaktifkanPengguna(int idJabatan);
}
