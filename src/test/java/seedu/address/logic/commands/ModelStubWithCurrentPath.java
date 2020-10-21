package seedu.address.logic.commands;

import seedu.address.model.currentpath.CurrentPath;
import seedu.address.model.currentpath.FileList;

public class ModelStubWithCurrentPath extends ModelStub {

    public static final String CURRENT_PATH = "C:\\Users";

    private CurrentPath currentPath = new CurrentPath(CURRENT_PATH, new FileList());

    @Override
    public CurrentPath getCurrentPath() {
        return currentPath;
    }
}