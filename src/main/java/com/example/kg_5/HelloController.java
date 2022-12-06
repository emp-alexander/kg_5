package com.example.kg_5;

import javafx.embed.swing.SwingFXUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class HelloController {

    public Button reserButton;
    @FXML
    private ImageView image;
    CategoryAxis x = new CategoryAxis();
    NumberAxis y = new NumberAxis();
    public BarChart barChart1;
    private BufferedImage currentImage;
    private Stage stage;

    @FXML
    public void openImage() throws IOException {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png",
                "*.jpg", "*.gif"));

        final File selectedFile = fileChooser.showOpenDialog(stage);
        currentImage = ImageIO.read(selectedFile);
        image.setImage(SwingFXUtils.toFXImage(currentImage, null));
    }
    @FXML
    public void lightPlus(){
        int inc = 20;
        for(int y = 0; y < currentImage.getHeight(); y++){
            for(int x = 0; x < currentImage.getWidth(); x++){
                Color color = new Color(currentImage.getRGB(x, y));
                int red = (color.getRed() + inc) > 255?  255 :  (color.getRed() + inc);
                int green = (color.getGreen() + inc) > 255?  255 :  (color.getGreen() + inc);
                int blue = (color.getBlue() + inc) > 255?  255 :  (color.getBlue() + inc);
                Color res = new Color(red, green, blue);
                currentImage.setRGB(x, y, res.getRGB());
            }
        }
        image.setImage(SwingFXUtils.toFXImage(currentImage, null));
        printChart();
    }

    @FXML
    public void lightMinus(){
        int inc = 20;
        for(int y = 0; y < currentImage.getHeight(); y++){
            for(int x = 0; x < currentImage.getWidth(); x++){
                Color color = new Color(currentImage.getRGB(x, y));
                int red = (color.getRed() - inc) < 0?  0 :  (color.getRed() - inc);
                int green = (color.getGreen() - inc) < 0?  0 :  (color.getGreen() - inc);
                int blue = (color.getBlue() - inc) < 0?  0 :  (color.getBlue() - inc);
                Color res = new Color(red, green, blue);
                currentImage.setRGB(x, y, res.getRGB());
            }
        }
        image.setImage(SwingFXUtils.toFXImage(currentImage, null));
        printChart();
    }

    @FXML
    public void contrMinus(){
        int rAvg = 0;
        int gAvg = 0;
        int bAvg = 0;

        for(int y = 0; y < currentImage.getHeight(); y++){
            for(int x = 0; x < currentImage.getWidth(); x++) {
                Color color = new Color(currentImage.getRGB(x, y));
                rAvg += color.getRed();
                gAvg += color.getGreen();
                bAvg += color.getBlue();
            }
        }
        rAvg /= currentImage.getHeight() * currentImage.getWidth();
        gAvg /= currentImage.getHeight() * currentImage.getWidth();
        bAvg /= currentImage.getHeight() * currentImage.getWidth();

        double k = 0.5;
        for(int y = 0; y < currentImage.getHeight(); y++) {
            for (int x = 0; x < currentImage.getWidth(); x++) {
                Color color = new Color(currentImage.getRGB(x, y));
                int red = (int) (k * (color.getRed() - rAvg) + rAvg);
                if(red < 0)
                    red = 0;
                else{
                    if(red > 255){
                        red = 255;
                    }
                }
                int green = (int) (k * (color.getGreen() - gAvg) + gAvg);
                if(green < 0)
                    green = 0;
                else{
                    if(green > 255){
                        green = 255;
                    }
                }
                int blue = (int) (k * (color.getBlue() - bAvg) + bAvg);
                if(blue < 0)
                    blue = 0;
                else{
                    if(blue > 255){
                        blue = 255;
                    }
                }
                Color res = new Color(red, green, blue);
                currentImage.setRGB(x, y, res.getRGB());
            }
        }
        image.setImage(SwingFXUtils.toFXImage(currentImage, null));
        printChart();
    }

    @FXML
    public void contrPlus(){
        int rAvg = 0;
        int gAvg = 0;
        int bAvg = 0;

        for(int y = 0; y < currentImage.getHeight(); y++){
            for(int x = 0; x < currentImage.getWidth(); x++) {
                Color color = new Color(currentImage.getRGB(x, y));
                rAvg += color.getRed();
                gAvg += color.getGreen();
                bAvg += color.getBlue();
            }
        }
        rAvg /= currentImage.getHeight() * currentImage.getWidth();
        gAvg /= currentImage.getHeight() * currentImage.getWidth();
        bAvg /= currentImage.getHeight() * currentImage.getWidth();

        double k = 2;
        for(int y = 0; y < currentImage.getHeight(); y++) {
            for (int x = 0; x < currentImage.getWidth(); x++) {
                Color color = new Color(currentImage.getRGB(x, y));
                int red = (int) (k * (color.getRed() - rAvg) + rAvg);
                if(red < 0)
                    red = 0;
                else{
                    if(red > 255){
                        red = 255;
                    }
                }
                int green = (int) (k * (color.getGreen() - gAvg) + gAvg);
                if(green < 0)
                    green = 0;
                else{
                    if(green > 255){
                        green = 255;
                    }
                }
                int blue = (int) (k * (color.getBlue() - bAvg) + bAvg);
                if(blue < 0)
                    blue = 0;
                else{
                    if(blue > 255){
                        blue = 255;
                    }
                }
                Color res = new Color(red, green, blue);
                currentImage.setRGB(x, y, res.getRGB());

            }
        }
        image.setImage(SwingFXUtils.toFXImage(currentImage, null));
        printChart();
    }

    @FXML
    public void blackWhite(){

        int avgL = 0;

        for(int y = 0; y < currentImage.getHeight(); y++){
            for(int x = 0; x < currentImage.getWidth(); x++) {
                Color color = new Color(currentImage.getRGB(x, y));
                avgL += (int)(color.getRed() + color.getGreen() + color.getBlue());
                avgL /= 3;
                avgL = (avgL > 127) ? 255 : 0;
                Color res = new Color(avgL, avgL, avgL);
                currentImage.setRGB(x, y, res.getRGB());
            }
        }


        image.setImage(SwingFXUtils.toFXImage(currentImage, null));
        printChart();
    }

//    public void grey(){
//        for(int y = 0; y < currentImage.getHeight(); y++){
//            for(int x = 0; x < currentImage.getWidth(); x++) {
//                Color color = new Color(currentImage.getRGB(x, y));
//                int light = (int)(color.getRed() + color.getGreen() + color.getBlue())/3;
//                Color res = new Color(light, light, light);
//                currentImage.setRGB(x, y, res.getRGB());
//            }
//        }
//        image.setImage(SwingFXUtils.toFXImage(currentImage, null));
//        printChart();
//    }


    public void negativeClick(){

        for(int y = 0; y < currentImage.getHeight(); y++){
            for(int x = 0; x < currentImage.getWidth(); x++) {
                Color color = new Color(currentImage.getRGB(x, y));
                Color res = new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
                currentImage.setRGB(x, y, res.getRGB());
            }
        }
        image.setImage(SwingFXUtils.toFXImage(currentImage, null));
        printChart();
    }



    public void medianFilter(){
        int size = 3; //сколько раз проити через фильр

        double half = Math.floor(size/2);

        for(int y = 0; y < currentImage.getHeight(); y++){
            for(int x = 0; x < currentImage.getWidth(); x++) {
                int r = 0, g = 0, b = 0;
                for(int fy = 0; fy < size; fy++){
                    for(int fx = 0; fx < size; fx++){
                        double neighborY = Math.min(
                                currentImage.getHeight() - 1, Math.max(0, y + fy - half)
                        );
                        double neighborX = Math.min(
                                currentImage.getWidth() - 1, Math.max(0, x + fx - half)
                        );

                        double inputIndex = (neighborY * currentImage.getWidth() + neighborX) * 3;
//                        r += (int)[inputIndex];
//                        g = inputData[inputIndex + 1];
//                        b = inputData[inputIndex + 2];
                    }
                }
            }
            }


    }

    //лаб 7
    public void scaling(){
        int scale = 2;

        int newHeight = (currentImage.getHeight() * scale);
        int newWidth = (currentImage.getWidth() * scale);
        for(int y = 0; y < currentImage.getHeight(); y++) {
            int topIndex = (int)Math.max(0, Math.min(currentImage.getHeight() - 1, Math.ceil(y / scale)) + 0);
            int bottomIndex = (int)Math.max(0, Math.min(currentImage.getHeight() - 1, Math.floor(y / scale)) + 0);
            for(int x = 0; x < currentImage.getWidth(); x++){
                int leftIndex = (int)Math.max(0, Math.min(currentImage.getWidth() - 1, Math.floor(x / scale)) - 0);
                int rightIndex = (int)Math.max(0, Math.min(currentImage.getWidth() - 1, Math.floor(x / scale)) + 0);
                int red = 0;
                int green = 0;
                int blue = 0;
                for (int i = Math.max(0, topIndex); i >= Math.min(currentImage.getHeight() - 1, bottomIndex); i--) {
                    for(int j = Math.max(0, leftIndex); j >= Math.min(currentImage.getWidth() - 1, rightIndex); j--){
                        Color color = new Color(currentImage.getRGB(i, j));
                        red += color.getRed();
                        green += color.getGreen();
                        blue += color.getBlue();
                    }
                }

                int count = (rightIndex - leftIndex + 1) * (bottomIndex - topIndex + 1);

                Color res = new Color(red/count, green/count, blue/count);
                currentImage.setRGB(x, y, res.getRGB());

            }
        }

    }

    public void printChart(){

        barChart1.getData().clear();
        ArrayList<Integer> light = new ArrayList<>();
        for(int y = 0; y < currentImage.getHeight(); y++){
            for(int x = 0; x < currentImage.getWidth(); x++) {
                Color color = new Color(currentImage.getRGB(x, y));
                light.add((int)(0.299 * color.getRed() + 0.5876 * color.getGreen() + 0.114 * color.getBlue()));
            }
        }

        Map<Integer, Integer> ch = new HashMap<>();
        for(int i = 0; i <= 255; i++){
            ch.put(i, 0);
        }



        int i;
        for(i = 0; i < light.size(); i++){
            ch.put(light.get(i), ch.get(light.get(i))+1);

        }

        x.setLabel("light");
        y.setLabel("count");
        XYChart.Series<String, Integer> ds = new XYChart.Series();
        ds.setName("");
        for(int k = 0; k < ch.size(); k++){
            int tmp = 0;
            if(ch.get(k).intValue() > 10000)
                tmp = 10000;
            else{
                tmp = ch.get(k).intValue();
            }
            ds.getData().add(new XYChart.Data(Integer.toString(k), tmp));
        }
        barChart1.getData().add(ds);

    }


    public void reset(ActionEvent actionEvent) {
        image.setImage(SwingFXUtils.toFXImage(currentImage, null));
    }
}

