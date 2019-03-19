package seedu.giatros.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.giatros.testutil.TypicalIndexes.INDEX_FIRST_PATIENT;
import static seedu.giatros.testutil.TypicalIndexes.INDEX_SECOND_PATIENT;

import java.nio.file.Path;
import java.util.function.Predicate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.ObservableList;
import seedu.giatros.commons.core.GuiSettings;
import seedu.giatros.logic.CommandHistory;
import seedu.giatros.logic.commands.exceptions.CommandException;
import seedu.giatros.model.Model;
import seedu.giatros.model.ReadOnlyGiatrosBook;
import seedu.giatros.model.ReadOnlyUserPrefs;
import seedu.giatros.model.patient.Patient;

public class AddallCommandTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void execute_throwsCommandException() throws Exception {
        AddallCommand addallCommand = new AddallCommand(INDEX_FIRST_PATIENT, "ibuprofen");
        Model modelStub = new ModelStub();

        thrown.expect(CommandException.class);
        thrown.expectMessage("ibuprofen");
        addallCommand.execute(modelStub, commandHistory);
    }

    @Test
    public void equals() {
        final AddallCommand standardCommand = new AddallCommand(INDEX_FIRST_PATIENT, "ibuprofen");

        // same values -> returns true
        String copyAllergyString = "ibuprofen";
        AddallCommand commandWithSameValues = new AddallCommand(INDEX_FIRST_PATIENT, copyAllergyString);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new AddallCommand(INDEX_SECOND_PATIENT, copyAllergyString)));

        // different descriptor -> returns false
        String differentAllergyString = "paracetamol";
        assertFalse(standardCommand.equals(new AddallCommand(INDEX_FIRST_PATIENT, differentAllergyString)));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getGiatrosBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGiatrosBookFilePath(Path giatrosBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPatient(Patient patient) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGiatrosBook(ReadOnlyGiatrosBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyGiatrosBook getGiatrosBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPatient(Patient patient) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePatient(Patient target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPatient(Patient target, Patient editedPatient) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Patient> getFilteredPatientList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPatientList(Predicate<Patient> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean canUndoGiatrosBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean canRedoGiatrosBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void undoGiatrosBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void redoGiatrosBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void commitGiatrosBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyProperty<Patient> selectedPatientProperty() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Patient getSelectedPatient() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setSelectedPatient(Patient patient) {
            throw new AssertionError("This method should not be called.");
        }
    }

}