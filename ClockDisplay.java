
/**
 * Author Nicholas Lindgren 
 * 24 hour internal, 12 hour string display. 
 * lab 3 clock lab
 * displays a clock using two number display objects. 
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = timeFormating(hours.getDisplayValue()) + ":" + 
                        minutes.getDisplayValue();
    }
    private String timeFormating(String numberDisplay)
    {
       return ""+ Math.abs(hours.getValue()-12); 
    }
    /**
     * clocks are cyclical, 13-24 is the same as 1-12
     * 00 is 12, therefore take absolute value
     * hours isn't formated correctly but it ddoesn't matter because
     * any 0 is always leading. 
     */
}
