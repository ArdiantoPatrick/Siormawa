package astratech.siormawa.controller;

import astratech.siormawa.model.Event;
import astratech.siormawa.model.Tahapan;
import astratech.siormawa.service.TahapanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class TahapanController {

    @Autowired
    TahapanService tahapanService;

    @GetMapping("/saveTahapan")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "idEvent") Event idEvent,
                                     @RequestParam(name = "nama") String nama,
                                     @RequestParam(name = "deskripsi") String deskripsi,
                                     @RequestParam(name = "slot") Integer slot,
                                     @RequestParam(name = "nilaibem") Integer nilaibem,
                                     @RequestParam(name = "nilaimpm") Integer nilaimpm,
                                     @RequestParam(name = "nilaihimma") Integer nilaihimma,
                                     @RequestParam(name = "urutan") Integer urutan ){

        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Tahapan tahapan = new Tahapan (0, idEvent, nama , deskripsi, slot, nilaibem, nilaimpm, nilaihimma, urutan, "Tidak Aktif", "a", date, null, null);
        tahapanService.save(tahapan);
        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Event/index.html")).build();
    }

    @GetMapping("/getTahapanByIdTahapan")
    public Tahapan getTahapanByIdTahapan(HttpServletResponse response, @RequestParam("id") Integer id){
        Tahapan tahapan = tahapanService.getTahapanByIdTahapan(id);
        return tahapan;
    }

    @GetMapping("/getTahapanByIdEvent")
    public Tahapan getTahapanByIdEvent(HttpServletResponse response, @RequestParam("id") Integer id){
        Tahapan tahapan = tahapanService.getTahapanByIdEvent(id);
        return tahapan;
    }

    @GetMapping("/getTahapans")
    public List<Tahapan> getTahapans(HttpServletResponse response){
        List<Tahapan> tahapans = tahapanService.getTahapans();
        return tahapans;
    }

    @GetMapping("/getTahapansByIdEvent")
    public List<Tahapan> getEvents(HttpServletResponse response, @RequestParam("id") Integer id){
        List<Tahapan> tahapans = tahapanService.getTahapansByIdEvent(id);
        return tahapans;
    }

    @GetMapping("/updateTahapan")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idTahapan") String idTahapan,
                                       @RequestParam(name = "nama") String nama,
                                       @RequestParam(name = "deskripsi") String deskripsi,
                                       @RequestParam(name = "slot") Integer slot,
                                       @RequestParam(name = "nilaibem") Integer nilaibem,
                                       @RequestParam(name = "nilaimpm") Integer nilaimpm,
                                       @RequestParam(name = "nilaihimma") Integer nilaihimma,
                                       @RequestParam(name = "urutan") Integer urutan) {

        Tahapan tahapan2 = tahapanService.getTahapanByIdTahapan(Integer.parseInt(idTahapan));
        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Tahapan tahapan = new Tahapan(Integer.parseInt(idTahapan), tahapan2.getIdEvent(), nama, deskripsi, slot, nilaibem, nilaimpm, nilaihimma,urutan, tahapan2.getStatus(), tahapan2.getCreatedby(), tahapan2.getCreateddate(), "b", date);
        tahapanService.updatedTahapan(Integer.parseInt(idTahapan), tahapan);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Event/index.html")).build();
    }

    @GetMapping("/deleteTahapan")
    public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
        tahapanService.deleteTahapan(id);
        return ResponseEntity.ok("Tahapan with ID: " + id + ". Deleted Successfully");
    }

    @GetMapping("/aktifkanTahapan")
    public ResponseEntity<String> aktifkanById(@RequestParam("id") Integer id) {
        tahapanService.AktifkanTahapan(id);
        return ResponseEntity.ok("Tahapan with ID: " + id + ". Activate Successfully");
    }

    @GetMapping("/nonaktifkanTahapan")
    public ResponseEntity<String> nonaktifkanById(@RequestParam("id") Integer id) {
        tahapanService.NonaktifkanTahapan(id);
        return ResponseEntity.ok("Tahapan with ID: " + id + ". Deactivate Successfully");
    }

    @GetMapping("/getTahapanAktif")
    public List<Tahapan> getTahapan(HttpServletResponse response){
        List<Tahapan> tahapan = tahapanService.getTahapanAktif();
        return tahapan;
    }

    @GetMapping("/semuaStatusTidakAktif")
    public ResponseEntity<String> semuaStatusTidakAktif(@RequestParam("id") Integer id) {
        tahapanService.semuatStatusTidakAktif(id);
        return ResponseEntity.ok("Semua tahapan berhasil di nonaktifkan");
    }

    @GetMapping("/aktifkanTahapanByUrutan")
    public ResponseEntity<String> aktifkanByIdEvent(@RequestParam("idEvent") Integer idEvent,
                                                    @RequestParam("urutan") Integer urutan) {
        tahapanService.AktifkanTahapanByUrutan(idEvent,urutan);
        return ResponseEntity.ok("Tahapan Activate Successfully");
    }

    @GetMapping("/selesaikanTahapanByUrutan")
    public ResponseEntity<String> nonaktifkanByIdEvent(@RequestParam("idEvent") Integer idEvent,
                                                       @RequestParam("urutan") Integer urutan) {
        tahapanService.SelesaikanTahapanByUrutan(idEvent,urutan);
        return ResponseEntity.ok("Tahapan Deactivate Successfully");
    }
}
