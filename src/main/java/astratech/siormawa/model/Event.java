package astratech.siormawa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "siormawa_msevent")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="evt_id_event")
    private Integer idEvent;

    @Column(name ="evt_nama_event")
    private String nama;

    @Column(name ="evt_deskripsi")
    private String deskripsi;

    @Column(name ="evt_status")
    private String status;

    @Column(name ="evt_created_by")
    private String createdby;

    @Column(name ="evt_created_date")
    private Date createddate;

    @Column(name ="evt_modified_by")
    private String modifiedby;

    @Column(name ="evt_modified_date")
    private Date modifieddate;

    public Event() {
    }

    public Event(Integer idEvent, String nama, String deskripsi, String status, String createdby, Date createddate, String modifiedby, Date modifieddate) {
        this.idEvent = idEvent;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.status = status;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
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
