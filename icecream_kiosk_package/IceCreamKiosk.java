package com.example.lib.oop_package.icecream_kiosk_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// 무인 아이스크림 할인점 키오스크 프로그램
public class IceCreamKiosk extends JFrame{

    // 패널 생성
    private JPanel namePanel = new NamePanel(); // 가게명 패널
    private JPanel tabPanel = new TabPanel(); // 탭 팬이 붙을 패널(탭 화면)
    private JPanel orderPanel = new OrderPanel(this); // 장바구니, 결제하기 버튼

    public IceCreamKiosk(){
        // frame title
        super("아이스크림 할인점 키오스크");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 배치관리자
        // 그리드백 객체
        GridBagLayout gridbag = new GridBagLayout();

        // 그리드백 제어 객체
        GridBagConstraints constraint = new GridBagConstraints();

        setLayout (gridbag);
//        setLayout(new BorderLayout(10,10));

        // Component가 격자보다 작을 때의 처리 지정
        // - BOTH :격자 크기에 맞춤
        constraint.fill = GridBagConstraints.BOTH;
        //Component가 크기를 비율로 지정
        // - 0 : Container 크기가 변해도 원래 크기 유지
        // - 0 이외의 값 : 같은 행에 있는 Component간의 비율 계산
        constraint.weightx = 1;
        constraint.weighty = 1;


        try{


            // frame에 panel 붙이기
            // namePanel
            constraint.gridwidth = 2; // 넓이 2칸 차지
            constraint.gridwidth = GridBagConstraints.REMAINDER; // 행 바꿈
            constraint.weighty = 0.2; // 높이 비율(0 ~ 1)
            gridbag.setConstraints(namePanel, constraint);
            add(namePanel);

            // tabPanel
            constraint.gridwidth = 1; // 넓이 1칸 차지
            constraint.weighty = 1; // 높이 비율

            constraint.weightx = 0.7; // 넓이 비율
            gridbag.setConstraints(tabPanel, constraint);
            add(tabPanel);

            // orderPanel
            constraint.weightx = 0.3; // 넓이 비율
            gridbag.setConstraints(orderPanel, constraint);
            add(orderPanel);



        }
        catch (Exception e){
            e.printStackTrace();
        }

        setSize (1200, 800);
        setVisible (true);

    } // public IceCreamKiosk() 끝 ================

} // public class IceCreamKiosk extends JFrame 끝 ================
