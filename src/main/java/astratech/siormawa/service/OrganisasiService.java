package astratech.siormawa.service;

import astratech.siormawa.model.Organisasi;
import astratech.siormawa.model.Periode;
import astratech.siormawa.repository.OrganisasiRepository;
import astratech.siormawa.repository.PeriodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisasiService {
    @Autowired
    OrganisasiRepository organisasiRepository;

    public boolean save(Organisasi organisasi){

        Organisasi result = organisasiRepository.save(organisasi);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return isSuccess;
    }

    public Organisasi getOrganisasi(Integer idOrganisasi){
        Organisasi organisasi = organisasiRepository.getOrganisasiByIdOrganisasi(idOrganisasi);
        return organisasi;
    }

    public List<Organisasi> getOrganisasis(){
        List<Organisasi> organisasis = organisasiRepository.getOrganisasis();
        return organisasis;
    }

    public List<Organisasi> getOrganisasisAktif(){
        List<Organisasi> organisasis = organisasiRepository.getOrganisasisAktif();
        return organisasis;
    }

    public boolean updateOrganisasi(Integer idOrganisasi, Organisasi updatedOrganisasi){

        Organisasi organisasi = organisasiRepository.getOrganisasiByIdOrganisasi(idOrganisasi);
        if(organisasi == null){
            return false;
        }
        organisasi.setNama(updatedOrganisasi.getNama());
        organisasi.setStatus(updatedOrganisasi.getStatus());
        organisasi.setCreatedby(updatedOrganisasi.getCreatedby());
        organisasi.setCreateddate(updatedOrganisasi.getCreateddate());
        organisasi.setModifiedby(updatedOrganisasi.getModifiedby());
        organisasi.setModifieddate(updatedOrganisasi.getModifieddate());
        Organisasi result = organisasiRepository.save(organisasi);
        return result != null;
    }
//
    public boolean deleteOrganisasi(Integer idOrganisasi){
        try {
            organisasiRepository.DeleteStatus(idOrganisasi);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AktifkanOrganisasi(Integer idOrganisasi){
        try {
            organisasiRepository.AktifkanOrganisasi(idOrganisasi);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean NonaktifkanOrganisasi(Integer idOrganisasi){
        try {
            organisasiRepository.NonaktifkanOrganisasi(idOrganisasi);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
