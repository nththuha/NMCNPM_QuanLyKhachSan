package QuanLy;

import DangNhapBanDau.DangNhapForm;
import Data.RoomModify;
import static Data.RoomModify.TimPhong;
import Data.DatThuePhongModify;
import PanelChiaSoDoPhong.PanelThongTinThuePhong;
import PanelChiaSoDoPhong.SoDoPhong;
import static QuanLy.FormXemPhieuDat_Va_ThuePhong.chuanHoa;
import static QuanLy.QuanLyPhong.nhanVienDangDangNhap;
import static QuanLy.QuanLyPhong.sodo;
import java.awt.Color;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;
import qlks.CTDL.CTPhieuDat;
import qlks.CTDL.CTThue;
import qlks.CTDL.KhachHang;
import qlks.CTDL.NhanVien;
import qlks.CTDL.PhieuDat;
import qlks.CTDL.PhieuThue;
import qlks.CTDL.Phong;
import qlks.CTDL.ThongTinThuePhong;

public class FormThuePhong extends javax.swing.JFrame {

    private static int table_Click_Row = -1;
    private static int MaPhongDangChon;
    private static KhachHang khachThuePhongNay;
    private static ArrayList<Phong> danhSachPhong;
    private static ArrayList<Phong> danhSachPhongDangChon;
    public static SoDoPhong sodo;
    public static NhanVien nvDangTruc;
    Color danger = new Color(0, 60, 100);
    Color success = new Color(0, 204, 173);
    LocalDate ld = LocalDate.now();

    // TRƯỜNG HỢP PHÒNG NÀY CHƯA ĐẶT
    public FormThuePhong() {//, NhanVien nhanvien) {
//        this.phong = phong;
//        this.nvDangTruc = nhanvien;
        initComponents();

        danhSachPhong = RoomModify.layDanhSachPhong();
        danhSachPhongDangChon = new ArrayList<Phong>();
        this.nvDangTruc = DangNhapForm.nhanVienDangDangNhap;
        this.setTitle("Lập Phiếu Thuê");
        jLabelMaNhanVien.setText(nvDangTruc.getMaNV());
        // TẠO SƠ ĐỒ
        sodo = new SoDoPhong(danhSachPhong);
        sodo.setSize(520, 320);
        sodo.setLocation(0, 0);
        panelSoDoPhong2.add(sodo);
        sodo.setVisible(true);
        // set button them phong 
        btn_ThemPhong.setEnabled(false);
        btn_LapPhieuThue.setEnabled(false);
        btn_remove.setEnabled(false);
        BatTXT(false);
        jTextField_NgayDen.setEditable(false);
        jTextField_NgayDen.setText(ld.getDayOfMonth() + " / " + ld.getMonth().getValue() + " / " + ld.getYear());
        jLabel_HangPhong.setText(" ");
    }

    private void BatTXT(boolean t) {
        txt_HoTenKH.setEditable(t);
        txt_DiaChiKhachHang.setEditable(t);
        txt_MaSoThueKH.setEditable(t);
        txt_SDT_KH.setEditable(t);

    }

    private void loadDSPhongRaTable() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã lPhòng");
        model.addColumn("Hạng Phòng");
        Vector vec;
        for (Phong phong : danhSachPhongDangChon) {
            vec = new Vector();
            vec.add(phong.getMaPhong());
            vec.add(phong.getHangPhong());
            model.addRow(vec);

        }

        jTable_DsPhongDaChon.setModel(model);
    }

    // TRƯỜNG HỢP PHÒNG NÀY ĐÃ ĐƯỢC ĐẶT
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNenFrame = new javax.swing.JPanel();
        jPanelThongTinPhong2 = new javax.swing.JPanel();
        btn_LapPhieuThue = new javax.swing.JButton();
        jPanelThongTinKhachHang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_MaKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_HoTenKH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_SDT_KH = new javax.swing.JTextField();
        txt_MaSoThueKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel_ThongBao = new javax.swing.JPanel();
        jLabelThongBao = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelMaNhanVien = new javax.swing.JLabel();
        jButton_Check = new javax.swing.JButton();
        txt_DiaChiKhachHang = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DsPhongDaChon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jCalendar_NgayDi = new com.toedter.calendar.JDateChooser();
        jTextField_NgayDen = new javax.swing.JTextField();
        btn_remove = new javax.swing.JButton();
        jLabel_HangPhong = new javax.swing.JLabel();
        jPanelBenDuoiSoDo = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        panelSoDoPhong2 = new javax.swing.JPanel();
        btn_ThemPhong = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setTitle("Lập Phiếu Đặt Phòng");
        setBackground(new java.awt.Color(153, 153, 255));
        setResizable(false);

        jPanelNenFrame.setBackground(new java.awt.Color(102, 153, 255));
        jPanelNenFrame.setMinimumSize(new java.awt.Dimension(600, 600));
        jPanelNenFrame.setPreferredSize(new java.awt.Dimension(960, 620));

        jPanelThongTinPhong2.setBackground(new java.awt.Color(153, 204, 255));
        jPanelThongTinPhong2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Hành động", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 51))); // NOI18N
        jPanelThongTinPhong2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanelThongTinPhong2.setPreferredSize(new java.awt.Dimension(560, 580));

        btn_LapPhieuThue.setBackground(new java.awt.Color(102, 102, 255));
        btn_LapPhieuThue.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_LapPhieuThue.setForeground(new java.awt.Color(0, 0, 51));
        btn_LapPhieuThue.setText("Lập Phiếu Thuê");
        btn_LapPhieuThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LapPhieuThueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelThongTinPhong2Layout = new javax.swing.GroupLayout(jPanelThongTinPhong2);
        jPanelThongTinPhong2.setLayout(jPanelThongTinPhong2Layout);
        jPanelThongTinPhong2Layout.setHorizontalGroup(
            jPanelThongTinPhong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelThongTinPhong2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_LapPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelThongTinPhong2Layout.setVerticalGroup(
            jPanelThongTinPhong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelThongTinPhong2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_LapPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanelThongTinKhachHang.setBackground(new java.awt.Color(153, 204, 255));
        jPanelThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 51))); // NOI18N
        jPanelThongTinKhachHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanelThongTinKhachHang.setPreferredSize(new java.awt.Dimension(477, 320));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mã KH(CMND):");

        txt_MaKH.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_MaKHInputMethodTextChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Họ&tên:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("SĐT:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Địa Chỉ:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Mã số thuế:");

        jPanel_ThongBao.setBackground(new java.awt.Color(0, 204, 173));

        jLabelThongBao.setForeground(new java.awt.Color(0, 0, 102));
        jLabelThongBao.setText("Thông báo:");

        javax.swing.GroupLayout jPanel_ThongBaoLayout = new javax.swing.GroupLayout(jPanel_ThongBao);
        jPanel_ThongBao.setLayout(jPanel_ThongBaoLayout);
        jPanel_ThongBaoLayout.setHorizontalGroup(
            jPanel_ThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ThongBaoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabelThongBao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_ThongBaoLayout.setVerticalGroup(
            jPanel_ThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Mã Nhân Viên: ");

        jLabelMaNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelMaNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelMaNhanVien.setText("01");

        jButton_Check.setBackground(new java.awt.Color(0, 102, 255));
        jButton_Check.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_Check.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Check.setText("Check");
        jButton_Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CheckActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Thời gian:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("->");

        jTable_DsPhongDaChon.setBackground(new java.awt.Color(85, 163, 255));
        jTable_DsPhongDaChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_DsPhongDaChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DsPhongDaChonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_DsPhongDaChon);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Danh sách phòng:");

        btn_remove.setBackground(new java.awt.Color(255, 204, 102));
        btn_remove.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_remove.setForeground(new java.awt.Color(0, 0, 102));
        btn_remove.setText("Remove");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        jLabel_HangPhong.setText("     ");

        javax.swing.GroupLayout jPanelThongTinKhachHangLayout = new javax.swing.GroupLayout(jPanelThongTinKhachHang);
        jPanelThongTinKhachHang.setLayout(jPanelThongTinKhachHangLayout);
        jPanelThongTinKhachHangLayout.setHorizontalGroup(
            jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_ThongBao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelThongTinKhachHangLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelThongTinKhachHangLayout.createSequentialGroup()
                        .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelThongTinKhachHangLayout.createSequentialGroup()
                                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33))
                            .addGroup(jPanelThongTinKhachHangLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelThongTinKhachHangLayout.createSequentialGroup()
                                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelThongTinKhachHangLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txt_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Check))
                            .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelThongTinKhachHangLayout.createSequentialGroup()
                                    .addComponent(jLabel_HangPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(33, 33, 33)
                                    .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_HoTenKH, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_MaSoThueKH, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_SDT_KH, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_DiaChiKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelThongTinKhachHangLayout.createSequentialGroup()
                                        .addComponent(jTextField_NgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jCalendar_NgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelThongTinKhachHangLayout.setVerticalGroup(
            jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThongTinKhachHangLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Check)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_HoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MaSoThueKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_SDT_KH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_DiaChiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_NgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jCalendar_NgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_remove)
                    .addGroup(jPanelThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_HangPhong)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel_ThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanelBenDuoiSoDo.setBackground(new java.awt.Color(153, 204, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(51, 255, 153));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        panelSoDoPhong2.setBackground(new java.awt.Color(0, 0, 102));
        panelSoDoPhong2.setPreferredSize(new java.awt.Dimension(522, 320));
        panelSoDoPhong2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelSoDoPhongMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSoDoPhong2Layout = new javax.swing.GroupLayout(panelSoDoPhong2);
        panelSoDoPhong2.setLayout(panelSoDoPhong2Layout);
        panelSoDoPhong2Layout.setHorizontalGroup(
            panelSoDoPhong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        panelSoDoPhong2Layout.setVerticalGroup(
            panelSoDoPhong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        btn_ThemPhong.setBackground(new java.awt.Color(255, 204, 102));
        btn_ThemPhong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ThemPhong.setForeground(new java.awt.Color(0, 0, 102));
        btn_ThemPhong.setText("Thêm Vào Danh Sách");
        btn_ThemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemPhongActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 144, 109));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 131, 198));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jLabel13.setText("Phòng trống");

        jLabel8.setText("Phòng chưa dọn");

        jLabel9.setText("Phòng đang được thuê");

        jLabel14.setText("Phòng chưa sửa chữa");

        jLabel22.setText("Phòng đã đặt");

        javax.swing.GroupLayout jPanelBenDuoiSoDoLayout = new javax.swing.GroupLayout(jPanelBenDuoiSoDo);
        jPanelBenDuoiSoDo.setLayout(jPanelBenDuoiSoDoLayout);
        jPanelBenDuoiSoDoLayout.setHorizontalGroup(
            jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBenDuoiSoDoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBenDuoiSoDoLayout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addGroup(jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelSoDoPhong2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThemPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanelBenDuoiSoDoLayout.createSequentialGroup()
                        .addGroup(jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(35, 35, 35)
                        .addGroup(jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBenDuoiSoDoLayout.createSequentialGroup()
                                .addGroup(jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelBenDuoiSoDoLayout.createSequentialGroup()
                                .addGroup(jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelBenDuoiSoDoLayout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanelBenDuoiSoDoLayout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(60, 60, 60))))))))
        );
        jPanelBenDuoiSoDoLayout.setVerticalGroup(
            jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBenDuoiSoDoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(panelSoDoPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btn_ThemPhong)
                .addGap(14, 14, 14)
                .addGroup(jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBenDuoiSoDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNenFrameLayout = new javax.swing.GroupLayout(jPanelNenFrame);
        jPanelNenFrame.setLayout(jPanelNenFrameLayout);
        jPanelNenFrameLayout.setHorizontalGroup(
            jPanelNenFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNenFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelNenFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBenDuoiSoDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelThongTinPhong2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelNenFrameLayout.setVerticalGroup(
            jPanelNenFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNenFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNenFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNenFrameLayout.createSequentialGroup()
                        .addComponent(jPanelBenDuoiSoDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelThongTinPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNenFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNenFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static String chuanHoa(String st, KhachHang khach) {
        st = st.trim();
        st = st.replaceAll("\\s+", " ");
        String[] temp = st.split(" ");
        st = "";
        String ho = "", ten = "";
        if (temp.length > 1) {

            for (int i = 0; i < temp.length; i++) {
                st += temp[i].substring(0, 1).toUpperCase() + temp[i].substring(1).toLowerCase();

                if (i < temp.length - 1) {
                    ho = st;
                    st += " ";
                } else if (i == temp.length - 1) {
                    ten += temp[i].substring(0, 1).toUpperCase() + temp[i].substring(1).toLowerCase();
                }
            }

        } else {
            for (int i = 0; i < temp.length; i++) {
                st = temp[0].substring(0, 1).toUpperCase() + temp[i].substring(1).toLowerCase();
            }
        }
        khach.setHo(ho);
        khach.setTen(ten);
        System.out.println("HO+ ten:" + ho + "  -  " + ten);
        return st;
    }

    private java.sql.Date doiDate(java.util.Date d) {
        String s = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            s = df.format(d);
        } catch (Exception e) {
            System.out.println("Không chuyển ngày sinh được!");
        }
        java.sql.Date date = java.sql.Date.valueOf(s);
        System.out.println(date);
        return date;
    }

    private void btn_LapPhieuThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LapPhieuThueActionPerformed
        String sDT = txt_SDT_KH.getText();
        String cmnd = txt_MaKH.getText();
        String hoten = txt_HoTenKH.getText();
        String masothue = txt_MaSoThueKH.getText();
        String diachi = txt_DiaChiKhachHang.getText();

        String mau = "[0-9]{9,12}";
        if (cmnd.matches(mau) == false) {

            txt_MaKH.requestFocus();
            return;
        }
        
        mau = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{1,20}";
        if (hoten.equals("") || hoten.matches(mau) == false) {

            jLabelThongBao.setText("Họ tên khách hàng không hợp lệ !");
            txt_HoTenKH.requestFocus();
            return;
        }

        if (masothue.equals("") != true) {
            String mauMST = "[0-9]{10}";
            String mau2 = "[0-9]{13}";
            if (masothue.matches(mauMST) != true && masothue.matches(mau2) != true) {
                jLabelThongBao.setText("Mã số thuế chứa 10 hoặc 13 chữ số!");
                return;
            }
        }
        
        mau = "[0-9]{10}";
        if (sDT.matches(mau) == false) {

            jLabelThongBao.setText("SDT không hợp lệ!");
            txt_SDT_KH.requestFocus();
            return;
        }
        
        if (diachi.equals("") != true) {
            mau = "[[0-9]+^\\p{L}+[\\p{L}\\p{Z}+[0-9/,.]]]{1,30}";
            if (diachi.matches(mau) == false) {
                jLabelThongBao.setText("Địa chỉ không hợp lệ");
                return;
            }
        }

        Date dateDen = null;
        java.util.Date Di = jCalendar_NgayDi.getDate();
        java.sql.Date dateDi = doiDate(Di);
        java.util.Date date = new java.util.Date();
        if (date.compareTo(Di) >= 0) {
            jLabelThongBao.setText("Ngày đến và đi không hợp lệ");
            return;
        }

        PhieuThue phieu = new PhieuThue();
        KhachHang kh = new KhachHang();
        hoten = chuanHoa(hoten, kh);
        //============== tìm xem mã Khách hàng đã có chưa =================

        khachThuePhongNay = DatThuePhongModify.TimKhach(cmnd);
        if (khachThuePhongNay == null) {
            khachThuePhongNay = new KhachHang(cmnd, kh.getHo(), kh.getTen(), diachi, sDT, masothue);
            DatThuePhongModify.ThemKhachVaoDB(khachThuePhongNay);
        } else {
            txt_MaKH.setText(khachThuePhongNay.getCMND());
            txt_HoTenKH.setText(khachThuePhongNay.getHo() + " " + khachThuePhongNay.getTen());
            txt_DiaChiKhachHang.setText(khachThuePhongNay.getDiaChi());
            txt_MaSoThueKH.setText(khachThuePhongNay.getMaSoThue());
            txt_SDT_KH.setText(khachThuePhongNay.getSDT());
        }

        phieu.setMaKH(khachThuePhongNay.getCMND());
        phieu.setMaNV(nvDangTruc.getMaNV());
        phieu.setMaPD(-1);
        //=======================================Tạo phiếu thuê================================================
        if (DatThuePhongModify.ThemPhieuThueVaoDB(phieu) == false) {
            jLabelThongBao.setText("Tạo Phiếu Thuê thất bại! vui lòng kiểm tra lại thông tin");
            return;
        }

        // ============================TẠo Phieu thue thành công -> tạo Chi tiết Thuê  ==========================================
        for (Phong phong : danhSachPhongDangChon) {
            CTThue ctthue = new CTThue(phieu.getMaPT(), phong.getMaPhong(), dateDen, dateDi);
            if (DatThuePhongModify.ThemCTThueVaoDB(ctthue) == true) {
                jLabelThongBao.setText("");
                // cập nhật cái phong này trên sql, trên sơ đồ phòng ở frame Quản lý phòng và trên Panel Thông tin Thuê phòng được tạo ở Frame Quản lý phòng
                phong.setTrangThai("Thuê");
                // cập nhật trên sơ đồ
                sodo.thaydoiTrangThaiPhong(phong);
                // cập nhật trong sql
                RoomModify.UpdatePhong(phong);
                // cập nhật thông tin khách hàng trên pannel Thông tin thuê phòng
            } else {
                JOptionPane.showMessageDialog(null, "Lập phiếu thuê Thất Bại!", "Thông Báo", WARNING_MESSAGE);
//                continue;
            }
        }
        JOptionPane.showMessageDialog(null, "Lập phiếu thuê thành công!", "Thông Báo", PLAIN_MESSAGE);
    }//GEN-LAST:event_btn_LapPhieuThueActionPerformed

    private void jButton_CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CheckActionPerformed
        // TODO add your handling code here:
        String mau = "[0-9]{9,12}";
        String cmnd = txt_MaKH.getText().toString().trim();
        if (cmnd.matches(mau) == false) {
            txt_MaKH.requestFocus();
            return;
        }
        System.out.println("CMND: " + cmnd);
        khachThuePhongNay = DatThuePhongModify.TimKhach(cmnd);
        if (khachThuePhongNay == null) {

            jLabelThongBao.setText("Khách mới - Không tìm thấy thông tin khách trong Cơ sở dữ liệu!");
            BatTXT(true);
        } else {

            jLabelThongBao.setText("Khách cũ - Thông tin khách đã được lưu trong DB!");
            txt_MaKH.setText(khachThuePhongNay.getCMND());
            txt_HoTenKH.setText(khachThuePhongNay.getHo() + " " + khachThuePhongNay.getTen());
            txt_DiaChiKhachHang.setText(khachThuePhongNay.getDiaChi());
            txt_MaSoThueKH.setText(khachThuePhongNay.getMaSoThue());
            txt_SDT_KH.setText(khachThuePhongNay.getSDT());
            BatTXT(false);
        }
    }//GEN-LAST:event_jButton_CheckActionPerformed

    private void txt_MaKHInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_MaKHInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_MaKHInputMethodTextChanged

    private void btn_ThemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemPhongActionPerformed
        // TODO add your handling code here:

        Phong phongDangChon = null;

        for (Phong p : danhSachPhongDangChon) {
            if (p.getMaPhong() == MaPhongDangChon) {
                return;
            }
        }
        if (MaPhongDangChon > 0) {
            phongDangChon = TimPhong(MaPhongDangChon, danhSachPhong);
        }
        if (phongDangChon != null) {
            danhSachPhongDangChon.add(phongDangChon);
        }
        if (!danhSachPhongDangChon.isEmpty()) {
            btn_LapPhieuThue.setEnabled(true);
        }
        loadDSPhongRaTable();
    }//GEN-LAST:event_btn_ThemPhongActionPerformed

    private String layHangPhong(int maPhong) {
        Connection ketNoi = qlks.QLKS.layKetNoi();
        String temp = "";
        try {
            PreparedStatement ps = ketNoi.prepareStatement("SELECT HANGPHONG FROM PHONG WHERE MAPHONG = '" + maPhong + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                temp = rs.getString(1);
            }
            rs.close();
            ps.close();
            ketNoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(FormDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    private void jPanelSoDoPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSoDoPhongMouseClicked
        // TODO add your handling code here:
        MaPhongDangChon = sodo.getRoomIdFromPosition(evt.getPoint());
        jLabel_HangPhong.setText(layHangPhong(MaPhongDangChon));
        System.out.println("Ma Phong click: " + MaPhongDangChon);
        Phong phong = TimPhong(MaPhongDangChon, danhSachPhong);
        if (MaPhongDangChon == -1 || phong == null || (!phong.getTrangThai().equals("Trống"))) {
            btn_ThemPhong.setEnabled(false);
            return;
        }

        System.out.println(MaPhongDangChon);
        btn_ThemPhong.setEnabled(true);
    }//GEN-LAST:event_jPanelSoDoPhongMouseClicked

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        // TODO add your handling code here:
        danhSachPhongDangChon.remove(table_Click_Row);
        if (danhSachPhongDangChon.isEmpty()) {
            btn_LapPhieuThue.setEnabled(false);
        }
        loadDSPhongRaTable();
    }//GEN-LAST:event_btn_removeActionPerformed

    private void jTable_DsPhongDaChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DsPhongDaChonMouseClicked
        // TODO add your handling code here:
        table_Click_Row = jTable_DsPhongDaChon.getSelectedRow();
        if (table_Click_Row < danhSachPhongDangChon.size() && table_Click_Row >= 0) {
            btn_remove.setEnabled(true);
        } else {
            btn_remove.setEnabled(false);
        }


    }//GEN-LAST:event_jTable_DsPhongDaChonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormThuePhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LapPhieuThue;
    private javax.swing.JButton btn_ThemPhong;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton jButton_Check;
    private com.toedter.calendar.JDateChooser jCalendar_NgayDi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMaNhanVien;
    private javax.swing.JLabel jLabelThongBao;
    private javax.swing.JLabel jLabel_HangPhong;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelBenDuoiSoDo;
    private javax.swing.JPanel jPanelNenFrame;
    private javax.swing.JPanel jPanelThongTinKhachHang;
    private javax.swing.JPanel jPanelThongTinPhong2;
    private javax.swing.JPanel jPanel_ThongBao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_DsPhongDaChon;
    private javax.swing.JTextField jTextField_NgayDen;
    private javax.swing.JPanel panelSoDoPhong2;
    private javax.swing.JTextField txt_DiaChiKhachHang;
    private javax.swing.JTextField txt_HoTenKH;
    private javax.swing.JTextField txt_MaKH;
    private javax.swing.JTextField txt_MaSoThueKH;
    private javax.swing.JTextField txt_SDT_KH;
    // End of variables declaration//GEN-END:variables
}
