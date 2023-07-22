package astratech.siormawa.repository;

import astratech.siormawa.model.Jabatan;
import astratech.siormawa.model.Pengguna;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PenggunaRepository extends CrudRepository<Pengguna, Integer> {

    @Query(value = "SELECT * FROM siormawa_mspengguna WHERE pgn_id_pengguna= ?1 AND (pgn_status = 'Aktif' OR pgn_status = 'Tidak Aktif')", nativeQuery = true)
    public Pengguna getPenggunaByIdPengguna(int idPengguna);

    @Query(value = "SELECT * FROM siormawa_mspengguna WHERE pgn_username= ?1 AND pgn_status = 'Aktif'", nativeQuery = true)
    public Pengguna getPenggunaByUsername(int username);

    @Query(value = "SELECT * FROM siormawa_mspengguna WHERE (pgn_status = 'Aktif' OR pgn_status = 'Tidak Aktif') AND (pgn_role = 'Admin' OR pgn_role = 'Ormawa')", nativeQuery = true)
    public List<Pengguna> getPenggunas();

    @Query(value = "UPDATE siormawa_mspengguna SET pgn_status = 'Deleted' WHERE pgn_id_pengguna= ?1", nativeQuery = true)
    public Pengguna DeleteStatus(int idPengguna);

    @Query(value = "UPDATE siormawa_mspengguna SET pgn_status = 'Aktif' WHERE pgn_id_pengguna= ?1", nativeQuery = true)
    public Pengguna AktifkanPengguna(int idJabatan);

    @Query(value = "UPDATE siormawa_mspengguna SET pgn_status = 'Tidak Aktif' WHERE pgn_id_pengguna= ?1", nativeQuery = true)
    public Pengguna NonaktifkanPengguna(int idJabatan);
}
