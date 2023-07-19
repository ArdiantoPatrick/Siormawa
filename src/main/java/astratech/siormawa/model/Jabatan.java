package astratech.siormawa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "siormawa_msjabatan")
public class Jabatan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="jbt_id_jabatan")
    private Integer idJabatan;

    @Column(name ="jbt_nama")
    private String nama;

    @Column(name ="jbt_status")
    private String status;

    @Column(name ="jbt_created_by")
    private String createdby;

    @Column(name ="jbt_created_date")
    private Date createddate;

    @Column(name ="jbt_modified_by")
    private String modifiedby;

    @Column(name ="jbt_modified_date")
    private Date modifieddate;

    public Jabatan() {
    }

    public Jabatan(Integer idJabatan, String nama, String status, String createdby, Date createddate, String modifiedby, Date modifieddate) {
        this.idJabatan = idJabatan;
        this.nama = nama;
        this.status = status;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
    }

    public Integer getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(Integer idJabatan) {
        this.idJabatan = idJabatan;
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
