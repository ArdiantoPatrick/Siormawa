package astratech.siormawa.service;

import astratech.siormawa.model.Informasi;
import astratech.siormawa.model.Pengguna;
import astratech.siormawa.repository.InformasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformasiService {
    @Autowired
    InformasiRepository informasiRepository;

    public boolean save(Informasi informasi){
        Informasi result = informasiRepository.save(informasi);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return isSuccess;
    }

    public Informasi getInformasi(Integer idInformasi){
        Informasi informasi = informasiRepository.getInformasiByIdInformasi(idInformasi);
        return informasi;
    }

    public Informasi getInformasiTerakhir(){
        Informasi informasi = informasiRepository.getInformasiTerakhir();
        return informasi;
    }

    public List<Informasi> getInformasis(){
        List<Informasi> informasis = informasiRepository.getInformasis();
        return informasis;
    }

    public List<Informasi> getInformasisByCreated(String namacreated){
        List<Informasi> informasis = informasiRepository.getInformasisByCreated(namacreated);
        return informasis;
    }

    public boolean updateInformasi(Integer idInformasi, Informasi updatedInformasi){

        Informasi informasi = informasiRepository.getInformasiByIdInformasi(idInformasi);
        if(informasi == null){
            return false;
        }
        informasi.setJudul(updatedInformasi.getJudul());
        informasi.setFile(updatedInformasi.getFile());
        informasi.setDeskripsi(updatedInformasi.getDeskripsi());
        informasi.setJenis(updatedInformasi.getJenis());
        informasi.setStatus(updatedInformasi.getStatus());
        informasi.setCreatedby(updatedInformasi.getCreatedby());
        informasi.setCreateddate(updatedInformasi.getCreateddate());
        informasi.setModifiedby(updatedInformasi.getModifiedby());
        informasi.setModifieddate(updatedInformasi.getModifieddate());
        Informasi result = informasiRepository.save(informasi);
        return result != null;
    }

    public boolean deleteInformasi(Integer idInformasi){
        try {
            informasiRepository.DeleteStatus(idInformasi);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AktifkanInformasi(Integer idInformasi){
        try {
            informasiRepository.AktifkanInformasi(idInformasi);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean NonaktifkanInformasi(Integer idInformasi){
        try {
            informasiRepository.NonaktifkanInformasi(idInformasi);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
