package com.builtbroken.picsort.fx;

import com.builtbroken.picsort.FxAPP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Handles most of the interaction and commands for the main application window
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 9/14/2016.
 */
public class Controller
{
    @FXML
    public void exit(ActionEvent event)
    {
        //TODO save any progress before existing
        System.exit(0);
    }

    @FXML
    public void minimize(ActionEvent event)
    {
        //TODO code up a system tray icon/process
        FxAPP.primaryStage.setIconified(true);
    }

    @FXML
    public void expand(ActionEvent event)
    {
        FxAPP.primaryStage.setMaximized(!FxAPP.primaryStage.isMaximized());
    }

    @FXML
    public void console(ActionEvent event)
    {
        //TODO open program's main console
    }

    @FXML
    public void settings(ActionEvent event)
    {
        //TODO open settings panel
    }
}
