package astratech.siormawa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "siormawa_mskandidat")
public class Kandidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="kdt_id_kandidat")
    private Integer idKandidat;

//    @JoinColumn(name = "evt_id_event")
//    @Column(name ="kdt_id_event")
    private Integer idEvent;

    @Column(name ="kdt_nama")
    private String nama;

    @Column(name ="kdt_username")
    private String username;

    @Column(name ="kdt_password")
    private String password;

    @Column(name ="kdt_role")
    private int role;

    @Column(name ="kdt_status")
    private String status;

    @Column(name ="kdt_created_by")
    private String createdby;

    @Column(name ="kdt_created_date")
    private Date createddate;

    @Column(name ="kdt_modified_by")
    private String modifiedby;

    @Column(name ="kdt_modified_date")
    private Date modifieddate;

    public Kandidat(Integer idKandidat, Integer idEvent, String nama, String username, String password, int role, String status, String createdby, Date createddate, String modifiedby, Date modifieddate) {
        this.idKandidat = idKandidat;
        this.idEvent = idEvent;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
    }

    public Kandidat(){

    }

    public Integer getIdKandidat() {
        return idKandidat;
    }

    public void setIdKandidat(Integer idKandidat) {
        this.idKandidat = idKandidat;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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
