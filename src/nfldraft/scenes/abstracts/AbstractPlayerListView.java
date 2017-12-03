/**
 * Program: NFLDraft
 * File: AbstractPlayerListView.java
 * Summary:
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes.abstracts;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import nfldraft.classes.NFLPlayer;
import nfldraft.interfaces.HasPlayers;
import nfldraft.managers.NFLPlayerManager;
import nfldraft.managers.TeamManager;

public abstract class AbstractPlayerListView extends AbstractScene {

    protected Text rosterStatOne = new Text("N/A");
    protected Text rosterStatTwo = new Text("N/A");
    protected Text rosterStatThree = new Text("N/A");
    protected Text rosterStatFour = new Text("N/A");
    protected Text rosterStatFive = new Text("N/A");
    protected Label currentRosterLabel = new Label("Current Roster");
    protected Label teamLabel = new Label("Team: ");
    protected Label positionLabel = new Label("Player Position: ");
    protected Label statsLabel = new Label("Player Stats:");
    protected VBox rosterVBox = new VBox(20);
    protected VBox rightVbox = new VBox(20);
    protected ListView roster;
    protected Text message;

    public AbstractPlayerListView(Stage window, String windowName, TeamManager teamManager, NFLPlayerManager playerManager) {
        super(window, windowName, teamManager, playerManager);
    }

    protected final void createScene(HasPlayers hasPlayers) {
        createRosterView(hasPlayers);
        createRightVbox();
        addRosterActionListener();
        createMessageView();
    }

    protected final void createRosterView(HasPlayers hasPlayers) {
        rosterVBox.setPadding(new Insets(10));
        rosterVBox.setAlignment(Pos.TOP_LEFT);
        rosterVBox.prefWidth(200);
        rosterVBox.prefHeight(400);

        currentRosterLabel.setFont(new Font(16));
        rosterVBox.getChildren().add(currentRosterLabel);

        roster = new ListView();
        roster.prefHeight(430);
        roster.prefWidth(200);

        updateRosterList(hasPlayers);;
        rosterVBox.getChildren().add(roster);

        content.getChildren().add(rosterVBox);
    }

    protected final void updateRosterList(HasPlayers hasPlayers) {
        ObservableList<NFLPlayer> items = FXCollections.observableList(hasPlayers.getPlayers());
        roster.getItems().clear();
        roster.getItems().addAll(items);
    }

    protected final void createRightVbox() {
        rightVbox.setPadding(new Insets(10));
        rightVbox.prefHeight(430);
        rightVbox.prefWidth(400);
        rightVbox.setAlignment(Pos.TOP_LEFT);
        statsLabel.setFont(new Font(14));
        rightVbox.setAlignment(Pos.TOP_LEFT);
        positionLabel.setFont(new Font(14));
        HBox statsHbox = new HBox();
        statsHbox.setAlignment(Pos.TOP_RIGHT);
        statsHbox.prefHeight(320);
        statsHbox.prefWidth(430);
        GridPane statsGrid = new GridPane();
        statsGrid.setPadding(new Insets(10));
        statsGrid.setVgap(50);
        statsGrid.setHgap(75);
        statsGrid.prefHeight(320);
        statsGrid.prefWidth(430);
        statsGrid.add(rosterStatOne, 0, 0);
        statsGrid.add(rosterStatTwo, 1, 0);
        statsGrid.add(rosterStatThree, 0, 1);
        statsGrid.add(rosterStatFour, 1, 1);
        statsGrid.add(rosterStatFive, 0, 2);

        statsHbox.getChildren().add(statsGrid);

        addActions();
        rightVbox.getChildren().add(teamLabel);
        rightVbox.getChildren().add(positionLabel);
        rightVbox.getChildren().add(statsLabel);
        rightVbox.getChildren().add(statsHbox);
        content.getChildren().add(rightVbox);
    }

    protected final void addRosterActionListener() {
        roster.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<NFLPlayer>() {
            @Override
            public void changed(ObservableValue<? extends NFLPlayer> observable, NFLPlayer oldValue, NFLPlayer newValue) {
                if (newValue != null) {
                    teamLabel.setText("Team: " + ((newValue.getTeam() != null) ? newValue.getTeam() : "N/A"));
                    positionLabel.setText("Player Position: " + newValue.getPositionType());
                    AtomicInteger i = new AtomicInteger(1);
                    for (Map.Entry<String, Integer> stat : newValue.getStats().entrySet()) {
                        switch (i.get()) {
                            case 1:
                                rosterStatOne.setText(stat.getKey() + ": " + stat.getValue().toString());
                                break;
                            case 2:
                                rosterStatTwo.setText(stat.getKey() + ": " + stat.getValue().toString());
                                break;
                            case 3:
                                rosterStatThree.setText(stat.getKey() + ": " + stat.getValue().toString());
                                break;
                            case 4:
                                rosterStatFour.setText(stat.getKey() + ": " + stat.getValue().toString());
                                break;
                            case 5:
                                rosterStatFive.setText(stat.getKey() + ": " + stat.getValue().toString());
                                break;
                        }
                        i.getAndIncrement();
                    }
                    enableButtons();
                } else {
                    teamLabel.setText("Team: " + "N/A");
                    positionLabel.setText("Player Position: ");
                    rosterStatOne.setText("N/A");
                    rosterStatTwo.setText("N/A");
                    rosterStatThree.setText("N/A");
                    rosterStatFour.setText("N/A");
                    rosterStatFive.setText("N/A");
                    disableButtons();
                }
            }
        });
    }

    protected void createMessageView() {
        message = new Text();
        root.getChildren().add(message);
    }

    public void setMessage(String incomingMessage) {
        message.setText(incomingMessage);
    }

    abstract protected void addActions();
    abstract protected void disableButtons();
    abstract protected void enableButtons();
}
