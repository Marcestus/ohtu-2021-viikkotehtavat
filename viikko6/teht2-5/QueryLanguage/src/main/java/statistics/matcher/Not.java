package statistics.matcher;

import statistics.Player;

public class Not implements Matcher {
    
    private Matcher matcher;
    
    public Not (Matcher incomingMatcher) {
        this.matcher = incomingMatcher;
    }
    
    public boolean matches(Player p) {
        if (!matcher.matches(p)) {
            return true;
        }
        return false;
    }
    
}
