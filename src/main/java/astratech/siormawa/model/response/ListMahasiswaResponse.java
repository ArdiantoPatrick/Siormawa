package astratech.siormawa.model.response;

import astratech.siormawa.model.MahasiswaAPI;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListMahasiswaResponse {
    @JsonProperty("data")
    private List<MahasiswaAPI> mMahasiswa;

    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private int status;

    public List<MahasiswaAPI> getmMahasiswa() {
        return mMahasiswa;
    }

    public void setmMahasiswa(List<MahasiswaAPI> mMahasiswa) {
        this.mMahasiswa = mMahasiswa;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ListMahasiswaResponse{" +
                "mMahasiswa=" + mMahasiswa +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}