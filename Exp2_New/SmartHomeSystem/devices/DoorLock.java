package devices;

public class DoorLock extends AbstractDevice {
    private boolean locked;

    public DoorLock(int id) {
        super(id, "Door");
        this.locked = true; // default locked
    }

    public void lock() { locked = true; }
    public void unlock() { locked = false; }

    @Override
    public String getStatus() {
        return type + " " + id + " is " + (locked ? "Locked" : "Unlocked");
    }
}
