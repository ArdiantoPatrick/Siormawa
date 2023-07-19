package astratech.siormawa.service;

import astratech.siormawa.model.Event;
import astratech.siormawa.model.Tahapan;
import astratech.siormawa.repository.TahapanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TahapanService {
    @Autowired
    TahapanRepository tahapanRepository;

    public boolean save(Tahapan tahapan){

        Tahapan result = tahapanRepository.save(tahapan);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return isSuccess;
    }

    public Tahapan getTahapanByIdTahapan(Integer idTahapan){
        Tahapan tahapan = tahapanRepository.getTahapanByIdTahapan(idTahapan);
        return tahapan;
    }

    public Tahapan getTahapanByIdEvent(Integer idEvent){
        Tahapan tahapan = tahapanRepository.getTahapanByIdEvent(idEvent);
        return tahapan;
    }

    public List<Tahapan> getTahapans(){
        List<Tahapan> tahapans = tahapanRepository.getTahapans();
        return tahapans;
    }

    public List<Tahapan> getTahapansByIdEvent(Integer idEvent){
        List<Tahapan> tahapans = tahapanRepository.getTahapansByIdEvent(idEvent);
        return tahapans;
    }

    public boolean updatedTahapan(Integer idTahapan, Tahapan updatedTahapan){

        Tahapan tahapan = tahapanRepository.getTahapanByIdTahapan(idTahapan);
        if(tahapan == null){
            return false;
        }
        tahapan.setIdEvent(updatedTahapan.getIdEvent());
        tahapan.setNama(updatedTahapan.getNama());
        tahapan.setDeskripsi(updatedTahapan.getDeskripsi());
        tahapan.setSlot(updatedTahapan.getSlot());
        tahapan.setNilaibem(updatedTahapan.getNilaibem());
        tahapan.setNilaimpm(updatedTahapan.getNilaimpm());
        tahapan.setNilaihimma(updatedTahapan.getNilaihimma());
        tahapan.setUrutan(updatedTahapan.getUrutan());
        tahapan.setStatus(updatedTahapan.getStatus());
        tahapan.setCreatedby(updatedTahapan.getCreatedby());
        tahapan.setCreateddate(updatedTahapan.getCreateddate());
        tahapan.setModifiedby(updatedTahapan.getModifiedby());
        tahapan.setModifieddate(updatedTahapan.getModifieddate());

        Tahapan result = tahapanRepository.save(tahapan);
        return result != null;
    }
//
    public boolean deleteTahapan(Integer idTahapan){
        try {
            tahapanRepository.DeleteStatus(idTahapan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AktifkanTahapan(Integer idTahapan){
        try {
            tahapanRepository.AktifkanTahapan(idTahapan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean NonaktifkanTahapan(Integer idTahapan){
        try {
            tahapanRepository.NonaktifkanTahapan(idTahapan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Tahapan> getTahapanAktif(){
        List<Tahapan> tahapan = tahapanRepository.getTahapanAktif();
        return tahapan;
    }

    public boolean semuatStatusTidakAktif(Integer idEvent){
        try {
            tahapanRepository.semuaStatusTidakAktif(idEvent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AktifkanTahapanByUrutan(Integer idEvent,Integer urutan){
        try {
            tahapanRepository.AktifkanTahapanByUrutan(idEvent, urutan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean SelesaikanTahapanByUrutan(Integer idEvent, Integer urutan){
        try {
            tahapanRepository.SelesaikanTahapanByUrutan(idEvent, urutan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
