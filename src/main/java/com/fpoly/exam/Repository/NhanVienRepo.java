package com.fpoly.exam.Repository;

import com.fpoly.exam.Entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface NhanVienRepo extends JpaRepository<NhanVien,Integer> {
}
