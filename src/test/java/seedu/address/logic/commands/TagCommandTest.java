package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.TagBuilder;

public class TagCommandTest {

    @Test
    public void constructor_nullTag_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TagCommand(null));
    }

    @Test
    @Disabled
    @Deprecated
    // This test is using the original idea of tagging person.
    public void execute_tagAcceptedByModel_tagSuccessful() throws Exception {
        ModelStubAcceptingTagAdded modelStub = new ModelStubAcceptingTagAdded();
        Tag validTag = new TagBuilder().build();

        CommandResult commandResult = new TagCommand(validTag).execute(modelStub);

        assertEquals(String.format(TagCommand.MESSAGE_SUCCESS, validTag), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validTag), modelStub.tagsAdded);
    }

    @Test
    public void execute_tagAddressFileNotFound_throwsCommandException() {
        Tag tagInvalidAddress = new TagBuilder().withFileAddress("./somewhereOverTheRainbow").build();
        assertThrows(IllegalArgumentException.class, () -> new TagCommand(tagInvalidAddress));
    }

    @Test
    public void execute_duplicateTagName_throwsCommandException() {
        Tag validTag = new TagBuilder().build();
        TagCommand tagCommand = new TagCommand(validTag);
        ModelStub modelStub = new ModelStubWithTag(validTag);

        assertThrows(CommandException.class, TagCommand.MESSAGE_DUPLICATE_TAG, () -> tagCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Tag t1 = new TagBuilder().withTagName("cs2101").build();
        Tag t2 = new TagBuilder().withTagName("cs2103").build();
        TagCommand tagT1Command = new TagCommand(t1);
        TagCommand tagT2Command = new TagCommand(t2);

        // same object -> returns true
        assertTrue(tagT1Command.equals(tagT1Command));

        // same values -> returns true
        TagCommand tagT1CommandCopy = new TagCommand(t1);
        assertTrue(tagT1Command.equals(tagT1CommandCopy));

        // different types -> returns false
        assertFalse(tagT1Command.equals(1));

        // null -> returns false
        assertFalse(tagT1Command.equals(null));
        // different person -> returns false
        assertFalse(tagT1Command.equals(tagT2Command));
    }


}