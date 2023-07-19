package astratech.siormawa.service;

import astratech.siormawa.model.Jabatan;
import astratech.siormawa.model.Periode;
import astratech.siormawa.repository.JabatanRepository;
import astratech.siormawa.repository.OrganisasiRepository;
import astratech.siormawa.repository.PeriodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JabatanService {
    @Autowired
    JabatanRepository jabatanRepository;

    public boolean save(Jabatan jabatan){

        Jabatan result = jabatanRepository.save(jabatan);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return isSuccess;
    }

    public Jabatan getJabatan(Integer idJabatan){
        Jabatan jabatan = jabatanRepository.getJabatanByIdJabatan(idJabatan);
        return jabatan;
    }

    public List<Jabatan> getJabatans(){
        List<Jabatan> jabatans = jabatanRepository.getJabatans();
        return jabatans;
    }

    public List<Jabatan> getJabatansAktif(){
        List<Jabatan> jabatans = jabatanRepository.getJabatansAktif();
        return jabatans;
    }


    public boolean updateJabatan(Integer idJabatan, Jabatan updatedJabatan){

        Jabatan jabatan = jabatanRepository.getJabatanByIdJabatan(idJabatan);
        if(jabatan == null){
            return false;
        }
        jabatan.setNama(updatedJabatan.getNama());
        jabatan.setStatus(updatedJabatan.getStatus());
        jabatan.setCreatedby(updatedJabatan.getCreatedby());
        jabatan.setCreateddate(updatedJabatan.getCreateddate());
        jabatan.setModifiedby(updatedJabatan.getModifiedby());
        jabatan.setModifieddate(updatedJabatan.getModifieddate());
        Jabatan result = jabatanRepository.save(jabatan);
        return result != null;
    }
//
    public boolean deleteJabatan(Integer idJabatan){
        try {
            jabatanRepository.DeleteStatus(idJabatan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AktifkanJabatan(Integer idJabatan){
        try {
            jabatanRepository.AktifkanJabatan(idJabatan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean NonaktifkanJabatan(Integer idJabatan){
        try {
            jabatanRepository.NonaktifkanJabatan(idJabatan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
