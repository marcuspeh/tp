package seedu.awe.ui.listener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import seedu.awe.ui.UiView;
import seedu.awe.ui.ViewPanel;

public class GroupButtonListener implements EventHandler<ActionEvent> {

    private ViewPanel viewPanel;

    public GroupButtonListener(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {
        viewPanel.toggleView(UiView.GROUP_PAGE);
    }
}