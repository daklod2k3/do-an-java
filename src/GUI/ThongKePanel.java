package GUI;

import BUS.*;
import DTO.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import GUI.Component.Variable;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ThongKePanel extends JPanel {
    private JLabel lbSP;
    private JLabel lbKH;
    private JLabel lbNV;
    private JLabel lbSPtrenNhap;
    private JComboBox<String> cbNam;
    private product_BUS prdBus;
    private NhanVienBUS nvBus;
    private KhachHangBUS khBus;
    private phieuNhap_BUS phieuNhapBus;
    private chitietPN_BUS chitietPNBus;
    private ChitiethdBUS chitiethdBUS;
    private HoaDonBUS hoaDonBUS;
    private List<Integer> dataChart = new ArrayList<>();
    DefaultCategoryDataset dataset;
    ChartPanel chartPanel;
    public ThongKePanel(){

        prdBus = new product_BUS();
        nvBus = new NhanVienBUS();
        khBus = new KhachHangBUS();
        phieuNhapBus = new phieuNhap_BUS();
        chitietPNBus = new chitietPN_BUS();
        chitiethdBUS = new ChitiethdBUS();
        hoaDonBUS = new HoaDonBUS();

        dataChart.add(0);
        dataChart.add(0);
        dataChart.add(0);
        dataChart.add(0);

        lbSP = new JLabel("Sản phẩm: ");
        lbKH = new JLabel("Khách hàng: ");
        lbNV = new JLabel("Nhân viên: ");
        lbSPtrenNhap = new JLabel("Sản phẩm đã bán/nhập: ");

        lbSP.setBackground(Color.WHITE);
        lbSP.setOpaque(true);
//        lbSP.setPreferredSize(new Dimension(300, 200));
        lbSP.setForeground(new Color(243, 93, 86));
        lbSP.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 20));


        lbKH.setBackground(Color.WHITE);
        lbKH.setOpaque(true);
//        lbKH.setPreferredSize(new Dimension(300, 200));
        lbKH.setForeground(new Color(247, 198, 65));
        lbKH.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 20));

        lbNV.setBackground(Color.WHITE);
        lbNV.setOpaque(true);
        lbNV.setForeground(new Color(168, 210, 2));
        lbNV.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 20));

        lbSPtrenNhap.setBackground(Color.WHITE);
        lbSPtrenNhap.setOpaque(true);
        lbSPtrenNhap.setForeground(new Color(76, 194, 234));
        lbSPtrenNhap.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 20));

        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.insets = new Insets(20,20,20,20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(lbSP, gbc);

        gbc.gridx++;
        add(lbKH, gbc);

        gbc.gridx--;
        gbc.gridy++;
        add(lbNV, gbc);

        gbc.gridx++;
        add(lbSPtrenNhap, gbc);

        dataset = new DefaultCategoryDataset();
        dataset.addValue(200, "Quý 1", "Quý 1");
        dataset.addValue(300, "Quý 2", "Quý 2");
        dataset.addValue(400, "Quý 3", "Quý 3");
        dataset.addValue(500, "Quý 4", "Quý 4");

        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Số lượng sản phẩm bán", // Chart title
                "Quý", // Domain axis label
                "Số lượng", // Range axis label
                dataset // Dataset
        );

        // Display the chart in a frame
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 400));

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.ipadx = 200;
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.weightx = 0.5;
//        gbc.weighty = 2.5;
        gbc.gridwidth = 2;
        add(chartPanel, gbc);
//        gbc.gridy ++;
//        gbc.gridx = 0;
//        gbc.gridheight = 1;
//        gbc.gridwidth = 2;
//        add(pnlThongTinSP, gbc);

        cbNam = new JComboBox<>(new String[]{
                "2021",
                "2022"
        });
        cbNam.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateData();
            }
        });
//        cbNam.setPreferredSize(new Dimension(100,35));

        gbc.gridy++;
//        gbc.weightx = 0;
//        gbc.weighty = 0;
//        gbc.fill = GridBagConstraints.NONE;
        add(cbNam, gbc);

        JButton btRs = new JButton("Cập nhật lại");

        gbc.gridy++;
        add(btRs, gbc);

        btRs.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateData();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        updateData();

    }

    int getSoLuongSP(){
        return prdBus.getAllProducts().size();

    }

    int getSoLuongNv(){
        nvBus.loadNV();
        return nvBus.dsnv.size();
    }

    int getSoLuongKH(){
        return khBus.getALL().size();
    }

    int getSoLuongNhap(){
        int tong = 0;
        for (chitietPN_DTO item : chitietPNBus.getAllChiTietPN()){
            tong += item.getSoLuong();
        }
        return tong;
    }

    int getSoLuongBan(){
        int tong = 0;
        chitiethdBUS.updateList();
        for (ChiTietHD item : chitiethdBUS.getList()){
            tong += item.getSoLuong();
            Calendar calendar = Calendar.getInstance();

            calendar.setTime(hoaDonBUS.getHoaDonFromId(item.getMAHD()).getNgayLap());
            int thang = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);
            if (year == Integer.parseInt((String) cbNam.getSelectedItem()) + 2)
                dataChart.set(thang / 4 - 1, dataChart.get(thang/4) +  item.getSoLuong());
        }
        return tong;
    }

    List<String> getAllDate(){
        List<String> rs = new ArrayList<>();
        hoaDonBUS.updateList();
        for (HoaDon item : hoaDonBUS.getList()){
            // Using java.util.Calendar
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(item.getNgayLap());
            int year = calendar.get(Calendar.YEAR);

            if (!rs.contains(String.valueOf(year))){
                rs.add(String.valueOf(year));
            }
        }
        return rs;
    }

    void updateData(){
        dataChart.set(0, 0);
        dataChart.set(1, 0);
        dataChart.set(2, 0);
        dataChart.set(3, 0);
        lbSP.setText("Nhân viên: " + getSoLuongNv());
        lbKH.setText("Khách hàng: " + getSoLuongKH());
        lbSP.setText("Tồn kho: " + getSoLuongSP());
        lbSPtrenNhap.setText("Số lượng hàng bán / số lượng nhập: " + getSoLuongBan() + "/" + getSoLuongNhap());
        cbNam.setModel(new DefaultComboBoxModel(getAllDate().toArray()));

        dataset.addValue(dataChart.get(0), "Quý 1", "Quý 1");
        dataset.addValue(dataChart.get(1), "Quý 2", "Quý 2");
        dataset.addValue(dataChart.get(2), "Quý 3", "Quý 3");
        dataset.addValue(dataChart.get(3), "Quý 4", "Quý 4");

        chartPanel.repaint();
    }



}
