package astratech.siormawa.model;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Entity
@Table(name = "siormawa_msinformasi")
public class Informasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="inf_id_informasi")
    private Integer idInformasi;

    @Column(name ="inf_judul")
    private String judul;

    @Column(name ="inf_gambar")
    private byte[] file;

    @Column(name ="inf_deskripsi")
    private String deskripsi;

    @Column(name ="inf_jenis")
    private String jenis;

    @Column(name ="inf_status")
    private String status;

    @Column(name ="inf_created_by")
    private String createdby;

    @Column(name ="inf_created_date")
    private Date createddate;

    @Column(name ="inf_modified_by")
    private String modifiedby;

    @Column(name ="inf_modified_date")
    private Date modifieddate;

    public Informasi(Integer idInformasi, String judul, byte[] file, String deskripsi, String jenis, String status, String createdby, Date createddate, String modifiedby, Date modifieddate) {
        this.idInformasi = idInformasi;
        this.judul = judul;
        this.file = file;
        this.deskripsi = deskripsi;
        this.jenis = jenis;
        this.status = status;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
    }

    public Informasi() {

    }

    public Integer getIdInformasi() {
        return idInformasi;
    }

    public void setIdInformasi(Integer idInformasi) {
        this.idInformasi = idInformasi;
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

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
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
