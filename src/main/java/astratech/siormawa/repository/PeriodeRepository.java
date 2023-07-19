package astratech.siormawa.repository;

import astratech.siormawa.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeriodeRepository extends CrudRepository<Periode, Integer> {

    @Query(value = "SELECT * FROM siormawa_msperiode WHERE prd_id_periode= ?1 AND (prd_status = 'Aktif' OR prd_status = 'Tidak Aktif')", nativeQuery = true)
    public Periode getPeriodeByIdPeriode(int idPeriode);

    @Query(value = "SELECT * FROM siormawa_msperiode WHERE (prd_status = 'Aktif' OR prd_status = 'Tidak Aktif')", nativeQuery = true)
    public List<Periode> getPeriodes();

    @Query(value = "SELECT * FROM siormawa_msperiode WHERE prd_status = 'Aktif'", nativeQuery = true)
    public List<Periode> getPeriodesAktif();

    @Query(value = "UPDATE siormawa_msperiode SET prd_status = 'Deleted' WHERE prd_id_periode= ?1", nativeQuery = true)
    public Periode DeleteStatus(int idPeriode);

    @Query(value = "UPDATE siormawa_msperiode SET prd_status = 'Aktif' WHERE prd_id_periode= ?1", nativeQuery = true)
    public Periode AktifkanPeriode(int idPeriode);

    @Query(value = "UPDATE siormawa_msperiode SET prd_status = 'Tidak Aktif' WHERE prd_id_periode= ?1", nativeQuery = true)
    public Periode NonaktifkanPeriode(int idPeriode);
}
