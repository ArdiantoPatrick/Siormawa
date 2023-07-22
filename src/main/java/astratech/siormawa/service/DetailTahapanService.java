package astratech.siormawa.service;

import astratech.siormawa.model.DetailTahapan;
import astratech.siormawa.repository.DetailTahapanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailTahapanService {
    @Autowired
    DetailTahapanRepository detailTahapanRepository;

    public boolean save(DetailTahapan detailTahapan){

        DetailTahapan result = detailTahapanRepository.save(detailTahapan);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return isSuccess;
    }

    public List<DetailTahapan> getDetailTahapanByTahapanAktif(){
        List<DetailTahapan> detailTahapans = detailTahapanRepository.getDetailTahapansByTahapanAktif();
        return detailTahapans;
    }

    public List<DetailTahapan> getDetailTahapanByIdTahapan(Integer idTahapan){
        List<DetailTahapan> detailTahapans = detailTahapanRepository.getDetailTahapansByIdTahapan(idTahapan);
        return detailTahapans;
    }

//    public boolean updatePengguna(Integer idPengguna, Pengguna updatedPengguna){
//
//        Pengguna pengguna = penggunaRepository.getPenggunaByIdPengguna(idPengguna);
//        if(pengguna == null){
//            return false;
//        }
//        pengguna.setNama(updatedPengguna.getNama());
//        pengguna.setIdOrganisasi(updatedPengguna.getIdOrganisasi());
//        pengguna.setIdJabatan(updatedPengguna.getIdJabatan());
//        pengguna.setIdPeriode(updatedPengguna.getIdPeriode());
//        pengguna.setUsername(updatedPengguna.getUsername());
//        pengguna.setStatus(updatedPengguna.getStatus());
//        pengguna.setCreatedby(updatedPengguna.getCreatedby());
//        pengguna.setCreateddate(updatedPengguna.getCreateddate());
//        pengguna.setModifiedby(updatedPengguna.getModifiedby());
//        pengguna.setModifieddate(updatedPengguna.getModifieddate());
//        Pengguna result = penggunaRepository.save(pengguna);
//        return result != null;
//    }
////
//    public boolean deletePengguna(Integer idPengguna){
//        try {
//            penggunaRepository.DeleteStatus(idPengguna);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean AktifkanPengguna(Integer idPengguna){
//        try {
//            penggunaRepository.AktifkanPengguna(idPengguna);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean NonaktifkanPengguna(Integer idPengguna){
//        try {
//            penggunaRepository.NonaktifkanPengguna(idPengguna);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
}
