package astratech.siormawa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "siormawa_mspengguna")
public class Pengguna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="pgn_id_pengguna")
    private Integer idPengguna;

    @ManyToOne
    @JoinColumn(name = "pgn_id_organisasi")
    private Organisasi idOrganisasi;

    @ManyToOne
    @JoinColumn(name = "pgn_id_jabatan")
    private Jabatan idJabatan;

    @ManyToOne
    @JoinColumn(name = "pgn_id_periode")
    private Periode idPeriode;

    @Column(name ="pgn_nama")
    private String nama;

    @Column(name ="pgn_username")
    private String username;

    @Column(name ="pgn_role")
    private String role;

    @Column(name ="pgn_status")
    private String status;

    @Column(name ="pgn_created_by")
    private String createdby;

    @Column(name ="pgn_created_date")
    private Date createddate;

    @Column(name ="pgn_modified_by")
    private String modifiedby;

    @Column(name ="pgn_modified_date")
    private Date modifieddate;

    public Pengguna() {
    }

    public Pengguna(Integer idPengguna, Organisasi idOrganisasi, Jabatan idJabatan, Periode idPeriode, String nama, String username, String role, String status, String createdby, Date createddate, String modifiedby, Date modifieddate) {
        this.idPengguna = idPengguna;
        this.idOrganisasi = idOrganisasi;
        this.idJabatan = idJabatan;
        this.idPeriode = idPeriode;
        this.nama = nama;
        this.username = username;
        this.role = role;
        this.status = status;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
    }

    public Integer getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(Integer idPengguna) {
        this.idPengguna = idPengguna;
    }

    public Organisasi getIdOrganisasi() {
        return idOrganisasi;
    }

    public void setIdOrganisasi(Organisasi idOrganisasi) {
        this.idOrganisasi = idOrganisasi;
    }

    public Jabatan getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(Jabatan idJabatan) {
        this.idJabatan = idJabatan;
    }

    public Periode getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Periode idPeriode) {
        this.idPeriode = idPeriode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }
}
