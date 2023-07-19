package astratech.siormawa.controller;

import astratech.siormawa.model.Jabatan;
import astratech.siormawa.model.Periode;
import astratech.siormawa.service.JabatanService;
import astratech.siormawa.service.PeriodeService;
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
public class JabatanController {
    @Autowired
    JabatanService jabatanService;

    @GetMapping("/saveJabatan")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "nama") String nama) {

        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Jabatan jabatan = new Jabatan(0, nama, "Aktif", "a", date, null, null);
        jabatanService.save(jabatan);
        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Jabatan/index.html")).build();
    }

    @GetMapping("/getJabatan")
    public Jabatan getJabatan(HttpServletResponse response, @RequestParam("id") Integer id){
        Jabatan jabatan = jabatanService.getJabatan(id);
        return jabatan;
    }

    @GetMapping("/getJabatans")
    public List<Jabatan> getJabatans(HttpServletResponse response){
        List<Jabatan> jabatans = jabatanService.getJabatans();
        return jabatans;
    }

    @GetMapping("/getJabatansAktif")
    public List<Jabatan> getJabatansAktif(HttpServletResponse response){
        List<Jabatan> jabatans = jabatanService.getJabatansAktif();
        return jabatans;
    }

    @GetMapping("/updateJabatan")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idJabatan") String idJabatan,
                                       @RequestParam(name = "nama") String nama) {

        Jabatan jabatan2 = jabatanService.getJabatan(Integer.parseInt(idJabatan));
        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Jabatan jabatan = new Jabatan(Integer.parseInt(idJabatan), nama, jabatan2.getStatus(), jabatan2.getCreatedby(), jabatan2.getCreateddate(), "b", date);
        jabatanService.updateJabatan(Integer.parseInt(idJabatan), jabatan);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Jabatan/index.html")).build();
    }

    @GetMapping("/deleteJabatan")
    public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
        jabatanService.deleteJabatan(id);
        return ResponseEntity.ok("Jabatan with ID: " + id + ". Deleted Successfully");
    }

    @GetMapping("/aktifkanJabatan")
    public ResponseEntity<String> aktifkanById(@RequestParam("id") Integer id) {
        jabatanService.AktifkanJabatan(id);
        return ResponseEntity.ok("Jabatan with ID: " + id + ". Activate Successfully");
    }

    @GetMapping("/nonaktifkanJabatan")
    public ResponseEntity<String> nonaktifkanById(@RequestParam("id") Integer id) {
        jabatanService.NonaktifkanJabatan(id);
        return ResponseEntity.ok("Jabatan with ID: " + id + ". Deactivate Successfully");
    }
}
