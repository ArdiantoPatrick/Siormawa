package astratech.siormawa.controller;

import astratech.siormawa.model.DetailTahapan;
import astratech.siormawa.model.Kandidat;
import astratech.siormawa.model.Tahapan;
import astratech.siormawa.service.DetailTahapanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class DetailTahapanController {
    @Autowired
    DetailTahapanService detailTahapanService;

    @GetMapping("/saveDetailTahapan")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "idTahapan") Tahapan idTahapan,
                                     @RequestParam(name = "idKandidat") Kandidat idKandidat) {

        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        DetailTahapan detailTahapan = new DetailTahapan(0, idTahapan, idKandidat,"Aktif", "a", date, null, null);
        detailTahapanService.save(detailTahapan);
        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Event/detail.html")).build();
    }

    @GetMapping("/getDetailTahapansByTahapanAktif")
    public List<DetailTahapan> getDetailTahapansByTahapanAktif(HttpServletResponse response){
        List<DetailTahapan> detailTahapans = detailTahapanService.getDetailTahapanByTahapanAktif();
        return detailTahapans;
    }

    @GetMapping("/getDetailTahapansByIdTahapan")
    public List<DetailTahapan> getDetailTahapansByIdTahapan(HttpServletResponse response,
                                    @RequestParam(name = "id") Integer idTahapan){
        List<DetailTahapan> detailTahapans = detailTahapanService.getDetailTahapanByIdTahapan(idTahapan);
        return detailTahapans;
    }

//    @GetMapping("/deletePengguna")
//    public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
//        penggunaService.deletePengguna(id);
//        return ResponseEntity.ok("Pengguna with ID: " + id + ". Deleted Successfully");
//    }
//
//    @GetMapping("/aktifkanPengguna")
//    public ResponseEntity<String> aktifkanById(@RequestParam("id") Integer id) {
//        penggunaService.AktifkanPengguna(id);
//        return ResponseEntity.ok("Pengguna with ID: " + id + ". Activate Successfully");
//    }
//
//    @GetMapping("/nonaktifkanPengguna")
//    public ResponseEntity<String> nonaktifkanById(@RequestParam("id") Integer id) {
//        penggunaService.NonaktifkanPengguna(id);
//        return ResponseEntity.ok("Pengguna with ID: " + id + ". Deactivate Successfully");
//    }
}
