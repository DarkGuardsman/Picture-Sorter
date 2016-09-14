package com.builtbroken.picsort;

import com.builtbroken.jlib.lang.StringHelpers;
import com.builtbroken.picsort.fx.Dialogs;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;

/**
 * Main class for the program
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 9/14/2016.
 */
public class FxAPP extends Application
{
    public static final double PREF_WIDTH = 1200;
    public static final double PREF_HEIGHT = 720;

    public static FxAPP instance;
    public static Stage primaryStage;

    public static void main(String[] args)
    {
        try
        {
            launch(args);
        }
        catch (Throwable t)
        {
            //TODO add a logger
            t.printStackTrace();
            JOptionPane.showMessageDialog(null, "The application failed to start. \n" + StringHelpers.toString(t), "Launcher error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        instance = this;
        try
        {
            stage.initStyle(StageStyle.UNDECORATED);

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("assets/fx/Frame.fxml"));
            Parent root = loader.load();
            root.minHeight(PREF_HEIGHT);
            root.minWidth(PREF_WIDTH);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            scene.getStylesheets().add("com/skcraft/launcher/fx/style.css");
            primaryStage = stage;

            //stage.getIcons().add(new Image(FxApp.class.getClassLoader().getResourceAsStream("assets/textures/icon.png")));
            stage.show();

            //TODO load settings
            //TODO load last opened folder
        }
        catch (Throwable t)
        {
            t.printStackTrace();
            Dialogs.showErrorDialog("An unexpected error was thrown during run time.", "Launcher error", t);
        }
    }
}
