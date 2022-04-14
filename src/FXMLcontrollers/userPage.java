package FXMLcontrollers;

import java.io.File;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ourFilesTM.Album;
import ourFilesTM.Photo;

public class userPage {
	@FXML VBox vbox; 
	@FXML GridPane gridPane;
	
	private File file;
	private Album root;
	
	/*Initializing*/
	public void init(File file) throws Exception{
		//User has been created for the first
		//time and requires a root directory
		this.file = file;
		root = new Album("/");
		loadDir();
	}
	public void init(File file, Album root) throws Exception{
		//TODO Work on this when serialization
		//is setup
		//User has already used the program
		this.file = file;
		this.root = root;
		loadDir();
	}
	
	public void loadDir() throws Exception {
		String dirPath = System.getProperty("user.dir");
		File dir = new File(dirPath + "/stockPhotos");
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			Photo photo = new Photo(files[i]);
			root.addFile(photo);
		}
		
		for (int i = 0; i < root.getDir().size(); i++) {
			if (i % 5 == 0 && i != 0) {
				
			}
			
			Object object = root.getFile(i);
			VBox vbox = new VBox(); 
			//vbox.setPrefWidth(10);
			//vbox.setPrefHeight(10);
			if (object instanceof Album) {
				Album album 	 	= (Album) object;
				ImageView imageview = new ImageView(album.getFileImage());
				Label label 		= new Label(album.getFileName());
				vbox.getChildren().addAll(imageview, label);
			} else {
				System.out.println(object);
				Photo photo 		= (Photo) object;
				ImageView imageview = new ImageView(photo.getFileImage());
				Label label 		= new Label(photo.getFileName());
				vbox.getChildren().addAll(imageview, label);
			}
			FlowPane.getChildren().add(vbox);
		}
		
		/*
		//ObservableList list = FlowPane.getChildren();
		//FlowPane.setMargin(vbox, new Insets(20, 0, 20, 20));
		for (int i = 0; i < root.getDir().size(); i++) {
			Object object = root.getFile(i);
			VBox vbox = new VBox(); 
			//vbox.setPrefWidth(10);
			//vbox.setPrefHeight(10);
			if (object instanceof Album) {
				Album album 	 	= (Album) object;
				ImageView imageview = new ImageView(album.getFileImage());
				Label label 		= new Label(album.getFileName());
				vbox.getChildren().addAll(imageview, label);
			} else {
				System.out.println(object);
				Photo photo 		= (Photo) object;
				ImageView imageview = new ImageView(photo.getFileImage());
				Label label 		= new Label(photo.getFileName());
				vbox.getChildren().addAll(imageview, label);
			}
			FlowPane.getChildren().add(vbox);
		}
		*/
	}	
	
	/*Task Bar; Handling buttons in File*/
	@FXML public void file_CreateAlbum (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void file_AddPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void file_DeleteSelected (ActionEvent Event) {
		//TODO Add functionality
	}
	
	/*Rest of Task Bar*/
	@FXML public void rename (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void editPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void viewPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void searchPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void scrollLeft (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void scrollRight (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void logout (ActionEvent Event) {
		//TODO Add functionality
	}
}

//Scrap Code
/*
for (int i = 0; i < root.getDir().size(); i++) {
	//TODO Not required?
	FXMLLoader FXMLLoader = new FXMLLoader(
		getClass().getResource("../FXML/thumbnail.fxml")
	);
	Parent parent = FXMLLoader.load();
	
	Object object = root.getFile(i); 
	thumbnail thumbnail = new thumbnail();
	if (object instanceof Album) {
		thumbnail.init((Album) object);
	} else {
		thumbnail.init((Photo) object);
	}	
}


FXMLLoader FXMLLoader = new FXMLLoader(
		getClass().getResource("../FXML/thumbnail.fxml")
	);
	FXMLLoader.load();
	
	thumbnail thumbnail = new thumbnail();
	if (object instanceof Album) {
		thumbnail.init((Album) object);
	} else {
		thumbnail.init((Photo) object);
	}
	FlowPane.getChildren().add(thumbnail.getPane());
*/