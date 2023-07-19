package astratech.siormawa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "siormawa_msperiode")
public class Periode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="prd_id_periode")
    private Integer idPeriode;

    @Column(name ="prd_tahun")
    private String tahun;

    @Column(name ="prd_status")
    private String status;

    @Column(name ="prd_created_by")
    private String createdby;

    @Column(name ="prd_created_date")
    private Date createddate;

    @Column(name ="prd_modified_by")
    private String modifiedby;

    @Column(name ="prd_modified_date")
    private Date modifieddate;

    public Periode() {
    }

    public Periode(Integer idPeriode, String tahun, String status, String createdby, Date createddate, String modifiedby, Date modifieddate) {
        this.idPeriode = idPeriode;
        this.tahun = tahun;
        this.status = status;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
    }

    public Integer getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Integer idPeriode) {
        this.idPeriode = idPeriode;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
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
