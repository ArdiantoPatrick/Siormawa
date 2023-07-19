package astratech.siormawa.controller;

import astratech.siormawa.model.MahasiswaAPI;
import astratech.siormawa.model.response.ListMahasiswaResponse;
import astratech.siormawa.model.response.LoginMahasiswaResponse;
import astratech.siormawa.service.MahasiswaAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MahasiswaAPIController {
    @Autowired
    MahasiswaAPIService mahasiswaAPIService;

    @PostMapping("/login")
    public String save(HttpServletResponse response) {
        return "Berhasill";
    }

    @GetMapping("/getMahasiswaByKelas")
    public ResponseEntity<ListMahasiswaResponse> getMahasiswaByKelas(@RequestParam("kelas") String kelas){
        List<MahasiswaAPI> mahasiswaList = mahasiswaAPIService.getListMahasiswaBykelas(kelas);
        ListMahasiswaResponse listMahasiswaResponse = new ListMahasiswaResponse();
        try{
            listMahasiswaResponse.setmMahasiswa(mahasiswaList);
            listMahasiswaResponse.setMessage("Ambil Data Berhasil");
            listMahasiswaResponse.setStatus(200);
        }catch (Exception e){
            listMahasiswaResponse.setmMahasiswa(null);
            listMahasiswaResponse.setMessage("Data Kosong");
            listMahasiswaResponse.setStatus(404);
        }
        return ResponseEntity.ok(listMahasiswaResponse);
    }

    @GetMapping("/getMahasiswa")
    public MahasiswaAPI[] getMahasiswa(@RequestParam("nim") String nim){
        return mahasiswaAPIService.getMahasiswaByNim(nim);
    }

    @PostMapping("/LoginMahasiswa")
    public ResponseEntity<LoginMahasiswaResponse> doLogin(@RequestParam("nim") String nim){
        MahasiswaAPI[] mahasiswa = mahasiswaAPIService.getMahasiswaByNim(nim);
        LoginMahasiswaResponse loginMahasiswaResponse = new LoginMahasiswaResponse();
        try {
            loginMahasiswaResponse.setmMahasiswa(mahasiswa[0]);
            loginMahasiswaResponse.setMessage("Login Berhasil");
            loginMahasiswaResponse.setStatus(200);
        }catch (Exception e){
            loginMahasiswaResponse.setmMahasiswa(null);
            loginMahasiswaResponse.setMessage("Akun tidak ditemukan");
            loginMahasiswaResponse.setStatus(404);
        }
        return ResponseEntity.ok(loginMahasiswaResponse);
    }


}