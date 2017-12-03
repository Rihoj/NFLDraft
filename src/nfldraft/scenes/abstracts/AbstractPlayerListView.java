/**
 * Program: NFLDraft
 * File: AbstractPlayerListView.java
 * Summary: Abstract scene view.
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
import nfldraft.classes.NFLPlayer;
import nfldraft.interfaces.HasPlayers;
import nfldraft.managers.NFLPlayerManager;
import nfldraft.managers.TeamManager;

public abstract class AbstractPlayerListView extends AbstractScene {

    //The first stat to
    protected Text firstPlayerStatLabel = new Text("N/A");
    protected Text secondPlayerStatLabel = new Text("N/A");
    protected Text thirdPlayerStatLabel = new Text("N/A");
    protected Text fourthPlayerStatLabel = new Text("N/A");
    protected Text fifthPlayerStatLabel = new Text("N/A");
    protected Label currentRosterLabel = new Label("Current Roster");
    protected Label teamLabel = new Label("Team: ");
    protected Label positionLabel = new Label("Player Position: ");
    protected Label statsLabel = new Label("Player Stats:");
    protected VBox rosterVBox = new VBox(20);
    protected VBox rightVbox = new VBox(20);
    protected ListView roster;
    protected Text message;

    /**
     * Create the class through the super.
     *
     * @param windowName
     * @param teamManager
     * @param playerManager
     */
    public AbstractPlayerListView(String windowName, TeamManager teamManager, NFLPlayerManager playerManager) {
        super(windowName, teamManager, playerManager);
    }

    /**
     * Create the scene layouts.
     *
     * @param hasPlayers
     */
    protected final void createScene(HasPlayers hasPlayers) {
        createRosterView(hasPlayers);
        createRightVbox();
        addRosterActionListener();
        createMessageView();
    }

    /**
     * Create the roster view layout.
     *
     * @param hasPlayers
     */
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

    /**
     * Update the roster list
     *
     * @param hasPlayers
     */
    protected final void updateRosterList(HasPlayers hasPlayers) {
        ObservableList<NFLPlayer> items = FXCollections.observableList(hasPlayers.getPlayers());
        roster.getItems().clear();
        roster.getItems().addAll(items);
    }

    /**
     * Create the right hand side layout.
     */
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
        statsGrid.add(firstPlayerStatLabel, 0, 0);
        statsGrid.add(secondPlayerStatLabel, 1, 0);
        statsGrid.add(thirdPlayerStatLabel, 0, 1);
        statsGrid.add(fourthPlayerStatLabel, 1, 1);
        statsGrid.add(fifthPlayerStatLabel, 0, 2);

        statsHbox.getChildren().add(statsGrid);

        addActions();
        rightVbox.getChildren().add(teamLabel);
        rightVbox.getChildren().add(positionLabel);
        rightVbox.getChildren().add(statsLabel);
        rightVbox.getChildren().add(statsHbox);
        content.getChildren().add(rightVbox);
    }

    /**
     * Add the action listener to the roster.
     */
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
                                firstPlayerStatLabel.setText(stat.getKey() + ": " + stat.getValue().toString());
                                break;
                            case 2:
                                secondPlayerStatLabel.setText(stat.getKey() + ": " + stat.getValue().toString());
                                break;
                            case 3:
                                thirdPlayerStatLabel.setText(stat.getKey() + ": " + stat.getValue().toString());
                                break;
                            case 4:
                                fourthPlayerStatLabel.setText(stat.getKey() + ": " + stat.getValue().toString());
                                break;
                            case 5:
                                fifthPlayerStatLabel.setText(stat.getKey() + ": " + stat.getValue().toString());
                                break;
                        }
                        i.getAndIncrement();
                    }
                    enableButtons();
                } else {
                    teamLabel.setText("Team: " + "N/A");
                    positionLabel.setText("Player Position: ");
                    firstPlayerStatLabel.setText("N/A");
                    secondPlayerStatLabel.setText("N/A");
                    thirdPlayerStatLabel.setText("N/A");
                    fourthPlayerStatLabel.setText("N/A");
                    fifthPlayerStatLabel.setText("N/A");
                    disableButtons();
                }
            }
        });
    }

    /**
     * Create the message layout.
     */
    protected void createMessageView() {
        message = new Text();
        root.getChildren().add(message);
    }

    /**
     * Set the message for this scene.
     *
     * @param incomingMessage
     */
    public void setMessage(String incomingMessage) {
        message.setText(incomingMessage);
    }

    /**
     * Add action buttons to the scene.
     */
    abstract protected void addActions();

    /**
     * Disable any buttons that can not be used when no player is selected.
     */
    abstract protected void disableButtons();

    /**
     * Enable any buttons that can be used when a player is selected.
     */
    abstract protected void enableButtons();
}
