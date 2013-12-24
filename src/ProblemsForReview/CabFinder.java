package ProblemsForReview;

/**
 * Created with IntelliJ IDEA.
 * User: JT026354
 * Date: 12/22/13
 * Time: 7:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class CabFinder implements CabStatusListener {

    private int maxCabs;
    private CabApp app;
    private CabStatusListener listener;
    public static final int VALID_DISTANCE = 1000;

    public void setMaxCabs(int maxCabs) {
        this.maxCabs = maxCabs;
    }

    public void setApp(CabApp app) {
        this.app = app;
    }

    public void setListener(CabStatusListener listener) {
        this.listener = listener;
    }

    public CabApp getApp() {
        return app;
    }

    public int getMaxCabs() {
        return maxCabs;
    }

    public CabStatusListener getListener() {
        return listener;
    }

    /**
     * Initiates CabFinder. Called only once per app startup.
     * @app An application object providing services implemented by
     *      the rest of the application.
     * @maxCabs Nearest number of cabs that can be returned to the user
     */
    public void initialize(CabApp app, int maxCabs) {
       this.maxCabs = maxCabs;
       this.app = app;
       this.listener = new CabStatusListener();
       this.app.register(this.listener);
    }

    /**
     * Gets nearest cabs within 1km of the current user’s location.
     * These must be the *nearest possible* @maxCabs in the 1km area.
     * @return An unordered list of the nearest cabs.
     */
    public ArrayList<Cab> getNearestCabs() {
        ArrayList<Cab> allCabs = this.app.getCabs();
        Position userPosition = this.app.getUserPosition();

        ArrayList<Cab> validCabs = new ArrayList<Cab> ();
        for(Cab item : allCabs) {
            if(distance(userPosition, item.getCabPosition()) <= VALID_DISTANCE) {
                validCabs.add(item);
            }
        }
        return validCabs;
    }
    /**
     * time complexity: O(n): n is number of all cabs.
     * space complexity: n+m: the "n" is number of all cabs, the "m" is number of valid cabs
     * **/

    /**
     *  Gets distance between user and cab.
     *  @userPosition the current position of user.
     *  @cabPostion the current position of cab.
     *  r@return a distance between the user and cab.
     * **/
    public int distance(Position userPosition, Position cabPosition) {
        return (int)Math.sqrt((userPosition.x-cabPosition.x)*(userPosition.x-cabPosition.x) + (userPosition.y-cabPosition.y)*(userPosition.y-cabPosition.y));
    }


    /**
     * Asynchronous Callback per CabStatusListener (see below). Called when the position of a cab has changed.
     */
    public void onCabPositionChanged(Cab cab) {
        ArrayList<Cab> allCabs = this.app.getCabs();
        for(Cab item : allCabs) {
           if(item.getID() == cab.getID()) {
               item.setCabPosition(cab.getCabPosition);
               break;
           }
        }
    }
    /**
    * time complexity: O(n): n is number of all cabs.
    *
    * **/

    /**
     * Asynchronous Callback per CabStatusListener (see below). Called when a cab’s availability changes.
     * @cab The cab whose availability has changed
     * @isAvailable true if the cab is now available, false otherwise
     */
    public void onCabAvailabilityChanged (Cab cab, boolean isAvailable) {
        ArrayList<Cab> allCabs = this.app.getCabs();
        for(Cab item : allCabs) {
            if(item.getID() == cab.getID()) {
                item.setAvailibilty(isAvailable);
                break;
            }
        }
    }
    /**
     * time complexity: O(n): n is number of all cabs.
     *
     * **/

    public static void main(String[] args) {

        CabApp app = new CabApp();
        int maxCabs = 6000;
        CabFinder finder = new CabFinder(app, maxCabs);

        /**test for getNearestCabs()**/
        System.out.println("---test for function getNearestCabs(): start----");
        ArrayList<Cab> availableCabs = finder.getNearestCabs();
        for(Cab cab : availableCabs) {
            System.out.println("-------");
            System.out.println(cab.getID());
            System.out.println(cab.isAvailable());
            System.out.println("-------");
        }
        System.out.println("---test for function getNearestCabs(): end----");

        /**test for distance()**/
        Position x1 = new Position(25, 45);
        Position x2 = new Position(450, 15);
        System.out.println("---test for function distance(): start----");
        System.out.println(finder.distance(x1, x2));
        System.out.println("---test for function distance(): end----");

        /**test for onCabPositionChanged()**/
        System.out.println("---test for function onCabPositionChanged(): start----");
        Position p = new Position(466, 265); // assume the constructor of class Position is Position(int x, int y)
        Cab cab = new Cab("1111", p); // assume the constructor of class Cab is Cab(int id, Position p)

        Finder.onCabPositionChanged(cab);
        ArrayList<Cab> allCabs = Finder.getApp.getCabs();
        for(Cab item : allCabs) {
            if(item.getID() == "1111" && item.getCabPosition().x == p.x && item.getCabPosition().y = p.y)
                System.out.println("position updated");
        }
        System.out.println("---test for function onCabPositionChanged(): end----");

        /**test for onCabAvailabilityChanged()**/
        System.out.println("---test for function onCabAvailabilityChanged(): start----");
        p = new Position(366, 265);
        cab = new Cab("2222", p);

        Finder.onCabAvailabilityChanged(cab, false);
        allCabs = Finder.getApp.getCabs();
        for(Cab item : allCabs) {
            if(item.getID() == "2222" && item.isAvailable == false)
                System.out.println("availability is updated");
        }
        System.out.println("---test for function onCabAvailabilityChanged(): end----");
    }

}

