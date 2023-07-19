package astratech.siormawa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "siormawa_msinformasiseleksi")
public class InformasiSeleksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="slk_id_infseleksi")
    private Integer idInfseleksi;

    @Column(name ="slk_judul")
    private String judul;

    @Column(name ="slk_gambar")
    private byte[] file;

    @Column(name ="slk_deskripsi")
    private String deskripsi;

    @Column(name ="slk_status")
    private String status;

    @Column(name ="slk_created_by")
    private String createdby;

    @Column(name ="slk_created_date")
    private Date createddate;

    @Column(name ="slk_modified_by")
    private String modifiedby;

    @Column(name ="slk_modified_date")
    private Date modifieddate;

    public InformasiSeleksi(Integer idInfseleksi, String judul, byte[] file, String deskripsi, String status, String createdby, Date createddate, String modifiedby, Date modifieddate) {
        this.idInfseleksi = idInfseleksi;
        this.judul = judul;
        this.file = file;
        this.deskripsi = deskripsi;
        this.status = status;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
    }

    public InformasiSeleksi() {
    }

    public Integer getIdInfseleksi() {
        return idInfseleksi;
    }

    public void setIdInfseleksi(Integer idInfseleksi) {
        this.idInfseleksi = idInfseleksi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
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
