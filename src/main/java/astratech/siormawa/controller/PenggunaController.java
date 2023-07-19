package astratech.siormawa.controller;

import astratech.siormawa.model.Jabatan;
import astratech.siormawa.model.Organisasi;
import astratech.siormawa.model.Pengguna;
import astratech.siormawa.model.Periode;
import astratech.siormawa.service.PenggunaService;
import org.jboss.jandex.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class PenggunaController {
    @Autowired
    PenggunaService penggunaService;

    @GetMapping("/savePengguna")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "organisasi") Organisasi idOrganisasi,
                                     @RequestParam(name = "jabatan") Jabatan idJabatan,
                                     @RequestParam(name = "periode") Periode idPeriode,
                                     @RequestParam(name = "nama") String nama,
                                     @RequestParam(name = "username") String username,
                                     @RequestParam(name = "role") String role) {

        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Pengguna pengguna = new Pengguna(0, idOrganisasi, idJabatan, idPeriode, nama, username, role, "Aktif", "a", date, null, null);
        penggunaService.save(pengguna);
        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/User/index.html")).build();
    }

    @GetMapping("/getPengguna")
    public Pengguna getPengguna(HttpServletResponse response, @RequestParam("id") Integer id){
        Pengguna pengguna = penggunaService.getPengguna(id);
        return pengguna;
    }

    @GetMapping("/getPenggunaByUsername")
    public Pengguna getPenggunaByUsername(HttpServletResponse response, @RequestParam("username") Integer username){
        Pengguna pengguna = penggunaService.getPenggunaByUsername(username);
        return pengguna;
    }

    @GetMapping("/getPenggunas")
    public List<Pengguna> getPenggunas(HttpServletResponse response){
        List<Pengguna> penggunas = penggunaService.getPenggunas();
        return penggunas;
    }

    @GetMapping("/UpdatePengguna")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idPengguna") String idPengguna,
                                       @RequestParam(name = "organisasi") Organisasi idOrganisasi,
                                       @RequestParam(name = "jabatan") Jabatan idJabatan,
                                       @RequestParam(name = "periode") Periode idPeriode,
                                       @RequestParam(name = "nama") String nama,
                                       @RequestParam(name = "username") String username,
                                       @RequestParam(name = "role") String role) {

        Pengguna pengguna2 = penggunaService.getPengguna(Integer.parseInt(idPengguna));
        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Pengguna pengguna = new Pengguna(Integer.parseInt(idPengguna), idOrganisasi, idJabatan, idPeriode, nama, username, role, pengguna2.getStatus(), pengguna2.getCreatedby(), pengguna2.getCreateddate(), "b", date);
        penggunaService.updatePengguna(Integer.parseInt(idPengguna), pengguna);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/User/index.html")).build();
    }

    @GetMapping("/deletePengguna")
    public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
        penggunaService.deletePengguna(id);
        return ResponseEntity.ok("Pengguna with ID: " + id + ". Deleted Successfully");
    }

    @GetMapping("/aktifkanPengguna")
    public ResponseEntity<String> aktifkanById(@RequestParam("id") Integer id) {
        penggunaService.AktifkanPengguna(id);
        return ResponseEntity.ok("Pengguna with ID: " + id + ". Activate Successfully");
    }

    @GetMapping("/nonaktifkanPengguna")
    public ResponseEntity<String> nonaktifkanById(@RequestParam("id") Integer id) {
        penggunaService.NonaktifkanPengguna(id);
        return ResponseEntity.ok("Pengguna with ID: " + id + ". Deactivate Successfully");
    }
}
