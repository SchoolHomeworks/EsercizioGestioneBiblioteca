package ObjectManager;

public interface I_ManagedObject {
    public String[] getAttributeNames();
    public void setAttribute(String name, Object value);
}