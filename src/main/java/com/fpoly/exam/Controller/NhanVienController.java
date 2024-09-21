package com.fpoly.exam.Controller;

import com.fpoly.exam.Entity.NhanVien;
import com.fpoly.exam.Repository.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NhanVienController {
    @Autowired
    NhanVienRepo nvrp;
    @GetMapping("/nhan-vien/hienthi")
    public List<NhanVien> getAll(){
        return nvrp.findAll();
    }
    @GetMapping("/nhan-vien/hienthipage")
    public List<NhanVien> getAll(@RequestParam(defaultValue = "0", value = "page")Integer page){
        Pageable pageable = PageRequest.of(page,5);
        Page<NhanVien> pagenv = nvrp.findAll(pageable);
        return pagenv.getContent();
    }
    @GetMapping("/nhan-vien/add")
    public void add(@RequestBody NhanVien nv){
        nvrp.save(nv);
    }

    @PostMapping("/nhan-vien/update/{idnv}")
    public void update(@PathVariable Integer idnv,@RequestBody NhanVien nv){
        nv.setId(idnv);
        nvrp.save(nv);
    }
    @GetMapping("/nhan-vien/detail/{idnv}")
    public NhanVien detail(@PathVariable Integer idnv){
        return nvrp.getReferenceById(idnv);
    }

    @DeleteMapping("/nhan-vien/delete/{idnv}")
    public void delete(@PathVariable Integer idnv){ nvrp.delete(nvrp.getReferenceById(idnv)); }
}
