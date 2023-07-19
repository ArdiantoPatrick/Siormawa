package astratech.siormawa.service;

import astratech.siormawa.model.InformasiSeleksi;
import astratech.siormawa.repository.InformasiSeleksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformasiSeleksiService {
    @Autowired
    InformasiSeleksiRepository informasiSeleksiRepository;

    public boolean save(InformasiSeleksi informasiSeleksi){
        InformasiSeleksi result = informasiSeleksiRepository.save(informasiSeleksi);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return isSuccess;
    }

    public InformasiSeleksi getInformasiSeleksi(Integer idInformasiSeleksi){
        InformasiSeleksi informasiSeleksi = informasiSeleksiRepository.getInformasiSeleksiByIdInformasiSeleksi(idInformasiSeleksi);
        return informasiSeleksi;
    }

    public InformasiSeleksi getInformasiSeleksiTerakhir(){
        InformasiSeleksi informasiSeleksi = informasiSeleksiRepository.getInformasiSeleksiTerakhir();
        return informasiSeleksi;
    }

    public List<InformasiSeleksi> getInformasiSeleksis(){
        List<InformasiSeleksi> informasiSeleksis = informasiSeleksiRepository.getInformasiSeleksis();
        return informasiSeleksis;
    }

    public List<InformasiSeleksi> getInformasiSeleksisByCreated(String namacreated){
        List<InformasiSeleksi> informasiSeleksis = informasiSeleksiRepository.getInformasiSeleksisByCreated(namacreated);
        return informasiSeleksis;
    }

    public boolean updateInformasiSeleksi(Integer idInformasiSeleksi, InformasiSeleksi updatedInformasiSeleksi){

        InformasiSeleksi informasiSeleksis = informasiSeleksiRepository.getInformasiSeleksiByIdInformasiSeleksi(idInformasiSeleksi);
        if(informasiSeleksis == null){
            return false;
        }
        informasiSeleksis.setJudul(updatedInformasiSeleksi.getJudul());
        informasiSeleksis.setFile(updatedInformasiSeleksi.getFile());
        informasiSeleksis.setDeskripsi(updatedInformasiSeleksi.getDeskripsi());
        informasiSeleksis.setStatus(updatedInformasiSeleksi.getStatus());
        informasiSeleksis.setCreatedby(updatedInformasiSeleksi.getCreatedby());
        informasiSeleksis.setCreateddate(updatedInformasiSeleksi.getCreateddate());
        informasiSeleksis.setModifiedby(updatedInformasiSeleksi.getModifiedby());
        informasiSeleksis.setModifieddate(updatedInformasiSeleksi.getModifieddate());
        InformasiSeleksi result = informasiSeleksiRepository.save(informasiSeleksis);
        return result != null;
    }

    public boolean deleteInformasi(Integer idInformasiSeleksi){
        try {
            informasiSeleksiRepository.DeleteStatus(idInformasiSeleksi);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AktifkanInformasiSeleksi(Integer idInformasiSeleksi){
        try {
            informasiSeleksiRepository.AktifkanInformasiSeleksi(idInformasiSeleksi);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean NonaktifkanInformasiSeleksi(Integer idInformasiSeleksi){
        try {
            informasiSeleksiRepository.NonaktifkanInformasiSeleksi(idInformasiSeleksi);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
