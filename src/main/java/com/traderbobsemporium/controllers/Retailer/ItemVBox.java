package main.java.com.traderbobsemporium.controllers.Retailer;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.com.traderbobsemporium.model.Item;
import main.java.com.traderbobsemporium.util.LoggingUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @Author Aidan Stewart
 * @Year 2019
 * Copyright (c)
 * All rights reserved.
 */
class ItemVBox extends VBox {
    private Item item;
    private ImageView imageView = new ImageView();

    public ItemVBox(Item item) {
        super();
        this.item = item;
        imageView.setFitWidth(210);
        imageView.setFitHeight(225);
        buildVbox();
    }

    Item getItem() {
        return item;
    }

    private void buildVbox() {
        addChildren();
        setAlignment(Pos.TOP_CENTER);
        setStyle("-fx-background-color: white");
        setSpacing(8);
    }

    private void addChildren(){
        getChildren().add(vBoxTextBuilder(String.valueOf(item.getId())));
        getChildren().add(vBoxTextBuilder("Price: " + String.valueOf(item.getPrice())));
        getChildren().add(vBoxTextBuilder("Quantity: " + String.valueOf(item.getQuantity())));
        getChildren().add(vBoxTextBuilder(item.getName()));
        getChildren().add(imageView);
    }

    private Text vBoxTextBuilder(String data){
        Text text = new Text(data);
        text.setStyle("-fx-font: 20 arial;");
        return text;
    }

    private BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new URL(item.getImageURL()));
        } catch (Exception ex){
            try {
                String path = "/main/java/com/traderbobsemporium/resources/Images/MTC Tree Poster.jpg";
                image = ImageIO.read(getClass().getResourceAsStream(path));
            } catch (IOException e) {
                e.printStackTrace();
                LoggingUtil.logExceptionToFile(e);
            }
        }
        return image;
    }

  void setImage() {
      imageView.setImage(SwingFXUtils.toFXImage(getImage(), null));
  }


}
