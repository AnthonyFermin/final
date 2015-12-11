package radiobutton;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a group of "radio buttons": toggle buttons for which exactly one is selected
 * at a given time. If a different button is selected, the previously-selected button is
 * automatically unselected.
 *
 * Buttons are numbered from 0 to one less than the number of buttons. For example, if the
 * button group has 4 buttons, they are numbered 0, 1, 2, and 3.
 */
public class RadioButtonGroup {

    int           numButtons;
    List<Boolean> buttons;
    int selected;

    /**
     * Creates a group of radio buttons.
     *
     * @param numButtons
     *   The number of buttons in the group.
     * @param initial
     *   The button number that is initially selected.
     * @raise RuntimeException
     *   The initial button number is invalid.
     */
    public RadioButtonGroup(int numButtons, int initial)
    {
        this.numButtons = numButtons;
        selected = initial;
        buttons = new ArrayList<Boolean>();
        for(int i = 0; i < numButtons; i++) {
            buttons.add(false);
        }
        buttons.set(initial, true);
    }

    /**
     * Creates a group of radio buttons. Button 0 is initially selected.
     */
    public RadioButtonGroup(int numButtons) {
        this(numButtons, 0);
    }

    /**
     * Selects a button, unselecting the button that was previously selected.
     * @param button
     *   The button number to select.
     * @raise RuntimeException
     *   The button number is invalid.
     */
    public void select(int button) {
        if(button > numButtons || button < 0) {
            throw new RuntimeException();
        }
        buttons.set(selected, false);
        buttons.set(button, true);
        selected = button;
    }

    /**
     * Returns whether a given button is selected.
     * @param button
     *   The button number to check.
     * @raise RuntimeException
     *   The button number is invalid.
     */
    public boolean isSelected(int button) {
        return buttons.get(button);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Selected: " + selected + " - ");
        for(int i = 0; i < numButtons; i++) {
            if(buttons.get(i)) {
                stringBuilder.append(" ____ ");
            } else {
                stringBuilder.append(" / " + i + " \\ ");
            }
        }
        return stringBuilder.append("\n").toString();
    }

    // TODO: Add attributes and helper methods as needed.

    public static void main(String[] args)
    {
        RadioButtonGroup myButtons = new RadioButtonGroup(4, 2);
        System.out.println(myButtons);
        myButtons.select(0);
        System.out.println(myButtons);
        myButtons.select(1);
        System.out.println(myButtons);
        myButtons.select(3);
        System.out.println(myButtons);

        //should throw RuntimeException
        myButtons.select(8);
    }

}
