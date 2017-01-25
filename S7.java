/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Stiv
 */
public class S7 extends Application {

    private ImageView pic1;
    private ImageView pic2;
    private ImageView pic3;
    private ImageView pic4;
    private ImageView pic5;
    private ImageView pic6;
    private ImageView pic7;
    private ImageView pic8;
    private ImageView pic9;
    private FadeTransition fadeTransition;
    private double orgScreenX, orgScreenY;
    private double orgTranslateX, orgTranslateY;

    File file = new File("Preferences.txt");

    double pic5x = 0;
    double pic5y = 0;
    double pic7x = 0;
    double pic7y = 0;
    double pic4x = 0;
    double pic4y = 0;
    double pic8x = 0;
    double pic8y = 0;
    double pic6x = 0;
    double pic6y = 0;
    double pic9x = 0;
    double pic9y = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        Runtime j = Runtime.getRuntime();

        Pane g = new Pane();
        g.setStyle("-fx-background-color: transparent;");

        Scene myScene = new Scene(g);

        primaryStage.setScene(myScene);
        myScene.setFill(null);

        try {
            Scanner scanner = new Scanner(file);
            pic5x = Double.parseDouble(scanner.nextLine());
            pic5y = Double.parseDouble(scanner.nextLine());
            pic7x = Double.parseDouble(scanner.nextLine());
            pic7y = Double.parseDouble(scanner.nextLine());
            pic4x = Double.parseDouble(scanner.nextLine());
            pic4y = Double.parseDouble(scanner.nextLine());
            pic8x = Double.parseDouble(scanner.nextLine());
            pic8y = Double.parseDouble(scanner.nextLine());
            pic6x = Double.parseDouble(scanner.nextLine());
            pic6y = Double.parseDouble(scanner.nextLine());
            pic9x = Double.parseDouble(scanner.nextLine());
            pic9y = Double.parseDouble(scanner.nextLine());

            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.printf("Error: %s\n", ex);

        }

        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(4);
        innerShadow.setOffsetY(4);
        innerShadow.setColor(Color.WHITE);

        Text text5 = new Text("LOG OFF");
        text5.setX(215 + pic5x);
        text5.setY(103 + pic5y);
        text5.setFill(Color.YELLOW);
        text5.setEffect(innerShadow);
        text5.setFont(Font.font("ARIAL BOLD", FontWeight.BOLD, 13));
        text5.setOpacity(-1.0);

        Text text3 = new Text("LOG OFF");
        text3.setX(215 + pic5x);
        text3.setY(103 + pic5y);
        text3.setFill(Color.YELLOW);
        text3.setFont(Font.font("ARIAL BOLD", FontWeight.BOLD, 13));
        text3.setOpacity(-1.0);

        pic5 = new ImageView(new Image(S7.class.getResourceAsStream("images/k.png")));
        pic5.setFitHeight(75);
        pic5.setFitWidth(75);
        pic5.setX(200 + pic5x);
        pic5.setY(10 + pic5y);
        pic5.setEffect(new Reflection());

        pic5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    j.exec("shutdown -l");
                } catch (IOException ex) {
                    Logger.getLogger(S7.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        pic5.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pic7.setOpacity(1.0);
                pic5.setOpacity(-1.0);
                pic3.setOpacity(1.0);
                text3.setOpacity(1.0);
                text5.setOpacity(1.0);

            }
        });
        pic5.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pic5.setOpacity(1.0);
                pic3.setOpacity(-1.0);
                text3.setOpacity(-1.0);
                text5.setOpacity(-1.0);

            }
        });

        pic3 = new ImageView(new Image(S7.class.getResourceAsStream("images/kG1.png")));
        pic3.setFitHeight(80);
        pic3.setFitWidth(80);
        pic3.xProperty().bind(pic5.xProperty());
        pic3.yProperty().bind(pic5.yProperty());
        pic3.setEffect(new Reflection());

        pic3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pic7.setOpacity(1.0);

            }
        });

        pic3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    j.exec("shutdown -l");
                } catch (IOException ex) {
                    Logger.getLogger(S7.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        pic3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pic3.setOpacity(-1.0);
                pic5.setOpacity(1.0);
                text3.setOpacity(-1.0);
                text5.setOpacity(-1.0);

            }
        });

        Text text = new Text("SHUTDOWN");
        text.setX(12 + pic4x);
        text.setY(103 + pic4y);
        text.setFill(Color.RED);
        text.setEffect(innerShadow);
        text.setFont(Font.font("ARIAL BOLD", FontWeight.BOLD, 13));
        text.setOpacity(-1.0);

        Text text1 = new Text("SHUTDOWN");
        text1.setX(12 + pic4x);
        text1.setY(103 + pic4y);
        text1.setFill(Color.RED);
        text1.setFont(Font.font("ARIAL BOLD", FontWeight.BOLD, 13));
        text1.setOpacity(-1.0);

        pic4 = new ImageView(new Image(S7.class.getResourceAsStream("images/bb111.png")));
        pic4.setFitHeight(70);
        pic4.setFitWidth(80);
        pic4.setX(10 + pic4x);
        pic4.setY(10 + pic4y);
        pic4.setEffect(new Reflection());

        pic4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    j.exec("shutdown -s -t 0");
                } catch (IOException ex) {
                    Logger.getLogger(S7.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        pic4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pic8.setOpacity(1.0);
                pic4.setOpacity(-1.0);
                pic2.setOpacity(1.0);
                text.setOpacity(1.0);
                text1.setOpacity(1.0);

            }
        });
        pic4.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pic4.setOpacity(1.0);
                pic2.setOpacity(-1.0);
                text.setOpacity(-1.0);
                text1.setOpacity(-1.0);

            }
        });

        pic2 = new ImageView(new Image(S7.class.getResourceAsStream("images/bb112.png")));
        pic2.setFitHeight(70);
        pic2.setFitWidth(80);
        pic2.xProperty().bind(pic4.xProperty());
        pic2.yProperty().bind(pic4.yProperty());
        pic2.setEffect(new Reflection());
        pic2.setOpacity(-1.0);

        pic2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    j.exec("shutdown -s -t 0");
                } catch (IOException ex) {
                    Logger.getLogger(S7.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pic2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pic4.setOpacity(1.0);
                pic2.setOpacity(-1.0);
                text.setOpacity(-1.0);
                text1.setOpacity(-1.0);

            }
        });

        Text text6 = new Text("RESTART");
        text6.setX(120 + pic6x);
        text6.setY(103 + pic6y);
        text6.setFill(Color.GREEN);
        text6.setEffect(innerShadow);
        text6.setFont(Font.font("ARIAL BOLD", FontWeight.BOLD, 13));
        text6.setOpacity(-1.0);

        Text text7 = new Text("RESTART");
        text7.setX(120 + pic6x);
        text7.setY(103 + pic6y);
        text7.setFill(Color.GREEN);
        text7.setFont(Font.font("ARIAL BOLD", FontWeight.BOLD, 13));
        text7.setOpacity(-1.0);

        pic6 = new ImageView(new Image(S7.class.getResourceAsStream("images/jj.png")));
        pic6.setFitHeight(70);
        pic6.setFitWidth(70);
        pic6.setX(106 + pic6x);
        pic6.setY(10 + pic6y);
        pic6.setEffect(new Reflection());

        pic6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    j.exec("shutdown -r -t 0");
                } catch (IOException ex) {
                    Logger.getLogger(S7.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        pic6.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pic9.setOpacity(1.0);
                pic6.setOpacity(-1.0);
                pic1.setOpacity(1.0);
                text7.setOpacity(1.0);
                text6.setOpacity(1.0);

            }
        });
        pic6.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pic6.setOpacity(1.0);
                pic1.setOpacity(-1.0);
                text7.setOpacity(-1.0);
                text6.setOpacity(-1.0);

            }
        });

        pic1 = new ImageView(new Image(S7.class.getResourceAsStream("images/jjG1.png")));
        pic1.setFitHeight(75);
        pic1.setFitWidth(75);
        pic1.xProperty().bind(pic6.xProperty());
        pic1.yProperty().bind(pic6.yProperty());
        pic1.setEffect(new Reflection());

        pic1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                try {
                    j.exec("shutdown -r -t 0");
                } catch (IOException ex) {
                    Logger.getLogger(S7.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        pic1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pic6.setOpacity(1.0);
                pic1.setOpacity(-1.0);
                text7.setOpacity(-1.0);
                text6.setOpacity(-1.0);

            }
        });

        Glow glow = new Glow();
        glow.setLevel(20.20);

        pic7 = new ImageView(new Image(S7.class.getResourceAsStream("images/move.png")));
        pic7.setFitHeight(40);
        pic7.setFitWidth(40);
        pic7.setX(270 + pic5x);
        pic7.setY(0 + pic5y);
        pic7.setOpacity(-1.0);

        pic7.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                pic7.setOpacity(1.0);

            }
        });

        pic7.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                orgScreenX = t.getScreenX();
                orgScreenY = t.getScreenY();
                orgTranslateX = ((ImageView) (t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView) (t.getSource())).getTranslateY();

            }
        });

        pic7.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getScreenX() - orgScreenX;
                double offsetY = t.getScreenY() - orgScreenY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;
                ((ImageView) (pic5)).setTranslateX(newTranslateX);
                ((ImageView) (pic5)).setTranslateY(newTranslateY);
                ((ImageView) (pic3)).setTranslateX(newTranslateX);
                ((ImageView) (pic3)).setTranslateY(newTranslateY);
                ((ImageView) (pic7)).setTranslateX(newTranslateX);
                ((ImageView) (pic7)).setTranslateY(newTranslateY);
                ((ImageView) (t.getSource())).setTranslateX(newTranslateX);
                ((ImageView) (t.getSource())).setTranslateY(newTranslateY);
                ((Text) (text5)).setTranslateX(newTranslateX);
                ((Text) (text5)).setTranslateY(newTranslateY);
                ((Text) (text3)).setTranslateX(newTranslateX);
                ((Text) (text3)).setTranslateY(newTranslateY);

                pic5.getX();
                pic5.getY();
                pic3.getX();
                pic3.getX();
                pic7.getX();
                pic7.getY();
                text5.getX();
                text3.getY();

            }
        });

        pic7.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                try {
                    PrintWriter output = new PrintWriter("Preferences.txt");

                    output.println((pic5.getX() + ((pic5)).getTranslateX()) - 200);
                    output.println((pic5.getY() + ((pic5)).getTranslateY()) - 10);

                    output.println((pic7.getX() + ((pic7)).getTranslateX()));
                    output.println((pic7.getY() + ((pic7)).getTranslateY()));

                    output.println((pic4.getX() + ((pic4)).getTranslateX()) - 10);
                    output.println((pic4.getY() + ((pic4)).getTranslateY()) - 10);

                    output.println((pic8.getX() + ((pic8)).getTranslateX()));
                    output.println((pic8.getY() + ((pic8)).getTranslateY()));

                    output.println((pic6.getX() + ((pic6)).getTranslateX()) - 106);
                    output.println((pic6.getY() + ((pic6)).getTranslateY()) - 10);

                    output.println((pic9.getX() + ((pic9)).getTranslateX()));
                    output.println((pic9.getY() + ((pic9)).getTranslateY()));

                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(S7.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        pic7.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                pic7.setEffect(null);
                FadeTransition fadeTrasition = new FadeTransition(Duration.seconds(2), pic7);
                fadeTrasition.setFromValue(1.0);
                fadeTrasition.setToValue(-1.0);
                fadeTrasition.play();
            }
        });

        pic8 = new ImageView(new Image(S7.class.getResourceAsStream("images/move.png")));
        pic8.setFitHeight(40);
        pic8.setFitWidth(40);
        pic8.setX(80 + pic4x);
        pic8.setY(0 + pic4y);
        pic8.setOpacity(-1.0);

        pic8.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                pic8.setOpacity(1.0);

            }
        });

        pic8.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                orgScreenX = t.getScreenX();
                orgScreenY = t.getScreenY();
                orgTranslateX = ((ImageView) (t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView) (t.getSource())).getTranslateY();
            }
        });

        pic8.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getScreenX() - orgScreenX;
                double offsetY = t.getScreenY() - orgScreenY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;
                ((ImageView) (pic4)).setTranslateX(newTranslateX);
                ((ImageView) (pic4)).setTranslateY(newTranslateY);
                ((ImageView) (pic2)).setTranslateX(newTranslateX);
                ((ImageView) (pic2)).setTranslateY(newTranslateY);
                ((ImageView) (t.getSource())).setTranslateX(newTranslateX);
                ((ImageView) (t.getSource())).setTranslateY(newTranslateY);
                ((Text) (text)).setTranslateX(newTranslateX);
                ((Text) (text)).setTranslateY(newTranslateY);
                ((Text) (text1)).setTranslateX(newTranslateX);
                ((Text) (text1)).setTranslateY(newTranslateY);

                pic4.getX();
                pic4.getY();
                pic8.getX();
                pic8.getY();
                text.getX();
                text1.getY();
            }
        });
        pic8.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                try {
                    PrintWriter output = new PrintWriter("Preferences.txt");

                    output.println((pic5.getX() + ((pic5)).getTranslateX()) - 200);
                    output.println((pic5.getY() + ((pic5)).getTranslateY()) - 10);

                    output.println((pic7.getX() + ((pic7)).getTranslateX()));
                    output.println((pic7.getY() + ((pic7)).getTranslateY()));

                    output.println((pic4.getX() + ((pic4)).getTranslateX()) - 10);
                    output.println((pic4.getY() + ((pic4)).getTranslateY()) - 10);

                    output.println((pic8.getX() + ((pic8)).getTranslateX()));
                    output.println((pic8.getY() + ((pic8)).getTranslateY()));

                    output.println((pic6.getX() + ((pic6)).getTranslateX()) - 106);
                    output.println((pic6.getY() + ((pic6)).getTranslateY()) - 10);

                    output.println((pic9.getX() + ((pic9)).getTranslateX()));
                    output.println((pic9.getY() + ((pic9)).getTranslateY()));

                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(S7.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        pic8.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                pic8.setEffect(null);
                FadeTransition fadeTrasition = new FadeTransition(Duration.seconds(2), pic8);
                fadeTrasition.setFromValue(1.0);
                fadeTrasition.setToValue(-1.0);
                fadeTrasition.play();
            }
        });

        pic9 = new ImageView(new Image(S7.class.getResourceAsStream("images/move.png")));
        pic9.setFitHeight(40);
        pic9.setFitWidth(40);
        pic9.setX(166 + pic6x);
        pic9.setY(0 + pic6y);
        pic9.setOpacity(-1.0);

        pic9.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                pic9.setOpacity(1.0);

            }
        });

        pic9.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                orgScreenX = t.getScreenX();
                orgScreenY = t.getScreenY();
                orgTranslateX = ((ImageView) (t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView) (t.getSource())).getTranslateY();
            }
        });

        pic9.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getScreenX() - orgScreenX;
                double offsetY = t.getScreenY() - orgScreenY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;
                ((ImageView) (pic6)).setTranslateX(newTranslateX);
                ((ImageView) (pic6)).setTranslateY(newTranslateY);
                ((ImageView) (pic1)).setTranslateX(newTranslateX);
                ((ImageView) (pic1)).setTranslateY(newTranslateY);
                ((ImageView) (t.getSource())).setTranslateX(newTranslateX);
                ((ImageView) (t.getSource())).setTranslateY(newTranslateY);
                ((Text) (text6)).setTranslateX(newTranslateX);
                ((Text) (text6)).setTranslateY(newTranslateY);
                ((Text) (text7)).setTranslateX(newTranslateX);
                ((Text) (text7)).setTranslateY(newTranslateY);

                pic6.getX();
                pic6.getY();
                pic9.getX();
                pic9.getY();
                text6.getX();
                text7.getY();

            }
        });

        pic9.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                try {
                    PrintWriter output = new PrintWriter("Preferences.txt");

                    output.println((pic5.getX() + ((pic5)).getTranslateX()) - 200);
                    output.println((pic5.getY() + ((pic5)).getTranslateY()) - 10);

                    output.println((pic7.getX() + ((pic7)).getTranslateX()));
                    output.println((pic7.getY() + ((pic7)).getTranslateY()));

                    output.println((pic4.getX() + ((pic4)).getTranslateX()) - 10);
                    output.println((pic4.getY() + ((pic4)).getTranslateY()) - 10);

                    output.println((pic8.getX() + ((pic8)).getTranslateX()));
                    output.println((pic8.getY() + ((pic8)).getTranslateY()));

                    output.println((pic6.getX() + ((pic6)).getTranslateX()) - 106);
                    output.println((pic6.getY() + ((pic6)).getTranslateY()) - 10);

                    output.println((pic9.getX() + ((pic9)).getTranslateX()));
                    output.println((pic9.getY() + ((pic9)).getTranslateY()));

                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(S7.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        pic9.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                pic9.setEffect(null);

                FadeTransition fadeTrasition = new FadeTransition(Duration.seconds(2), pic9);
                fadeTrasition.setFromValue(1.0);
                fadeTrasition.setToValue(-1.0);
                fadeTrasition.play();

            }

        });
        g.getChildren().addAll(pic1, pic3, pic6, pic5, pic2, pic4, pic7, pic8, pic9,
                (text1), (text), (text3), (text5), (text7), (text6));
        primaryStage.setMaximized(true);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
