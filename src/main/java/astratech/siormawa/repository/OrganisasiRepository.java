package astratech.siormawa.repository;

import astratech.siormawa.model.Informasi;
import astratech.siormawa.model.Jabatan;
import astratech.siormawa.model.Organisasi;
import astratech.siormawa.model.Periode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganisasiRepository extends CrudRepository<Organisasi, Integer> {

    @Query(value = "SELECT * FROM siormawa_msorganisasi WHERE org_id_organisasi= ?1 AND (org_status = 'Aktif' OR org_status = 'Tidak Aktif')", nativeQuery = true)
    public Organisasi getOrganisasiByIdOrganisasi(int idOrganisasi);

    @Query(value = "SELECT * FROM siormawa_msorganisasi WHERE (org_status = 'Aktif' OR org_status = 'Tidak Aktif')", nativeQuery = true)
    public List<Organisasi> getOrganisasis();

    @Query(value = "SELECT * FROM siormawa_msorganisasi WHERE org_status = 'Aktif'", nativeQuery = true)
    public List<Organisasi> getOrganisasisAktif();

    @Query(value = "UPDATE siormawa_msorganisasi SET org_status = 'Deleted' WHERE org_id_organisasi= ?1", nativeQuery = true)
    public Organisasi DeleteStatus(int idOrganisasi);

    @Query(value = "UPDATE siormawa_msorganisasi SET org_status = 'Aktif' WHERE org_id_organisasi= ?1", nativeQuery = true)
    public Organisasi AktifkanOrganisasi(int idOrganisasi);

    @Query(value = "UPDATE siormawa_msorganisasi SET org_status = 'Tidak Aktif' WHERE org_id_organisasi= ?1", nativeQuery = true)
    public Organisasi NonaktifkanOrganisasi(int idOrganisasi);
}
