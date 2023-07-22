package astratech.siormawa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "siormawa_msdetailtahapan")
public class DetailTahapan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="dthp_id_detail_tahapan")
    private Integer idDetailTahapan;

    @ManyToOne
    @JoinColumn(name = "dthp_id_tahapan")
    private Tahapan idTahapan;

    @ManyToOne
    @JoinColumn(name = "dthp_id_kandidat")
    private Kandidat idKandidat;

    @Column(name ="dthp_status")
    private String status;

    @Column(name ="dthp_created_by")
    private String createdby;

    @Column(name ="dthp_created_date")
    private Date createddate;

    @Column(name ="dthp_modified_by")
    private String modifiedby;

    @Column(name ="dthp_modified_date")
    private Date modifieddate;

    public DetailTahapan() {
    }

    public DetailTahapan(Integer idDetailTahapan, Tahapan idTahapan, Kandidat idKandidat, String status, String createdby, Date createddate, String modifiedby, Date modifieddate) {
        this.idDetailTahapan = idDetailTahapan;
        this.idTahapan = idTahapan;
        this.idKandidat = idKandidat;
        this.status = status;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
    }

    public Integer getIdDetailTahapan() {
        return idDetailTahapan;
    }

    public void setIdDetailTahapan(Integer idDetailTahapan) {
        this.idDetailTahapan = idDetailTahapan;
    }

    public Tahapan getIdTahapan() {
        return idTahapan;
    }

    public void setIdTahapan(Tahapan idTahapan) {
        this.idTahapan = idTahapan;
    }

    public Kandidat getIdKandidat() {
        return idKandidat;
    }

    public void setIdKandidat(Kandidat idKandidat) {
        this.idKandidat = idKandidat;
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
