package astratech.siormawa.service;

import astratech.siormawa.model.Pengguna;
import astratech.siormawa.repository.PenggunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PenggunaService {
    @Autowired
    PenggunaRepository penggunaRepository;

    public boolean save(Pengguna pengguna){

        Pengguna result = penggunaRepository.save(pengguna);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return isSuccess;
    }

    public Pengguna getPengguna(Integer idPengguna){
        Pengguna pengguna = penggunaRepository.getPenggunaByIdPengguna(idPengguna);
        return pengguna;
    }

    public Pengguna getPenggunaByUsername(Integer username){
        Pengguna pengguna = penggunaRepository.getPenggunaByUsername(username);
        return pengguna;
    }

    public List<Pengguna> getPenggunas(){
        List<Pengguna> penggunas = penggunaRepository.getPenggunas();
        return penggunas;
    }

    public boolean updatePengguna(Integer idPengguna, Pengguna updatedPengguna){

        Pengguna pengguna = penggunaRepository.getPenggunaByIdPengguna(idPengguna);
        if(pengguna == null){
            return false;
        }
        pengguna.setNama(updatedPengguna.getNama());
        pengguna.setIdOrganisasi(updatedPengguna.getIdOrganisasi());
        pengguna.setIdJabatan(updatedPengguna.getIdJabatan());
        pengguna.setIdPeriode(updatedPengguna.getIdPeriode());
        pengguna.setUsername(updatedPengguna.getUsername());
        pengguna.setRole(updatedPengguna.getRole());
        pengguna.setStatus(updatedPengguna.getStatus());
        pengguna.setCreatedby(updatedPengguna.getCreatedby());
        pengguna.setCreateddate(updatedPengguna.getCreateddate());
        pengguna.setModifiedby(updatedPengguna.getModifiedby());
        pengguna.setModifieddate(updatedPengguna.getModifieddate());
        Pengguna result = penggunaRepository.save(pengguna);
        return result != null;
    }
//
    public boolean deletePengguna(Integer idPengguna){
        try {
            penggunaRepository.DeleteStatus(idPengguna);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AktifkanPengguna(Integer idPengguna){
        try {
            penggunaRepository.AktifkanPengguna(idPengguna);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean NonaktifkanPengguna(Integer idPengguna){
        try {
            penggunaRepository.NonaktifkanPengguna(idPengguna);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
