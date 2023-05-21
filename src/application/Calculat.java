package application;


import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;

public class Calculat extends Application {
	StringBuilder lab = new StringBuilder();
	Label label1 = new Label();
	double q, h, s;
	String op;

	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		BorderPane root=new BorderPane();
		CaursorLinked array=new CaursorLinked();
		Stack ar=new Stack();
		
		GridPane pane1 = new GridPane();
		TextField Postfix=new TextField();
		Postfix.setPromptText("postfix");
		Postfix.setFocusTraversable(false);
		Postfix.setFont(Font.font(20));
		Postfix.prefHeight(50);
		Postfix.setAlignment(Pos.BASELINE_LEFT);
		Postfix.setStyle("-fx-background-color: #e1e1e1");
		
		
		
		
		TextField Expression=new TextField("");
		Expression.setPromptText("Expression");
		Expression.setFocusTraversable(false);
		Expression.setFont(Font.font(20));
		Expression.prefHeight(50);
		Expression.setAlignment(Pos.BASELINE_LEFT);
		Expression.setStyle("-fx-background-color: #fdfdfd");
		
		TextField Result=new TextField();
		Result.setPromptText("Result");
		Result.setFocusTraversable(false);
		Result.setFont(Font.font(20));
		Result.prefHeight(50);
		Result.setAlignment(Pos.BASELINE_LEFT);
		
		pane1.setAlignment(Pos.CENTER);
		//Add node
		Button button0 = new Button("SIN");
		button0.setPrefSize(100, 50);button0.setFont(Font.font(30));
		button0.setOnAction(e -> {
//			Expression.appendText("SIN");
			button0.setStyle("-fx-background-color: #87CEEB");

			double d=Double.parseDouble(Expression.getText());
			double n=Math.sin(Math.toRadians(d)  );
			Result.setText(n+"");
		});
		Button button1 = new Button("COS");
		button1.setPrefSize(100, 50);button1.setFont(Font.font(30));
		
		button1.setOnAction(e -> {
			

			double d=Double.parseDouble(Expression.getText());
			double n=Math.cos(Math.toRadians(d)  );
			Result.setText(n+"");
		});
		
		Button button2 = new Button("TAN");
		button2.setPrefSize(100, 50);button2.setFont(Font.font(30));
		button2.setOnAction(e -> {
		

			double d=Double.parseDouble(Expression.getText());
			double n=Math.tan(Math.toRadians(d)  );
			Result.setText(n+"");
		});
		
		Button button3 = new Button("(");
		button3.setPrefSize(100, 50);button3.setFont(Font.font(30));
		button3.setOnAction(e -> {
			Expression.appendText("(");
		});

		Button button4 = new Button(")");
		button4.setPrefSize(100, 50);button4.setFont(Font.font(30));
		button4.setOnAction(e -> {
			Expression.appendText(")");
		});
		Button button5 = new Button("!");
		button5.setPrefSize(100, 50);button5.setFont(Font.font(30));
		button5.setOnAction(e -> {
		
			double d=Double.parseDouble(Expression.getText());
			Postfix.setText(d+"!");
			int j=1;
			for(int i=1;i<=d;i++) {
				j=j*i;
			}
			
			Result.setText(j+"");
		});
		Button button6 = new Button("OFF");
		button6.setPrefSize(100, 50);button6.setFont(Font.font(30));
		button6.setOnAction(e -> {
			primaryStage.close();
		});
		Button button7 = new Button("PI");
		button7.setPrefSize(100, 50);button7.setFont(Font.font(30));
		button7.setOnAction(e -> {
			Expression.appendText("PI");
			double n=Math.PI;
			Result.setText(n+"");
		});
		Button button8 = new Button("^");
		button8.setPrefSize(100, 50);button8.setFont(Font.font(30));
		button8.setOnAction(e -> {
			Expression.appendText("^");
		});
		Button button9 = new Button("7");
		button9.setPrefSize(100, 50);button9.setFont(Font.font(30));
		button9.setOnAction(e -> {
			Expression.appendText("7");
		});
		Button button11 = new Button("8");
		button11.setPrefSize(100, 50);button11.setFont(Font.font(30));
		button11.setOnAction(e -> {
			Expression.appendText("8");
		});
		Button button12 = new Button("9");
		button12.setPrefSize(100, 50);button12.setFont(Font.font(30));
		button12.setOnAction(e -> {
			Expression.appendText("9");
		});
		Button button13 = new Button("/");
		button13.setPrefSize(100, 50);button13.setFont(Font.font(30));
		button13.setOnAction(e -> {
			Expression.appendText("/");
		});
		Button button14 = new Button("(-)");
		button14.setPrefSize(100, 50);button14.setFont(Font.font(30));
		button14.setOnAction(e -> {
			double b=Double.parseDouble(Expression.getText());
			double n=-1*b;
			Result.setText(n+"");
		});
		Button button15 = new Button("X2");
		button15.setPrefSize(100, 50);button15.setFont(Font.font(30));
		button15.setOnAction(e -> {
			double n=Double.parseDouble(Expression.getText());
			double m=Math.pow(n, 2);
			Result.setText(m+"");
		});
		Button button16 = new Button("sqrx");
		button16.setPrefSize(100, 50);button16.setFont(Font.font(30));
		button16.setOnAction(e -> {
			double n=Double.parseDouble(Expression.getText());
			double m=Math.sqrt(n);
			Result.setText(m+"");
		});
		Button button17 = new Button("4");
		button17.setPrefSize(100, 50);button17.setFont(Font.font(30));
		button17.setOnAction(e -> {
			Expression.appendText("4");
		});
		Button button18 = new Button("5");
		button18.setPrefSize(100, 50);button18.setFont(Font.font(30));
		button18.setOnAction(e -> {
			Expression.appendText("5");
		});
		Button button19 = new Button("6");
		button19.setPrefSize(100, 50);button19.setFont(Font.font(30));
		button19.setOnAction(e -> {
			Expression.appendText("6");
		});
		Button button21 = new Button("*");
		button21.setPrefSize(100, 50);button21.setFont(Font.font(30));
		button21.setOnAction(e -> {
			Expression.appendText("*");
		});
		Button button22 = new Button("CA");
		button22.setPrefSize(100, 50);button22.setFont(Font.font(30));
		button22.setOnAction(e -> {
			Expression.setText("");
			Postfix.setText("");
			Result.setText("");
			
			for(int i=0;ar.peek()!=null;i++) {
				ar.pop();
			}
			
		});
		Button button23 = new Button("ex");
		button23.setPrefSize(100, 50);button23.setFont(Font.font(30));
		button23.setOnAction(e -> {
			double j=Double.parseDouble(Expression.getText());
			double b=Math.exp(j);
			Result.setText(b+"");
		});
		Button button24 = new Button("LN");
		button24.setPrefSize(100, 50);button24.setFont(Font.font(30));
		button24.setOnAction(e -> {
			double n=Double.parseDouble(Expression.getText());
			double m=Math.log(n);
			Result.setText(m+"");
			
		});
		Button button25 = new Button("1");
		button25.setPrefSize(100, 50);button25.setFont(Font.font(30));
		button25.setOnAction(e -> {
			Expression.appendText("1");
		});
		Button button26 = new Button("2");
		button26.setPrefSize(100, 50);button26.setFont(Font.font(30));
		button26.setOnAction(e -> {
			Expression.appendText("2");
		});
		Button button27 = new Button("3");
		button27.setPrefSize(100, 50);button27.setFont(Font.font(30));
		button27.setOnAction(e -> {
			Expression.appendText("3");
		});
		Button button28 = new Button("-");
		button28.setPrefSize(100, 50);button28.setFont(Font.font(30));
		button28.setOnAction(e -> {
			Expression.appendText("-");
		});
		Button button29 = new Button("C");
		button29.setPrefSize(100, 50);button29.setFont(Font.font(30));
		button29.setOnAction(e -> {
			String na=Expression.getText();
			na=na.substring(0,na.length()-1);
			Expression.setText("");
			
			Expression.appendText(na);
		});
		Button button30 = new Button("LOG");
		button30.setPrefSize(100, 50);button30.setFont(Font.font(30));
		button30.setOnAction(e -> {
			double m=Double.parseDouble(Expression.getText());
			double n=Math.log10(m);
			Result.setText(n+"");
		});
		Button button31 = new Button("1/x");
		button31.setPrefSize(100, 50);button31.setFont(Font.font(30));
		button31.setOnAction(e -> {
			double n=Double.parseDouble(Expression.getText());
			double m=1/n;
			Result.setText(m+"");
		});
		Button button32 = new Button("0");
		button32.setPrefSize(100, 50);button32.setFont(Font.font(30));
		button32.setOnAction(e -> {
			Expression.appendText("0");
		});
		Button button33 = new Button(".");
		button33.setPrefSize(100, 50);button33.setFont(Font.font(30));
		button33.setOnAction(e -> {
			Expression.appendText(".");
		});
		Button button34 = new Button("%");
		button34.setPrefSize(100, 50);button34.setFont(Font.font(30));
		button34.setOnAction(e -> {
			Expression.appendText("%");
		});
		Button button35 = new Button("+");
		button35.setPrefSize(100, 50);button35.setFont(Font.font(30));
		button35.setOnAction(e -> {
			Expression.appendText("+");
		});
		Button button36 = new Button("<");
		button36.setPrefSize(100, 50);button36.setFont(Font.font(30));
		button36.setOnAction(e -> {
			String na=Expression.getText();
			na=na.substring(0,na.length()-1);
			Expression.setText("");
			
			Expression.appendText(na);
		});
		pane1.add(button0, 0, 0);
		pane1.add(button1, 1, 0);
		pane1.add(button2, 2, 0);
		pane1.add(button3, 3, 0);
		pane1.add(button4, 4, 0);
		pane1.add(button5, 5, 0);
		pane1.add(button6, 6, 0);

		pane1.add(button7, 0, 1);
		pane1.add(button8, 1, 1);
		pane1.add(button9, 2, 1);
		pane1.add(button11, 3, 1);
		pane1.add(button12, 4, 1);
		pane1.add(button13, 5, 1);
		pane1.add(button14, 6, 1);


		pane1.add(button15, 0, 2);
		pane1.add(button16, 1, 2);
		pane1.add(button17, 2, 2);
		pane1.add(button18, 3, 2);
		pane1.add(button19, 4, 2);
		pane1.add(button21, 5, 2);
		pane1.add(button22, 6, 2);

		pane1.add(button23, 0, 3);
		pane1.add(button24, 1, 3);
		pane1.add(button25, 2, 3);
		pane1.add(button26, 3, 3);
		pane1.add(button27, 4, 3);
		pane1.add(button28, 5, 3);
		pane1.add(button29, 6, 3);

		pane1.add(button30, 0, 4);
		pane1.add(button31, 1, 4);
		pane1.add(button32, 2, 4);
		pane1.add(button33, 3, 4);
		pane1.add(button34, 4, 4);
		pane1.add(button35, 5, 4);
		pane1.add(button36, 6, 4);
		

		HBox hbeq=new HBox();
		hbeq.setAlignment(Pos.BASELINE_CENTER);
		Button ButtunEq=new Button("=");
		ButtunEq.setPrefSize(700, 50);ButtunEq.setFont(Font.font(40));
		hbeq.getChildren().add(ButtunEq);
		/////////////////////////////////////
		VBox hT=new VBox();
		hT.setSpacing(30);
		hT.setPrefWidth(100);
		hT.setPrefHeight(200);
		hT. setAlignment(Pos.BASELINE_CENTER);
		
		Expression.setPrefWidth(5);
		
		ButtunEq.setOnAction(e -> {
			String name = Expression.getText();
			
			String sum="";
			int counter=0;
			for(int i=0;i<name.length();i++) {
				if(name.charAt(i)=='*'||name.charAt(i)=='+'||name.charAt(i)=='/'||name.charAt(i)=='-') {
					if(name.charAt(i+1)=='*'||name.charAt(i+1)=='+'||name.charAt(i+1)=='/'||name.charAt(i+1)=='-') {
						counter++;
						
					}
				}
			}
			if(counter!=0) {
				System.out.println("Error: Missing ");
				return;
			}
			
			
			for(int  i=0;i<name.length();i++) {

				int n=name.charAt(i)-48;
				
				if(n>=0&&n<=9) {
					sum=sum+name.charAt(i);
					if(i<name.length()-1) {
					int m=name.charAt(i+1)-48;
					
					if(m>=0&&m<=9) {
						
					sum=sum+name.charAt(i+1);
					i++;
					continue;
					}
					else {
						
						continue;
					}
					
					}
				}
				else if(name.charAt(i)=='.') {
					sum=sum+name.charAt(i);
				}
				else if(name.charAt(i)=='(') {
					sum=sum+name.charAt(i)+",";
				}
				else if(name.charAt(i)==')') {
					sum=sum+","+name.charAt(i);
				}
				else {
					sum=sum+","+name.charAt(i)+",";
				}
			}
			
			
			
			String [] arr=sum.split(",");
			String la=ar.infexToPostFix(arr);
			Postfix.setText(la);
			System.out.println(la);
			if(la.equals("Error: Missing parentheses")) {
				System.out.println(la);
			}
			else {
				
				Result.setText(ar.postFixedToEvaluiton(la) + "");
				System.out.println(ar.postFixedToEvaluiton(la));
			}

			
		});

		hT.getChildren().addAll(Expression,Postfix,Result);
		root.setCenter(pane1) ;
		root.setBottom(hbeq);
		root.setTop(hT);

		label1.setPrefSize(30, 40);
		label1.setFont(Font.font(5));
		label1.setTextAlignment(TextAlignment.LEFT);
		//VBox pane2=new VBox(label1);
		//pane2.setAlignment(Pos.BASELINE_LEFT);

		VBox pane = new VBox(10, label1, root);

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

