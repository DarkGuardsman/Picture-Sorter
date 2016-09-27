package com.builtbroken.picsort.fx;

import com.builtbroken.picsort.FxAPP;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.util.HashMap;

/**
 * Handles opening different dialogs for the app
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 9/14/2016.
 */
public class Dialogs
{
    private static HashMap<Stage, Integer[]> movement = new HashMap();

    public static void showErrorDialog(String message, String title, Throwable error)
    {
        Stage stage = newScene(null, "Error", "dialog/error.fxml");

        stage.showAndWait();
    }

    public static Stage newScene(Window window, String title, String file)
    {
        try
        {
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            Parent root = FXMLLoader.load(Dialogs.class.getClassLoader().getResource("assets/fx/" + file));
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(window == null ? FxAPP.primaryStage : window);
            addMouseMoveStage(stage, root.lookup("#header"));
            return stage;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static void addMouseMoveStage(Stage stage, Node node)
    {
        node.setOnMousePressed(event -> {
            int xOffset = (int) (stage.getX() - event.getScreenX());
            int yOffset = (int) (stage.getY() - event.getScreenY());
            movement.put(stage, new Integer[]{xOffset, yOffset});
        });
        node.setOnMouseDragged(event -> {
            Integer[] in = movement.get(stage);
            if (in != null)
            {
                stage.setX(event.getScreenX() + in[0]);
                stage.setY(event.getScreenY() + in[1]);
            }
        });
    }
}
