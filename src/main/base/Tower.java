package base;

import java.util.ArrayList;
import java.util.List;

import utils.LoggerUtils;

public class Tower {

    private List<Flyable> observers = new ArrayList<Flyable>();

    // Tower: TYPE@NAME at COORDINATES is now in the system!
    private final String REGISTER_MSG_TEMPLATE = "Tower: %10s@%s at %s is now in the system!";

    // Tower: TYPE@NAME has landed at COORDINATES.
    private final String UNREGISTER_MSG_TEMPLATE = "Tower: %10s@%s has landed at %s.";

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        // suppose this should log into the output file
        LoggerUtils.log(getRegisterMessage(p_flyable));
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        // suppose this should log into the output file
        LoggerUtils.log(getUnregisterMessage(p_flyable));
    }

    protected void contitionChanged() {
        // observer will unregister itself in updateConditions
        // which means it will update while iterating through
        // this will throw ConcurrentModificationException
        // need to every time this function is called.

        List<Flyable> copyObservers = new ArrayList<>(observers);
        for (Flyable observer : copyObservers) {
            observer.updateConditions();
        }
    }

    private String getRegisterMessage(Flyable p_flyable) {
        return String.format(REGISTER_MSG_TEMPLATE, p_flyable.getAircraftType(), p_flyable.getName(),
                p_flyable.getCoordinates().toString());
    }

    private String getUnregisterMessage(Flyable p_flyable) {
        return String.format(UNREGISTER_MSG_TEMPLATE, p_flyable.getAircraftType(), p_flyable.getName(),
                p_flyable.getCoordinates().toString());
    }

}
