package duke;

import duke.command.Command;
import duke.parser.Parser;
import duke.storage.TaskStorage;
import duke.Ui.Ui;
import java.io.FileNotFoundException;

public class Duke {
    // attributes
    private TaskStorage taskStorage;
    private Ui ui;

    public Duke() {
        try {
            this.ui = new Ui();
            this.taskStorage = new TaskStorage("./data/Storage.txt");
        } catch (FileNotFoundException e) {
            System.out.println("./data/Storage.txt");
            System.out.println("File not found");
        }
    }

    public String getResponse(String input) {
        try {
            Command command = Parser.parse(input);
            return command.execute(this.ui, this.taskStorage);
        } catch (Exception e) {
            return this.ui.showErrorMessage(e);
        }

    }
}
