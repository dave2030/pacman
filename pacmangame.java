package packman;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;



public class pacmangame extends Level  {
	Image game;

	Image pacman;
	Image left;
	Image right;
	Image down;
	Image up;

	Image pink;
	Image red; 

	Image[] pellet = new Image[302];

	Image gameOver;

	// x and y of ghost
	int xPosP = 282;
	int yPosP = 228;

	//x and y of redghost
	int xPosR = 327;
	int yPosR = 228;

	int win =0; // variable to show that you have won
	int score = 0; // pacman's score

	//x and y of pacman
	int Xpac=302; 
	int Ypac=368;

	//pacman speed
	int speed = 10;

	//arrays for pellets x and y
	int []xPel = new int [pellet.length];
	int []yPel = new int [pellet.length];

	//variable to show that you have lost
	int gg = 0;

	//speed of ghosts
	int ghostSpeed = 4;

	public pacmangame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		game = kit.getImage("game.jpg");
		gameOver = kit.getImage("gameOver.jpg");

		up= kit.getImage("pacmanUp.gif");
		down= kit.getImage("pacmanDown.gif");
		left= kit.getImage("pacmanLeft.gif");
		right= kit.getImage("pacmanRight.gif");

		pink = kit.getImage("pinkGhost.png");
		red = kit.getImage("redGhost.png");

		for (int i=0;i<pellet.length;i++)
			pellet[i]= kit.getImage("pellet.png");

		for (int i=0; i<pellet.length;i++) // spawning xPel and yPel coordinates of pellets
		{

			//row 1
			if(i<12){
				xPel[i]= 115 + (i*15);
				yPel[i]= 23;
			}
			else if(i>=12 && i <24){
				xPel[i]= 325+ ((i-12)*15);
				yPel[i]= 23;
			}

			//row 2
			else if(i>=25 && i <51){
				xPel[i]= 115+ ((i-25)*15);
				yPel[i]= 83 ;
			}
			//row 3
			else if(i>=52 && i <58){
				xPel[i]= 115+ ((i-52)*15);
				yPel[i]= 128 ;
			}
			else if(i>=58 && i <62){
				xPel[i]= 235+ ((i-58)*15);
				yPel[i]= 128 ;
			}
			else if(i>=62 && i <66){
				xPel[i]= 325+ ((i-62)*15);
				yPel[i]= 128 ;
			}
			else if(i>=67 && i <73){
				xPel[i]= 415+ ((i-67)*15);
				yPel[i]= 128 ;
			}

			//row 4
			else if(i>=73 && i <83){
				xPel[i]= 235+ ((i-73)*15);
				yPel[i]= 173;
			}
			//row 5
			else if(i>=198 && i <202){
				xPel[i]= 190+ ((i-198)*15);
				yPel[i]= 233;
			}
			else if(i>=202 && i <206){
				xPel[i]= 370+ ((i-202)*15);
				yPel[i]= 233;
			}

			//row 6
			else if(i>=83 && i <93){
				xPel[i]= 235+ ((i-83)*15);
				yPel[i]= 278;
			}

			//row 7
			else if(i>=93 && i <105){
				xPel[i]=115+ ((i-93)*15);
				yPel[i]= 323;
			}
			else if(i>=105 && i <117){
				xPel[i]= 325+ ((i-105)*15);
				yPel[i]= 323;
			}

			//row 8
			else if(i>=192 && i <195){
				xPel[i]= 115+ ((i-192)*15);
				yPel[i]= 368;
			}
			else if(i>=118 && i <134){
				xPel[i]= 190+ ((i-118)*15);
				yPel[i]= 368;
			}
			else if(i>=195 && i <198){
				xPel[i]= 460+ ((i-195)*15);
				yPel[i]= 368;
			}

			//row 9
			else if(i>=135 && i <141){
				xPel[i]= 115+ ((i-135)*15);
				yPel[i]= 413 ;
			}
			else if(i>=141 && i <145){
				xPel[i]= 235+ ((i-141)*15);
				yPel[i]= 413 ;
			}
			else if(i>=145 && i <149){
				xPel[i]= 325+ ((i-145)*15);
				yPel[i]=413 ;
			}
			else if(i>=150 && i <156){
				xPel[i]= 415+ ((i-150)*15);
				yPel[i]= 413 ;
			}
			//row 10
			else if(i>=156 && i <182){
				xPel[i]=115+ ((i-156)*15);
				yPel[i]= 458;
			}

			//column 1
			else if(i>=183 && i <186){
				xPel[i]=115;
				yPel[i]= 38+ ((i-183)*15);
			}
			else if(i>=186 && i <188){
				xPel[i]=115;
				yPel[i]= 98+ ((i-186)*15);
			}
			else if(i>=188 && i <192){
				xPel[i]=115;
				yPel[i]= 323+ ((i-188)*15);
			}
			else if(i>=207 && i <209){
				xPel[i]=115;
				yPel[i]= 413+ ((i-206)*15);
			}

			//column 2
			else if(i>=209 && i <211){
				xPel[i]=145;
				yPel[i]= 368+ ((i-208)*15);
			}

			//column 3
			else if(i>=211 && i <214){
				xPel[i]=190;
				yPel[i]= 38+ ((i-211)*15);
			}
			else if(i>=214 && i <216){
				xPel[i]=190;
				yPel[i]= 98+ ((i-214)*15);
			}
			else if(i>=216 && i <222){
				xPel[i]=190;
				yPel[i]= 143+ ((i-216)*15);
			}
			else if(i>=222 && i <227){
				xPel[i]=190;
				yPel[i]= 248+ ((i-222)*15);
			}
			else if(i>=227 && i <229){
				xPel[i]=190;
				yPel[i]= 338+ ((i-227)*15);
			}
			else if(i>=229 && i <231){
				xPel[i]=190;
				yPel[i]= 383+ ((i-229)*15);
			}

			//column 4
			else if(i>=231 && i <233){
				xPel[i]=235;
				yPel[i]= 98+ ((i-231)*15);
			}
			else if(i>=233 && i <236){
				xPel[i]=235;
				yPel[i]= 188+ ((i-233)*15);
			}
			else if(i>=236 && i <238){
				xPel[i]=235;
				yPel[i]= 248+ ((i-236)*15);
			}
			else if(i>=238 && i <240){
				xPel[i]=235;
				yPel[i]= 293+ ((i-238)*15);
			}
			else if(i>=240 && i <242){
				xPel[i]=235;
				yPel[i]= 383+ ((i-240)*15);
			}

			//column 5
			else if(i>=242 && i <245){
				xPel[i]=280;
				yPel[i]= 38+ ((i-242)*15);
			}
			else if(i>=245 && i <247){
				xPel[i]=280;
				yPel[i]= 143+ ((i-245)*15);
			}
			else if(i>=247 && i <249){
				xPel[i]=280;
				yPel[i]= 338+ ((i-247)*15);
			}
			else if(i>=249 && i <251){
				xPel[i]=280;
				yPel[i]= 428+ ((i-249)*15);
			}

			//column 6
			else if(i>=251 && i <254){
				xPel[i]=325;
				yPel[i]= 38+ ((i-251)*15);
			}
			else if(i>=254 && i <256){
				xPel[i]=325;
				yPel[i]= 143+ ((i-254)*15);
			}
			else if(i>=256 && i <258){
				xPel[i]=325;
				yPel[i]= 338+ ((i-256)*15);
			}
			else if(i>=258 && i <260){
				xPel[i]=325;
				yPel[i]= 428+ ((i-258)*15);
			}


			//column 7
			else if(i>=260 && i <262){
				xPel[i]=370;
				yPel[i]= 98+ ((i-260)*15);
			}
			else if(i>=262 && i <265){
				xPel[i]=370;
				yPel[i]= 188+ ((i-262)*15);
			}
			else if(i>=265 && i <267){
				xPel[i]=370;
				yPel[i]= 248+ ((i-265)*15);
			}
			else if(i>=267 && i <269){
				xPel[i]=370;
				yPel[i]= 293+ ((i-267)*15);
			}
			else if(i>=269 && i <271){
				xPel[i]=370;
				yPel[i]= 383+ ((i-269)*15);
			}

			//column 8
			else if(i>=271 && i <274){
				xPel[i]=415;
				yPel[i]= 38+ ((i-271)*15);
			}
			else if(i>=274 && i <276){
				xPel[i]=415;
				yPel[i]= 98+ ((i-274)*15);
			}
			else if(i>=276 && i <282){
				xPel[i]=415;
				yPel[i]= 143+ ((i-276)*15);
			}
			else if(i>=282 && i <287){
				xPel[i]=415;
				yPel[i]= 248+ ((i-282)*15);
			}
			else if(i>=287 && i <289){
				xPel[i]=415;
				yPel[i]= 338+ ((i-287)*15);
			}
			else if(i>=289 && i <291){
				xPel[i]=415;
				yPel[i]= 383+ ((i-289)*15);
			}

			//column 9
			else if(i>=291 && i <293){
				xPel[i]=460;
				yPel[i]= 383+ ((i-291)*15);
			}

			//column 10
			else if(i>=293 && i <296){
				xPel[i]=490;
				yPel[i]= 38+ ((i-293)*15);
			}
			else if(i>=296 && i <298){
				xPel[i]=490;
				yPel[i]= 98+ ((i-296)*15);
			}
			else if(i>=298 && i <300){
				xPel[i]=490;
				yPel[i]= 338+ ((i-298)*15);
			}
			else if(i>=300 && i <302){
				xPel[i]=490;
				yPel[i]= 428+ ((i-300)*15);
			}
			else {
				xPel[i]= 1000;
				yPel[i]= 1000;
			}

		}

		pacman=right;
		level=2;
	}

	public void paintLevel(Graphics2D g ,JPanel p) {
		g.drawImage(game, 0, 0, p); // game
		g.drawImage(pacman,Xpac,Ypac, p); //pacRec

		g.drawImage(red, xPosR, yPosR, p);//red ghost
		g.drawImage(pink, xPosP, yPosP, p);//pink ghost

		for (int i=0;i<pellet.length;i++) // array for pellet
			g.drawImage(pellet[i],xPel[i],yPel[i], p);

		g.setColor(Color.white);//shows score count
		g.drawString("Score:"+score,10,50);
		/*
      Rectangle one = new Rectangle(140,45,45,36);
      Rectangle two = new Rectangle(215,45,65,36);
      Rectangle three = new Rectangle(310,23,10,58);
      Rectangle four = new Rectangle(345,45,65,36);
      Rectangle five = new Rectangle(440,45,45,36);
      Rectangle six = new Rectangle(140,110,45,15);
      Rectangle seven = new Rectangle(216,110,15,115);
      Rectangle eight = new Rectangle(260,110,105,15);
      Rectangle nine = new Rectangle(394,110,15,115);
      Rectangle ten = new Rectangle(440,110,45,15);
      Rectangle eleven = new Rectangle(102,158,85,70);
      Rectangle twelve = new Rectangle(232,158,45,15);
      Rectangle thirteen = new Rectangle(308,130,10,40);
      Rectangle fourteen = new Rectangle(348,158,45,15);
      Rectangle fifteen = new Rectangle(440,158,85,70);
      Rectangle sixteen = new Rectangle(102,258,85,55);
      Rectangle seventeen = new Rectangle(216,262,15,50);
      Rectangle eighteen = new Rectangle(260,306,105,15);
      Rectangle ninteen = new Rectangle(394,262,15,50);
      Rectangle twenty = new Rectangle(440,258,85,55);
      Rectangle twentyone = new Rectangle(140,349,45,15);
      Rectangle twentytwo = new Rectangle(214,349,62,15);
      Rectangle twentythree = new Rectangle(308,323,10,35);
      Rectangle twentyfour = new Rectangle(348,349,62,15);
      Rectangle twentyfive = new Rectangle(440,349,45,15);
      Rectangle twentysix = new Rectangle(102,394,39,15);
      Rectangle twentyseven = new Rectangle(170,365,15,40);
      Rectangle twentyeight = new Rectangle(218,390,15,46);
      Rectangle twentynine = new Rectangle(260,389,105,15);
      Rectangle thirty = new Rectangle(394,390,15,46);
      Rectangle thirtyone = new Rectangle(440,365,15,40);
      Rectangle thirtytwo = new Rectangle(485,389,39,15);
      Rectangle thirtythree = new Rectangle(140,435,140,15);
      Rectangle thirtyfour = new Rectangle(308,410,10,40);
      Rectangle thirtyfive = new Rectangle(348,435,140,15);
		 */

		//      g.setColor (Color.blue); 
		//  		g.draw(one);
		//  		g.draw(two);
		//  		g.draw(three);
		//  		g.draw(four);
		//  		g.draw(five);
		//  		g.draw(six);
		//  		g.draw(seven);
		//  		g.draw(eight);
		//  		g.draw(nine);
		//  		g.draw(ten);
		//  		g.draw(eleven);
		//  		g.draw(twelve);
		//  		g.draw(thirteen);
		//  		g.draw(fourteen);
		//  		g.draw(fifteen);
		//  		g.draw(sixteen);
		//  		g.draw(seventeen);
		//  		g.draw(eighteen);
		//  		g.draw(ninteen);
		//  		g.draw(twenty);
		//  		g.draw(twentyone);
		//  		g.draw(twentytwo);
		//  		g.draw(twentythree);
		//  		g.draw(twentyfour);
		//  		g.draw(twentyfive);
		//  		g.draw(twentysix);
		//  		g.draw(twentyseven);
		//  		g.draw(twentyeight);
		//  		g.draw(twentynine);
		//  		g.draw(thirty);
		//  		g.draw(thirtyone);
		//  		g.draw(thirtytwo);
		//  		g.draw(thirtythree);
		//  		g.draw(thirtyfour);
		//  		g.draw(thirtyfive);


		// if value is greater than 0
		if (gg>0){
			g.drawImage(gameOver, 0, 0, p);//game over screen is painted
			g.drawString("Points:"+score,282,234);  //score is shown
		}

		if ((Xpac >=  265&& Xpac <= 355) && (Ypac >= 190 && Ypac <=230))
			gg=1;

		if (win == 1)
			g.drawImage(gameOver, 0, 0, p);

		
	}

	public void buildLevel(JPanel p) {

		//red ghost movement	
		if (xPosR > Xpac && yPosR>Ypac)     		  
			xPosR-= ghostSpeed ;     		
		else if (xPosR < Xpac && yPosR>Ypac) 
			xPosR+= ghostSpeed ;    		 
		else if (xPosR < Xpac && yPosR<Ypac) 
			xPosR+= ghostSpeed ;     		  
		else if (xPosR > Xpac && yPosR<Ypac)  
			xPosR-= ghostSpeed ;     		      	 
		if (xPosR == Xpac && yPosR<Ypac) 
			yPosR+= ghostSpeed ;     		     	
		else if (xPosR == Xpac && yPosR>Ypac)  
			yPosR-= ghostSpeed ;     		 
		else if (xPosR < Xpac && yPosR==Ypac)  
			xPosR+= ghostSpeed ;     		     	
		else if (xPosR > Xpac && yPosR==Ypac)  
			xPosR-= ghostSpeed ; 

		//pink ghost movement
		if (xPosP > Xpac && yPosP>Ypac)  
			yPosP-= ghostSpeed ;     		  
		else if (xPosP < Xpac && yPosP>Ypac)      		
			yPosP-= ghostSpeed ;     		  
		else if (xPosP < Xpac && yPosP<Ypac)      		  
			yPosP+= ghostSpeed ;     		  
		else if (xPosP > Xpac && yPosP<Ypac)      		
			yPosP+= ghostSpeed ;     		  
		else if (xPosP > Xpac && yPosP==Ypac)     		  
			xPosP-=ghostSpeed ;    		  
		else if (xPosP< Xpac && yPosP==Ypac)     		   
			xPosP+=ghostSpeed ;    	
		else if (xPosP == Xpac && yPosP>Ypac)     		  
			yPosP-=ghostSpeed ;    		  
		else if (xPosP== Xpac && yPosP<Ypac)     		   
			yPosP+=ghostSpeed ;  

		//if ghosts touch pacman
		if (xPosR < Xpac+15 && xPosR > Xpac-15 && yPosR < Ypac+15 && yPosR >Ypac-15)              
			gg = gg+1;                            
		if (xPosP < Xpac+15 && xPosP > Xpac-15 && yPosP < Ypac+15 && yPosP >Ypac-15)                
			gg = gg+1;

	}

	public void keyPressed (KeyEvent event){ 


		// pacman movement

		//key is up
		if (event.getKeyCode() == KeyEvent.VK_UP ){
			if (gg<=0){// if game over isnt activated
				pacman = up; 
				Ypac-=speed; 
				int z = scoreNum(Xpac,Ypac,xPel, yPel, pellet); 
				score = score+z;
			}
			if(Ypac<25)
				Ypac=25; 
		}
		//key is down
		else if (event.getKeyCode() == KeyEvent.VK_DOWN ){
			if (gg<=0){// if game over isnt activated
				pacman = down; 
				Ypac+=speed; 
				int z = scoreNum(Xpac,Ypac,xPel, yPel, pellet); 
				score = score+z;
			}
			if(Ypac>457)
				Ypac=457; 
		}
		//key is left
		else if(event.getKeyCode() == KeyEvent.VK_LEFT ) {
			if (gg<=0){// if game over isnt activated
				pacman = left; 
				Xpac-=speed; 	

				int z = scoreNum(Xpac,Ypac,xPel, yPel, pellet);
				score = score+z;
			}
			if(Xpac<117)
				Xpac=117; 
		}
		//key is right
		else if (event.getKeyCode() == KeyEvent.VK_RIGHT ){ 
			if (gg<=0){ // if game over isnt activated
				pacman = right; 
				Xpac+=speed; 
				int z = scoreNum(Xpac,Ypac,xPel, yPel, pellet); 
				score = score+z;
			}
			if(Xpac>492)
				Xpac=492; 
		}

		//moving from one tunnel to other tunnel
		if (Xpac == 117 && (Ypac>228&& Ypac<258))
			Xpac = 507;
		else if (Xpac == 492 && (Ypac>228&& Ypac<258))
			Xpac = 102;


		Rectangle pacRec = new Rectangle (Xpac-10,Ypac-10,20,20);
		Rectangle one = new Rectangle(140-10,45-7,45,36);
		Rectangle two = new Rectangle(215-10,45-7,65,36);
		Rectangle three = new Rectangle(310-10,23-7,10,58);
		Rectangle four = new Rectangle(345-10,45-7,65,36);
		Rectangle five = new Rectangle(440-10,45-7,45,36);
		Rectangle six = new Rectangle(140-10,110-7,45,15);
		Rectangle seven = new Rectangle(216-10,110-7,15,125);
		Rectangle eight = new Rectangle(260-10,110-7,105,15);
		Rectangle nine = new Rectangle(394-10,110-7,15,125);
		Rectangle ten = new Rectangle(440-10,110-7,45,15);
		Rectangle eleven = new Rectangle(102-10,158-7,85,70);
		Rectangle twelve = new Rectangle(232-10,158-7,45,15);
		Rectangle thirteen = new Rectangle(308-10,130-7,10,30);
		Rectangle fourteen = new Rectangle(348-10,158-13,45,15);
		Rectangle fifteen = new Rectangle(440-10,158-7,85,70);
		Rectangle sixteen = new Rectangle(102-10,258-7,85,65);
		Rectangle seventeen = new Rectangle(216-10,262-7,15,60);
		Rectangle eighteen = new Rectangle(260-10,306-7,105,15);
		Rectangle ninteen = new Rectangle(394-10,262-7,15,60);
		Rectangle twenty = new Rectangle(440-10,258-7,85,65);
		Rectangle twentyone = new Rectangle(140-10,349-7,45,15);
		Rectangle twentytwo = new Rectangle(214-10,349-7,62,15);
		Rectangle twentythree = new Rectangle(308-10,323-7,10,35);
		Rectangle twentyfour = new Rectangle(348-10,349-7,62,15);
		Rectangle twentyfive = new Rectangle(440-10,349-7,45,15);
		Rectangle twentysix = new Rectangle(102-10,394-7,39,15);
		Rectangle twentyseven = new Rectangle(170-10,365-7,15,40);
		Rectangle twentyeight = new Rectangle(218-10,390-7,15,46);
		Rectangle twentynine = new Rectangle(260-10,389-7,105,15);
		Rectangle thirty = new Rectangle(394-10,390-7,15,46);
		Rectangle thirtyone = new Rectangle(440-10,365-7,15,40);
		Rectangle thirtytwo = new Rectangle(485-10,389-7,39,25);
		Rectangle thirtythree = new Rectangle(140-10,435-7,140,15);
		Rectangle thirtyfour = new Rectangle(308-10,410-7,10,40);
		Rectangle thirtyfive = new Rectangle(348-10,435-7,140,15);

		if (pacRec.intersects(one) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(one) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(one) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(one) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(two) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(two) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(two) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(two) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(three) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(three) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(three) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(three) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(four) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(four) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(four) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(four) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(five) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(five) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(five) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(five) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(six) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(six) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(six) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(six) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(seven) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(seven) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(seven) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(seven) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(eight) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(eight) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(eight) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(eight) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(nine) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(nine) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(nine) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(nine) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(ten) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(ten) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(ten) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(ten) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(eleven) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(eleven) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(eleven) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(eleven) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(twelve) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(twelve) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(twelve) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(twelve) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(thirteen) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(thirteen) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(thirteen) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(thirteen) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(fourteen) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(fourteen) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(fourteen) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(fourteen) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(fifteen) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(fifteen) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(fifteen) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(fifteen) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(sixteen) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(sixteen) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(sixteen) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(sixteen) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(seventeen) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(seventeen) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(seventeen) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(seventeen) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(eighteen) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(eighteen) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(eighteen) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(eighteen) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(ninteen) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(ninteen) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(ninteen) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(ninteen) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(twenty) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(twenty) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(twenty) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(twenty) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(twentyone) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(twentyone) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(twentyone) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(twentyone) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(twentytwo) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(twentytwo) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(twentytwo) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(twentytwo) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(twentythree) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(twentythree) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(twentythree) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(twentythree) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(twentyfour) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(twentyfour) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(twentyfour) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(twentyfour) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(twentyfive) && pacman == left) 
			Xpac=Xpac+10;		
		else if (pacRec.intersects(twentyfive) && pacman == down) 
			Ypac=Ypac-10;		
		else if (pacRec.intersects(twentyfive) && pacman == up) 
			Ypac=Ypac+10;		
		else if (pacRec.intersects(twentyfive) && pacman == right) 
			Xpac=Xpac-10;		
		if (pacRec.intersects(twentysix) && pacman == left)
			Xpac=Xpac+10;		
		else if (pacRec.intersects(twentysix) && pacman == down)
			Ypac=Ypac-10;		
		else if (pacRec.intersects(twentysix) && pacman == up)
			Ypac=Ypac+10;		
		else if (pacRec.intersects(twentysix) && pacman == right)
			Xpac=Xpac-10;	
		if (pacRec.intersects(twentyseven) && pacman == left)
			Xpac=Xpac+10;		
		else if (pacRec.intersects(twentyseven) && pacman == down)
			Ypac=Ypac-10;		
		else if (pacRec.intersects(twentyseven) && pacman == up)
			Ypac=Ypac+10;		
		else if (pacRec.intersects(twentyseven) && pacman == right)
			Xpac=Xpac-10;		
		if (pacRec.intersects(twentyeight) && pacman == left)
			Xpac=Xpac+10;		
		else if (pacRec.intersects(twentyeight) && pacman == down)
			Ypac=Ypac-10;		
		else if (pacRec.intersects(twentyeight) && pacman == up)
			Ypac=Ypac+10;	
		else if (pacRec.intersects(twentyeight) && pacman == right)
			Xpac=Xpac-10;	
		if (pacRec.intersects(twentynine) && pacman == left)
			Xpac=Xpac+10;		
		else if (pacRec.intersects(twentynine) && pacman == down)
			Ypac=Ypac-10;		
		else if (pacRec.intersects(twentynine) && pacman == up)
			Ypac=Ypac+10;		
		else if (pacRec.intersects(twentynine) && pacman == right)
			Xpac=Xpac-10;
		if (pacRec.intersects(thirty) && pacman == left)
			Xpac=Xpac+10;		
		else if (pacRec.intersects(thirty) && pacman == down)
			Ypac=Ypac-10;		
		else if (pacRec.intersects(thirty) && pacman == up)
			Ypac=Ypac+10;		
		else if (pacRec.intersects(thirty) && pacman == right)
			Xpac=Xpac-10;		
		if (pacRec.intersects(thirtyone) && pacman == left)
			Xpac=Xpac+10;		
		else if (pacRec.intersects(thirtyone) && pacman == down)
			Ypac=Ypac-10;		
		else if (pacRec.intersects(thirtyone) && pacman == up)
			Ypac=Ypac+10;		
		else if (pacRec.intersects(thirtyone) && pacman == right)
			Xpac=Xpac-10;		
		if (pacRec.intersects(thirtytwo) && pacman == left)
			Xpac=Xpac+10;		
		else if (pacRec.intersects(thirtytwo) && pacman == down)
			Ypac=Ypac-10;		
		else if (pacRec.intersects(thirtytwo) && pacman == up)
			Ypac=Ypac+10;		
		else if (pacRec.intersects(thirtytwo) && pacman == right)
			Xpac=Xpac-10;		
		if (pacRec.intersects(thirtythree) && pacman == left)
			Xpac=Xpac+10;		
		else if (pacRec.intersects(thirtythree) && pacman == down)
			Ypac=Ypac-10;		
		else if (pacRec.intersects(thirtythree) && pacman == up)
			Ypac=Ypac+10;		
		else if (pacRec.intersects(thirtythree) && pacman == right)
			Xpac=Xpac-10;		
		if (pacRec.intersects(thirtyfour) && pacman == left)
			Xpac=Xpac+10;		
		else if (pacRec.intersects(thirtyfour) && pacman == down)
			Ypac=Ypac-10;		
		else if (pacRec.intersects(thirtyfour) && pacman == up)
			Ypac=Ypac+10;		
		else if (pacRec.intersects(thirtyfour) && pacman == right)
			Xpac=Xpac-10;		
		if (pacRec.intersects(thirtyfive) && pacman == left)
			Xpac=Xpac+10;	
		else if (pacRec.intersects(thirtyfive) && pacman == down)
			Ypac=Ypac-10;		
		else if (pacRec.intersects(thirtyfive) && pacman == up)
			Ypac=Ypac+10;		
		else if (pacRec.intersects(thirtyfive) && pacman == right)
			Xpac=Xpac-10;
	}    

	//method to check if pacman hit a pellet
	public static int scoreNum (int Xpac, int Ypac, int xPel[], int yPel[], Image pellet[]){
		int pelletScore=0;
		//compare the coordinate of pacman and images in the array 
		for (int i=0;i<pellet.length;i++)
		{
			//if diver hit a pellet 
			if (Xpac < xPel[i]+10 && Xpac > xPel[i]-10 && Ypac < yPel[i]+10 && Ypac > yPel[i]-10 && !(pellet[i]== null) )
			{
				pellet[i] = null; //remove pellet
				pelletScore=3;  //return 3 points
			} 
		}
		return (pelletScore);
	}















}
