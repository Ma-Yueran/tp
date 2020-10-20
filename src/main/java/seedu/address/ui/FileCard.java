package seedu.address.ui;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

/**
 * An UI component that displays information of a {@code File}.
 */
public class FileCard extends UiPart<Region> {

    private static final String FXML = "FileCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final File file;

    @FXML
    private HBox cardPane;
    @FXML
    private Label fileName;

    /**
     * Creates a {@code FileCard} with the given {@code File}.
     */
    public FileCard(File file) {
        super(FXML);
        this.file = file;
        fileName.setText(file.getName());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FileCard)) {
            return false;
        }

        // state check
        FileCard card = (FileCard) other;
        return file.equals(card.file);
    }
}