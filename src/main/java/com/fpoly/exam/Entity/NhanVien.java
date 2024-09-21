package com.fpoly.exam.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "nhan_vien")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
    @Column
        private String ma;
    @Column
        private String ten;
    @Column
        private String ten_dem;
    @Column
        private String ho;
    @Column
         private String gioi_tinh;
    @Column
        private String dia_chi;
    @Column
        private String sdt;
    @Column
        private String mat_khau;
    @ManyToOne
    @JoinColumn(name = "id_cv")
    ChucVu chucVu;
       @Column
    private Integer trang_thai;


}
