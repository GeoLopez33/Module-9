package application;
	
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;


public class Main extends Application {

	Stage window;
	 Scene scene1;
	 Scene scene2;
	 
	 static int nextIndex = 0;
		static String[] checkArray = new String[1100];
		
		
		
		/**
		 * Pushes value into checkArray. Used if checkArray doesn't have a given word already in it's list.
		 * @param e Word pulled from String
		 */
		
		public static void push(String e) {
		    checkArray[nextIndex] = e;
		    ++nextIndex;
		}
		
		/**
		 * Searches through checkArray to find position of given word within the array
		 * @param target This is the word to be searched for
		 * @return Position of word in the array as integer
		 */
		
		public static int find(String target)
		{
		    for (int i = 0; i < 500; i++)
		    {

		        if (checkArray[i].equals(target)) {

		        	return i;
		            
		        }
		    }
		 
		    return 0;
		}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		
		String[] FinalArray = new String[20];
		
{
			
			
			//This is the actual code that counts the words
			
			/*First I download the text from the webpage and turn it into a long string
			 */
			
			String raven ="";
			
			try {
				String webPage = "https://www.gutenberg.org/files/1065/1065-h/1065-h.htm";
				URL url = new URL(webPage);
				URLConnection urlConnection = url.openConnection();
				InputStream is = urlConnection.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);

				int numCharsRead;
				char[] charArray = new char[1024];
				StringBuffer sb = new StringBuffer();
				while ((numCharsRead = isr.read(charArray)) > 0) {
					sb.append(charArray, 0, numCharsRead);
				}
				String result = sb.toString();

				raven=result;
				
			} catch (MalformedURLException q) {
				q.printStackTrace();
			} catch (IOException q) {
				q.printStackTrace();
			}
			
			/*This next part removes all unnecessary pieces and symbols from the text*/
			
			String ravena = raven.substring(3167,11430);
			

			
			ravena = ravena.replaceAll("<[^>]*>", "");
			ravena = ravena.replaceAll("â€™", "");
			ravena = ravena.replaceAll("&mdash;", " ");
			ravena = ravena.replaceAll(";", " ");
			ravena = ravena.replaceAll("â€œ", "");
			ravena = ravena.replaceAll("â€", "");

			ravena = ravena.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
			
	
			
			
			String[] ravray = ravena.split(" ");

			
			WordC[] wordArray = new WordC[ravray.length];
			
			for (int i=0; i<=ravray.length-1; i++) {
				wordArray[i]= new WordC("z");
			}

			for (int i=0; i<=ravray.length-1; i++) {

				if (Arrays.asList(checkArray).contains(ravray[i])) {
					wordArray[find(ravray[i])].upCount();

				}
				else {
					wordArray[nextIndex]=new WordC(ravray[i]);
					push(ravray[i]);
				}
			}
			
			/*This last Section goes through the array and should only have one copy of each word*/
			
		

			WordC max= new WordC("");
			
			WordC[] topTw = new WordC[20];
			for (int i=0; i<=19; i++) {
				for (int j=0; j<=nextIndex-1; j++) {
					if (wordArray[j].getCount()>max.getCount()) {
						max=new WordC(wordArray[j].toString(), wordArray[j].getCount());
						
						wordArray[j].setZero();
						
					}
				}

				topTw[i]= new WordC(max.toString(), max.getCount());
				max.setZero();
			}
			for (int i=0; i<=19; i++) {
				
				FinalArray[i]= topTw[i].getCountSS();
			}
			
			
			
			}
			
			
			
		
		
		Label label1=new  Label("When you press this button, I will show you the top twenty\nwords in 'The Raven' poem!");
		Button button1 = new Button ("Let's Go!");
		button1.setOnAction(e -> {
			window.setScene(scene2);});
		
		//Layout 1
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout1, 400, 200);
		
		
		
		
		//Layout 2
		StackPane layout2 = new StackPane();
		Label label2=new  Label(Arrays.toString(FinalArray));
		
		layout2.getChildren().addAll(label2);
		scene2 = new Scene(layout2, 1000, 300);
		
		window.setScene(scene1);
		window.setTitle("Final Result");
		window.show();
		
	}
	}
	

