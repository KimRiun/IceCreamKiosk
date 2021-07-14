package com.example.lib.oop_package.icecream_kiosk_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

// 메뉴를 고르는 키오스크 탭 화면
public class TabPanel extends JPanel {
    // 탭 화면으로 구성되는 탭 팬
    private JTabbedPane tp;
    // 6개의 탭 메뉴들의 이름
    private static String[] tabTitle = {"바", "콘", "쮸쮸바", "샌드형", "컵", "얼음"};
    // 각각의 탭 화면을 구성하는 JPanel
    private JPanel[] menuPanel = new JPanel[tabTitle.length];
    // 메뉴 버튼 title
    public static String[][] menuTitle = new String[tabTitle.length][];
    // 메뉴 버튼 가격
    public static String[][] menuPrice = new String[tabTitle.length][];
    // 메뉴 버튼
    private JButton[][] menuButton = new JButton[tabTitle.length][];
    // 버튼 이미지 경로
    private String imgPath = "C:/Users/sue11/Images/icecream/";
//    private String imgPath = "./icecream/";
    // 이미지 파일명
    private String[][] imgName = new String[tabTitle.length][];



    public TabPanel(){
        // 배치관리자
        setLayout(new BorderLayout());
        // 폰트
        Font font = new Font("맑은 고딕", Font.PLAIN, 20);

        // 탭 팬 생성
        UIManager.put("TabbedPane.selected", new Color(0xEED0CE));
        tp = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        tp.setFont(font);

        // 메뉴판 패널 init
        GridBagLayout gridbag = new GridBagLayout(); // 배치관리자
        GridBagConstraints constraint = new GridBagConstraints();
//        constraint.fill = GridBagConstraints.BOTH;
        constraint.weightx = 1;
        constraint.weighty = 1;
        constraint.gridwidth = 1;
        constraint.gridheight = 1;

        for(int i=0; i < tabTitle.length; i++){
            menuPanel[i] = new JPanel(); // 패널 생성
            menuPanel[i].setLayout (gridbag);;
            menuPanel[i].setBackground(new Color(0xE9E9E2));
        }

        // 메뉴 버튼 타이틀
        menuTitle[0] = new String [] {"메로나", "쌍쌍바", "요맘때"};
        menuTitle[1] = new String [] {"부라보", "더블콘", "월드콘"};
        menuTitle[2] = new String [] {"뽕따", "빠삐코", "탱크보이"};
        menuTitle[3] = new String [] {"빵또아", "붕어싸만코","찰옥수수"};
        menuTitle[4] = new String [] {"하겐다즈", "와", "나뚜르"};
        menuTitle[5] = new String [] {"폴라포", "고드름", "아이스가이"};

        // 메뉴 버튼 가격
        menuPrice[0] = new String [] {"500", "500", "500"};
        menuPrice[1] = new String [] {"1000", "1000", "1000"};
        menuPrice[2] = new String [] {"1000", "1000", "1000"};
        menuPrice[3] = new String [] {"1500", "1500", "1500"};
        menuPrice[4] = new String [] {"3000", "1000", "2500"};
        menuPrice[5] = new String [] {"1000", "1500", "1500"};

        // 메뉴 이미지 파일명
        for(int i=0; i<tabTitle.length;i++){
            imgName[i] = new String [menuTitle[i].length];
            for(int j=0; j < menuTitle[i].length; j++) {
                // imgName[i][j] = "testImage.jpg";
                imgName[i][j] = Integer.toString(i) + Integer.toString(j) + ".jpg";
            }
        }


        // 메뉴버튼 생성
        for(int i=0; i < menuTitle.length; i++){
            menuButton[i] = new JButton[menuTitle[i].length];
            for(int j=0; j < menuTitle[i].length; j++){
                // 버튼 이름
                String str = "<html>" + menuTitle[i][j] + "<br>" + menuPrice[i][j] + "원</html>";
//                    menuButton[i][j] = new JButton(menuTitle[i][j]);
                menuButton[i][j] = new JButton(str);
                menuButton[i][j].setVerticalTextPosition(JButton.BOTTOM);  // 텍스트 아래로
                menuButton[i][j].setHorizontalTextPosition(JButton.CENTER); // 텍스트 가운데
                menuButton[i][j].setFont(font);
                // 버튼 이미지
                menuButton[i][j].setIcon(new ImageIcon(imgPath + imgName[i][j])); // 버튼 이미지
                menuButton[i][j].setPreferredSize(new Dimension(200, 200));
                // 버튼 배경색, 테두리
                menuButton[i][j].setBackground(new Color(0xFFFFFF));
                menuButton[i][j].setFocusPainted(false);
                menuButton[i][j].setBorderPainted(false);


                menuButton[i][j].addActionListener(new MenuBtnActionListener());
            }

        }



        // 각 메뉴판 패널에 메뉴 버튼 붙이기
        for(int i=0; i < menuPanel.length; i++){
            for(int j=0; j < menuButton[i].length; j++){
                gridbag.setConstraints(menuButton[i][j], constraint);
                menuPanel[i].add(menuButton[i][j]);

            }
        }



        // 탭 팬에 메뉴판 패널 붙이기
        for(int i=0; i < tabTitle.length; i++){
//            tp.addTab(tabTitle[i], menuPanel[i]);
            tp.addTab("<html><body><table width='94'>"+tabTitle[i]+"</table></body></html>", menuPanel[i]);
        }


        // 탭 패널에 탭 팬 붙이기
        add("Center", tp);
    } // public TabPanel() 끝 ================

    // 메뉴 버튼 리스너
    class MenuBtnActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            String b = btn.getText();

            // 버튼으로 눌려진 메뉴명
            b = b.split(">")[1];
            b = b.split("<")[0];

            // 장바구니에 담긴 서로 다른 메뉴의 개수
            int tableSize = OrderPanel.model.getRowCount();
            // 장바구니에 담긴 해당 메뉴의 수량
            int quantity = 0;
            // 해당 메뉴의 가격
            int price = 0;
            // 이미 장바구니에 담겨져 있는 검사
            boolean inBasket = false;

            // 해당 메뉴 가격
            for(int i=0; i < menuTitle.length; i++)
                for(int j=0; j < menuTitle[i].length; j++)
                    if(b.equals(menuTitle[i][j]))
                        price = Integer.parseInt(menuPrice[i][j]);


            // 장바구니에 이미 담겨있는지 검사
            for(int i=0; i < tableSize; i++){
                // 같은 값이 존재할 때
                if(b.equals(OrderPanel.model.getValueAt(i,0))) {
                    String[] curMenu = new String[2];
                    curMenu[0] = (String) OrderPanel.model.getValueAt(i,1); // 수량
                    curMenu[1] = (String) OrderPanel.model.getValueAt(i,2); // 가격

                    quantity = Integer.parseInt(curMenu[0]) + 1; // 수량 + 1
                    price = quantity * price ; // 수량 * 가격

                    // table 업데이트
                    OrderPanel.model.setValueAt(Integer.toString(quantity),i,1);
                    OrderPanel.model.setValueAt(Integer.toString(price),i,2);

                    inBasket = true;
                    break;
                }

            }
            // 새로운 상품이라면
            if(!inBasket){
                tableSize++; // 테이블 사이즈 + 1

                String[] newMenu = new String[3];
                newMenu[0] = b;
                newMenu[1] = "1";
                newMenu[2] = Integer.toString(price);


                // table 업데이트
                OrderPanel.model.addRow(newMenu);
            }

            // 합계 업데이트
            int sum = 0;
            for(int i=0; i < tableSize; i++)
                sum += Integer.parseInt((String) OrderPanel.model.getValueAt(i,2));

            OrderPanel.sumPrice.setText(Integer.toString(sum) + "원");

        }
    } // class BtnActionListener implements ActionListener 끝

}// class TabPanel extends JPanel 끝 ================