
/**
 * Author Nicholas Lindgren 
 * 12 hour internal storage, 12 hour with am pm display 
 * chapter 3 clock lab
 * 
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private boolean isPM; //am= false, pm = true
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 12:00 am.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        setTime(12, 0, false);
        
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, boolean isAfternoon)
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        setTime(hour, minute, isAfternoon);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) 
        {  // it just rolled over!
            hours.increment();
        }
        if(hours.getValue() == 0)
        {   // hours rolled over & =0 
            hours.increment();
            rollOverPM();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, boolean isAfternoon)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        isPM = isAfternoon;
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
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() +"  " 
                        + getDisplayPM();
    }
    public void setPM(boolean isAfternoon)
    {
        isPM = isAfternoon;
    }
    /**
     * sets the pm am bool to opposite value when 12->0
     */
    public void rollOverPM()
    {
        if(isPM)
        {
            setPM(false);
        }else if(!isPM){
            setPM(true);
        }
    }
    /**
     * returns a string based on a boolean
     */
    public String getDisplayPM()
    {
        if(isPM)
        {
            return "PM";
        }
        return "AM";
    }   
}
