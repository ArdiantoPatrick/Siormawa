package astratech.siormawa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "siormawa_msorganisasi")
public class Organisasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="org_id_organisasi")
    private Integer idOrganisasi;

    @Column(name ="org_nama")
    private String nama;

    @Column(name ="org_status")
    private String status;

    @Column(name ="org_created_by")
    private String createdby;

    @Column(name ="org_created_date")
    private Date createddate;

    @Column(name ="org_modified_by")
    private String modifiedby;

    @Column(name ="org_modified_date")
    private Date modifieddate;

    public Organisasi() {
    }

    public Organisasi(Integer idOrganisasi, String nama, String status, String createdby, Date createddate, String modifiedby, Date modifieddate) {
        this.idOrganisasi = idOrganisasi;
        this.nama = nama;
        this.status = status;
        this.createdby = createdby;
        this.createddate = createddate;
        this.modifiedby = modifiedby;
        this.modifieddate = modifieddate;
    }

    public Integer getIdOrganisasi() {
        return idOrganisasi;
    }

    public void setIdOrganisasi(Integer idOrganisasi) {
        this.idOrganisasi = idOrganisasi;
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
