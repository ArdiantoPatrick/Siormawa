package astratech.siormawa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "siormawa_mstahapan")
public class Tahapan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="thp_id_tahapan")
    private Integer idTahapan;

    @ManyToOne
    @JoinColumn(name = "thp_id_event")
    private Event idEvent;

    @Column(name ="thp_nama")
    private String nama;

    @Column(name ="thp_deskripsi")
    private String deskripsi;

    @Column(name ="thp_slot")
    private Integer slot;

    @Column(name ="thp_nilai_bem")
    private Integer nilaibem;

    @Column(name ="thp_nilai_mpm")
    private Integer nilaimpm;

    @Column(name ="thp_nilai_himma")
    private Integer nilaihimma;

    @Column(name ="thp_urutan")
    private Integer urutan;

    @Column(name ="thp_status")
    private String status;

    @Column(name ="thp_created_by")
    private String createdby;

    @Column(name ="thp_created_date")
    private Date createddate;

    @Column(name ="thp_modified_by")
    private String modifiedby;

    @Column(name ="thp_modified_date")
    private Date modifieddate;

    public Tahapan() {
    }

    public Tahapan(Integer idTahapan, Event idEvent, String nama, String deskripsi, Integer slot, Integer nilaibem, Integer nilaimpm, Integer nilaihimma, Integer urutan, String status, String createdby, Date createddate, String modifiedby, Date modifieddate) {
        this.idTahapan = idTahapan;
        this.idEvent = idEvent;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.slot = slot;
        this.nilaibem = nilaibem;
        this.nilaimpm = nilaimpm;
        this.nilaihimma = nilaihimma;
        this.urutan = urutan;
        this.status = status;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
    }

    public Integer getIdTahapan() {
        return idTahapan;
    }

    public void setIdTahapan(Integer idTahapan) {
        this.idTahapan = idTahapan;
    }

    public Event getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Event idEvent) {
        this.idEvent = idEvent;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Integer getNilaibem() {
        return nilaibem;
    }

    public void setNilaibem(Integer nilaibem) {
        this.nilaibem = nilaibem;
    }

    public Integer getNilaimpm() {
        return nilaimpm;
    }

    public void setNilaimpm(Integer nilaimpm) {
        this.nilaimpm = nilaimpm;
    }

    public Integer getNilaihimma() {
        return nilaihimma;
    }

    public void setNilaihimma(Integer nilaihimma) {
        this.nilaihimma = nilaihimma;
    }

    public Integer getUrutan() {
        return urutan;
    }

    public void setUrutan(Integer urutan) {
        this.urutan = urutan;
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

