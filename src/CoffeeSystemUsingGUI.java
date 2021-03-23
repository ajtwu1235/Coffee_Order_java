import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class CoffeeSystemUsingGUI {
	
	// JPanel속성을 상속받은 이미지 패널 설정, 이미지를 그리는 도구 
	@SuppressWarnings("serial")
	static class ImagePanel extends JPanel{
		// 1번방식: img를 먼저 선언하고 아래에 경로 써주기
		private Image img;		
		// 2번방식: img를 선언하고 경로도 한번에 같이 써주기
		private Image manual_img = new ImageIcon("C:\\\\workpace\\\\THcoffeeSystem\\\\images\\\\사용설명서.jpg").getImage();
		
		public ImagePanel (Image img) {
			this.img = img; 
			
		}
		
		//그리기 도구 배경화면, 사용서 이미지 그리기
		public void paintComponent (Graphics g) {
			g.drawImage(img, 0,0,1900,1200,null);
			g.drawImage(manual_img,1050,300,800,600,null);
		}
	}



	
	
	public static void main(String[] args) {
		JFrame fr = new JFrame("Taehoung 커피시스템");
		// 이미지 패널 그리기
        ImagePanel pn =new ImagePanel(new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\배경화면.jpg").getImage());
        fr.pack();
        fr.add(pn);
        JPanel Hotpn = new JPanel();
        JPanel Icepn = new JPanel();
        JPanel Adepn = new JPanel();
        JPanel Dstpn = new JPanel(); // 디저트 메뉴를 띄우는 패널
        JPanel Orderpn = new JPanel();
        
        //주문내역
        JTextArea ordertxt = new JTextArea(); 
       

        //주문내역을 확인할수있는 텍스트 필드를 붙이고, 내용추가
        pn.add(ordertxt);     
        ordertxt.append("<주문하신 물품을 확인할수 있습니다.> \n\n");
        ordertxt.setBounds(250, 900, 1000, 300); // 주문한내역을 볼수있는 txtarea를 생성       
        ordertxt.setEditable(false);
        ordertxt.setFont(new Font("맑은 고딕",Font.BOLD,20));
        
        
        JTextArea listtxt = new JTextArea();
        listtxt.setBounds(0,0, 1600, 600);
        listtxt.setFont(new Font("맑은 고딕",Font.BOLD,12));
        
        JButton[] bt = new JButton[6];
        JButton order_bt = new JButton("주문담기");
        
        // 메뉴판 테이블 만들기
        String [] heading = new String[] {"상품명","가격"};
        Object[][] data = new Object [][] {
        	{"상품명","가격"},
        	{"(Hot)아메리카노","1500원"},
        	{"(Hot)카푸치노","2000원"},
        	{"(Ice)아메리카노","2000원"},
        	{"(Ice)카페라떼","2500원"},
        	{"레몬에이드","3000원"},
        	{"자몽에이드","3000원"},
        	{"초코케이크(1조각)","3000원"},
        	{"딸기케이크(1조각)","3500원"}
        	
        };     
        
        JTable table = new JTable(data,heading);
        pn.add(new JScrollPane(table));
        pn.add(table);
        table.setBounds(250, 300, 800, 600);
        table.setFont(new Font("맑은 고딕",Font.BOLD,30));
        table.setRowHeight(50);
        
       
        //버튼들 위치와 크기 설정
        int width[]= {300,300,300,300,200,200};
        int height[]= {150,150,150,150,100,100};
        int x[] = {80,480,880,1280,30,30};
        int y[] = {100,100,100,100,300,500};
        
        //이미지 패널 크기설정
        pn.setLayout(null);
        pn.setBounds(0,0,1900,1200);
        // 팔 메뉴들 Vector 객체속에 미리 저장해놓기
        CoffeeSystem.setupMenu(); 
       
        //메인 버튼 6개 설정
        bt[0] = new JButton("HOT"); 
        bt[1] = new JButton("ICE"); 
        bt[2] = new JButton("ADE");
        bt[3] = new JButton("Dessert");
        bt[4] = new JButton("Main");
        bt[5] = new JButton("Order");
        
        
        
        for (int i = 0; i < bt.length; i++) {
            pn.add(bt[i]);
            bt[i].setBounds(x[i], y[i], width[i], height[i]);
            // 폰트 설정
            bt[i].setFont(new Font("Blackadder ITC", Font.BOLD, 60));
            //버튼을 투명하게 만들고, 버튼글씨 색상 설정
            bt[i].setContentAreaFilled(false);
            bt[i].setBorderPainted(false);
            bt[i].setFocusPainted(false);
            bt[i].setForeground(Color.WHITE);
        }
        
        //버튼 0번의 기능설정
        bt[0].addActionListener(new ActionListener () {
        	 
            @Override
            public void actionPerformed(ActionEvent e) {
            	JButton srcBtn =(JButton)e.getSource();
                if(srcBtn==bt[0]) {
                	doHot();
                	
                	//hotpn 의 크기 및 색상
                	Hotpn.setLayout(null);
    				Hotpn.setBounds(250, 300, 1600, 600);
    				Hotpn.setBackground(Color.gray);
                	
    				//hotpn 누를시, 나머지 패널을 보이지 않게하기
                	Hotpn.setVisible(true);
                	Icepn.setVisible(false);   	
                	Adepn.setVisible(false);
                	Dstpn.setVisible(false);
                	Orderpn.setVisible(false);
                	ordertxt.setVisible(true);
                
                	table.setVisible(false);
                	order_bt.setVisible(true);
                }
            }

			private void doHot() {	
				// Hotpn에 생성할 이지지 버튼들을 설정
				JButton HotButton_아메리카노 = new JButton("");
				fr.add(Hotpn);
				HotButton_아메리카노.setIcon(new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\아메리카노.JFIF"));
				Hotpn.add(HotButton_아메리카노);
				HotButton_아메리카노.setBounds(20, 20, 260,195);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField hot_아메리카노 = new JTextField("(HOT)아메리카노  1500원"); 
				Hotpn.add(hot_아메리카노);
				hot_아메리카노.setBounds(20,215,260,30);
				hot_아메리카노.setEditable(false);
				
				// 아메리카노를 누르면 알림창이 뜨게끔 기능 설정
				HotButton_아메리카노.addActionListener(new ActionListener () {
			        	 
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	JButton srcBtn =(JButton)e.getSource();
			                if(srcBtn==HotButton_아메리카노) {
			            int result=	JOptionPane.showConfirmDialog(HotButton_아메리카노, "아메리카노를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
			                	if(result == JOptionPane.OK_OPTION) {
			                		ordertxt.append((CoffeeSystem.hot_drink.get(0).toString()));
			                		CoffeeSystem.order.add(CoffeeSystem.hot_drink.get(0));
			                		CoffeeSystem.new_Price(1500);
			                	}
			                }
			            }});
				
				JButton HotButton_카푸치노 = new JButton("");
				HotButton_카푸치노.setIcon(new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\카푸치노.JFIF"));
				Hotpn.add(HotButton_카푸치노);
				HotButton_카푸치노.setBounds(280, 20, 259, 194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField 카푸치노 = new JTextField("(Hot)카푸치노  2000원"); 
				Hotpn.add(카푸치노);
				카푸치노.setBounds(280,215,260,30);
				카푸치노.setEditable(false);
				// 카푸치노를 누르면 알림창이 뜨게끔 설정
				HotButton_카푸치노.addActionListener(new ActionListener () {	        	 
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	JButton srcBtn =(JButton)e.getSource();
		                if(srcBtn==HotButton_카푸치노) {
		                	int result = JOptionPane.showConfirmDialog(HotButton_카푸치노, "카푸치노를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
		                	if(result == JOptionPane.OK_OPTION) {
		                		ordertxt.append((CoffeeSystem.hot_drink.get(1).toString()));
		                		CoffeeSystem.order.add(CoffeeSystem.hot_drink.get(1));
		                		CoffeeSystem.new_Price(2500);
		                		
		                	}
		                	
		                }
		            }});
			}

    }
        
     );
        //bt[0] 과 같은 형식임.
        bt[1].addActionListener(new ActionListener () {
       	 
            @Override
            public void actionPerformed(ActionEvent e) {
            	JButton srcBtn =(JButton)e.getSource();
                if(srcBtn==bt[1]) {
                	doICE();
                	
                	Icepn.setLayout(null);
				    Icepn.setBounds(250, 300, 1600, 600);
				    Icepn.setBackground(Color.gray);
				    
                	Hotpn.setVisible(false);
                	Icepn.setVisible(true);
                	Adepn.setVisible(false);
                	Dstpn.setVisible(false);
                	Orderpn.setVisible(false);
                	ordertxt.setVisible(true);
               
                	table.setVisible(false);
                	order_bt.setVisible(true);
                }
            }

			private void doICE() {
				
				fr.add(Icepn);
				JButton IceButton_아이스아메리카노 = new JButton("");								
				IceButton_아이스아메리카노.setIcon(new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\(ICE)아메리카노.JFIF"));
				Icepn.add(IceButton_아이스아메리카노);
				IceButton_아이스아메리카노.setBounds(20, 20, 259,194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField Ice_아메리카노 = new JTextField("(ICE)아메리카노  2000원"); 
				Icepn.add(Ice_아메리카노);
				Ice_아메리카노.setBounds(20,215,260,30);
				Ice_아메리카노.setEditable(false);
				//버튼 기능 추가
				IceButton_아이스아메리카노.addActionListener(new ActionListener () {
		        	 
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	JButton srcBtn =(JButton)e.getSource();
		                if(srcBtn==IceButton_아이스아메리카노) {
		                	int result = JOptionPane.showConfirmDialog(IceButton_아이스아메리카노, "아이스아메리카노를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
		                	if(result == JOptionPane.OK_OPTION) {
		                		ordertxt.append((CoffeeSystem.ice_drink.get(0).toString()));
		                		CoffeeSystem.order.add(CoffeeSystem.ice_drink.get(0));
		                		CoffeeSystem.new_Price(2000);
		                	}
		                	
		                }
		            }});			
		        // 이미지 크기조절하기!
				ImageIcon icon_아이스카페라떼 = new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\아이스카페라떼.jpg");						
				JButton IceButton_아이스카페라떼 = new JButton(CoffeeSystem.resizeIcon(icon_아이스카페라떼, 259, 194));				
				Icepn.add(IceButton_아이스카페라떼);
				IceButton_아이스카페라떼.setBounds(280, 20, 259,194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField Ice_아이스카페라떼 = new JTextField("(ICE)카페라떼  2500원"); 
				Icepn.add(Ice_아이스카페라떼);
				Ice_아이스카페라떼.setBounds(280,215,260,30);
				Ice_아이스카페라떼.setEditable(false);
				//버튼 기능 추가
				IceButton_아이스카페라떼.addActionListener(new ActionListener () {
		        	 
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	JButton srcBtn =(JButton)e.getSource();
		                if(srcBtn==IceButton_아이스카페라떼) {
		                	int result = JOptionPane.showConfirmDialog(IceButton_아이스카페라떼, "아이스 카페라떼를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
		                	if(result == JOptionPane.OK_OPTION) {
		                		ordertxt.append((CoffeeSystem.ice_drink.get(1).toString()));
		                		CoffeeSystem.order.add(CoffeeSystem.ice_drink.get(1));
		                		CoffeeSystem.new_Price(2500);
		                	}
		                	
		                }
		            }});
			}

    }
        
     );
        
        bt[2].addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn = (JButton)e.getSource();
				if(srcBtn==bt[2]) {
					doAde();
					
					Adepn.setLayout(null);
					Adepn.setBounds(250, 300, 1600, 600);
					Adepn.setBackground(Color.gray);				
					Hotpn.setVisible(false);
                	Icepn.setVisible(false);   	
                	Adepn.setVisible(true);
                	Dstpn.setVisible(false);
                	Orderpn.setVisible(false);
                	ordertxt.setVisible(true);
               
                	table.setVisible(false);
                	order_bt.setVisible(true);
				}
			}
        	
			private void doAde() {
			 fr.add(Adepn);
				JButton AdeButton_레몬에이드 = new JButton(new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\레몬에이드.JFIF"));
				Adepn.add(AdeButton_레몬에이드);
				AdeButton_레몬에이드.setBounds(20, 20, 259,194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField 레몬에이드 = new JTextField("레몬에이드  3000원"); 
				Adepn.add(레몬에이드);
				레몬에이드.setBounds(20,215,260,30);
				레몬에이드.setEditable(false);
				AdeButton_레몬에이드.addActionListener(new ActionListener () {
			        	 
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	JButton srcBtn =(JButton)e.getSource();
			                if(srcBtn==AdeButton_레몬에이드) {
			            int result=	JOptionPane.showConfirmDialog(AdeButton_레몬에이드, "레몬에이드를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
			                	if(result == JOptionPane.OK_OPTION) {
			                		ordertxt.append((CoffeeSystem.ade_drink.get(0).toString()));
			                		CoffeeSystem.order.add(CoffeeSystem.ade_drink.get(0));
			                		CoffeeSystem.new_Price(3000);
			                	}
			                }
			            }
			});
				
				ImageIcon icon_자몽에이드 = new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\자몽에이드.JPG");
				JButton AdeButton_자몽에이드 = new JButton(CoffeeSystem.resizeIcon(icon_자몽에이드, 260, 195));
				
				Adepn.add(AdeButton_자몽에이드);
				AdeButton_자몽에이드.setBounds(280, 20, 259,194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField 자몽에이드 = new JTextField("자몽에이드  3000원"); 
				Adepn.add(자몽에이드);
				자몽에이드.setBounds(280,215,260,30);
				자몽에이드.setEditable(false);
				AdeButton_자몽에이드.addActionListener(new ActionListener () {
			        	 
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	JButton srcBtn =(JButton)e.getSource();
			                if(srcBtn==AdeButton_자몽에이드) {
			            int result=	JOptionPane.showConfirmDialog(AdeButton_자몽에이드, "자몽에이드를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
			                	if(result == JOptionPane.OK_OPTION) {
			                		ordertxt.append((CoffeeSystem.ade_drink.get(1).toString()));
			                		CoffeeSystem.order.add(CoffeeSystem.ade_drink.get(1));
			                		CoffeeSystem.new_Price(3000);
			                	}
			                }
			            }
			});
        }});
        
        bt[3].addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn = (JButton)e.getSource();
				if(srcBtn==bt[3]) {
					doDeasert();
					
					Dstpn.setLayout(null);
					Dstpn.setBounds(250, 300, 1600, 600);
					Dstpn.setBackground(Color.gray);
					
					Hotpn.setVisible(false);
                	Icepn.setVisible(false);   	
                	Adepn.setVisible(false);
                	Dstpn.setVisible(true);
                	Orderpn.setVisible(false);
                	ordertxt.setVisible(true);
                	
                	table.setVisible(false);
                	order_bt.setVisible(true);
				}
			}
        	
			private void doDeasert() {
			 fr.add(Dstpn);
				JButton DstButton_초코케이크 = new JButton(new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\초코케이크.JFIF"));
				Dstpn.add(DstButton_초코케이크);
				DstButton_초코케이크.setBounds(20, 20, 259,194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField 초코케이크 = new JTextField("초코케이크 (1조각) 3000원"); 
				Dstpn.add(초코케이크);
				초코케이크.setBounds(20,215,260,30);
				초코케이크.setEditable(false);
				DstButton_초코케이크.addActionListener(new ActionListener () {
			        	 
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	JButton srcBtn =(JButton)e.getSource();
			                if(srcBtn==DstButton_초코케이크) {
			            int result=	JOptionPane.showConfirmDialog(DstButton_초코케이크, "초코케이크를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
			                	if(result == JOptionPane.OK_OPTION) {
			                		ordertxt.append((CoffeeSystem.deasert.get(0).toString()));
			                		CoffeeSystem.order.add(CoffeeSystem.deasert.get(0));
			                		CoffeeSystem.new_Price(3000);
			                	}
			               
			                }
			            }
			});
				ImageIcon icon_딸기케이크 = new ImageIcon("C:\\workpace\\THcoffeeSystem\\images\\딸기케이크.JFIF");
				JButton DstButton_딸기케이크 = new JButton(CoffeeSystem.resizeIcon(icon_딸기케이크, 260, 195));
				Dstpn.add(DstButton_딸기케이크);
				DstButton_딸기케이크.setBounds(280, 20, 259,194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField 딸기케이크 = new JTextField("딸기케이크 (1조각) 3500원"); 
				Dstpn.add(딸기케이크);
				딸기케이크.setBounds(280,215,260,30);
				딸기케이크.setEditable(false);
				DstButton_딸기케이크.addActionListener(new ActionListener () {
			        	 
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	JButton srcBtn =(JButton)e.getSource();
			                if(srcBtn==DstButton_딸기케이크) {
			            int result=	JOptionPane.showConfirmDialog(DstButton_딸기케이크, "딸기케이크를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
			                	if(result == JOptionPane.OK_OPTION) {
			                		ordertxt.append((CoffeeSystem.deasert.get(1).toString()));
			                		CoffeeSystem.order.add(CoffeeSystem.deasert.get(1));
			                		CoffeeSystem.new_Price(3500);
			                	}
			               
			                }
			            }
			});
			
        }});
        // 메인화면 버튼 기능
        bt[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn =(JButton)e.getSource();
				if(srcBtn==bt[4]) {
					
					Hotpn.setVisible(false);
                	Icepn.setVisible(false);   	
                	Adepn.setVisible(false);
                	Dstpn.setVisible(false);
                	Orderpn.setVisible(false);
                	ordertxt.setVisible(false);
                	table.setVisible(true);
                	order_bt.setVisible(false);
				}
				
			}

        	
        });
        
        // 주문리스트 버튼 기능
        bt[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn =(JButton)e.getSource();
				if(srcBtn==bt[5]) {
					fr.add(Orderpn);
					Hotpn.setVisible(false);
                	Icepn.setVisible(false);   	
                	Adepn.setVisible(false);
                	Dstpn.setVisible(false);
                	Orderpn.setVisible(true);
					ordertxt.setVisible(false);
					
					table.setVisible(false);
					order_bt.setVisible(false);
                
					Orderpn.add(listtxt);
                	Orderpn.setBounds(250, 300, 1600, 600);
					Orderpn.setBackground(Color.white);
					
							
				}
				
			}

			
        	
        });
        
        // 주문담기 버튼 추가 및 설정
        order_bt.setFont(new Font("돋움", Font.PLAIN, 25));
        order_bt.setBounds(1400, 950, 300, 150);
        pn.add(order_bt); // 주문담기 버튼 생성 및 출력
        order_bt.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn =(JButton)e.getSource();
				if(srcBtn==order_bt) {
					int result=JOptionPane.showConfirmDialog(order_bt, "주문하시겠습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(result==JOptionPane.OK_OPTION) {
											
						Custmoer_Order();	
						// 주문담기 버튼을 누르면 주문내역,총 주문비용 을 모두 지우고 다시 주문문구 생성
						ordertxt.setText("");
						int sum = 0;
						listtxt.append(CoffeeSystem.total_Price(sum));
						ordertxt.append("<주문하신 물품을 확인할수 있습니다.> \n\n");
						CoffeeSystem.order.removeAllElements();
						CoffeeSystem.price.removeAllElements();
							
					}
				}
				
			}
			// 주문리스트에 저장할 내용을 설정
			private void Custmoer_Order() {
				
					Menu m;									
					listtxt.append("------------------------모든 주문 리스트-------------------------\n");
							
					// 모든 주문리스트를 불러옴
					for(int i=0; i<CoffeeSystem.getNumOrders(); i++) {
						m=CoffeeSystem.getOrder(i);
						listtxt.append(i+1+". ");
						listtxt.append(m.toString());
										
			}
					
				listtxt.append("\n--------------------------------------------------------------------\n");
			}

        	
        });
               
       
                
        //첫 화면에는 주문기능 보이지 않게하기
        ordertxt.setVisible(false);
        order_bt.setVisible(false);
      
        
        //프레임 설정
        fr.setLocation(300,150);
        fr.setContentPane(pn);
        fr.setSize(1900, 1200);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	
	}




